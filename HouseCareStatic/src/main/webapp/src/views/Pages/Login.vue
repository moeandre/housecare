<template>
    <div class="block-center mt-4 wd-xl">
        <!-- START card-->
        <div class="card card-flat">
            <div class="card-header text-center bg-dark">
                <a href="#">
                    <img class="block-center rounded" src="img/logo.png" alt="Image" />
                </a>
            </div>
            <div class="card-body">
                <p class="text-center py-2">EFETUE O LOGIN PARA CONTINUAR.</p>
                <form class="mb-3" @submit.prevent="validateBeforeSubmit('login')" data-vv-scope="login">
                    <div class="form-group">
                        <div class="input-group with-focus">
                            <input :class="{'form-control border-right-0':true, 'is-invalid': errors.has('login.email')}" placeholder="Digite seu e-mail" v-model="login.user" v-validate="'required|email'" type="text" name="email"/>
                            <div class="input-group-append">
                                <span class="input-group-text text-muted bg-transparent border-left-0">
                                    <em class="fa fa-envelope"></em>
                                </span>
                            </div>
                            <span v-show="errors.has('login.email')" class="invalid-feedback">{{ errors.first('login.email') }}</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group with-focus">
                            <input :class="{'form-control  border-right-0':true, 'is-invalid': errors.has('login.password')}" v-model="login.pass" v-validate="'required'" type="password" name="password" placeholder="Informe a Senha"/>
                            <div class="input-group-append">
                                <span class="input-group-text text-muted bg-transparent border-left-0">
                                    <em class="fa fa-lock"></em>
                                </span>
                            </div>
                            <span v-show="errors.has('login.password')" class="invalid-feedback">{{ errors.first('login.password') }}</span>
                        </div>
                    </div>
                    <div class="clearfix">
                        <div class="float-left">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" name="rememberme" id="rememberme" v-model="login.rememberme">
                                <label class="custom-control-label" for="rememberme">Lembrar meu acesso.</label>
                            </div>
                        </div>
                        <div class="float-right">
                            <router-link class="text-muted" to="/recover">
                                <small>Esqueceu sua senha?</small>
                            </router-link>
                        </div>
                    </div>
                    <button class="btn btn-block btn-primary mt-3" type="submit">Login</button>
                </form>
            </div>
        </div>
        <!-- END card-->
        <div class="p-3 text-center">
            <span class="mr-2">&copy;</span>
            <span>2020</span>
            <span class="mr-2">-</span>
            <span>House Care</span>
           
        </div>
    </div>
</template>
<script>
    import Vue from 'vue'
    import { mapState, mapActions } from 'vuex'
    import VeeValidate from 'vee-validate';
    
    Vue.use(VeeValidate, {
        fieldsBagName: 'formFields'  // fix issue with b-table
    })

    export default {
        data() {
            return {
                login: {
                    user: '',
                    pass: '',
                    rememberme: false
                }
            }
        },
        computed: {
            ...mapState('account', ['status'])
        },
        created () {
           this.logoutRequest();
        },
        methods: {
            ...mapActions('account', ['loginRequest', 'logoutRequest']),
            validateBeforeSubmit(scope) {
                this.$validator.validateAll(scope).then((result) => {
                    if (result) {
                        this.loginRequest(this.login);
                        return;
                    }
                    console.log('Correct them errors!');
                });
            }
        }
    }
</script>
