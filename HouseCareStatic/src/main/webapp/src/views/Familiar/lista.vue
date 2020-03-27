<template>
    <ContentWrapper>
        <div class="content-heading">Familiares
            <div class="ml-auto">
               <a class="btn btn-secondary right" :href="'/familiar/criar/'">Adicionar Novo</a>
            </div>
        </div>
        <div class="card card-default">
            <div class="table-responsive">
                <table class="table table-bordered table-hover" id="table-familiares">
                    <thead>
                        <tr>
                            <th>UID</th>
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
                        <tr>
                            <td>1</td>
                            <td>Familiar 1</td>
                            <td>Filho</td>
                            <td>(11) 1234-5678</td>
                            <td>mail@example.com</td>
                            <td>11/11/1111</td>
                            <td class="text-center">
                                Sim
                            </td>
                            <td class="text-right">
                                <div class="btn-group">
                                    <a class="btn btn-secondary btn-xs" :href="'/familiar/editar/1'"><i class="fa fa-edit"></i></a>
                                    <button class="btn btn-danger btn-xs" type="button"><i class="fa fa-trash"></i></button>
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
