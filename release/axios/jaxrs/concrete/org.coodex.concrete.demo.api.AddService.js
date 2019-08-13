/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const AddService = {
    'add': function (x1, x2) {
        return execute(module, `/OrgCoodexConcreteDemoApiAddService/add`, 'json', 'POST', { x1, x2 });
    }
}

export default AddService


