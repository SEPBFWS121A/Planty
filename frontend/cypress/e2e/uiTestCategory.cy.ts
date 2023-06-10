import { forEach } from 'cypress/types/lodash';
describe('UI Test Category', () => {
    before(() => {
        cy.visit('http://localhost:4200/category');
    });

    describe('Check UI-Elements', () => {
        it('Check Submit Button', () => {
            //Check if buttons exist
            cy.contains('button', 'Add Category').should('exist');
        });

        it('Check name field', () => {
            //Check if field exist
            cy.get('input[placeholder="Name"]').should('exist');
        });

        it('Check description field', () => {
            //Check if field exist
            cy.get('input[placeholder="Description"]').should('exist');
        });

        it('Check min humidity field', () => {
            //Check if field exist
            cy.get('input[placeholder="Min Humidity Level"]').should('exist');
        });
    });

    describe('Check UI-Elements functionality', () => {
        it('fill out form, submits and deletes the category', () => {
            cy.get('input[placeholder="Name"]').type('Category Name');
            cy.get('input[placeholder="Description"]').type('Category Description');
            cy.get('input[placeholder="Min Humidity Level"]').type('10');

            cy.get('button').contains('Add Category').click();

            // Find the button within the last <td> element
            cy.get('td.mat-cell.cdk-column-delete button.mat-button').click();
        });
    });
});
