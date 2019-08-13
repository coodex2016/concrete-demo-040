/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const DemoLoginService = {
    'login': function (id) {
        return execute(module, `/OrgCoodexConcreteDemoApiExceptedDemoLoginService/login`, 'json', 'POST', id);
    }
}

export default DemoLoginService


