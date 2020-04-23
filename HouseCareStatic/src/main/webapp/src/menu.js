const Menu = [
    {
        heading: 'Menu Principal',
        translate: 'Menu Principal'
    },
    {
        name: 'Cliente/Hospedagem',
        icon: 'icon-diamond',
        translate: 'Cliente/Hospedagem',
        submenu: [{
                name: 'Dados Cadastrais',
                path: '/cliente'
            },
            {
                name: 'Familiares',
                path: '/familiar'
            },
            /*{
                name: 'Hospedagem',
                path: '/cliente'
            },
            {
                name: 'Inventário',
                path: '/cliente'
            },
            {
                name: 'Farmácia',
                path: '/cliente'
            },
            {
                name: 'Serviços',
                path: '/cliente'
            },
            {
                name: 'Conta Corrente',
                path: '/cliente'
            },
            {
                name: 'Fatura',
                path: '/cliente'
            }*/
        ]
    },
    {
        name: 'Financeiro',
        icon: 'fa fa-money-bill-alt',
        translate: 'Financeiro',
        submenu: [{
                name: 'Faturamento',
                path: '/fatura'
            }
        ]
    },
    {
        name: 'Usuários',
        icon: 'fa fa-cog',
        translate: 'Usuários',
        submenu: [{
                name: 'Cadastro',
                path: '/usuario'
            }
        ]
    },
    {
        name: 'Médico',
        icon: 'fa fa-hospital',
        translate: 'Médico',
        submenu: [{
                name: 'Anotações',
                path: '/medico/anotacao'
            },
            {
                name: 'Prescrição',
                path: '/medico/prescricao'
            },
            {
                name: 'Evolução do Cliente',
                path: '/medico/evolucao-cliente'
            }
        ]
    },
    {
        name: 'Enfermagem',
        icon: 'fa fa-heart',
        translate: 'Enfermagem',
        submenu: [{
                name: 'Anotações',
                path: '/enfermagem/anotacao'
            },
            {
                name: 'Prescrição',
                path: '/enfermagem/prescricao'
            },
            {
                name: 'Evolução do Cliente',
                path: '/enfermagem/evolucao-cliente'
            }
        ]
    },
    {
        name: 'Nutrição',
        icon: 'fa fa-lemon',
        translate: 'Nutrição',
        submenu: [{
                name: 'Anotações',
                path: '/nutricao/anotacao'
            },
            {
                name: 'Prescrição',
                path: '/nutricao/prescricao'
            },
            {
                name: 'Evolução do Cliente',
                path: '/nutricao/evolucao-cliente'
            }
        ]
    },
    {
        name: 'Auxiliar de Enfermagem',
        icon: 'fa fa-pills',
        translate: 'Médico',
        submenu: [{
                name: 'Anotações',
                path: '/auxiliar-enfermagem/anotacao'
            }
        ]
    },
    {
        name: 'Configurações',
        icon: 'fa fa-cogs',
        translate: 'Configurações',
        submenu: [{
                name: 'Companhia',
                path: '/configuracoes/companhia'
            },
            {
                name: 'Quartos',
                path: '/configuracoes/quartos'
            }
        ]
    },
    {
        name: 'Sair',
        icon: 'fa fa-sign-out-alt',
        path: '/login'
    }
];

export default Menu;