package generictype.functional_interface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public abstract class BaseResultValueConverter<T, N, R, E extends Exception> {

    protected <T> T getValueFromResultSet(ResultSet resultSet, String valueName, T defaultValue, ThrowingBiFunction<ResultSet, String, T, SQLException> extractor) {
        try {
            return Optional.ofNullable(extractor.apply(resultSet, valueName))
                    .orElse(defaultValue);
        } catch (SQLException e) {
            return defaultValue;
        }
    }
}
