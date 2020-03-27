<template>
    <ContentWrapper>
        <div class="content-heading">Lançamentos da Fatura
            <div class="ml-auto">
               <router-link class="btn btn-secondary right" tag="a" to="/cliente/1/fatura/criar">Adicionar Novo</router-link>
               <router-link class="btn btn-secondary right" tag="a" to="/cliente/editar/1">Voltar</router-link>
            </div>
        </div>
        <div class="card card-default">
            <div class="table-responsive">
               <table class="table table-bordered table-hover" id="table-familiares">
                    <thead>
                        <tr>
                            <th>UID</th>
                            <th>Item</th>
                            <th>Valor</th>
                            <th>Faturado</th>
                            <th>Data</th>
                            <th>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Compra</td>
                            <td class="text-right"> R$ 1,30</td>
                            <td class="text-right">
                                
                            </td>
                            <td>10/03/2020</td>
                            <td class="text-right">
                                <div class="btn-group">
                                    <a class="btn btn-secondary btn-xs" :href="'/familiar/editar/1'"><i class="fa fa-edit"></i></a>
                                    <button class="btn btn-danger btn-xs" type="button"><i class="fa fa-trash"></i></button>
                                </div> 
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Compra</td>
                            <td class="text-right"> R$ 1,30</td>
                            <td class="text-right">
                                10
                            </td>
                            <td>10/03/2020</td>
                            <td class="text-right">
                                <div class="btn-group">
                                    <a class="btn btn-secondary btn-xs disabled" :href="'/familiar/editar/1'"><i class="fa fa-edit"></i></a>
                                    <button class="btn btn-danger btn-xs disabled" type="button" disabled="disabled"><i class="fa fa-trash"></i></button>
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
    import Vue from 'vue';
    import { ClientTable } from 'vue-tables-2';

    Vue.use(ClientTable);

    const tableData = [
        {"engine": "Trident", "browser": "Internet Explorer 4.0", "platform": "Win 95+", "version": "4", "grade": "X"},
        {"engine": "Trident","browser": "Internet Explorer 5.0","platform": "Win 95+","version": "5","grade": "C"},
        {"engine": "Trident","browser": "Internet Explorer 5.5","platform": "Win 95+","version": "5.5","grade": "A"},
        {"engine": "Trident","browser": "Internet Explorer 6","platform": "Win 98+","version": "6","grade": "A"},
        {"engine": "Trident", "browser": "Internet Explorer 7", "platform": "Win XP SP2+", "version": "7", "grade": "A"},
        {"engine": "Trident", "browser": "AOL browser (AOL desktop)", "platform": "Win XP", "version": "6", "grade": "A"},
        {"engine": "Gecko", "browser": "Firefox 1.0", "platform": "Win 98+ / OSX.2+", "version": "1.7", "grade": "A"},
        {"engine": "Gecko", "browser": "Firefox 1.5", "platform": "Win 98+ / OSX.2+", "version": "1.8", "grade": "A"},
        {"engine": "Gecko", "browser": "Firefox 2.0", "platform": "Win 98+ / OSX.2+", "version": "1.8", "grade": "A"},
        {"engine": "Gecko", "browser": "Firefox 3.0", "platform": "Win 2k+ / OSX.3+", "version": "1.9", "grade": "A"},
        {"engine": "Gecko", "browser": "Camino 1.0", "platform": "OSX.2+", "version": "1.8", "grade": "A"},
        {"engine": "Gecko", "browser": "Camino 1.5", "platform": "OSX.3+", "version": "1.8", "grade": "A"},
        {"engine": "Trident", "browser": "Internet Explorer 4.0", "platform": "Win 95+", "version": "4", "grade": "X"},
        {"engine": "Trident","browser": "Internet Explorer 5.0","platform": "Win 95+","version": "5","grade": "C"},
        {"engine": "Trident","browser": "Internet Explorer 5.5","platform": "Win 95+","version": "5.5","grade": "A"},
        {"engine": "Trident","browser": "Internet Explorer 6","platform": "Win 98+","version": "6","grade": "A"},
        {"engine": "Trident", "browser": "Internet Explorer 7", "platform": "Win XP SP2+", "version": "7", "grade": "A"},
        {"engine": "Trident", "browser": "AOL browser (AOL desktop)", "platform": "Win XP", "version": "6", "grade": "A"},
        {"engine": "Gecko", "browser": "Firefox 1.0", "platform": "Win 98+ / OSX.2+", "version": "1.7", "grade": "A"},
        {"engine": "Gecko", "browser": "Firefox 1.5", "platform": "Win 98+ / OSX.2+", "version": "1.8", "grade": "A"},
        {"engine": "Gecko", "browser": "Firefox 2.0", "platform": "Win 98+ / OSX.2+", "version": "1.8", "grade": "A"},
        {"engine": "Gecko", "browser": "Firefox 3.0", "platform": "Win 2k+ / OSX.3+", "version": "1.9", "grade": "A"},
        {"engine": "Gecko", "browser": "Camino 1.0", "platform": "OSX.2+", "version": "1.8", "grade": "A"},
        {"engine": "Gecko", "browser": "Camino 1.5", "platform": "OSX.3+", "version": "1.8", "grade": "A"},
        {"engine": "Trident", "browser": "AOL browser (AOL desktop)", "platform": "Win XP", "version": "6", "grade": "A"}
    ]

    export default {
        components: {
            ClientTable
        },
        data() {
            return {
                tableData: [],
                columns: ['engine', 'browser', 'version', 'action'],
                options: {
                  pagination: { chunk: 5 },
                  
                  filterable: false,
                  sortIcon: {
                    is: 'fa-sort',
                    base: 'fas',
                    up: 'fa-sort-up',
                    down: 'fa-sort-down'
                  }
                }
            }
        },
        created () {
            // Add IDs for child rows functionality
            this.tableData = tableData.map((item, index) => {
                item['id'] = index
                return item
            })
        },
        methods: {
            edit (row) {
              alert(`Editing row id: ${row.id}`)
            },
            remove (row) {
                this.tableData = this.tableData.filter(item => (row.id !== item.id));
            },
            reload() {
                this.tableData = tableData;
            },
            clear() {
                this.tableData = [];
            }
        }
    }
</script>
