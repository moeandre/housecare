const parentesco = {
    values : [
        {key: 'pais', value: 'Pai/Mãe'},
        {key: 'avos', value: 'Avô/Avó'},
        {key: 'filhos', value: 'Filho(a)'},
        {key: 'netos', value: 'Neto(a)'},
        {key: 'bisnetos', value: 'Bisnetpo(a)'},
        {key: 'irmaos', value: 'Irmão/Irmã'},
        {key: 'tios', value: 'Tia(a)'},
        {key: 'sobrinhos', value: 'Sobrinho(a)'},
        {key: 'outros', value: 'Outros'}
    ],
    get (key) { 
        let value = this.values.filter(
            function(data){ return data.key === key }
        );
        return (value[0]) ? value[0].value || key : key;
    }
};
export default parentesco;