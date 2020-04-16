<template>
    <ContentWrapper>
        <div class="content-heading">{{title}}
            <div class="ml-auto">
                <div class="btn-group">
                    <button class="btn btn-secondary right" @click="openForm()">Adicionar Novo</button>
                    <button class="btn btn-secondary right" @click="$router.go(-1)" v-if="$route.params.id">Voltar</button>
                </div>
            </div>
        </div>
        <div class="card card-default d-none d-lg-block" v-if="showForm">
            <div class="card-body">
                <form class="form-horizontal" @submit.prevent="validateBeforeSubmit('familiar')" data-vv-scope="familiar">
                    <div class="row">
                        <div class="col-lg-12 col-md-12">
                            <fieldset>
                                <legend>Dados do Familiar</legend>
                                <div class="form-row">
                                    <div class="col-xl-6 col-md-6 col-6 mb-6">
                                        <label for="nome">Nome: *</label>
                                        <input class="form-control" 
                                            name="nome" id="nome" type="text" placeholder="Nome do Familiar" 
                                            v-model="familiar.nome" 
                                            v-validate="'required|max:75'"
                                            :class="{'form-control':true, 'is-invalid': errors.has('familiar.nome')}"
                                        />
                                        <span v-if="errors.has('familiar.nome')" class="invalid-feedback">{{ errors.first('familiar.nome') }}</span>
                                    </div>
                                    <div class="col-xl-2 col-md-2 col-2 mb-2">
                                        <label for="telefone">Telefone: *</label>
                                        <the-mask input name="telefone" id="telefone" type="text" placeholder="Telefone do Familiar" 
                                            v-model="familiar.telefone" 
                                            v-validate="'required'"
                                            :class="{'form-control':true, 'is-invalid': errors.has('familiar.telefone')}"
                                            :mask="['(##) ####-####', '(##) #####-####']"/>
                                        <span v-if="errors.has('familiar.telefone')" class="invalid-feedback">{{ errors.first('familiar.telefone') }}</span>
                                    </div>
                                    <div class="col-xl-4 col-md-4 col-4 mb-4">
                                        <label for="email">E-mail: </label>
                                        <input name="email" id="email" type="text" placeholder="E-mail do Familiar" 
                                            v-model="familiar.email"
                                            v-validate="'email'"
                                            :class="{'form-control':true, 'is-invalid': errors.has('familiar.email')}"
                                        />
                                        <span v-if="errors.has('familiar.email')" class="invalid-feedback">{{ errors.first('familiar.email') }}</span>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="col-xl-3 col-md-3 col-3">
                                        <label>Cadastro</label>
                                        <p class="form-control-plaintext">{{familiar.criacao | formatDate}}</p>
                                    </div>
                                    <div class="col-xl-3 col-md-3 col-3">
                                        <label>Alteração</label>
                                        <p class="form-control-plaintext">{{familiar.alteracao | formatDate}}</p>
                                    </div>
                                    <div class="col-xl-3 col-md-3 col-3">
                                        <label>Contato</label>
                                        <p class="form-control-plaintext">{{familiar.ultimoContato | formatDate}}</p>
                                    </div>
                                </div>
                            </fieldset>
                            <fieldset>
                                <legend>Clientes</legend>
                                <table class="table table-striped table-hover" id="table-clientes">
                                    <thead>
                                        <tr class="row">
                                            <th class="col-xl-4 col-md-4 col-4">Nome</th>
                                            <th class="col-xl-3 col-md-3 col-3">Parentesco</th>
                                            <th class="col-xl-2 col-md-2 col-2">Responsavel Financeiro</th>
                                            <th class="col-xl-2 col-md-2 col-2">Responsável Solidário</th>
                                            <th class="col-xl-1 col-md-1 col-1 text-right">
                                                <button class="btn btn-secondary btn-xs" v-on:click="addParentesco()">
                                                    <i class="fa fa-plus-circle"></i>
                                                </button>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr class="row">
                                            <th colspan="5" class="col-xl-12 col-md-12 col-12 text-right">
                                                <button class="btn btn-secondary btn-xs" v-on:click="addParentesco()">
                                                    <i class="fa fa-plus-circle"></i>
                                                </button>
                                            </th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <tr v-for="(parentesco, index) in familiar.parentescos" :key="index" class="row">
                                            <td class="col-xl-4 col-md-4 col-4">
                                                <select class="custom-select" :name="'familiar.parentescos['+index+'][cliente][id]'" :id="'cliente_'+index" 
                                                    v-model="parentesco.cliente.id.id"
                                                    v-validate="'required'"
                                                    :class="{'custom-select':true, 'is-invalid': errors.has('familiar.parentescos['+index+'][cliente][id]')}">
                                                    <option >Selecione o Cliente</option>
                                                    <option v-for="(c, cIndex) in clientes" v-bind:value="c.id.id" v-bind:key="cIndex" :selected="c.id.id === parentesco.cliente.id.id" >{{ c.nome }}</option>
                                                </select>
                                                <span v-if="errors.has('familiar.parentescos['+index+'][cliente][id]')" class="invalid-feedback">{{ errors.first('familiar.parentescos['+index+'][cliente][id]') }}</span>
                                            </td>
                                            <td class="col-xl-3 col-md-3 col-3">
                                                <select :name="'familiar.parentescos['+index+'][parentesco]'" :id="'parentesco_'+index" 
                                                    v-model="parentesco.parentesco"
                                                    v-validate="'required'"
                                                    :class="{'custom-select':true, 'is-invalid': errors.has('familiar.parentescos['+index+'][parentesco]')}">
                                                    <option>Selecione o Parentesco do Familiar</option>
                                                    <option v-for="p in vParentescos.values" v-bind:value="p.key" v-bind:key="p.key" :selected="p.key === parentesco.parentesco" >{{ p.value }}</option>
                                                </select>
                                                <span v-if="errors.has('familiar.parentescos['+index+'][parentesco]')" class="invalid-feedback">{{ errors.first('familiar.parentescos['+index+'][parentesco]') }}</span>
                                            </td>
                                            <td class="col-xl-2 col-md-2 col-2">
                                                <div class="checkbox c-checkbox">
                                                    <label :for="'financeiro_'+index">
                                                        <input type="checkbox" :name="'familiar.parentescos['+index+'][financeiro]'" :id="'financeiro_'+index" 
                                                            v-model="parentesco.financeiro"  
                                                            true-value="1"
                                                            false-value="0"
                                                            />
                                                        <span class="fa fa-check"></span>
                                                    </label>
                                                </div>
                                            </td>
                                            <td class="col-xl-2 col-md-2 col-2">
                                                <div class="checkbox c-checkbox">
                                                    <label :for="'responsavel_'+index">
                                                        <input type="checkbox" :name="'familiar.parentescos['+index+'][responsavel]'" :id="'responsavel_'+index" 
                                                            v-model="parentesco.responsavel" 
                                                            true-value="1"
                                                            false-value="0"
                                                        />
                                                        <span class="fa fa-check"></span>
                                                    </label>
                                                </div>
                                            </td>
                                            <td class="col-xl-1 col-md-1 col-1 text-right">
                                                <button class="btn btn-danger btn-xs" @click="removeParentesco(index)">
                                                    <i class="fa fa-minus-circle"></i>
                                                </button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </fieldset>
                        </div>
                    </div>
                    <div class="form-group row">
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
                            <th>UUID</th>
                            <th>Nome</th>
                            <th>Telefone</th>
                            <th>E-mail</th>
                            <th>Último Contato</th>
                            <th>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="familiar of familiars" v-bind:key="familiar.idFamiliar">
                            <td>{{familiar.idFamiliar}}</td>
                            <td>{{familiar.nome}}</td>
                            <td>{{familiar.telefone}}</td>
                            <td>{{familiar.email}}</td>
                            <td>{{familiar.ultimoContato | formatDate}}</td>
                            <td class="text-right">
                                <div class="btn-group">
                                    <button
                                        class="btn btn-secondary btn-xs"
                                        @click="editar(familiar)"
                                    >
                                        <i class="fa fa-edit"></i>
                                    </button>
                                    <button
                                        class="btn btn-danger btn-xs"
                                        @click="apagar(familiar)"
                                        >
                                        <i class="fa fa-trash"></i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- END table-responsive-->
        </div>
        
    </ContentWrapper>
