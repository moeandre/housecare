<template>
    <ContentWrapper>
        <div class="content-heading">{{title}}
            <div class="ml-auto">
                <div class="btn-group">
                    <button class="btn btn-secondary right" @click="openForm()">Adicionar Novo</button>
                    <button class="btn btn-secondary right" @click="$router.go(-1)">Voltar</button>
                </div>
            </div>
        </div>
        <div class="card card-default d-none d-lg-block" v-if="showForm">
            <div class="card-header">
                <div class="card-title text-center">Anotação</div>
            </div>
            <div class="card-body">
                <form class="form-horizontal" @submit.prevent="validateBeforeSubmit('anotacao')" data-vv-scope="anotacao">
                    <div class="form-row">
                        <div class="col-xl-12 col-md-12 col-12 mb-3">
                            <label for="anotacao">Texto</label>
                            <b-textarea id="anotacao" name="anotacao" placeholder="Anotação" 
                                v-model="anotacao.texto" 
                                v-validate="'required'"
                                :class="{'form-control':true, 'is-invalid': errors.has('anotacao.texto')}"
                            >
                            </b-textarea>
                            <span v-if="errors.has('anotacao.texto')" class="invalid-feedback">{{ errors.first('anotacao.texto') }}</span>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-xl-4 col-md-4 col-4 mb-3">
                            <label>Usuário de Cadastro</label>
                            <p class="form-control-plaintext">{{anotacao.usuario.nome}}</p>
                        </div>
                        <div class="col-xl-4 col-md-4 col-4 mb-3">
                            <label>Cadastro</label>
                            <p class="form-control-plaintext">{{anotacao.criacao | formatDate}}</p>
                        </div>
                        <div class="col-xl-4 col-md-4 col-4 mb-3">
                            <label for="alteracao">Alteração</label>
                            <p class="form-control-plaintext">{{anotacao.alteracao | formatDate}}</p>
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
        <div class="row">
            <div class="col-xl-12 col-lg-12">
                <div class="card card-default">
                    <div class="card-body">
                        <!-- p.lead.text-centerNo mails here-->
                        <table class="table table-hover mb-mails">
                            <tbody>
                                <tr v-for="anotacao of anotacaos" v-bind:key="anotacao.id.id">
                                    <td>
                                        <div class="d-flex">
                                            <img class="mb-mail-avatar mr-2" alt="Mail Avatar" src="img/user/01.jpg" />
                                            <div class="mb-mail-meta">
                                                <div class="mb-mail-subject">{{anotacao.usuario.nome}}</div>
                                                <div class="mb-mail-preview">{{anotacao.texto}}</div>
                                            </div>
                                            <div class="mb-mail-date ml-auto">{{anotacao.criacao | formatDate}}</div>
                                        </div>
                                    </td>
                                    <td class="text-right">
                                        <div class="btn-group">
                                            <button
                                                :disabled="anotacao.id.idUsuario != account.user.id"
                                                class="btn btn-secondary btn-xs"
                                                @click="editar(anotacao)"
                                            >
                                                <i class="fa fa-edit"></i>
                                            </button>
                                            <button
                                                :disabled="anotacao.id.idUsuario != account.user.id"
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
            </div>
        </div>
    </ContentWrapper>
</template>
<script>
    import Vue from "vue";

    import moment from "moment";
    import { mapState, mapActions } from "vuex";

    import ClienteDataService from "../../services/ClienteDataService";
    import AnotacaoDataService from "../../services/AnotacaoDataService";
    
    import VeeValidate, { Validator } from 'vee-validate';
    import CpfValidator from '../../components/validators/cpf.validator'

    import msgBR from 'vee-validate/dist/locale/pt_BR';
    
    Validator.localize('pt_BR', msgBR);
    Validator.extend('cpf', CpfValidator)

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
        name: "anotacao-edit",
        computed: {
            ...mapState({
                account: state => state.account
            })
        },
        data() {
            return {
                title: "",
                anotacao: {
                    'alteracao': null,
                    'criacao': null,
                    'texto': 'teste'
                },
                cliente: {},
                anotacaos: [],
                showForm: false
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
                this.anotacao = {};
                this.anotacao.criacao = new Date();
                this.anotacao.alteracao = new Date();
                this.anotacao.usuario = this.account.user
            },
            closeForm() {
                this.showForm = false;
                this.anotacao = {};
            },
            editar(anotacao) {
                this.showForm = true;
                this.anotacao = anotacao;
            },
            apagar(anotacao) {
                this.showConfirmation(
                    "Confirma a remoção do resgistro?"
                ).then(result => {
                    if (result.value) {
                        this.remover(anotacao);
                    }
                });
            },
            listar(id) {
                AnotacaoDataService.getAll(this.account.user.empresa.id, id)
                    .then(response => {
                        this.anotacaos = response.data;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            obterCliente(id) {
                ClienteDataService.get(this.account.user.empresa.id, id)
                    .then(response => {
                        this.cliente = response.data;
                        this.title = "Anotações - " + this.cliente.apelido;
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
                if (this.anotacao.id) {
                    this.anotacao.alteracao = new Date();
                    
                    AnotacaoDataService.update(
                        this.account.user.empresa.id,
                        this.$route.params.id,
                        this.anotacao.id.id,
                        this.anotacao
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
                    this.anotacao.criacao = new Date();
                    AnotacaoDataService.create(
                        this.account.user.empresa.id,
                        this.$route.params.id,
                        this.anotacao
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
            remover(anotacao) {
                AnotacaoDataService.delete(
                    this.account.user.empresa.id,
                    this.$route.params.id,
                    anotacao.id.id
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