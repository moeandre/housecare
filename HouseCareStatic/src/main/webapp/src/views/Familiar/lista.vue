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
            <div class="card-header">
                <div class="card-title text-center">Familiar</div>
            </div>
            <div class="card-body">
                <div class="row py-4 justify-content-center">
                    <div class="col-12 col-sm-12">
                        <form class="form-horizontal" @submit.prevent="validateBeforeSubmit('familiar')" data-vv-scope="familiar">
                            <div class="form-group row">
                                <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="nome">Nome</label>
                                <div class="col-xl-9 col-md-9 col-8">
                                    <input class="form-control" id="nome" type="text" placeholder="Nome do Familiar" v-model="familiar.nome" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="parentesco">Parentesco</label>
                                <div class="col-xl-9 col-md-9 col-8">
                                    <input class="form-control" id="parentesco" type="text" placeholder="Parentesco do Familiar" v-model="familiar.parentesco" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="telefone">Telefone</label>
                                <div class="col-xl-9 col-md-9 col-8">
                                    <input class="form-control" id="telefone" type="text" placeholder="Telefone do Familiar" v-model="familiar.telefone" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="email">E-mail</label>
                                <div class="col-xl-9 col-md-9 col-8">
                                    <input class="form-control" id="email" type="text" placeholder="E-mail do Familiar" v-model="familiar.email" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="cliente">Cliente</label>
                                <div class="col-xl-9 col-md-9 col-8">
                                    <select class="custom-select" id="cliente" v-model="familiar.id.idCliente" :disabled="familiar.id.idCliente == $route.params.id && $route.params.id !=null">
                                        <option >Selecione</option>
                                        <option v-for="cliente in clientes" v-bind:value="cliente.id.id" v-bind:key="cliente.id.id" :selected="cliente.id.id === familiar.id.idCliente" >{{ cliente.nome }}</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-xl-3 col-md-3 offset-md-3 col-4">
                                    <div class="checkbox c-checkbox">
                                        <label>
                                            <input type="checkbox" id="responsavel" v-model="familiar.responsavel" />
                                            <span class="fa fa-check"></span> Responsável Solidário
                                        </label>
                                    </div>
                                </div>
                                <label class="text-bold col-xl-3 col-md-3 col-2 col-form-label text-right" for="criacao">Último Contato</label>
                                <div class="col-xl-3 col-md-3 col-4">
                                    <p class="form-control-plaintext">{{familiar.ultimoContato | formatDate}}</p>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="text-bold col-xl-3 col-md-3 col-2 col-form-label text-right" for="criacao">Cadastro</label>
                                <div class="col-xl-3 col-md-3 col-4">
                                    <p class="form-control-plaintext">{{familiar.criacao | formatDate}}</p>
                                </div>
                                <label class="text-bold col-xl-3 col-md-3 col-2 col-form-label text-right" for="alteracao">Alteração</label>
                                <div class="col-xl-3 col-md-3 col-4">
                                    <p class="form-control-plaintext">{{familiar.alteracao | formatDate}}</p>
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
            </div>
        </div>
        <div class="card card-default">
            <div class="table-responsive">
                <table class="table table-bordered table-hover" id="table-familiares">
                    <thead>
                        <tr>
                            <th>UUID</th>
                            <th v-if="!$route.params.id">Cliente</th>
                            <th>Nome</th>
                            <th>Parentesco</th>
                            <th>Telefone</th>
                            <th>E-mail</th>
                            <th>Ultimo Contato</th>
                            <th>Responsável</th>
                            <th>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="familiar of familiars" v-bind:key="familiar.id.idFamiliar">
                            <td>{{familiar.id.idFamiliar}}</td>
                            <td v-if="!$route.params.id">{{familiar.cliente.apelido}}</td>
                            <td>{{familiar.nome}}</td>
                            <td>{{familiar.parentesco}}</td>
                            <td>{{familiar.telefone}}</td>
                            <td>{{familiar.email}}</td>
                            <td>{{familiar.ultimoContato | formatDate}}</td>
                            <td class="text-center">
                                {{familiar.responsavel ? 'Sim' : 'Não'}}
                            </td>
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

    import ClienteDataService from "../../services/ClienteDataService";
    import FamiliarDataService from "../../services/FamiliarDataService";
    import VeeValidate from "vee-validate";

    Vue.use(VeeValidate, {
        fieldsBagName: "formFields" // fix issue with b-table
    });

    Vue.filter("formatDate", function(value) {
        if (value) {
            return moment(value).format("DD/MM/YYYY HH:mm:ss");
        }
    });

    export default {
        name: "familiar-edit",
        computed: {
            ...mapState({
                account: state => state.account
            })
        },
        data() {
            return {
                title: "Familiares",
                familiar: {
                    'id': {
                        'idCliente' : null,
                    },
                    'alteracao': null,
                    'criacao': null,
                    'email': '',
                    'nome': '',
                    'parentesco': '',
                    'responsavel': null,
                    'telefone': '',
                    'ultimoContato': null
                },
                cliente: {},
                clientes: {},
                familiars: [],
                showForm: false
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
                if(this.$route.params.id){
                    this.familiar.id = {'idCliente': this.$route.params.id};
                }else{
                    this.familiar.id = {'idCliente': null};
                }
                
            },
            closeForm() {
                this.showForm = false;
                this.familiar = {};
            },
            editar(familiar) {
                this.showForm = true;
                this.familiar = familiar;
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
                this.familiar.responsavel = (this.familiar.responsavel) ? 1 : 0;

                if (this.familiar.id.idFamiliar) {
                    this.familiar.alteracao = new Date();
                    
                    FamiliarDataService.update(
                        this.account.user.empresa.id,
                        this.familiar.id.idCliente,
                        this.familiar.id.idFamiliar,
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
                        this.familiar.id.idCliente,
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
                FamiliarDataService.deleteByCliente(
                    this.account.user.empresa.id,
                    familiar.id.idCliente,
                    familiar.id.idFamiliar
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
