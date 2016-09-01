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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//CentroActividadConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;




@SuppressWarnings("unused")
final public class CentroActividadDataAccess extends  CentroActividadDataAccessAdditional{ //CentroActividadDataAccessAdditional,DataAccessHelper<CentroActividad>
	//static Logger logger = Logger.getLogger(CentroActividadDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="centro_actividad";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,id_tipo_movimiento,id_tipo_grupo_flujo_caja,consolidado,con_proyecto,observacion)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,id_tipo_movimiento=?,id_tipo_grupo_flujo_caja=?,consolidado=?,con_proyecto=?,observacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select centroactividad from "+CentroActividadConstantesFunciones.SPERSISTENCENAME+" centroactividad";
	public static String QUERYSELECTNATIVE="select "+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".id,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".version_row,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".id_empresa,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".codigo,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".nombre,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".id_tipo_grupo_flujo_caja,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".consolidado,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".con_proyecto,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".observacion from "+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME;//+" as "+CentroActividadConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".id,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".version_row,"+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+".nombre from "+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME;//+" as "+CentroActividadConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CentroActividadConstantesFunciones.SCHEMA+"."+CentroActividadConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,id_tipo_movimiento=?,id_tipo_grupo_flujo_caja=?,consolidado=?,con_proyecto=?,observacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CENTROACTIVIDAD_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CENTROACTIVIDAD_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CENTROACTIVIDAD_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CENTROACTIVIDAD_SELECT(?,?)";
	
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
	
	
	protected CentroActividadDataAccessAdditional centroactividadDataAccessAdditional=null;
	
	public CentroActividadDataAccessAdditional getCentroActividadDataAccessAdditional() {
		return this.centroactividadDataAccessAdditional;
	}
	
