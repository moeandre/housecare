const parentesco = {
    values : [
        {key: '1', value: 'Pai/Mãe'},
        {key: '2', value: 'Avô/Avó'},
        {key: '3', value: 'Filho(a)'},
        {key: '4', value: 'Neto(a)'},
        {key: '5', value: 'Bisnetpo(a)'},
        {key: '6', value: 'Irmão/Irmã'},
        {key: '7', value: 'Tia(a)'},
        {key: '8', value: 'Sobrinho(a)'},
        {key: '0', value: 'Outros'}
    ],
    get (key) { 
        let value = this.values.filter(
            function(data){ return data.key === key }
        );
        return (value[0]) ? value[0].value || key : key;
    }
};
export default parentesco;