<template>

  <ContentWrapper>
    <div class="content-heading">
      {{title}}
      <div class="ml-auto">
        <div class="btn-group">
          <button class="btn btn-secondary right" @click="openForm()">Adicionar Novo</button>
          <button class="btn btn-secondary right" @click="$router.go(-1)">Voltar</button>
        </div>
      </div>
    </div>
    <div class="card card-default d-none d-lg-block" v-if="showForm">
      <div class="card-header">
        <div class="card-title text-center">Lançamento</div>
      </div>
      <div class="card-body">
            <form class="" @submit.prevent="validateBeforeSubmit('lancamento')" data-vv-scope="lancamento">
              <div class="form-row">
                <div class="col-xl-4 col-md-4 col-4 mb-3">
                  <label for="nome">Nome: *</label>
                  <input id="nome" name="nome" type="text" placeholder="Nome do Item"
                    v-model="lancamento.nome"
                    v-validate="'required|max:75'"
                    :class="{'form-control':true, 'is-invalid': errors.has('lancamento.nome')}"
                    />
                    <span v-if="errors.has('lancamento.nome')" class="invalid-feedback">{{ errors.first('lancamento.nome') }}</span>
                </div>
                <div class="col-xl-2 col-md-2 col-2 mb-3">
                  <label for="quantidade" >Quantidade: *</label>
                  <input id="quantidade" nome="quantidade" type="number" placeholder="Quantidade do Item"
                    v-model="lancamento.quantidade"
                    v-validate="'required'"
                    :class="{'form-control':true, 'is-invalid': errors.has('lancamento.quantidade')}"
                    />
                    <span v-if="errors.has('lancamento.quantidade')" class="invalid-feedback">{{ errors.first('lancamento.quantidade') }}</span>
                </div>
                <div class="col-xl-4 col-md-4 col-4 mb-3">
                  <label for="valor" >Valor: *</label>
                  <masked-input id="valor" nome="valor" type="text" placeholder="Valor do Item"
                    v-model="lancamento.valor"
                    v-validate="'required'"
                    :mask="numberMask"
                    :class="{'form-control':true, 'is-invalid': errors.has('lancamento.valor')}"
                    />
                    <span v-if="errors.has('lancamento.valor')" class="invalid-feedback">{{ errors.first('lancamento.valor') }}</span>
                </div>
                <div class="col-xl-2 col-md-2 col-2 mb-3">
                  <label for="criacao">Cadastro</label>
                  <p class="form-control-plaintext">{{lancamento.criacao | formatDate}}</p>
                </div>
              </div>
              <div class="form-row">
                <div class="col-md-12 text-right">
                  <button class="btn btn-primary mr-1" type="submit">Armazenar</button>
                  <button class="btn btn-secondary mr-1" type="button" @click="closeForm()">Cancelar</button>
                </div>
              </div>
            </form>
      </div>
    </div>

    <div class="card card-default">
      <div class="table-responsive">
        <table class="table table-bordered table-hover" id="table-familiares">
          <thead>
            <tr>
              <th>UID</th>
              <th>Item</th>
              <th>Quantidade</th>
              <th>Valor</th>
              <th>Total</th>
              <th>Faturado</th>
              <th>Data</th>
              <th>Ação</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="lancamento of lancamentos" v-bind:key="lancamento.id.id">
              <td>{{lancamento.id.id}}</td>
              <td>{{lancamento.nome}}</td>
              <td class="text-right">{{lancamento.quantidade}}</td>
              <td class="text-right">R$ {{lancamento.valor}}</td>
              <td class="text-right">R$ {{lancamento.valor * lancamento.quantidade}}</td>
              <td class="text-right">{{lancamento.idFatura}}</td>
              <td>{{lancamento.criacao | formatDate}}</td>
              <td class="text-right">
                <div class="btn-group">
                  <button
                    :disabled="lancamento.idFatura"
                    class="btn btn-secondary btn-xs"
                    @click="editar(lancamento)"
                  >
                    <i class="fa fa-edit"></i>
                  </button>
                  <button
                    :disabled="lancamento.idFatura"
                    class="btn btn-danger btn-xs"
                    @click="apagar(lancamento)"
                  >
                    <i class="fa fa-trash"></i>
                  </button>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </ContentWrapper>
</template>
<script>
import Vue from "vue";

import moment from "moment";
import { mapState, mapActions } from "vuex";

