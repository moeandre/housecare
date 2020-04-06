import CpfValidate from './rules/cpf'

const validator = {
  getMessage (field, args) { // will be added to default English messages.
    return 'CPF inválido'
  },
  validate (value, args) {
    return CpfValidate(value)
  }
}
export default validator