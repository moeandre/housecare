<template>
    <ContentWrapper>
        <div class="content-heading">
            {{title}}
            <div class="ml-auto">
                <button disabled="disabled" class="ml-auto btn btn-secondary btn-sm" type="button">Copiar esta fatura</button>
                <button class="btn btn-secondary right" @click="$router.go(-1)">Voltar</button>
            </div>    
        </div>
        <div class="card">
            <div class="card-body">
                <div class="d-flex align-items-center">
                    <h3 class="m-0">{{title}}</h3>
                </div>
                <hr/>
                <div class="row mb-3">
                    <div class="col-xl-4 col-6 br py-2">
                        <div class="row">
                            <div class="col-lg-2 text-center d-none d-lg-block">
                                <em class="fa icon-diamond fa-3x text-muted"></em>
                            </div>
                            <div class="col-lg-10">
                                <h4>{{fatura.cliente.nome}} {{fatura.cliente.sobrenome}}</h4>
                                <address>
                                    CPF: {{fatura.cliente.cpf}}
                                    <br>TIPO: {{fatura.tipo}}
                                </address>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-6 br py-2">
                        <div class="row">
                            <div class="col-lg-2 text-center d-none d-lg-block">
                                <em class="fa far fa-money-bill-alt fa-3x text-muted"></em>
                            </div>
                            <div class="col-lg-10" v-if="fatura.familiar">
                                <h4>{{fatura.familiar.nome}}</h4>
                                <address>
                                    CPF: {{fatura.familiar.cpf}}
                                    <br>E-MAIL: {{fatura.familiar.email}}
                                    <br>TELEFONE: {{fatura.familiar.telefone}}
                                </address>
                            </div>
                            <div class="col-lg-10" v-else>
                                <h4>{{fatura.cliente.nome}} {{fatura.cliente.sobrenome}}</h4>
                                <address>
                                    CPF: {{fatura.cliente.cpf}}
                                    <br>TIPO: {{fatura.tipo}}
                                </address>
                            </div>
                        </div>
                    </div>
                    <hr/>
                    <div class="col-xl-4 col-12 py-2">
                        <div class="clearfix">
                            <p class="float-left">FATURA Nº</p>
                            <p class="float-right mr-2">{{fatura.id}}</p>
                        </div>
                        <div class="clearfix">
                            <p class="float-left">Data</p>
                            <p class="float-right">{{fatura.data | formatDate}}</p>
                        </div>
                        <div class="clearfix">
                            <p class="float-left">Vencimento</p>
                            <p class="float-right">{{fatura.vencimento | formatDate}}</p>
                        </div>
                        <div class="clearfix">
                            <p class="float-left">Pagamento</p>
                            <p class="float-right" v-if="fatura.pagamento">{{fatura.pagamento | formatDate}}</p>
                            <p class="float-right" v-else>Pendente</p>
                        </div>
                    </div>
                </div>
                <div class="table-responsive table-bordered mb-3">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Item #</th>
                                <th>Descrição</th>
                                <th>Quantidade</th>
                                <th>Valor</th>
                                <th class="text-right">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="lancamento of fatura.lancamentos" v-bind:key="lancamento.id.id">
                                <td>{{lancamento.id.id}}</td>
                                <td>{{lancamento.nome}}</td>
                                <td class="text-right">{{lancamento.quantidade}}</td>
                                <td class="text-right">R$ {{lancamento.valor  | formatMoney}}</td>
                                <td class="text-right">R$ {{(lancamento.valor * lancamento.quantidade)  | formatMoney}}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="row">
                    <div class="col-lg-6"></div>
                    <div class="col-lg-6 py-2">
                        <div class="row mb-3">
                            <div class="col-8">Subtotal</div>
                            <div class="col-4">
                                <div class="text-right">R$ {{fatura.valor  | formatMoney}}</div>
                            </div>
                        </div>
                        <!--
                        <div class="row mb-3">
                            <div class="col-8">Tax (21%)</div>
                            <div class="col-4">
                                <div class="text-right">$ 2700</div>
                            </div>
                        </div>
                        -->
                        <div class="row mb-3 align-items-center">
                            <div class="col-7">
                                <div class="h3">TOTAL</div>
                            </div>
                            <div class="col-5">
                                <div class="text-right h3">R$ {{fatura.valor  | formatMoney}}</div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr class="d-print-none" />
                <div class="clearfix">
                    <button class="btn btn-info float-left mr-2" type="button">Edit</button>
                    <button class="btn btn-secondary float-left" type="button" onclick="window.print();">Print</button>
                    <button class="btn btn-success float-right" type="button">Send Invoice</button>
                </div>
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
                fatura: {}
            };
        },
        methods: {
            detalhar(id) {
                FaturaDataService.get(this.account.user.empresa.id, id)
                    .then(response => {
                        this.fatura = response.data;
                    })
                    .catch(e => {
                        console.log(e);
                    });
            }
        },
        mounted() {
            if(this.$route.params.id){
                let id = this.$route.params.id;
                this.title = "Fatura "+id;
                this.detalhar(id);
            }
        }
    }
</script>