import ClienteDataService from "../../services/ClienteDataService";
import LancamentoFaturaDataService from "../../services/LancamentoFaturaDataService";

import MaskedInput from 'vue-text-mask'
import * as textMaskAddons from 'text-mask-addons/dist/textMaskAddons'

import VeeValidate, { Validator } from 'vee-validate';

import msgBR from 'vee-validate/dist/locale/pt_BR';
    
Validator.localize('pt_BR', msgBR);

Vue.use(VeeValidate, {
    fieldsBagName: 'formFields',  // fix issue with b-table
    locale: 'pt_BR'
});

Vue.filter("formatDate", function(value) {
  if (value) {
    return moment(value).format("DD/MM/YYYY HH:mm:ss");
  }
});

export default {
  components: {
    MaskedInput
  },
  name: "lancamento-edit",
  computed: {
    ...mapState({
      account: state => state.account
    })
  },
  data() {
    return {
      title: "",
      lancamento: {
        criacao: null,
        idFatura: null,
        nome: "",
        valor: null
      },
      cliente: {},
      lancamentos: [],
      showForm: false,
      numberMask: textMaskAddons.createNumberMask({ 
        prefix: 'R$ ',
        allowDecimal: true,
        thousandsSeparatorSymbol: '.',
        decimalSymbol: ','
        })
    };
  },
  mounted() {
    if (this.$route.params.id) {
      let id = this.$route.params.id;
      this.obterCliente(id);
      this.listar(id);
    }
  },
  methods: {
    ...mapActions("waAlert", ["showSuccess", "showError", "showConfirmation"]),
    openForm() {
      if (this.showForm) return;

      this.showForm = true;
      this.lancamento = {};
      this.lancamento.criacao = new Date();
    },
    closeForm() {
      this.showForm = false;
      this.lancamento = {};
    },
    editar(lancamento) {
      this.showForm = true;
      this.lancamento = lancamento;
    },
    apagar(lancamento) {
      this.showConfirmation(
        "Confirma a remoção do '" + lancamento.nome + "'?"
      ).then(result => {
        if (result.value) {
          this.remover(lancamento);
        }
      });
    },
    listar(id) {
      LancamentoFaturaDataService.getAll(this.account.user.empresa.id, id)
        .then(response => {
          this.lancamentos = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    obterCliente(id) {
      ClienteDataService.get(this.account.user.empresa.id, id)
        .then(response => {
          this.cliente = response.data;
          this.title = "Lançamentos da Fatura - " + this.cliente.apelido;
        })
        .catch(e => {
          console.log(e);
        });
    },
    validateBeforeSubmit(scope) {
      this.$validator.validateAll(scope).then(result => {
        if (result) {
          this.armazenar();
          return;
        }
        console.log("Correct them errors!");
      });
    },
    armazenar() {

      this.lancamento.valor = this.lancamento.valor.replace('.','').replace(',','.').replace('R$ ','');

      if (this.lancamento.id) {
        LancamentoFaturaDataService.update(
          this.account.user.empresa.id,
          this.$route.params.id,
          this.lancamento.id.id,
          this.lancamento
        )
          .then(response => {
            this.showSuccess("Registro alterado com sucesso!").then(result => {
              if (result.value) {
                this.listar(this.$route.params.id);
                this.closeForm();
              }
            });
          })
          .catch(e => {
            this.showError("Não foi possível alterar o registro!");
            console.log(e);
          });
      } else {
        this.lancamento.criacao = new Date();
        LancamentoFaturaDataService.create(
          this.account.user.empresa.id,
          this.$route.params.id,
          this.lancamento
        )
          .then(response => {
            this.showSuccess("Registro incluído com sucesso!").then(result => {
              if (result.value) {
                this.listar(this.$route.params.id);
                this.closeForm();
              }
            });
          })
          .catch(e => {
            this.showError("Não foi possível incluir o registro!");
            console.log(e);
          });
      }
    },
    remover(lancamento) {
      LancamentoFaturaDataService.delete(
        this.account.user.empresa.id,
        this.$route.params.id,
        lancamento.id.id
      )
        .then(response => {
          this.showSuccess("Registro removido com sucesso!").then(result => {
            if (result.value) {
              this.listar(this.$route.params.id);
              this.closeForm();
            }
          });
        })
        .catch(e => {
          this.showError("Não foi possível remover o registro!");
          console.log(e);
        });
    }
  }
};
</script>