/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.nomina.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//DatoGeneralEmpleadoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class DatoGeneralEmpleadoDataAccess extends  DatoGeneralEmpleadoDataAccessAdditional{ //DatoGeneralEmpleadoDataAccessAdditional,DataAccessHelper<DatoGeneralEmpleado>
	//static Logger logger = Logger.getLogger(DatoGeneralEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="dato_general_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+"(id,version_row,id_numero_patronal,id_tipo_afiliacion,carnet_iess,sectorial_iess,id_pais,id_provincia,id_canton,id_parroquia,fecha_nacimiento,fecha_fallece,valor_evaluacion,numero_horas,valor_hora,salario,id_moneda,numero_contrato,id_tipo_contrato,valor1,valor2,valor3,valor4,valor5,valor6,con_aporta_seguro_social,con_recibe_horas_extras,con_descuento_impuestos,pension_alimenticia,con_pago_por_horas,con_anticipo,id_tipo_libreta_mili,libreta_militar,id_tipo_grupo_forma_pago,id_banco,id_tipo_cuenta_banco_global,numero_cuenta,id_tipo_sangre)values(?,current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_numero_patronal=?,id_tipo_afiliacion=?,carnet_iess=?,sectorial_iess=?,id_pais=?,id_provincia=?,id_canton=?,id_parroquia=?,fecha_nacimiento=?,fecha_fallece=?,valor_evaluacion=?,numero_horas=?,valor_hora=?,salario=?,id_moneda=?,numero_contrato=?,id_tipo_contrato=?,valor1=?,valor2=?,valor3=?,valor4=?,valor5=?,valor6=?,con_aporta_seguro_social=?,con_recibe_horas_extras=?,con_descuento_impuestos=?,pension_alimenticia=?,con_pago_por_horas=?,con_anticipo=?,id_tipo_libreta_mili=?,libreta_militar=?,id_tipo_grupo_forma_pago=?,id_banco=?,id_tipo_cuenta_banco_global=?,numero_cuenta=?,id_tipo_sangre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select datogeneralempleado from "+DatoGeneralEmpleadoConstantesFunciones.SPERSISTENCENAME+" datogeneralempleado";
	public static String QUERYSELECTNATIVE="select "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".version_row,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_numero_patronal,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_tipo_afiliacion,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".carnet_iess,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".sectorial_iess,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_pais,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_provincia,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_canton,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_parroquia,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".fecha_nacimiento,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".fecha_fallece,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor_evaluacion,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".numero_horas,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor_hora,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".salario,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_moneda,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".numero_contrato,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_tipo_contrato,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor1,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor2,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor3,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor4,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor5,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor6,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".con_aporta_seguro_social,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".con_recibe_horas_extras,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".con_descuento_impuestos,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".pension_alimenticia,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".con_pago_por_horas,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".con_anticipo,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_tipo_libreta_mili,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".libreta_militar,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_tipo_grupo_forma_pago,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_banco,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco_global,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".numero_cuenta,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_tipo_sangre from "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME;//+" as "+DatoGeneralEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".version_row,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".carnet_iess from "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME;//+" as "+DatoGeneralEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_numero_patronal=?,id_tipo_afiliacion=?,carnet_iess=?,sectorial_iess=?,id_pais=?,id_provincia=?,id_canton=?,id_parroquia=?,fecha_nacimiento=?,fecha_fallece=?,valor_evaluacion=?,numero_horas=?,valor_hora=?,salario=?,id_moneda=?,numero_contrato=?,id_tipo_contrato=?,valor1=?,valor2=?,valor3=?,valor4=?,valor5=?,valor6=?,con_aporta_seguro_social=?,con_recibe_horas_extras=?,con_descuento_impuestos=?,pension_alimenticia=?,con_pago_por_horas=?,con_anticipo=?,id_tipo_libreta_mili=?,libreta_militar=?,id_tipo_grupo_forma_pago=?,id_banco=?,id_tipo_cuenta_banco_global=?,numero_cuenta=?,id_tipo_sangre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DATOGENERALEMPLEADO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DATOGENERALEMPLEADO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DATOGENERALEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DATOGENERALEMPLEADO_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected DatoGeneralEmpleadoDataAccessAdditional datogeneralempleadoDataAccessAdditional=null;
	
	public DatoGeneralEmpleadoDataAccessAdditional getDatoGeneralEmpleadoDataAccessAdditional() {
		return this.datogeneralempleadoDataAccessAdditional;
	}
	
	public void setDatoGeneralEmpleadoDataAccessAdditional(DatoGeneralEmpleadoDataAccessAdditional datogeneralempleadoDataAccessAdditional) {
		try {
			this.datogeneralempleadoDataAccessAdditional=datogeneralempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DatoGeneralEmpleadoDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		DatoGeneralEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DatoGeneralEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DatoGeneralEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}

	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setDatoGeneralEmpleadoOriginal(DatoGeneralEmpleado datogeneralempleado)throws Exception  {
		datogeneralempleado.setDatoGeneralEmpleadoOriginal((DatoGeneralEmpleado)datogeneralempleado.clone());		
	}
	
	public void setDatoGeneralEmpleadosOriginal(List<DatoGeneralEmpleado> datogeneralempleados)throws Exception  {
		
		for(DatoGeneralEmpleado datogeneralempleado:datogeneralempleados){
			datogeneralempleado.setDatoGeneralEmpleadoOriginal((DatoGeneralEmpleado)datogeneralempleado.clone());
		}
	}
	
	public static void setDatoGeneralEmpleadoOriginalStatic(DatoGeneralEmpleado datogeneralempleado)throws Exception  {
		datogeneralempleado.setDatoGeneralEmpleadoOriginal((DatoGeneralEmpleado)datogeneralempleado.clone());		
	}
	
	public static void setDatoGeneralEmpleadosOriginalStatic(List<DatoGeneralEmpleado> datogeneralempleados)throws Exception  {
		
		for(DatoGeneralEmpleado datogeneralempleado:datogeneralempleados){
			datogeneralempleado.setDatoGeneralEmpleadoOriginal((DatoGeneralEmpleado)datogeneralempleado.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  DatoGeneralEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  DatoGeneralEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoGeneralEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoGeneralEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.DatoGeneralEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDatoGeneralEmpleadoOriginal(new DatoGeneralEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDatoGeneralEmpleado("",entity,resultSet); 
				
				//entity.setDatoGeneralEmpleadoOriginal(super.getEntity("",entity.getDatoGeneralEmpleadoOriginal(),resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoGeneralEmpleadoOriginal(this.getEntityDatoGeneralEmpleado("",entity.getDatoGeneralEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDatoGeneralEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DatoGeneralEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  DatoGeneralEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoGeneralEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoGeneralEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,DatoGeneralEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.DatoGeneralEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDatoGeneralEmpleadoOriginal(new DatoGeneralEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDatoGeneralEmpleado("",entity,resultSet);    
				
				//entity.setDatoGeneralEmpleadoOriginal(super.getEntity("",entity.getDatoGeneralEmpleadoOriginal(),resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoGeneralEmpleadoOriginal(this.getEntityDatoGeneralEmpleado("",entity.getDatoGeneralEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDatoGeneralEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DatoGeneralEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoGeneralEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoGeneralEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,DatoGeneralEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.DatoGeneralEmpleado.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseDatoGeneralEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DatoGeneralEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DatoGeneralEmpleado> entities = new  ArrayList<DatoGeneralEmpleado>();
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<DatoGeneralEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DatoGeneralEmpleado> entities = new  ArrayList<DatoGeneralEmpleado>();
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoGeneralEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoGeneralEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,DatoGeneralEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoGeneralEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoGeneralEmpleado("",entity,resultSet);
      	    	
				//entity.setDatoGeneralEmpleadoOriginal( new DatoGeneralEmpleado());
      	    	//entity.setDatoGeneralEmpleadoOriginal(super.getEntity("",entity.getDatoGeneralEmpleadoOriginal(),resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoGeneralEmpleadoOriginal(this.getEntityDatoGeneralEmpleado("",entity.getDatoGeneralEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoGeneralEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoGeneralEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DatoGeneralEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DatoGeneralEmpleado> entities = new  ArrayList<DatoGeneralEmpleado>();
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<DatoGeneralEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DatoGeneralEmpleado> entities = new  ArrayList<DatoGeneralEmpleado>();
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoGeneralEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapDatoGeneralEmpleado();
					//entity.setMapDatoGeneralEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDatoGeneralEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDatoGeneralEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=DatoGeneralEmpleadoDataAccess.getEntityDatoGeneralEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDatoGeneralEmpleadoOriginal( new DatoGeneralEmpleado());
					////entity.setDatoGeneralEmpleadoOriginal(super.getEntity("",entity.getDatoGeneralEmpleadoOriginal(),resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setDatoGeneralEmpleadoOriginal(this.getEntityDatoGeneralEmpleado("",entity.getDatoGeneralEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoGeneralEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoGeneralEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DatoGeneralEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  DatoGeneralEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoGeneralEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapDatoGeneralEmpleado();
					//entity.setMapDatoGeneralEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDatoGeneralEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDatoGeneralEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=DatoGeneralEmpleadoDataAccess.getEntityDatoGeneralEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDatoGeneralEmpleadoOriginal( new DatoGeneralEmpleado());
					////entity.setDatoGeneralEmpleadoOriginal(super.getEntity("",entity.getDatoGeneralEmpleadoOriginal(),resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setDatoGeneralEmpleadoOriginal(this.getEntityDatoGeneralEmpleado("",entity.getDatoGeneralEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDatoGeneralEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoGeneralEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DatoGeneralEmpleado getEntityDatoGeneralEmpleado(String strPrefijo,DatoGeneralEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DatoGeneralEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DatoGeneralEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DatoGeneralEmpleadoDataAccess.setFieldReflectionDatoGeneralEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDatoGeneralEmpleado=DatoGeneralEmpleadoConstantesFunciones.getTodosTiposColumnasDatoGeneralEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDatoGeneralEmpleado) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = DatoGeneralEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DatoGeneralEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DatoGeneralEmpleadoDataAccess.setFieldReflectionDatoGeneralEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDatoGeneralEmpleado(Field field,String strPrefijo,String sColumn,DatoGeneralEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DatoGeneralEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDNUMEROPATRONAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDTIPOAFILIACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.CARNETIESS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.SECTORIALIESS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDPROVINCIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDCANTON:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDPARROQUIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.FECHANACIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.FECHAFALLECE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.VALOREVALUACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.NUMEROHORAS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.VALORHORA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.SALARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.NUMEROCONTRATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDTIPOCONTRATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.VALOR1:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.VALOR2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.VALOR3:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.VALOR4:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.VALOR5:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.VALOR6:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.CONAPORTASEGUROSOCIAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.CONRECIBEHORASEXTRAS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.CONDESCUENTOIMPUESTOS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.PENSIONALIMENTICIA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.CONPAGOPORHORAS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.CONANTICIPO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDTIPOLIBRETAMILI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.LIBRETAMILITAR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDTIPOGRUPOFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.NUMEROCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralEmpleadoConstantesFunciones.IDTIPOSANGRE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DatoGeneralEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DatoGeneralEmpleado> entities = new  ArrayList<DatoGeneralEmpleado>();
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoGeneralEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoGeneralEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,DatoGeneralEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new DatoGeneralEmpleado();
					entity=super.getEntity("",entity,resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDatoGeneralEmpleado("",entity,resultSet);
					
					//entity.setDatoGeneralEmpleadoOriginal( new DatoGeneralEmpleado());
					//entity.setDatoGeneralEmpleadoOriginal(super.getEntity("",entity.getDatoGeneralEmpleadoOriginal(),resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setDatoGeneralEmpleadoOriginal(this.getEntityDatoGeneralEmpleado("",entity.getDatoGeneralEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDatoGeneralEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoGeneralEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DatoGeneralEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DatoGeneralEmpleado> entities = new  ArrayList<DatoGeneralEmpleado>();
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoGeneralEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoGeneralEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,DatoGeneralEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<DatoGeneralEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoGeneralEmpleado> entities = new  ArrayList<DatoGeneralEmpleado>();
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<DatoGeneralEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoGeneralEmpleado> entities = new  ArrayList<DatoGeneralEmpleado>();
		DatoGeneralEmpleado entity = new DatoGeneralEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoGeneralEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoGeneralEmpleado("",entity,resultSet);
      	    	
				//entity.setDatoGeneralEmpleadoOriginal( new DatoGeneralEmpleado());
      	    	//entity.setDatoGeneralEmpleadoOriginal(super.getEntity("",entity.getDatoGeneralEmpleadoOriginal(),resultSet,DatoGeneralEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoGeneralEmpleadoOriginal(this.getEntityDatoGeneralEmpleado("",entity.getDatoGeneralEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDatoGeneralEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoGeneralEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public DatoGeneralEmpleado getEntityDatoGeneralEmpleado(String strPrefijo,DatoGeneralEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_numero_patronal(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDNUMEROPATRONAL));
				entity.setid_tipo_afiliacion(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDTIPOAFILIACION));
				entity.setcarnet_iess(resultSet.getString(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.CARNETIESS));
				entity.setsectorial_iess(resultSet.getString(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.SECTORIALIESS));
				entity.setid_pais(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDPAIS));
				entity.setid_provincia(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDPROVINCIA));
				entity.setid_canton(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDCANTON));
				entity.setid_parroquia(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDPARROQUIA));
				entity.setfecha_nacimiento(new Date(resultSet.getDate(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.FECHANACIMIENTO).getTime()));
				entity.setfecha_fallece(new Date(resultSet.getDate(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.FECHAFALLECE).getTime()));
				entity.setvalor_evaluacion(resultSet.getDouble(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.VALOREVALUACION));
				entity.setnumero_horas(resultSet.getDouble(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.NUMEROHORAS));
				entity.setvalor_hora(resultSet.getDouble(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.VALORHORA));
				entity.setsalario(resultSet.getDouble(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.SALARIO));
				entity.setid_moneda(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDMONEDA));
				entity.setnumero_contrato(resultSet.getString(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.NUMEROCONTRATO));
				entity.setid_tipo_contrato(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDTIPOCONTRATO));
				entity.setvalor1(resultSet.getDouble(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.VALOR1));
				entity.setvalor2(resultSet.getDouble(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.VALOR2));
				entity.setvalor3(resultSet.getDouble(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.VALOR3));
				entity.setvalor4(resultSet.getDouble(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.VALOR4));
				entity.setvalor5(resultSet.getDouble(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.VALOR5));
				entity.setvalor6(resultSet.getDouble(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.VALOR6));
				entity.setcon_aporta_seguro_social(resultSet.getBoolean(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.CONAPORTASEGUROSOCIAL));
				entity.setcon_recibe_horas_extras(resultSet.getBoolean(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.CONRECIBEHORASEXTRAS));
				entity.setcon_descuento_impuestos(resultSet.getBoolean(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.CONDESCUENTOIMPUESTOS));
				entity.setpension_alimenticia(resultSet.getDouble(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.PENSIONALIMENTICIA));
				entity.setcon_pago_por_horas(resultSet.getBoolean(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.CONPAGOPORHORAS));
				entity.setcon_anticipo(resultSet.getBoolean(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.CONANTICIPO));
				entity.setid_tipo_libreta_mili(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDTIPOLIBRETAMILI));
				entity.setlibreta_militar(resultSet.getString(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.LIBRETAMILITAR));
				entity.setid_tipo_grupo_forma_pago(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDTIPOGRUPOFORMAPAGO));
				entity.setid_banco(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDBANCO));
				entity.setid_tipo_cuenta_banco_global(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL));
				entity.setnumero_cuenta(resultSet.getString(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.NUMEROCUENTA));
				entity.setid_tipo_sangre(resultSet.getLong(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.IDTIPOSANGRE));
			} else {
				entity.setcarnet_iess(resultSet.getString(strPrefijo+DatoGeneralEmpleadoConstantesFunciones.CARNETIESS));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDatoGeneralEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DatoGeneralEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DatoGeneralEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DatoGeneralEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DatoGeneralEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DatoGeneralEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DatoGeneralEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,DatoGeneralEmpleadoDataAccess.TABLENAME,DatoGeneralEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			DatoGeneralEmpleadoDataAccess.setDatoGeneralEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empleado getEmpleado(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,reldatogeneralempleado.getId());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public NumeroPatronal getNumeroPatronal(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		NumeroPatronal numeropatronal= new NumeroPatronal();

		try {
			NumeroPatronalDataAccess numeropatronalDataAccess=new NumeroPatronalDataAccess();

			numeropatronalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			numeropatronalDataAccess.setConnexionType(this.connexionType);
			numeropatronalDataAccess.setParameterDbType(this.parameterDbType);

			numeropatronal=numeropatronalDataAccess.getEntity(connexion,reldatogeneralempleado.getid_numero_patronal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return numeropatronal;

	}

	public TipoAfiliacion getTipoAfiliacion(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		TipoAfiliacion tipoafiliacion= new TipoAfiliacion();

		try {
			TipoAfiliacionDataAccess tipoafiliacionDataAccess=new TipoAfiliacionDataAccess();

			tipoafiliacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoafiliacionDataAccess.setConnexionType(this.connexionType);
			tipoafiliacionDataAccess.setParameterDbType(this.parameterDbType);

			tipoafiliacion=tipoafiliacionDataAccess.getEntity(connexion,reldatogeneralempleado.getid_tipo_afiliacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoafiliacion;

	}

	public Pais getPais(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,reldatogeneralempleado.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Provincia getProvincia(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		Provincia provincia= new Provincia();

		try {
			ProvinciaDataAccess provinciaDataAccess=new ProvinciaDataAccess();

			provinciaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			provinciaDataAccess.setConnexionType(this.connexionType);
			provinciaDataAccess.setParameterDbType(this.parameterDbType);

			provincia=provinciaDataAccess.getEntity(connexion,reldatogeneralempleado.getid_provincia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return provincia;

	}

	public Canton getCanton(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		Canton canton= new Canton();

		try {
			CantonDataAccess cantonDataAccess=new CantonDataAccess();

			cantonDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cantonDataAccess.setConnexionType(this.connexionType);
			cantonDataAccess.setParameterDbType(this.parameterDbType);

			canton=cantonDataAccess.getEntity(connexion,reldatogeneralempleado.getid_canton());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return canton;

	}

	public Parroquia getParroquia(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		Parroquia parroquia= new Parroquia();

		try {
			ParroquiaDataAccess parroquiaDataAccess=new ParroquiaDataAccess();

			parroquiaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			parroquiaDataAccess.setConnexionType(this.connexionType);
			parroquiaDataAccess.setParameterDbType(this.parameterDbType);

			parroquia=parroquiaDataAccess.getEntity(connexion,reldatogeneralempleado.getid_parroquia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parroquia;

	}

	public Moneda getMoneda(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,reldatogeneralempleado.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public TipoContrato getTipoContrato(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		TipoContrato tipocontrato= new TipoContrato();

		try {
			TipoContratoDataAccess tipocontratoDataAccess=new TipoContratoDataAccess();

			tipocontratoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocontratoDataAccess.setConnexionType(this.connexionType);
			tipocontratoDataAccess.setParameterDbType(this.parameterDbType);

			tipocontrato=tipocontratoDataAccess.getEntity(connexion,reldatogeneralempleado.getid_tipo_contrato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocontrato;

	}

	public TipoLibretaMili getTipoLibretaMili(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		TipoLibretaMili tipolibretamili= new TipoLibretaMili();

		try {
			TipoLibretaMiliDataAccess tipolibretamiliDataAccess=new TipoLibretaMiliDataAccess();

			tipolibretamiliDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipolibretamiliDataAccess.setConnexionType(this.connexionType);
			tipolibretamiliDataAccess.setParameterDbType(this.parameterDbType);

			tipolibretamili=tipolibretamiliDataAccess.getEntity(connexion,reldatogeneralempleado.getid_tipo_libreta_mili());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipolibretamili;

	}

	public TipoGrupoFormaPago getTipoGrupoFormaPago(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		TipoGrupoFormaPago tipogrupoformapago= new TipoGrupoFormaPago();

		try {
			TipoGrupoFormaPagoDataAccess tipogrupoformapagoDataAccess=new TipoGrupoFormaPagoDataAccess();

			tipogrupoformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogrupoformapagoDataAccess.setConnexionType(this.connexionType);
			tipogrupoformapagoDataAccess.setParameterDbType(this.parameterDbType);

			tipogrupoformapago=tipogrupoformapagoDataAccess.getEntity(connexion,reldatogeneralempleado.getid_tipo_grupo_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogrupoformapago;

	}

	public Banco getBanco(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,reldatogeneralempleado.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobal(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		TipoCuentaBancoGlobal tipocuentabancoglobal= new TipoCuentaBancoGlobal();

		try {
			TipoCuentaBancoGlobalDataAccess tipocuentabancoglobalDataAccess=new TipoCuentaBancoGlobalDataAccess();

			tipocuentabancoglobalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocuentabancoglobalDataAccess.setConnexionType(this.connexionType);
			tipocuentabancoglobalDataAccess.setParameterDbType(this.parameterDbType);

			tipocuentabancoglobal=tipocuentabancoglobalDataAccess.getEntity(connexion,reldatogeneralempleado.getid_tipo_cuenta_banco_global());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocuentabancoglobal;

	}

	public TipoSangre getTipoSangre(Connexion connexion,DatoGeneralEmpleado reldatogeneralempleado)throws SQLException,Exception {

		TipoSangre tiposangre= new TipoSangre();

		try {
			TipoSangreDataAccess tiposangreDataAccess=new TipoSangreDataAccess();

			tiposangreDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiposangreDataAccess.setConnexionType(this.connexionType);
			tiposangreDataAccess.setParameterDbType(this.parameterDbType);

			tiposangre=tiposangreDataAccess.getEntity(connexion,reldatogeneralempleado.getid_tipo_sangre());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiposangre;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DatoGeneralEmpleado datogeneralempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!datogeneralempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(datogeneralempleado.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_numero_patronal=new ParameterValue<Long>();
					parameterMaintenanceValueid_numero_patronal.setValue(datogeneralempleado.getid_numero_patronal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_numero_patronal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_afiliacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_afiliacion.setValue(datogeneralempleado.getid_tipo_afiliacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_afiliacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecarnet_iess=new ParameterValue<String>();
					parameterMaintenanceValuecarnet_iess.setValue(datogeneralempleado.getcarnet_iess());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecarnet_iess);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesectorial_iess=new ParameterValue<String>();
					parameterMaintenanceValuesectorial_iess.setValue(datogeneralempleado.getsectorial_iess());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesectorial_iess);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(datogeneralempleado.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_provincia=new ParameterValue<Long>();
					parameterMaintenanceValueid_provincia.setValue(datogeneralempleado.getid_provincia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_provincia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_canton=new ParameterValue<Long>();
					parameterMaintenanceValueid_canton.setValue(datogeneralempleado.getid_canton());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_canton);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_parroquia=new ParameterValue<Long>();
					parameterMaintenanceValueid_parroquia.setValue(datogeneralempleado.getid_parroquia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_parroquia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_nacimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_nacimiento.setValue(datogeneralempleado.getfecha_nacimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_nacimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_fallece=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_fallece.setValue(datogeneralempleado.getfecha_fallece());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_fallece);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_evaluacion=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_evaluacion.setValue(datogeneralempleado.getvalor_evaluacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_evaluacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuenumero_horas=new ParameterValue<Double>();
					parameterMaintenanceValuenumero_horas.setValue(datogeneralempleado.getnumero_horas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_horas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_hora=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_hora.setValue(datogeneralempleado.getvalor_hora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_hora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesalario=new ParameterValue<Double>();
					parameterMaintenanceValuesalario.setValue(datogeneralempleado.getsalario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesalario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(datogeneralempleado.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_contrato=new ParameterValue<String>();
					parameterMaintenanceValuenumero_contrato.setValue(datogeneralempleado.getnumero_contrato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_contrato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_contrato=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_contrato.setValue(datogeneralempleado.getid_tipo_contrato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_contrato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor1=new ParameterValue<Double>();
					parameterMaintenanceValuevalor1.setValue(datogeneralempleado.getvalor1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor2=new ParameterValue<Double>();
					parameterMaintenanceValuevalor2.setValue(datogeneralempleado.getvalor2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor3=new ParameterValue<Double>();
					parameterMaintenanceValuevalor3.setValue(datogeneralempleado.getvalor3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor4=new ParameterValue<Double>();
					parameterMaintenanceValuevalor4.setValue(datogeneralempleado.getvalor4());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor4);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor5=new ParameterValue<Double>();
					parameterMaintenanceValuevalor5.setValue(datogeneralempleado.getvalor5());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor5);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor6=new ParameterValue<Double>();
					parameterMaintenanceValuevalor6.setValue(datogeneralempleado.getvalor6());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor6);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_aporta_seguro_social=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_aporta_seguro_social.setValue(datogeneralempleado.getcon_aporta_seguro_social());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_aporta_seguro_social);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_recibe_horas_extras=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_recibe_horas_extras.setValue(datogeneralempleado.getcon_recibe_horas_extras());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_recibe_horas_extras);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_descuento_impuestos=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_descuento_impuestos.setValue(datogeneralempleado.getcon_descuento_impuestos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_descuento_impuestos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuepension_alimenticia=new ParameterValue<Double>();
					parameterMaintenanceValuepension_alimenticia.setValue(datogeneralempleado.getpension_alimenticia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepension_alimenticia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_pago_por_horas=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_pago_por_horas.setValue(datogeneralempleado.getcon_pago_por_horas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_pago_por_horas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_anticipo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_anticipo.setValue(datogeneralempleado.getcon_anticipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_anticipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_libreta_mili=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_libreta_mili.setValue(datogeneralempleado.getid_tipo_libreta_mili());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_libreta_mili);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelibreta_militar=new ParameterValue<String>();
					parameterMaintenanceValuelibreta_militar.setValue(datogeneralempleado.getlibreta_militar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelibreta_militar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_grupo_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_grupo_forma_pago.setValue(datogeneralempleado.getid_tipo_grupo_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_grupo_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco.setValue(datogeneralempleado.getid_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cuenta_banco_global=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cuenta_banco_global.setValue(datogeneralempleado.getid_tipo_cuenta_banco_global());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cuenta_banco_global);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cuenta=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cuenta.setValue(datogeneralempleado.getnumero_cuenta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cuenta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_sangre=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_sangre.setValue(datogeneralempleado.getid_tipo_sangre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_sangre);
					parametersTemp.add(parameterMaintenance);
					
						if(!datogeneralempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(datogeneralempleado.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(datogeneralempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(datogeneralempleado.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseDatoGeneralEmpleado(DatoGeneralEmpleado datogeneralempleado)throws Exception  {		
		datogeneralempleado.setIsNew(false);
		datogeneralempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDatoGeneralEmpleados(List<DatoGeneralEmpleado> datogeneralempleados)throws Exception  {				
		for(DatoGeneralEmpleado datogeneralempleado:datogeneralempleados) {
			datogeneralempleado.setIsNew(false);
			datogeneralempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarDatoGeneralEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
