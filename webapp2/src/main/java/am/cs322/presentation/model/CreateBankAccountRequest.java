package am.cs322.presentation.model;

import jakarta.annotation.Nonnull;

public record CreateBankAccountRequest(@Nonnull
                                       String firstName,
                                       @Nonnull
                                       String lastName,
                                       double balance) {
}
