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
                        <h3 class="m-0 text-bold">{{cliente.nome ||  'Novo Cliente'}}</h3>
                        <div class="my-3">
                            <p>{{cliente.apelido}} </p>
                        </div>
                    </div>
                </div>
                <div class="card card-default d-none d-lg-block" v-if="cliente.id">
                    <div class="card-header">
                        <div class="card-title text-center">Familiares</div>
                    </div>
                    <div class="card-body">
                        <div class="media"  v-for="familiar of familiars" v-bind:key="familiar.idFamiliar">
                            <img class="align-self-center mr-2 rounded-circle img-thumbnail thumb48" src="img/user/05.jpg" alt="Contact" />
                            <div class="media-body py-2">
                                <div class="text-bold">{{familiar.nome}}
                                    <div class="text-sm text-muted">{{familiar.ultimoContato | formatDate}}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card card-default">
                    <div class="card-header d-flex align-items-center">
                        <div class="d-flex col">
                            <div class="h4 m-0">Dados Cadastrais</div>
                        </div>
                        <div class="d-flex justify-content-end">
                            <b-dropdown id="opcoes-cliente" variant="link" no-caret right v-if="cliente.id">
                                <template slot="button-content">
                                    <em class="fa fa-ellipsis-v fa-lg text-muted"></em>
                                </template>
                                <b-dropdown-item>
                                    <router-link tag="a" :to="{ name: 'familiar-cliente', params: { id: cliente.id.id }}">Familiares</router-link>
                                </b-dropdown-item>
                                <b-dropdown-item>
                                    <router-link tag="a" :to="{ name: 'anotacao-cliente', params: { id: cliente.id.id }}">Anotações</router-link>
                                </b-dropdown-item>
                                <b-dropdown-item>
                                    <router-link tag="a" :to="{ name: 'hospedagem-cliente', params: { id: cliente.id.id }}">Hospedagem</router-link>
                                </b-dropdown-item>
                                <b-dropdown-divider></b-dropdown-divider>
                                <b-dropdown-item>
                                    <router-link tag="a" :to="{ name: 'fatura-cliente', params: { id: cliente.id.id }}">Lançamentos de Fatura</router-link>
                                </b-dropdown-item>
                            </b-dropdown>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="row py-4 justify-content-center">
                            <div class="col-12 col-sm-10">
                                <form class="form-horizontal" @submit.prevent="validateBeforeSubmit('cliente')" data-vv-scope="cliente">
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="nome">Nome</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input id="nome" name="nome" type="text" placeholder="Nome do Cliente" 
                                                maxlength="75"
                                                v-model="cliente.nome"
                                                v-validate="'required|max:75'"
                                                :class="{'form-control':true, 'is-invalid': errors.has('cliente.nome')}"
                                             />
                                            <span v-if="errors.has('cliente.nome')" class="invalid-feedback">{{ errors.first('cliente.nome') }}</span>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="sobrenome">Sobrenome</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input name="sobrenome" id="sobrenome" type="text" placeholder="Sobrenome do Cliente" 
                                                v-model="cliente.sobrenome" 
                                                v-validate="'required|max:75'"
                                                :class="{'form-control':true, 'is-invalid': errors.has('cliente.sobrenome')}"
                                             />
                                            <span v-if="errors.has('cliente.sobrenome')" class="invalid-feedback">{{ errors.first('cliente.sobrenome') }}</span>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="apelido">Apelido</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input name="apelido" id="apelido" type="text" placeholder="Apelido do Cliente" 
                                                v-model="cliente.apelido" 
                                                v-validate="'required|max:75'"
                                                :class="{'form-control':true, 'is-invalid': errors.has('cliente.apelido')}"
                                             />
                                            <span v-if="errors.has('cliente.apelido')" class="invalid-feedback">{{ errors.first('cliente.apelido') }}</span>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="cpf">CPF</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <masked-input 
                                                name="cpf" id="cpf" type="text" placeholder="CPF do Cliente"
                                                v-model="cliente.cpf" 
                                                v-validate="'required|cpf|max:14'"
                                                :class="{'form-control':true, 'is-invalid': errors.has('cliente.cpf')}"
                                                :mask="cpfMask" 
                                                />
                                            <span v-if="errors.has('cliente.cpf')" class="invalid-feedback">{{ errors.first('cliente.cpf') }}</span>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="nascimento">Nascimento</label>
                                        <div class="col-xl-9 col-md-9 col-8 ">
                                            <datepicker v-model="cliente.nascimento" :bootstrapStyling="true" name="nascimento" id="nascimento" 
                                                :format="customFormatter"  
                                                v-validate="'required'"
                                                :class="{'is-invalid': errors.has('cliente.nascimento')}"
                                             />
                                            <span v-if="errors.has('cliente.nascimento')" class="invalid-feedback">{{ errors.first('cliente.nascimento') }}</span>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="nacionalidade">Nacionalidade</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input name="nacionalidade" id="nacionalidade" type="text" placeholder="Nacionalidade do Cliente" 
                                                v-model="cliente.nacionalidade" 
                                                v-validate="'required|max:75'"
                                                :class="{'form-control':true, 'is-invalid': errors.has('cliente.nacionalidade')}"
                                             />
                                            <span v-if="errors.has('cliente.nacionalidade')" class="invalid-feedback">{{ errors.first('cliente.nacionalidade') }}</span>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="naturalidade">Naturalidade</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <input class="form-control" name="naturalidade" id="naturalidade" type="text" placeholder="Naturalidade do Cliente" 
                                                v-model="cliente.naturalidade" 
                                                v-validate="'max:75'"
                                                :class="{'form-control':true, 'is-invalid': errors.has('cliente.naturalidade')}"
                                             />
                                            <span v-if="errors.has('cliente.naturalidade')" class="invalid-feedback">{{ errors.first('cliente.naturalidade') }}</span>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact8">Cadastro</label>
                                        <div class="col-xl-9 col-md-9 col-8 ">
                                            <p class="form-control-plaintext">{{cliente.criacao | formatDate}}</p>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="text-bold col-xl-3 col-md-3 col-4 col-form-label text-right" for="inputContact8">Alteração</label>
                                        <div class="col-xl-9 col-md-9 col-8">
                                            <p class="form-control-plaintext">{{cliente.alteracao | formatDate}}</p>
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
    import ClienteDataService from "../../services/ClienteDataService";
    import FamiliarDataService from "../../services/FamiliarDataService";

    import Datepicker from 'vuejs-datepicker'

    import MaskedInput from 'vue-text-mask'
    import * as textMaskAddons from 'text-mask-addons/dist/textMaskAddons'

    import VeeValidate, { Validator } from 'vee-validate';
    import CpfValidator from '../../components/validators/cpf.validator'

    import msgBR from 'vee-validate/dist/locale/pt_BR';
    
    Validator.localize('pt_BR', msgBR);
    Validator.extend('cpf', CpfValidator)

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
            MaskedInput
        },
        name: "cliente-edit",
        computed: {
            ...mapState({
                account: state => state.account
            })
        },
        data() {
            return {
                cliente: {
                    'alteracao': null,
                    'apelido': '',
                    'cpf': '',
                    'criacao': null,
                    'nacionalidade': '',
                    'nascimento': null,
                    'naturalidade': null,
                    'nome': '',
                    'sobrenome': ''
                },
                familiars: [],
                title: "Novo Cliente",
                cpfMask: [/\d/, /\d/, /\d/, '.', /\d/, /\d/, /\d/,'.', /\d/, /\d/, /\d/, '-', /\d/, /\d/]
            };
        },
        methods: {
            ...mapActions('waAlert',['showSuccess', 'showError']),
            detalhar(id) {
                ClienteDataService.get(this.account.user.empresa.id, id)
                    .then(response => {
                        this.cliente = response.data;
                        this.title = 'Editar '+this.cliente.apelido
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            listarFamiliars(id) {
                FamiliarDataService.getAll(this.account.user.empresa.id, id)
                    .then(response => {
                        this.familiars = response.data;
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
                this.cliente.alteracao = new Date();
                if(this.cliente.id){
                    ClienteDataService.update(this.account.user.empresa.id, this.$route.params.id, this.cliente)
                    .then(response => {
                        this.cliente = response.data;
                        this.showSuccess('Registro alterado com sucesso!');
                    })
                    .catch(e => {
                        this.showError('Não foi possível alterar o registro!');
                        console.log(e);
                    });
                }else{
                    this.cliente.criacao = new Date();
                    
                    ClienteDataService.create(this.account.user.empresa.id, this.cliente)
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
                this.listarFamiliars(id);
            }
        }
    };
</script>

