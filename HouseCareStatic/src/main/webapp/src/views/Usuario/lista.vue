<template>
    <ContentWrapper>
        <div class="content-heading">Usuários
            <div class="ml-auto">
                <router-link class="btn bg-primary-light right" tag="a" to="/usuario/criar">Adicionar Novo</router-link>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-sm-6" v-for="funcionario of funcionarios" v-bind:key="funcionario.id.idUsuario">

                <div class="card card-default">
                    <div class="card-body text-center">
                        <img class="mb-2 img-fluid rounded-circle thumb64" src="img/user/13.jpg" />
                        <h4>{{funcionario.usuario.nome}}</h4>
                        <p>{{funcionario.usuario.email}}</p>
                        <p>{{funcionario.situacao == 'A' ? 'Ativo' : 'Inativo'}}</p>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="ml-auto">
                            <router-link class="btn btn-xs btn-secondary" tag="a" :to="{ name: 'editar-funcionario', params: { id: funcionario.id.idUsuario }}">Visualizar</router-link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </ContentWrapper>
</template>
<script>
    import { mapState, mapMutations } from 'vuex'
    import FuncionarioDataService from "../../services/FuncionarioDataService";
    
    export default {
        name: "funcionario-list",
        computed: {
            ...mapState({
                account: state => state.account
            })
        },
        data() {
            return {
                funcionarios: [],
                title: ""
            };
        },
        methods: {
            listar() {
                FuncionarioDataService.getAll(this.account.user.empresa.id)
                    .then(response => {
                        this.funcionarios = response.data;
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
