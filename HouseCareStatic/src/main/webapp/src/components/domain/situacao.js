const situacao = {
    values : [
        {key: 'A', value: 'Ativo'},
        {key: 'I', value: 'Itativo'}
    ],
    get (key) { 
        let value = this.values.filter(
            function(data){ return data.key === key }
        );
        return (value[0]) ? value[0].value || key : key;
    }
};
export default situacao;