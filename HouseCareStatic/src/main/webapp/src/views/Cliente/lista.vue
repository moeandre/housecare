<template>
    <ContentWrapper>
        <div class="content-heading">Clientes
            <div class="ml-auto">
               <a class="btn btn-secondary right" :href="'/cliente/criar/'">Adicionar Novo</a>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-sm-6" 
               >
                <div class="card card-default">
                    <div class="card-header text-right">
                        <b-dropdown id="ddown1" variant="link" no-caret right>
                                <template slot="button-content">
                                    <em class="fa fa-ellipsis-v fa-lg text-muted"></em>
                                </template>
                                <b-dropdown-item>Conta Corrente</b-dropdown-item>
                                <b-dropdown-item>Serviços</b-dropdown-item>
                                <b-dropdown-item>Inventário</b-dropdown-item>
                                <b-dropdown-item>Lançamentos de Fatura</b-dropdown-item>
                                <b-dropdown-divider></b-dropdown-divider>
                                <b-dropdown-item>Anotações</b-dropdown-item>
                                <b-dropdown-item>Hospedagem</b-dropdown-item>
                            </b-dropdown>
                            

                    </div>
                    <div class="card-body text-center">
                        
                        <img class="mb-2 img-fluid rounded-circle thumb64" src="img/user/13.jpg" />
                        <h4>Joana</h4>
                        <p>Teresinha Joana</p>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="ml-auto">
                            <a class="btn btn-xs btn-secondary" :href="'/cliente/editar/1'">Visualizar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </ContentWrapper>
</template>
<script>
    import ClienteDataService from "../../services/ClienteDataService";
    export default {
        name: "cliente-list",
        data() {
            return {
                clientes: [],
                title: ""
            };
        },
        methods: {
            listar() {
                /*ClienteDataService.getAll()
                    .then(response => {
                        this.clientes = response.data.results;
                    })
                    .catch(e => {
                        console.log(e);
                    });*/
            },
            
        },
        mounted() {
            this.listar();
        }
    };
</script>
