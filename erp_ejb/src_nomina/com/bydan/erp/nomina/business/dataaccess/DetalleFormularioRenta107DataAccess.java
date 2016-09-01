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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//DetalleFormularioRenta107ConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetalleFormularioRenta107DataAccess extends  DetalleFormularioRenta107DataAccessAdditional{ //DetalleFormularioRenta107DataAccessAdditional,DataAccessHelper<DetalleFormularioRenta107>
	//static Logger logger = Logger.getLogger(DetalleFormularioRenta107DataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_formulario_renta107";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_formulario_renta107,id_ejercicio,sueldos_301,sobre_sueldos_303,decimo_tercero_305,decimo_cuarto_307,fondo_reserva_309,utilidades_311,desahucio_313,iess_personal_315,gastos_vivienda_317,gastos_salud_319,gastos_educacion_321,gastos_alimentacion_323,gastos_vestimenta_325,descuento_discapacidad_327,descuento_tercera_edad_329,asume_empleador_331,sub_empleador_351,numero_meses_trabajados_353,ingreso_otros_empleadores_401,deduccion_gastos_otros_empleadores_403,rebajas_otros_empleadores_405,base_imponible_anual_407,impuesto_causado_409,impuesto_retenido_empleador_411,impuesto_retenido_otros_empleadores_413)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_formulario_renta107=?,id_ejercicio=?,sueldos_301=?,sobre_sueldos_303=?,decimo_tercero_305=?,decimo_cuarto_307=?,fondo_reserva_309=?,utilidades_311=?,desahucio_313=?,iess_personal_315=?,gastos_vivienda_317=?,gastos_salud_319=?,gastos_educacion_321=?,gastos_alimentacion_323=?,gastos_vestimenta_325=?,descuento_discapacidad_327=?,descuento_tercera_edad_329=?,asume_empleador_331=?,sub_empleador_351=?,numero_meses_trabajados_353=?,ingreso_otros_empleadores_401=?,deduccion_gastos_otros_empleadores_403=?,rebajas_otros_empleadores_405=?,base_imponible_anual_407=?,impuesto_causado_409=?,impuesto_retenido_empleador_411=?,impuesto_retenido_otros_empleadores_413=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleformulariorenta107 from "+DetalleFormularioRenta107ConstantesFunciones.SPERSISTENCENAME+" detalleformulariorenta107";
	public static String QUERYSELECTNATIVE="select "+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".id,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".version_row,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".id_empresa,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".id_empleado,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".id_formulario_renta107,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".sueldos_301,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".sobre_sueldos_303,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".decimo_tercero_305,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".decimo_cuarto_307,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".fondo_reserva_309,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".utilidades_311,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".desahucio_313,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".iess_personal_315,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".gastos_vivienda_317,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".gastos_salud_319,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".gastos_educacion_321,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".gastos_alimentacion_323,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".gastos_vestimenta_325,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".descuento_discapacidad_327,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".descuento_tercera_edad_329,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".asume_empleador_331,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".sub_empleador_351,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".numero_meses_trabajados_353,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".ingreso_otros_empleadores_401,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".deduccion_gastos_otros_empleadores_403,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".rebajas_otros_empleadores_405,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".base_imponible_anual_407,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".impuesto_causado_409,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".impuesto_retenido_empleador_411,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".impuesto_retenido_otros_empleadores_413 from "+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME;//+" as "+DetalleFormularioRenta107ConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".id,"+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+".version_row from "+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME;//+" as "+DetalleFormularioRenta107ConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+"."+DetalleFormularioRenta107ConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_formulario_renta107=?,id_ejercicio=?,sueldos_301=?,sobre_sueldos_303=?,decimo_tercero_305=?,decimo_cuarto_307=?,fondo_reserva_309=?,utilidades_311=?,desahucio_313=?,iess_personal_315=?,gastos_vivienda_317=?,gastos_salud_319=?,gastos_educacion_321=?,gastos_alimentacion_323=?,gastos_vestimenta_325=?,descuento_discapacidad_327=?,descuento_tercera_edad_329=?,asume_empleador_331=?,sub_empleador_351=?,numero_meses_trabajados_353=?,ingreso_otros_empleadores_401=?,deduccion_gastos_otros_empleadores_403=?,rebajas_otros_empleadores_405=?,base_imponible_anual_407=?,impuesto_causado_409=?,impuesto_retenido_empleador_411=?,impuesto_retenido_otros_empleadores_413=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEFORMULARIORENTA107_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEFORMULARIORENTA107_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEFORMULARIORENTA107_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEFORMULARIORENTA107_SELECT(?,?)";
	
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
	
	
	protected DetalleFormularioRenta107DataAccessAdditional detalleformulariorenta107DataAccessAdditional=null;
	
	public DetalleFormularioRenta107DataAccessAdditional getDetalleFormularioRenta107DataAccessAdditional() {
		return this.detalleformulariorenta107DataAccessAdditional;
	}
	
	public void setDetalleFormularioRenta107DataAccessAdditional(DetalleFormularioRenta107DataAccessAdditional detalleformulariorenta107DataAccessAdditional) {
		try {
			this.detalleformulariorenta107DataAccessAdditional=detalleformulariorenta107DataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleFormularioRenta107DataAccess() {
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
		DetalleFormularioRenta107DataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleFormularioRenta107DataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleFormularioRenta107DataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleFormularioRenta107Original(DetalleFormularioRenta107 detalleformulariorenta107)throws Exception  {
		detalleformulariorenta107.setDetalleFormularioRenta107Original((DetalleFormularioRenta107)detalleformulariorenta107.clone());		
	}
	
	public void setDetalleFormularioRenta107sOriginal(List<DetalleFormularioRenta107> detalleformulariorenta107s)throws Exception  {
		
		for(DetalleFormularioRenta107 detalleformulariorenta107:detalleformulariorenta107s){
			detalleformulariorenta107.setDetalleFormularioRenta107Original((DetalleFormularioRenta107)detalleformulariorenta107.clone());
		}
	}
	
	public static void setDetalleFormularioRenta107OriginalStatic(DetalleFormularioRenta107 detalleformulariorenta107)throws Exception  {
		detalleformulariorenta107.setDetalleFormularioRenta107Original((DetalleFormularioRenta107)detalleformulariorenta107.clone());		
	}
	
	public static void setDetalleFormularioRenta107sOriginalStatic(List<DetalleFormularioRenta107> detalleformulariorenta107s)throws Exception  {
		
		for(DetalleFormularioRenta107 detalleformulariorenta107:detalleformulariorenta107s){
			detalleformulariorenta107.setDetalleFormularioRenta107Original((DetalleFormularioRenta107)detalleformulariorenta107.clone());
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
	
	public  DetalleFormularioRenta107 getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		
		
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
	
	public  DetalleFormularioRenta107 getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleFormularioRenta107DataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleFormularioRenta107DataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.DetalleFormularioRenta107.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleFormularioRenta107Original(new DetalleFormularioRenta107());
      	    	entity=super.getEntity("",entity,resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleFormularioRenta107("",entity,resultSet); 
				
				//entity.setDetalleFormularioRenta107Original(super.getEntity("",entity.getDetalleFormularioRenta107Original(),resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFormularioRenta107Original(this.getEntityDetalleFormularioRenta107("",entity.getDetalleFormularioRenta107Original(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleFormularioRenta107(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleFormularioRenta107 getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();
				
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
	
	public  DetalleFormularioRenta107 getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleFormularioRenta107DataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleFormularioRenta107DataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFormularioRenta107DataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.DetalleFormularioRenta107.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleFormularioRenta107Original(new DetalleFormularioRenta107());
      	    	entity=super.getEntity("",entity,resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleFormularioRenta107("",entity,resultSet);    
				
				//entity.setDetalleFormularioRenta107Original(super.getEntity("",entity.getDetalleFormularioRenta107Original(),resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFormularioRenta107Original(this.getEntityDetalleFormularioRenta107("",entity.getDetalleFormularioRenta107Original(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleFormularioRenta107(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleFormularioRenta107
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleFormularioRenta107DataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleFormularioRenta107DataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFormularioRenta107DataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.DetalleFormularioRenta107.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleFormularioRenta107(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleFormularioRenta107> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleFormularioRenta107> entities = new  ArrayList<DetalleFormularioRenta107>();
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		  
		
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
	
	public  List<DetalleFormularioRenta107> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleFormularioRenta107> entities = new  ArrayList<DetalleFormularioRenta107>();
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleFormularioRenta107DataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleFormularioRenta107DataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFormularioRenta107DataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFormularioRenta107();
      	    	entity=super.getEntity("",entity,resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleFormularioRenta107("",entity,resultSet);
      	    	
				//entity.setDetalleFormularioRenta107Original( new DetalleFormularioRenta107());
      	    	//entity.setDetalleFormularioRenta107Original(super.getEntity("",entity.getDetalleFormularioRenta107Original(),resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFormularioRenta107Original(this.getEntityDetalleFormularioRenta107("",entity.getDetalleFormularioRenta107Original(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleFormularioRenta107s(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFormularioRenta107(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleFormularioRenta107> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleFormularioRenta107> entities = new  ArrayList<DetalleFormularioRenta107>();
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		  
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
	
	public  List<DetalleFormularioRenta107> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleFormularioRenta107> entities = new  ArrayList<DetalleFormularioRenta107>();
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFormularioRenta107();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleFormularioRenta107();
					//entity.setMapDetalleFormularioRenta107(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleFormularioRenta107Value(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleFormularioRenta107().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA);         		
					entity=DetalleFormularioRenta107DataAccess.getEntityDetalleFormularioRenta107("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleFormularioRenta107Original( new DetalleFormularioRenta107());
					////entity.setDetalleFormularioRenta107Original(super.getEntity("",entity.getDetalleFormularioRenta107Original(),resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleFormularioRenta107Original(this.getEntityDetalleFormularioRenta107("",entity.getDetalleFormularioRenta107Original(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleFormularioRenta107s(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFormularioRenta107(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleFormularioRenta107 getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		  
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
	
	public  DetalleFormularioRenta107 getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFormularioRenta107();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleFormularioRenta107();
					//entity.setMapDetalleFormularioRenta107(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleFormularioRenta107Value(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleFormularioRenta107().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA);         		
					entity=DetalleFormularioRenta107DataAccess.getEntityDetalleFormularioRenta107("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleFormularioRenta107Original( new DetalleFormularioRenta107());
					////entity.setDetalleFormularioRenta107Original(super.getEntity("",entity.getDetalleFormularioRenta107Original(),resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleFormularioRenta107Original(this.getEntityDetalleFormularioRenta107("",entity.getDetalleFormularioRenta107Original(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleFormularioRenta107(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFormularioRenta107(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleFormularioRenta107 getEntityDetalleFormularioRenta107(String strPrefijo,DetalleFormularioRenta107 entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleFormularioRenta107.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleFormularioRenta107.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleFormularioRenta107DataAccess.setFieldReflectionDetalleFormularioRenta107(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleFormularioRenta107=DetalleFormularioRenta107ConstantesFunciones.getTodosTiposColumnasDetalleFormularioRenta107();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleFormularioRenta107) {
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
							field = DetalleFormularioRenta107.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleFormularioRenta107.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleFormularioRenta107DataAccess.setFieldReflectionDetalleFormularioRenta107(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleFormularioRenta107(Field field,String strPrefijo,String sColumn,DetalleFormularioRenta107 entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleFormularioRenta107ConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.IDFORMULARIORENTA107:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.SUELDOS_301:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.SOBRESUELDOS_303:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.DECIMOTERCERO_305:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.DECIMOCUARTO_307:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.FONDORESERVA_309:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.UTILIDADES_311:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.DESAHUCIO_313:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.IESSPERSONAL_315:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.GASTOSVIVIENDA_317:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.GASTOSSALUD_319:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.GASTOSEDUCACION_321:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.GASTOSALIMENTACION_323:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.GASTOSVESTIMENTA_325:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.DESCUENTODISCAPACIDAD_327:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.DESCUENTOTERCERAEDAD_329:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.ASUMEEMPLEADOR_331:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.SUBEMPLEADOR_351:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.NUMEROMESESTRABAJADOS_353:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.INGRESOOTROSEMPLEADORES_401:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.DEDUCCIONGASTOSOTROSEMPLEADORES_403:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.REBAJASOTROSEMPLEADORES_405:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.BASEIMPONIBLEANUAL_407:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.IMPUESTOCAUSADO_409:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOEMPLEADOR_411:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOOTROSEMPLEADORES_413:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleFormularioRenta107>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleFormularioRenta107> entities = new  ArrayList<DetalleFormularioRenta107>();
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleFormularioRenta107DataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleFormularioRenta107DataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFormularioRenta107DataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleFormularioRenta107();
					entity=super.getEntity("",entity,resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleFormularioRenta107("",entity,resultSet);
					
					//entity.setDetalleFormularioRenta107Original( new DetalleFormularioRenta107());
					//entity.setDetalleFormularioRenta107Original(super.getEntity("",entity.getDetalleFormularioRenta107Original(),resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleFormularioRenta107Original(this.getEntityDetalleFormularioRenta107("",entity.getDetalleFormularioRenta107Original(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleFormularioRenta107s(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFormularioRenta107(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleFormularioRenta107>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleFormularioRenta107> entities = new  ArrayList<DetalleFormularioRenta107>();
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleFormularioRenta107DataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleFormularioRenta107DataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleFormularioRenta107DataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleFormularioRenta107> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleFormularioRenta107> entities = new  ArrayList<DetalleFormularioRenta107>();
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		  
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
	
	public  List<DetalleFormularioRenta107> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleFormularioRenta107> entities = new  ArrayList<DetalleFormularioRenta107>();
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFormularioRenta107();
      	    	entity=super.getEntity("",entity,resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleFormularioRenta107("",entity,resultSet);
      	    	
				//entity.setDetalleFormularioRenta107Original( new DetalleFormularioRenta107());
      	    	//entity.setDetalleFormularioRenta107Original(super.getEntity("",entity.getDetalleFormularioRenta107Original(),resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFormularioRenta107Original(this.getEntityDetalleFormularioRenta107("",entity.getDetalleFormularioRenta107Original(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleFormularioRenta107s(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleFormularioRenta107(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleFormularioRenta107> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleFormularioRenta107> entities = new  ArrayList<DetalleFormularioRenta107>();
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<DetalleFormularioRenta107> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleFormularioRenta107> entities = new  ArrayList<DetalleFormularioRenta107>();
		DetalleFormularioRenta107 entity = new DetalleFormularioRenta107();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleFormularioRenta107();
      	    	entity=super.getEntity("",entity,resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleFormularioRenta107("",entity,resultSet);
      	    	
				//entity.setDetalleFormularioRenta107Original( new DetalleFormularioRenta107());
      	    	//entity.setDetalleFormularioRenta107Original(super.getEntity("",entity.getDetalleFormularioRenta107Original(),resultSet,DetalleFormularioRenta107DataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleFormularioRenta107Original(this.getEntityDetalleFormularioRenta107("",entity.getDetalleFormularioRenta107Original(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleFormularioRenta107s(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleFormularioRenta107 getEntityDetalleFormularioRenta107(String strPrefijo,DetalleFormularioRenta107 entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.IDEMPLEADO));
				entity.setid_formulario_renta107(resultSet.getLong(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.IDFORMULARIORENTA107));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.IDEJERCICIO));
				entity.setsueldos_301(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.SUELDOS_301));
				entity.setsobre_sueldos_303(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.SOBRESUELDOS_303));
				entity.setdecimo_tercero_305(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.DECIMOTERCERO_305));
				entity.setdecimo_cuarto_307(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.DECIMOCUARTO_307));
				entity.setfondo_reserva_309(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.FONDORESERVA_309));
				entity.setutilidades_311(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.UTILIDADES_311));
				entity.setdesahucio_313(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.DESAHUCIO_313));
				entity.setiess_personal_315(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.IESSPERSONAL_315));
				entity.setgastos_vivienda_317(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.GASTOSVIVIENDA_317));
				entity.setgastos_salud_319(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.GASTOSSALUD_319));
				entity.setgastos_educacion_321(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.GASTOSEDUCACION_321));
				entity.setgastos_alimentacion_323(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.GASTOSALIMENTACION_323));
				entity.setgastos_vestimenta_325(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.GASTOSVESTIMENTA_325));
				entity.setdescuento_discapacidad_327(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.DESCUENTODISCAPACIDAD_327));
				entity.setdescuento_tercera_edad_329(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.DESCUENTOTERCERAEDAD_329));
				entity.setasume_empleador_331(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.ASUMEEMPLEADOR_331));
				entity.setsub_empleador_351(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.SUBEMPLEADOR_351));
				entity.setnumero_meses_trabajados_353(resultSet.getInt(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.NUMEROMESESTRABAJADOS_353));
				entity.setingreso_otros_empleadores_401(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.INGRESOOTROSEMPLEADORES_401));
				entity.setdeduccion_gastos_otros_empleadores_403(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.DEDUCCIONGASTOSOTROSEMPLEADORES_403));
				entity.setrebajas_otros_empleadores_405(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.REBAJASOTROSEMPLEADORES_405));
				entity.setbase_imponible_anual_407(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.BASEIMPONIBLEANUAL_407));
				entity.setimpuesto_causado_409(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.IMPUESTOCAUSADO_409));
				entity.setimpuesto_retenido_empleador_411(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOEMPLEADOR_411));
				entity.setimpuesto_retenido_otros_empleadores_413(resultSet.getDouble(strPrefijo+DetalleFormularioRenta107ConstantesFunciones.IMPUESTORETENIDOOTROSEMPLEADORES_413));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleFormularioRenta107(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleFormularioRenta107 entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleFormularioRenta107DataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleFormularioRenta107DataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleFormularioRenta107DataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleFormularioRenta107DataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleFormularioRenta107ConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleFormularioRenta107DataAccess.TABLENAME,DetalleFormularioRenta107DataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleFormularioRenta107DataAccess.setDetalleFormularioRenta107OriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleFormularioRenta107 reldetalleformulariorenta107)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleformulariorenta107.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,DetalleFormularioRenta107 reldetalleformulariorenta107)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,reldetalleformulariorenta107.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public FormularioRenta107 getFormularioRenta107(Connexion connexion,DetalleFormularioRenta107 reldetalleformulariorenta107)throws SQLException,Exception {

		FormularioRenta107 formulariorenta107= new FormularioRenta107();

		try {
			FormularioRenta107DataAccess formulariorenta107DataAccess=new FormularioRenta107DataAccess();

			formulariorenta107DataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formulariorenta107DataAccess.setConnexionType(this.connexionType);
			formulariorenta107DataAccess.setParameterDbType(this.parameterDbType);

			formulariorenta107=formulariorenta107DataAccess.getEntity(connexion,reldetalleformulariorenta107.getid_formulario_renta107());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formulariorenta107;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleFormularioRenta107 reldetalleformulariorenta107)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetalleformulariorenta107.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleFormularioRenta107 detalleformulariorenta107) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleformulariorenta107.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleformulariorenta107.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(detalleformulariorenta107.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formulario_renta107=new ParameterValue<Long>();
					parameterMaintenanceValueid_formulario_renta107.setValue(detalleformulariorenta107.getid_formulario_renta107());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formulario_renta107);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detalleformulariorenta107.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesueldos_301=new ParameterValue<Double>();
					parameterMaintenanceValuesueldos_301.setValue(detalleformulariorenta107.getsueldos_301());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesueldos_301);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesobre_sueldos_303=new ParameterValue<Double>();
					parameterMaintenanceValuesobre_sueldos_303.setValue(detalleformulariorenta107.getsobre_sueldos_303());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesobre_sueldos_303);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedecimo_tercero_305=new ParameterValue<Double>();
					parameterMaintenanceValuedecimo_tercero_305.setValue(detalleformulariorenta107.getdecimo_tercero_305());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedecimo_tercero_305);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedecimo_cuarto_307=new ParameterValue<Double>();
					parameterMaintenanceValuedecimo_cuarto_307.setValue(detalleformulariorenta107.getdecimo_cuarto_307());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedecimo_cuarto_307);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefondo_reserva_309=new ParameterValue<Double>();
					parameterMaintenanceValuefondo_reserva_309.setValue(detalleformulariorenta107.getfondo_reserva_309());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefondo_reserva_309);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueutilidades_311=new ParameterValue<Double>();
					parameterMaintenanceValueutilidades_311.setValue(detalleformulariorenta107.getutilidades_311());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueutilidades_311);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedesahucio_313=new ParameterValue<Double>();
					parameterMaintenanceValuedesahucio_313.setValue(detalleformulariorenta107.getdesahucio_313());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedesahucio_313);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiess_personal_315=new ParameterValue<Double>();
					parameterMaintenanceValueiess_personal_315.setValue(detalleformulariorenta107.getiess_personal_315());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiess_personal_315);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegastos_vivienda_317=new ParameterValue<Double>();
					parameterMaintenanceValuegastos_vivienda_317.setValue(detalleformulariorenta107.getgastos_vivienda_317());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegastos_vivienda_317);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegastos_salud_319=new ParameterValue<Double>();
					parameterMaintenanceValuegastos_salud_319.setValue(detalleformulariorenta107.getgastos_salud_319());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegastos_salud_319);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegastos_educacion_321=new ParameterValue<Double>();
					parameterMaintenanceValuegastos_educacion_321.setValue(detalleformulariorenta107.getgastos_educacion_321());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegastos_educacion_321);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegastos_alimentacion_323=new ParameterValue<Double>();
					parameterMaintenanceValuegastos_alimentacion_323.setValue(detalleformulariorenta107.getgastos_alimentacion_323());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegastos_alimentacion_323);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegastos_vestimenta_325=new ParameterValue<Double>();
					parameterMaintenanceValuegastos_vestimenta_325.setValue(detalleformulariorenta107.getgastos_vestimenta_325());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegastos_vestimenta_325);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_discapacidad_327=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_discapacidad_327.setValue(detalleformulariorenta107.getdescuento_discapacidad_327());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_discapacidad_327);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_tercera_edad_329=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_tercera_edad_329.setValue(detalleformulariorenta107.getdescuento_tercera_edad_329());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_tercera_edad_329);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueasume_empleador_331=new ParameterValue<Double>();
					parameterMaintenanceValueasume_empleador_331.setValue(detalleformulariorenta107.getasume_empleador_331());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueasume_empleador_331);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_empleador_351=new ParameterValue<Double>();
					parameterMaintenanceValuesub_empleador_351.setValue(detalleformulariorenta107.getsub_empleador_351());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_empleador_351);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_meses_trabajados_353=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_meses_trabajados_353.setValue(detalleformulariorenta107.getnumero_meses_trabajados_353());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_meses_trabajados_353);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueingreso_otros_empleadores_401=new ParameterValue<Double>();
					parameterMaintenanceValueingreso_otros_empleadores_401.setValue(detalleformulariorenta107.getingreso_otros_empleadores_401());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueingreso_otros_empleadores_401);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuededuccion_gastos_otros_empleadores_403=new ParameterValue<Double>();
					parameterMaintenanceValuededuccion_gastos_otros_empleadores_403.setValue(detalleformulariorenta107.getdeduccion_gastos_otros_empleadores_403());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuededuccion_gastos_otros_empleadores_403);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuerebajas_otros_empleadores_405=new ParameterValue<Double>();
					parameterMaintenanceValuerebajas_otros_empleadores_405.setValue(detalleformulariorenta107.getrebajas_otros_empleadores_405());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerebajas_otros_empleadores_405);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebase_imponible_anual_407=new ParameterValue<Double>();
					parameterMaintenanceValuebase_imponible_anual_407.setValue(detalleformulariorenta107.getbase_imponible_anual_407());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebase_imponible_anual_407);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto_causado_409=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto_causado_409.setValue(detalleformulariorenta107.getimpuesto_causado_409());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto_causado_409);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto_retenido_empleador_411=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto_retenido_empleador_411.setValue(detalleformulariorenta107.getimpuesto_retenido_empleador_411());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto_retenido_empleador_411);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto_retenido_otros_empleadores_413=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto_retenido_otros_empleadores_413.setValue(detalleformulariorenta107.getimpuesto_retenido_otros_empleadores_413());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto_retenido_otros_empleadores_413);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleformulariorenta107.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleformulariorenta107.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleformulariorenta107.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleformulariorenta107.getId());
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
	
	public void setIsNewIsChangedFalseDetalleFormularioRenta107(DetalleFormularioRenta107 detalleformulariorenta107)throws Exception  {		
		detalleformulariorenta107.setIsNew(false);
		detalleformulariorenta107.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleFormularioRenta107s(List<DetalleFormularioRenta107> detalleformulariorenta107s)throws Exception  {				
		for(DetalleFormularioRenta107 detalleformulariorenta107:detalleformulariorenta107s) {
			detalleformulariorenta107.setIsNew(false);
			detalleformulariorenta107.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleFormularioRenta107(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
