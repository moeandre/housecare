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
                            <div class="h2 m-0 text-bold">R$ {{(dashboard.pago | 0) | formatMoney}}</div>
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
                            <div class="h2 m-0 text-bold">R$ {{(dashboard.aVencer | 0) | formatMoney}}</div>
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
                            <div class="h2 m-0 text-bold">R$ {{ (dashboard.vencido | 0) | formatMoney}}</div>
                            <div class="text-uppercase">Em Atraso</div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <!-- END row-->
        <div class="card card-default">
            <div class="row mt-2">
                <div class="offset-md-4 col-md-1"><button class="btn bg-primary-light right" @click="subDate()"><</button></div>
                <div class="col-md-2 text-center"><h2>{{filterDate | formatMesAno}}</h2></div>
                <div class="col-md-1"><button class="btn bg-primary-light right" @click="addDate()">></button></div>
            </div>
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
                            <td class="text-right">R$ {{fatura.valor | formatMoney}}</td>
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
            return moment(value).format("DD/MM/YYYY");
        }
    });

    Vue.filter("formatMesAno", function(value) {
        if (value) {
            return moment(value).format("MMM YYYY");
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
                faturas: {},
                dashboard: {
                    'total': 0,
                    'pago': 0,
                    'aVencer': 0,
                    'vencido': 0
                },
                filterDate: new Date()
            };
        },
        methods: {
            listar() {
                let mesano = moment(this.filterDate).format("YYYYMM");
                FaturaDataService.getByMesAno(this.account.user.empresa.id,mesano)
                    .then(response => {
                        this.faturas = response.data;
                    })
                    .catch(e => {
                        this.faturas = {};
                        console.log(e);
                    });
            },
            dash() {
                let mesano = moment(this.filterDate).format("YYYYMM");
                FaturaDataService.dash(this.account.user.empresa.id, mesano)
                    .then(response => {
                        this.dashboard = response.data;
                    })
                    .catch(e => {
                        this.dashboard = {
                            'total': 0,
                            'pago': 0,
                            'aVencer': 0,
                            'vencido': 0
                        };
                        console.log(e);
                    });
            },
            load(){
                this.listar();
                this.dash();
            },
            addDate(){
                let d = this.filterDate;
                d.setMonth(d.getMonth() + 1);
                this.filterDate = d;
                this.load();
            },
            subDate(){
                let d = this.filterDate;
                d.setMonth(d.getMonth() - 1);
                this.filterDate = d;
                this.load();
            }

        },
        mounted() {
            this.load();
        }
    };
</script>
