import swal from 'sweetalert2'

const actions = {
    showSuccess({}, message){
        swal({
                title: "Bom trabalho!",
                text: message,
                type: "success",
                heightAuto: false
            })
    },
    showError({}, message){
        swal({
                title: "Atenção!",
                text: message,
                type: "error",
                heightAuto: false
            })
    },
    showAlert({}, message){
        swal({
                title: "Atenção!",
                text: message,
                type: "warning",
                heightAuto: false
            })
    },
    showConfirmation({}, message){
        return swal({
            title: "Tem certeza?",
            text: message,
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Confirmar",
            cancelButtonText: "Cancelar",
            heightAuto: false
        });
          
    }
};

export const waAlert = {
    namespaced: true,
    actions
};

export default waAlert;
