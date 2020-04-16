<template>
    <ContentWrapper>
        <div class="content-heading">{{title}}
        </div>
        <!-- START row-->
        <div class="row">
            <div class="col-xl-4 col-lg-6">
                <!-- START card-->
                <div class="card bg-success-dark border-0">
                    <div class="row align-items-center mx-0">
                        <div class="col-3 text-center">
                            <em class="fa fa-3x fa-money-bill"></em>
                        </div>
                        <div class="col-9 py-3 bg-success rounded-right text-right">
                            <div class="h2 m-0 text-bold">R$ 15.000,00</div>
                            <div class="text-uppercase">Recebido</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-4 col-lg-12">
                <!-- START card-->
                <div class="card bg-warning-dark border-0">
                    <div class="row align-items-center mx-0">
                        <div class="col-3 text-center">
                            <em class="fa fa-3x fas fa-hand-holding-usd"></em>
                        </div>
                        <div class="col-9 py-3 bg-warning rounded-right text-right">
                            <div class="h2 m-0 text-bold">R$ 30.000,00</div>
                            <div class="text-uppercase">A Receber</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-4 col-lg-6">
                <!-- START card-->
                <div class="card bg-danger-dark border-0">
                    <div class="row align-items-center mx-0">
                        <div class="col-3 text-center">
                            <em class="fa fa-3x fas fa-hand-holding"></em>
                        </div>
                        <div class="col-9 py-3 bg-danger rounded-right text-right">
                            <div class="h2 m-0 text-bold">R$ 7.500,00</div>
                            <div class="text-uppercase">Em Atraso</div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <!-- END row-->
        <div class="card card-default">
            <div class="table-responsive">
                <table class="table table-bordered table-hover" id="table-faturas">
                    <thead>
                        <tr>
                            <th>UUID</th>
                            <th>Cliente</th>
                            <th>Valor</th>
                            <th>Data</th>
                            <th>Vencimento</th>
                            <th>Pagamento</th>
                            <th>Tipo</th>
                            <th>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="fatura of faturas" v-bind:key="fatura.id">
                            <td>{{fatura.id}}</td>
                            <td>{{fatura.cliente.nome}}</td>
                            <td class="text-right">{{fatura.valor | formatMoney}}</td>
                            <td class="text-right">{{fatura.data | formatDate}}</td>
                            <td class="text-right">{{fatura.vencimento | formatDate}}</td>
                            <td class="text-right">{{fatura.pagamento | formatDate}}</td>
                            <td>{{fatura.tipo}}</td>
                            <td class="text-right">
                                <div class="btn-group">
                                    <router-link class="btn btn-xs btn-secondary" tag="a" :to="{ name: 'detalhar-fatura', params: { id: fatura.id }}">
                                        <i class="fa icon-magnifier"></i>
                                    </router-link>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        
    </ContentWrapper>
</template>
<script>
    import Vue from "vue";

    import moment from "moment";
    import { mapState, mapActions } from "vuex";

    import FaturaDataService from "../../services/FaturaDataService";

    Vue.filter("formatDate", function(value) {
        if (value) {
            return moment(value).format("DD/MM/YYYY HH:mm:ss");
        }
    });

    export default {
        name: "fatura-list",
        computed: {
            ...mapState({
                account: state => state.account
            })
        },
        data() {
            return {
                title: "Faturamento",
                faturas: {}
            };
        },
        methods: {
            listar() {
                FaturaDataService.getAll(this.account.user.empresa.id)
                    .then(response => {
                        this.faturas = response.data;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            }
        },
        mounted() {
            this.listar();
        }
    };
</script>
