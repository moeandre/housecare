<template>
    <ContentWrapper>
        <div class="content-heading">Clientes
            <div class="ml-auto">
                <router-link class="btn btn-secondary right" tag="a" to="/cliente/criar">Adicionar Novo</router-link>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-sm-6" v-for="cliente of clientes" v-bind:key="cliente.id.id">

                <div class="card card-default">
                    <div class="card-header text-right">
                        <b-dropdown id="ddown1" variant="link" no-caret right>
                            <template slot="button-content">
                                <em class="fa fa-ellipsis-v fa-lg text-muted"></em>
                            </template>
                            <b-dropdown-item>
                                <router-link tag="a" :to="{ name: 'fatura-cliente', params: { id: cliente.id.id }}">Lançamentos de Fatura</router-link>
                            </b-dropdown-item>
                            <b-dropdown-divider></b-dropdown-divider>
                            <b-dropdown-item>
                                <router-link tag="a" :to="{ name: 'anotacao-cliente', params: { id: cliente.id.id }}">Anotações</router-link>
                            </b-dropdown-item>
                            <b-dropdown-item>
                                <router-link tag="a" :to="{ name: 'hospedagem-cliente', params: { id: cliente.id.id }}">Hospedagem</router-link>
                            </b-dropdown-item>
                        </b-dropdown>
                    </div>
                    <div class="card-body text-center">
                        
                        <img class="mb-2 img-fluid rounded-circle thumb64" src="img/user/13.jpg" />
                        <h4>{{cliente.apelido}}</h4>
                        <p>{{cliente.nome}}</p>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="ml-auto">
                            <router-link class="btn btn-xs btn-secondary" tag="a" :to="{ name: 'editar-cliente', params: { id: cliente.id.id }}">Visualizar</router-link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </ContentWrapper>
</template>
<script>
    import { mapState, mapMutations } from 'vuex'
    import ClienteDataService from "../../services/ClienteDataService";
    export default {
        name: "cliente-list",
        computed: {
            ...mapState({
                account: state => state.account
            })
        },
        data() {
            return {
                clientes: [],
                title: ""
            };
        },
        methods: {
            listar() {
                ClienteDataService.getAll(this.account.user.empresa.id)
                    .then(response => {
                        this.clientes = response.data;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            
        },
        mounted() {
            this.listar();
        }
    };
</script>
