/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const LibraryB = {
    'sort': function () {
        return execute(module, `/B/Books/sort`, 'json', 'GET');
    }, 
    'delete': function (name) {
        return execute(module, `/B/Books/${name}`, 'json', 'DELETE');
    }
}

export default LibraryB


