<template>
    <ContentWrapper>
        <div class="content-heading">
            {{title}}
            <div class="ml-auto">
                <button class="btn btn-secondary right" @click="$router.go(-1)">Voltar</button>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <div class="card card-default">
                    <div class="card-body text-center">
                        <div class="py-4">
                            <img class="img-fluid rounded-circle img-thumbnail thumb96" src="img/user/13.jpg" alt="Contact" />
                        </div>
                        <h3 class="m-0 text-bold">{{funcionario.usuario.nome ||  'Novo Usuário'}}</h3>
                        <div class="my-3">
                            <p>{{funcionario.usuario.email}} </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card card-default">
                    <div class="card-header d-flex align-items-center">
                        <div class="d-flex col">
                            <div class="h4 m-0">Dados do Usuário</div>
                        </div>
                        <div class="d-flex justify-content-end">
                            
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="row py-4 justify-content-center">
                            <div class="col-12 col-sm-10">
                                <form class="form-horizontal" @submit.prevent="validateBeforeSubmit('funcionario')" data-vv-scope="funcionario">
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="nome">Nome</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input 
                                                name="nome" id="nome" type="text" placeholder="Nome do Usuário" 
                                                v-model="funcionario.usuario.nome" 
                                                v-validate="'required|max:75'"
                                                :class="{'form-control':true, 'is-invalid': errors.has('funcionario.usuario.nome')}"
                                            />
                                            <span v-if="errors.has('funcionario.usuario.nome')" class="invalid-feedback">{{ errors.first('funcionario.usuario.nome') }}</span>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="email">E-mail</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input 
                                                name="email" id="email" type="text" placeholder="E-mail do Usuário" 
                                                v-model="funcionario.usuario.email"
                                                v-validate="'email'"
                                                :class="{'form-control':true, 'is-invalid': errors.has('funcionario.usuario.email')}"
                                            />
                                            <span v-if="errors.has('funcionario.usuario.email')" class="invalid-feedback">{{ errors.first('funcionario.usuario.email') }}</span>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="telefone">Telefone</label>
                                         <div class="col-xl-9 col-md-9 col-8">
                                            <the-mask 
                                                name="telefone" id="telefone" type="text" placeholder="Telefone do Usuário" 
                                                v-model="funcionario.usuario.telefone" 
                                                v-validate="'required'"
                                                :class="{'form-control':true, 'is-invalid': errors.has('funcionario.usuario.telefone')}"
                                                :mask="['(##) ####-####', '(##) #####-####']"/>
                                            <span v-if="errors.has('funcionario.usuario.telefone')" class="invalid-feedback">{{ errors.first('funcionario.usuario.telefone') }}</span>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="senha">Senha</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" id="senha" type="password" placeholder="Senha do Usuário" v-model="funcionario.usuario.senha" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="situacao">Situação</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <select class="custom-select" id="cliente" v-model="funcionario.situacao">
                                                <option >Selecione</option>
                                                <option value="A" :selected="funcionario.situacao == 'A'">Ativo</option>
                                                <option value="I" :selected="funcionario.situacao == 'I'">Inativo</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-xl-3 col-md-3 offset-md-3 col-4">
                                            <div class="checkbox c-checkbox">
                                                <label>
                                                    <input type="checkbox" id="responsavel" v-model="funcionario.responsavel" />
                                                    <span class="fa fa-check"></span> Responsável 
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact8">Cadastro</label>
                                        <div class="col-xl-9 col-md-9 col-8 ">
                                            <p class="form-control-plaintext">{{funcionario.usuario.criacao | formatDate}}</p>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact8">Alteração</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <p class="form-control-plaintext">{{funcionario.usuario.alteracao | formatDate}}</p>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-md-12 text-right">
                                            <button class="btn btn-primary mr-1" type="submit">Armazenar</button>
                                            <button class="btn btn-secondary mr-1" type="button" @click="$router.go(-1)">Cancelar</button>
                                        </div>
                                    </div>
                                </form>
                                <div class="text-right">
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </ContentWrapper>
</template>
<script>
    
    import Vue from 'vue'
    import moment from 'moment'
    
    import { mapState, mapActions } from 'vuex'
    import FuncionarioDataService from "../../services/FuncionarioDataService";

    import parentescos from '../../components/domain/parentesco';
   
    import Datepicker from 'vuejs-datepicker'
    
    import {TheMask} from 'vue-the-mask'

    import VeeValidate, { Validator } from 'vee-validate';

    import msgBR from 'vee-validate/dist/locale/pt_BR';
    
    Validator.localize('pt_BR', msgBR);

    Vue.use(VeeValidate, {
        fieldsBagName: 'formFields',  // fix issue with b-table
        locale: 'pt_BR'
    });

    Vue.filter('formatDate', function(value) {
        if (value) {
            return moment(value).format('DD/MM/YYYY HH:mm:ss')
        }
    });

    export default {
        components: {
            Datepicker,
            TheMask
        },
        name: "usuario-edit",
        computed: {
            ...mapState({
                account: state => state.account
            })
        },
        data() {
            return {
                funcionario: {
                    'responsavel': null,
                    'situacao': null,
                    'usuario': {
                        'alteracao': null,
                        'criacao': null,
                        'email': null,
                        'login': null,
                        'nome': null,
                        'telefone': null
                    }
                },
                
                title: "Novo Usuário"
            };
        },
        methods: {
            ...mapActions('waAlert',['showSuccess', 'showError']),
            detalhar(id) {
                FuncionarioDataService.get(this.account.user.empresa.id, id)
                    .then(response => {
                        this.funcionario = response.data;
                        this.title = 'Editar '+this.funcionario.usuario.nome
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            validateBeforeSubmit(scope) {
                this.$validator.validateAll(scope).then((result) => {
                    if (result) {
                        this.armazenar();                        
                        return;
                    }
                    console.log('Correct them errors!');
                });
            },
            customFormatter(date) {
                return moment(date).format('DD/MM/YYYY');
            },
            armazenar(){
                this.funcionario.usuario.alteracao = new Date();
                this.funcionario.usuario.login = this.funcionario.usuario.email;
                this.funcionario.responsavel = (this.funcionario.responsavel) ? 1 : 0;

                if(this.funcionario.id){
                    FuncionarioDataService.update(this.account.user.empresa.id, this.$route.params.id, this.funcionario)
                    .then(response => {
                        this.funcionario = response.data;
                        this.showSuccess('Registro alterado com sucesso!');
                    })
                    .catch(e => {
                        this.showError('Não foi possível alterar o registro!');
                        console.log(e);
                    });
                }else{
                    this.funcionario.usuario.criacao = new Date();
                    
                    FuncionarioDataService.create(this.account.user.empresa.id, this.funcionario)
                    .then(response => {
                        this.showSuccess('Registro incluído com sucesso!');
                    })
                    .catch(e => {
                        this.showError('Não foi possível incluir o registro!');
                        console.log(e);
                    });
                }
            }
            
        },
        mounted() {
            if(this.$route.params.id){
                let id = this.$route.params.id;
                this.detalhar(id);
            }
        }
    };
</script>