</template>
<script>
    import Vue from "vue";

    import moment from "moment";
    import { mapState, mapActions } from "vuex";

    import vParentescos from '../../components/domain/parentesco';

    import ClienteDataService from "../../services/ClienteDataService";
    import FamiliarDataService from "../../services/FamiliarDataService";

    import {TheMask} from 'vue-the-mask'
    
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
        name: "familiar-edit",
        components: {
            TheMask
        },
        computed: {
            ...mapState({
                account: state => state.account
            })
        },
        data() {
            return {
                title: "Familiares",
                familiar: {
                    "nome": null,
                    "bairro": null,
                    "cep": null,
                    "complemento": null,
                    "cpf": null,
                    "email": null,
                    "envioFatura": null,
                    "estado": null,
                    "idContato": null,
                    "logradouro": null,
                    "municipio": null,
                    "numero": null,
                    "rg": null,
                    "telefone": null,
                    "ultimoContato": null,
                    "alteracao": null,
                    "criacao": null,
                    "parentescos": []
                        
                },
                defaultParentesco: {
                        "financeiro": null,
                        "parentesco": null,
                        "responsavel": null,
                        "cliente": {},
                        "alteracao": null,
                        "criacao": null
                    },
                cliente: {},
                clientes: {},
                familiars: [],
                showForm: false,
                vParentescos,
                phoneMask: '\d',
            };
        },
        methods: {
            ...mapActions("waAlert", ["showSuccess", "showError", "showConfirmation"]),
            openForm() {
                if (this.showForm) return;

                this.showForm = true;
                this.familiar = {};
                this.familiar.criacao = new Date();
                this.familiar.alteracao = new Date();

                this.addParentesco();

                /*
                if(this.$route.params.id){
                    this.familiar.id = {'idCliente': this.$route.params.id};
                }else{
                    this.familiar.id = {'idCliente': null};
                }
                */
                
            },
            closeForm() {
                this.showForm = false;
                this.familiar = {};
            },
            editar(familiar) {
                this.showForm = true;
                FamiliarDataService.get(this.account.user.empresa.id, familiar.idFamiliar)
                    .then(response => {
                        this.familiar = response.data;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            addParentesco(){
                if(!this.familiar.parentescos){
                    this.familiar.parentescos = [];
                }

                let newParentesco = Object.assign({}, this.defaultParentesco);
                newParentesco.cliente = { 'id': {'id' :null } };
                newParentesco.criacao = new Date();
                newParentesco.alteracao = new Date();
                this.familiar.parentescos.push(newParentesco);
                return false;
            },
            removeParentesco(index){
                this.familiar.parentescos.splice(index,1);
                return false;
            },
            apagar(familiar) {
                this.showConfirmation(
                    "Confirma a remoção do resgistro?"
                ).then(result => {
                    if (result.value) {
                        this.remover(familiar);
                    }
                });
            },
            listar() {
                FamiliarDataService.getAll(this.account.user.empresa.id)
                    .then(response => {
                        this.familiars = response.data;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            listarPorCliente(id) {
                FamiliarDataService.getAllByCliente(this.account.user.empresa.id, id)
                    .then(response => {
                        this.familiars = response.data;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            obterCliente(id) {
                ClienteDataService.get(this.account.user.empresa.id, id)
                    .then(response => {
                        this.cliente = response.data;
                        this.title = "Familiares - " + this.cliente.apelido;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            listarClientes() {
                ClienteDataService.getAll(this.account.user.empresa.id)
                    .then(response => {
                        this.clientes = response.data;
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

                if (this.familiar.idFamiliar) {
                    this.familiar.alteracao = new Date();
                    
                    FamiliarDataService.update(
                        this.account.user.empresa.id,
                        this.familiar.idFamiliar,
                        this.familiar
                    )
                    .then(response => {
                        this.showSuccess("Registro alterado com sucesso!").then(result => {
                            if (result.value) {
                                if(this.$route.params.id){
                                    this.listarPorCliente(this.$route.params.id);
                                }else{
                                    this.listar(); 
                                }
                                this.closeForm();
                            }
                        });
                    })
                    .catch(e => {
                        this.showError("Não foi possível alterar o registro!");
                        console.log(e);
                    });
                } else {
                    this.familiar.criacao = new Date();
                    FamiliarDataService.create(
                        this.account.user.empresa.id,
                        this.familiar
                    )
                    .then(response => {
                        this.showSuccess("Registro incluído com sucesso!").then(result => {
                            if (result.value) {
                                if(this.$route.params.id){
                                    this.listarPorCliente(this.$route.params.id);
                                }else{
                                    this.listar(); 
                                }
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
            remover(familiar) {
                FamiliarDataService.delete(
                    this.account.user.empresa.id,
                    familiar.idFamiliar
                )
                .then(response => {
                    this.showSuccess("Registro removido com sucesso!").then(result => {
                        if (result.value) {
                            if(this.$route.params.id){
                                this.listarPorCliente(this.$route.params.id);
                            }else{
                                this.listar(); 
                            }
                            this.closeForm();
                        }
                    });
                })
                .catch(e => {
                    this.showError("Não foi possível remover o registro!");
                    console.log(e);
                });
            }
        },
        mounted() {
            if (this.$route.params.id) {
                let id = this.$route.params.id;
                this.obterCliente(id);
                this.listarPorCliente(id);
            }else{
                this.title = "Familiares";
                this.listar();
            }
            this.listarClientes();
        }
    };
</script>