	public void setCentroActividadDataAccessAdditional(CentroActividadDataAccessAdditional centroactividadDataAccessAdditional) {
		try {
			this.centroactividadDataAccessAdditional=centroactividadDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CentroActividadDataAccess() {
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
		CentroActividadDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CentroActividadDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CentroActividadDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCentroActividadOriginal(CentroActividad centroactividad)throws Exception  {
		centroactividad.setCentroActividadOriginal((CentroActividad)centroactividad.clone());		
	}
	
	public void setCentroActividadsOriginal(List<CentroActividad> centroactividads)throws Exception  {
		
		for(CentroActividad centroactividad:centroactividads){
			centroactividad.setCentroActividadOriginal((CentroActividad)centroactividad.clone());
		}
	}
	
	public static void setCentroActividadOriginalStatic(CentroActividad centroactividad)throws Exception  {
		centroactividad.setCentroActividadOriginal((CentroActividad)centroactividad.clone());		
	}
	
	public static void setCentroActividadsOriginalStatic(List<CentroActividad> centroactividads)throws Exception  {
		
		for(CentroActividad centroactividad:centroactividads){
			centroactividad.setCentroActividadOriginal((CentroActividad)centroactividad.clone());
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
	
	public  CentroActividad getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CentroActividad entity = new CentroActividad();		
		
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
	
	public  CentroActividad getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CentroActividad entity = new CentroActividad();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroActividadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroActividadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.CentroActividad.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCentroActividadOriginal(new CentroActividad());
      	    	entity=super.getEntity("",entity,resultSet,CentroActividadDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCentroActividad("",entity,resultSet); 
				
				//entity.setCentroActividadOriginal(super.getEntity("",entity.getCentroActividadOriginal(),resultSet,CentroActividadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroActividadOriginal(this.getEntityCentroActividad("",entity.getCentroActividadOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCentroActividad(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CentroActividad getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CentroActividad entity = new CentroActividad();
				
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
	
	public  CentroActividad getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CentroActividad entity = new CentroActividad();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroActividadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroActividadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroActividadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.CentroActividad.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCentroActividadOriginal(new CentroActividad());
      	    	entity=super.getEntity("",entity,resultSet,CentroActividadDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCentroActividad("",entity,resultSet);    
				
				//entity.setCentroActividadOriginal(super.getEntity("",entity.getCentroActividadOriginal(),resultSet,CentroActividadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroActividadOriginal(this.getEntityCentroActividad("",entity.getCentroActividadOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCentroActividad(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CentroActividad
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CentroActividad entity = new CentroActividad();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroActividadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroActividadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroActividadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.CentroActividad.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCentroActividad(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CentroActividad> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CentroActividad> entities = new  ArrayList<CentroActividad>();
		CentroActividad entity = new CentroActividad();		  
		
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
	
	public  List<CentroActividad> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CentroActividad> entities = new  ArrayList<CentroActividad>();
		CentroActividad entity = new CentroActividad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroActividadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroActividadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroActividadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroActividad();
      	    	entity=super.getEntity("",entity,resultSet,CentroActividadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroActividad("",entity,resultSet);
      	    	
				//entity.setCentroActividadOriginal( new CentroActividad());
      	    	//entity.setCentroActividadOriginal(super.getEntity("",entity.getCentroActividadOriginal(),resultSet,CentroActividadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroActividadOriginal(this.getEntityCentroActividad("",entity.getCentroActividadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroActividads(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroActividad(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CentroActividad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CentroActividad> entities = new  ArrayList<CentroActividad>();
		CentroActividad entity = new CentroActividad();		  
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
	
	public  List<CentroActividad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CentroActividad> entities = new  ArrayList<CentroActividad>();
		CentroActividad entity = new CentroActividad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroActividad();
				
				if(conMapGenerico) {
					entity.inicializarMapCentroActividad();
					//entity.setMapCentroActividad(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCentroActividadValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCentroActividad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CentroActividadDataAccess.ISWITHSCHEMA);         		
					entity=CentroActividadDataAccess.getEntityCentroActividad("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCentroActividadOriginal( new CentroActividad());
					////entity.setCentroActividadOriginal(super.getEntity("",entity.getCentroActividadOriginal(),resultSet,CentroActividadDataAccess.ISWITHSCHEMA));         		
					////entity.setCentroActividadOriginal(this.getEntityCentroActividad("",entity.getCentroActividadOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroActividads(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroActividad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CentroActividad getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CentroActividad entity = new CentroActividad();		  
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
	
	public  CentroActividad getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CentroActividad entity = new CentroActividad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroActividad();
				
				if(conMapGenerico) {
					entity.inicializarMapCentroActividad();
					//entity.setMapCentroActividad(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCentroActividadValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCentroActividad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CentroActividadDataAccess.ISWITHSCHEMA);         		
					entity=CentroActividadDataAccess.getEntityCentroActividad("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCentroActividadOriginal( new CentroActividad());
					////entity.setCentroActividadOriginal(super.getEntity("",entity.getCentroActividadOriginal(),resultSet,CentroActividadDataAccess.ISWITHSCHEMA));         		
					////entity.setCentroActividadOriginal(this.getEntityCentroActividad("",entity.getCentroActividadOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCentroActividad(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroActividad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CentroActividad getEntityCentroActividad(String strPrefijo,CentroActividad entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CentroActividad.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CentroActividad.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CentroActividadDataAccess.setFieldReflectionCentroActividad(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCentroActividad=CentroActividadConstantesFunciones.getTodosTiposColumnasCentroActividad();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCentroActividad) {
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
							field = CentroActividad.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CentroActividad.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CentroActividadDataAccess.setFieldReflectionCentroActividad(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCentroActividad(Field field,String strPrefijo,String sColumn,CentroActividad entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CentroActividadConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroActividadConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CentroActividadConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroActividadConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CentroActividadConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CentroActividadConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroActividadConstantesFunciones.IDTIPOGRUPOFLUJOCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroActividadConstantesFunciones.CONSOLIDADO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CentroActividadConstantesFunciones.CONPROYECTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CentroActividadConstantesFunciones.OBSERVACION:
					field.set(entity,resultSet.getString(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CentroActividad>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CentroActividad> entities = new  ArrayList<CentroActividad>();
		CentroActividad entity = new CentroActividad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroActividadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroActividadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroActividadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CentroActividad();
					entity=super.getEntity("",entity,resultSet,CentroActividadDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCentroActividad("",entity,resultSet);
					
					//entity.setCentroActividadOriginal( new CentroActividad());
					//entity.setCentroActividadOriginal(super.getEntity("",entity.getCentroActividadOriginal(),resultSet,CentroActividadDataAccess.ISWITHSCHEMA));         		
					//entity.setCentroActividadOriginal(this.getEntityCentroActividad("",entity.getCentroActividadOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCentroActividads(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroActividad(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CentroActividad>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CentroActividad> entities = new  ArrayList<CentroActividad>();
		CentroActividad entity = new CentroActividad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroActividadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroActividadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroActividadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CentroActividad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroActividad> entities = new  ArrayList<CentroActividad>();
		CentroActividad entity = new CentroActividad();		  
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
	
	public  List<CentroActividad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroActividad> entities = new  ArrayList<CentroActividad>();
		CentroActividad entity = new CentroActividad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroActividad();
      	    	entity=super.getEntity("",entity,resultSet,CentroActividadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroActividad("",entity,resultSet);
      	    	
				//entity.setCentroActividadOriginal( new CentroActividad());
      	    	//entity.setCentroActividadOriginal(super.getEntity("",entity.getCentroActividadOriginal(),resultSet,CentroActividadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroActividadOriginal(this.getEntityCentroActividad("",entity.getCentroActividadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCentroActividads(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroActividad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CentroActividad> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroActividad> entities = new  ArrayList<CentroActividad>();
		CentroActividad entity = new CentroActividad();		  
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
	
	public  List<CentroActividad> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroActividad> entities = new  ArrayList<CentroActividad>();
		CentroActividad entity = new CentroActividad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroActividad();
      	    	entity=super.getEntity("",entity,resultSet,CentroActividadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroActividad("",entity,resultSet);
      	    	
				//entity.setCentroActividadOriginal( new CentroActividad());
      	    	//entity.setCentroActividadOriginal(super.getEntity("",entity.getCentroActividadOriginal(),resultSet,CentroActividadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroActividadOriginal(this.getEntityCentroActividad("",entity.getCentroActividadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroActividads(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CentroActividad getEntityCentroActividad(String strPrefijo,CentroActividad entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CentroActividadConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+CentroActividadConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+CentroActividadConstantesFunciones.NOMBRE));
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+CentroActividadConstantesFunciones.IDTIPOMOVIMIENTO));
				entity.setid_tipo_grupo_flujo_caja(resultSet.getLong(strPrefijo+CentroActividadConstantesFunciones.IDTIPOGRUPOFLUJOCAJA));
				entity.setconsolidado(resultSet.getBoolean(strPrefijo+CentroActividadConstantesFunciones.CONSOLIDADO));
				entity.setcon_proyecto(resultSet.getBoolean(strPrefijo+CentroActividadConstantesFunciones.CONPROYECTO));
				entity.setobservacion(resultSet.getString(strPrefijo+CentroActividadConstantesFunciones.OBSERVACION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+CentroActividadConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCentroActividad(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CentroActividad entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CentroActividadDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CentroActividadDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CentroActividadDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CentroActividadDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CentroActividadConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CentroActividadDataAccess.TABLENAME,CentroActividadDataAccess.ISWITHSTOREPROCEDURES);
			
			CentroActividadDataAccess.setCentroActividadOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CentroActividad relcentroactividad)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcentroactividad.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,CentroActividad relcentroactividad)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relcentroactividad.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}

	public TipoGrupoFlujoCaja getTipoGrupoFlujoCaja(Connexion connexion,CentroActividad relcentroactividad)throws SQLException,Exception {

		TipoGrupoFlujoCaja tipogrupoflujocaja= new TipoGrupoFlujoCaja();

		try {
			TipoGrupoFlujoCajaDataAccess tipogrupoflujocajaDataAccess=new TipoGrupoFlujoCajaDataAccess();

			tipogrupoflujocajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogrupoflujocajaDataAccess.setConnexionType(this.connexionType);
			tipogrupoflujocajaDataAccess.setParameterDbType(this.parameterDbType);

			tipogrupoflujocaja=tipogrupoflujocajaDataAccess.getEntity(connexion,relcentroactividad.getid_tipo_grupo_flujo_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogrupoflujocaja;

	}


		
		public List<PagoAuto> getPagoAutos(Connexion connexion,CentroActividad centroactividad)throws SQLException,Exception {

		List<PagoAuto> pagoautos= new ArrayList<PagoAuto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad ON "+PagoAutoConstantesFunciones.SCHEMA+".pago_auto.id_centro_actividad="+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad.id WHERE "+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad.id="+String.valueOf(centroactividad.getId());
			} else {
				sQuery=" INNER JOIN pagoauto.CentroActividad WHERE pagoauto.CentroActividad.id="+String.valueOf(centroactividad.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PagoAutoDataAccess pagoautoDataAccess=new PagoAutoDataAccess();

			pagoautoDataAccess.setConnexionType(this.connexionType);
			pagoautoDataAccess.setParameterDbType(this.parameterDbType);
			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pagoautos;

	}

	public List<Cliente> getClientes(Connexion connexion,CentroActividad centroactividad)throws SQLException,Exception {

		List<Cliente> clientes= new ArrayList<Cliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad ON "+ClienteConstantesFunciones.SCHEMA+".cliente.id_centro_actividad="+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad.id WHERE "+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad.id="+String.valueOf(centroactividad.getId());
			} else {
				sQuery=" INNER JOIN cliente.CentroActividad WHERE cliente.CentroActividad.id="+String.valueOf(centroactividad.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clientes;

	}

	public List<DetalleAsientoContable> getDetalleAsientoContables(Connexion connexion,CentroActividad centroactividad)throws SQLException,Exception {

		List<DetalleAsientoContable> detalleasientocontables= new ArrayList<DetalleAsientoContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad ON "+DetalleAsientoContableConstantesFunciones.SCHEMA+".detalle_asiento_contable.id_centro_actividad="+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad.id WHERE "+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad.id="+String.valueOf(centroactividad.getId());
			} else {
				sQuery=" INNER JOIN detalleasientocontable.CentroActividad WHERE detalleasientocontable.CentroActividad.id="+String.valueOf(centroactividad.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleAsientoContableDataAccess detalleasientocontableDataAccess=new DetalleAsientoContableDataAccess();

			detalleasientocontableDataAccess.setConnexionType(this.connexionType);
			detalleasientocontableDataAccess.setParameterDbType(this.parameterDbType);
			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleasientocontables;

	}

	public List<AutoriPago> getAutoriPagos(Connexion connexion,CentroActividad centroactividad)throws SQLException,Exception {

		List<AutoriPago> autoripagos= new ArrayList<AutoriPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad ON "+AutoriPagoConstantesFunciones.SCHEMA+".autori_pago.id_centro_actividad="+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad.id WHERE "+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad.id="+String.valueOf(centroactividad.getId());
			} else {
				sQuery=" INNER JOIN autoripago.CentroActividad WHERE autoripago.CentroActividad.id="+String.valueOf(centroactividad.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriPagoDataAccess autoripagoDataAccess=new AutoriPagoDataAccess();

			autoripagoDataAccess.setConnexionType(this.connexionType);
			autoripagoDataAccess.setParameterDbType(this.parameterDbType);
			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoripagos;

	}

	public List<PresupuestoFlujoCajaTsr> getPresupuestoFlujoCajaTsrs(Connexion connexion,CentroActividad centroactividad)throws SQLException,Exception {

		List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs= new ArrayList<PresupuestoFlujoCajaTsr>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad ON "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+".presupuesto_flujo_caja_tsr.id_centro_actividad="+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad.id WHERE "+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad.id="+String.valueOf(centroactividad.getId());
			} else {
				sQuery=" INNER JOIN presupuestoflujocajatsr.CentroActividad WHERE presupuestoflujocajatsr.CentroActividad.id="+String.valueOf(centroactividad.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresupuestoFlujoCajaTsrDataAccess presupuestoflujocajatsrDataAccess=new PresupuestoFlujoCajaTsrDataAccess();

			presupuestoflujocajatsrDataAccess.setConnexionType(this.connexionType);
			presupuestoflujocajatsrDataAccess.setParameterDbType(this.parameterDbType);
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presupuestoflujocajatsrs;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CentroActividad centroactividad) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!centroactividad.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(centroactividad.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(centroactividad.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(centroactividad.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(centroactividad.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_grupo_flujo_caja=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_grupo_flujo_caja.setValue(centroactividad.getid_tipo_grupo_flujo_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_grupo_flujo_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueconsolidado=new ParameterValue<Boolean>();
					parameterMaintenanceValueconsolidado.setValue(centroactividad.getconsolidado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueconsolidado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_proyecto=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_proyecto.setValue(centroactividad.getcon_proyecto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_proyecto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion=new ParameterValue<String>();
					parameterMaintenanceValueobservacion.setValue(centroactividad.getobservacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!centroactividad.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(centroactividad.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(centroactividad.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(centroactividad.getId());
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
	
	public void setIsNewIsChangedFalseCentroActividad(CentroActividad centroactividad)throws Exception  {		
		centroactividad.setIsNew(false);
		centroactividad.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCentroActividads(List<CentroActividad> centroactividads)throws Exception  {				
		for(CentroActividad centroactividad:centroactividads) {
			centroactividad.setIsNew(false);
			centroactividad.setIsChanged(false);
		}
	}
	
	public void generarExportarCentroActividad(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
