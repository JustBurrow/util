package kr.lul.commons.util;

import java.util.Objects;

import static kr.lul.commons.util.Arguments.notNull;

/**
 * 컴포저 부분 구현.
 *
 * @param <S> 원본 자료형.
 *
 * @author justburrow
 * @since 2018. 9. 19.
 */
public abstract class AbstractComposer<S> implements Composer<S> {
    protected final Class<S> sourceType;
    protected final ConverterId id;

    protected AbstractComposer(Class<S> sourceType) {
        notNull(sourceType, "sourceType");

        this.sourceType = sourceType;
        this.id = new ConverterId(sourceType, String.class);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // kr.lul.commons.util.Composer
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ConverterId getId() {
        return this.id;
    }

    @Override
    public Class<S> getSourceClass() {
        return this.sourceType;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // java.lang.Object
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractComposer)) return false;
        AbstractComposer<?> that = (AbstractComposer<?>) o;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}
