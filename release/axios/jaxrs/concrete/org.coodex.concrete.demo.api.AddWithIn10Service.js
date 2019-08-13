/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const AddWithIn10Service = {
    'add': function (x1, x2) {
        return execute(module, `/OrgCoodexConcreteDemoApiAddWithIn10Service/add`, 'json', 'POST', { x1, x2 });
    }
}

export default AddWithIn10Service


