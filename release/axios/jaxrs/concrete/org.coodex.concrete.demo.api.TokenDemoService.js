/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const TokenDemoService = {
    'setTokenValue': function (value) {
        return execute(module, `/OrgCoodexConcreteDemoApiTokenDemoService/tokenValue`, 'json', 'PUT', value);
    }, 
    'getTokenValue': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiTokenDemoService/tokenValue`, 'text', 'GET');
    }
}

export default TokenDemoService


