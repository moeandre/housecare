<template>
    <ContentWrapper>
        <div class="content-heading">Hospedagem
            <div class="ml-auto">
               <router-link class="btn btn-secondary right" tag="a" to="/cliente/editar/1">Voltar</router-link>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-sm-4">
                <div class="card card-default">
                    <div class="card-body">
                        <a class="text-muted float-right" href="#">
                            <em class="fa fa-arrow-right"></em>
                        </a>
                        <div class="text-info">Quarto 1</div>
                        <div class="text-center py-4">
                            <div ref="easypie1" class="easypie-chart easypie-chart-lg" data-percent="66">
                                <span>66%</span>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <div class="d-flex align-items-center flex-wrap justify-content-center">
                            <a href="#" v-b-tooltip.hover title="Tamara">
                                <img class="circle thumb24 mx-1" src="img/user/03.jpg" alt="Follower">
                            </a>
                            <a href="#" v-b-tooltip.hover title="Gene">
                                <img class="circle thumb24 mx-1" src="img/user/04.jpg" alt="Follower">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-4">
                <div class="card card-default">
                    <div class="card-body">
                        <a class="text-muted float-right" href="#">
                            <em class="fa fa-arrow-right"></em>
                        </a>
                        <div class="text-info">Quarto 2</div>
                        <div class="text-center py-4">
                            <div ref="easypie2" class="easypie-chart easypie-chart-lg" data-percent="75">
                                <span>75%</span>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <div class="d-flex align-items-center flex-wrap justify-content-center">
                            <a href="#" v-b-tooltip.hover title="Tamara">
                                <img class="circle thumb24 mx-1" src="img/user/03.jpg" alt="Follower">
                            </a>
                            <a href="#" v-b-tooltip.hover title="Gene">
                                <img class="circle thumb24 mx-1" src="img/user/02.jpg" alt="Follower">
                            </a>
                            <a href="#" v-b-tooltip.hover title="Marsha">
                                <img class="circle thumb24 mx-1" src="img/user/04.jpg" alt="Follower">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-4">
                <div class="card card-default">
                    <div class="card-body">
                        <a class="text-muted float-right" href="#">
                            <em class="fa fa-arrow-right"></em>
                        </a>
                        <div class="text-info">Quarto 3</div>
                        <div class="text-center py-4">
                            <div ref="easypie3" class="easypie-chart easypie-chart-lg" data-percent="100">
                                <span>100%</span>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <div class="d-flex align-items-center flex-wrap justify-content-center">
                            <a href="#" v-b-tooltip.hover title="Tamara">
                                <img class="circle thumb24 mx-1" src="img/user/03.jpg" alt="Follower">
                            </a>
                            <a href="#" v-b-tooltip.hover title="Gene">
                                <img class="circle thumb24 mx-1" src="img/user/02.jpg" alt="Follower">
                            </a>
                            <a href="#" v-b-tooltip.hover title="Marsha">
                                <img class="circle thumb24 mx-1" src="img/user/04.jpg" alt="Follower">
                            </a>
                            <a href="#" v-b-tooltip.hover title="Marsha">
                                <img class="circle thumb24 mx-1" src="img/user/09.jpg" alt="Follower">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </ContentWrapper>
</template>
<script>
    import EasyPieChart from 'easy-pie-chart';
   
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
            let pieOptions1 = {
                animate: {
                    duration: 800,
                    enabled: true
                },
                barColor: '#23b7e5',
                trackColor: 'rgba(200,200,200,0.4)',
                scaleColor: false,
                lineWidth: 10,
                lineCap: 'round',
                size: 145
            };
            new EasyPieChart(this.$refs.easypie1, pieOptions1);
            new EasyPieChart(this.$refs.easypie2, pieOptions1);
            new EasyPieChart(this.$refs.easypie3, pieOptions1);
        }
    };
</script>
