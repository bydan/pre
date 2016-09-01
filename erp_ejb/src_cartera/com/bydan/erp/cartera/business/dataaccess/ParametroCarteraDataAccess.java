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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//ParametroCarteraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class ParametroCarteraDataAccess extends  ParametroCarteraDataAccessAdditional{ //ParametroCarteraDataAccessAdditional,DataAccessHelper<ParametroCartera>
	//static Logger logger = Logger.getLogger(ParametroCarteraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_cartera";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_transaccion_factura,numero_digitos_factura,por_lotes,id_empleado,id_transaccion_deshabilita,id_transaccion_habilita,id_bodega,id_tipo_factura,id_tipo_auto_pago,numero_orden_pago,id_cuenta_contable_credito_fiscal,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_transaccion_factura=?,numero_digitos_factura=?,por_lotes=?,id_empleado=?,id_transaccion_deshabilita=?,id_transaccion_habilita=?,id_bodega=?,id_tipo_factura=?,id_tipo_auto_pago=?,numero_orden_pago=?,id_cuenta_contable_credito_fiscal=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrocartera from "+ParametroCarteraConstantesFunciones.SPERSISTENCENAME+" parametrocartera";
	public static String QUERYSELECTNATIVE="select "+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".version_row,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_empresa,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_transaccion_factura,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".numero_digitos_factura,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".por_lotes,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_empleado,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_transaccion_deshabilita,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_transaccion_habilita,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_bodega,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_tipo_factura,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_tipo_auto_pago,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".numero_orden_pago,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_fiscal,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".descripcion from "+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME;//+" as "+ParametroCarteraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".id,"+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+".version_row from "+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME;//+" as "+ParametroCarteraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroCarteraConstantesFunciones.SCHEMA+"."+ParametroCarteraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_transaccion_factura=?,numero_digitos_factura=?,por_lotes=?,id_empleado=?,id_transaccion_deshabilita=?,id_transaccion_habilita=?,id_bodega=?,id_tipo_factura=?,id_tipo_auto_pago=?,numero_orden_pago=?,id_cuenta_contable_credito_fiscal=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROCARTERA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROCARTERA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROCARTERA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROCARTERA_SELECT(?,?)";
	
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
	
	
	protected ParametroCarteraDataAccessAdditional parametrocarteraDataAccessAdditional=null;
	
	public ParametroCarteraDataAccessAdditional getParametroCarteraDataAccessAdditional() {
		return this.parametrocarteraDataAccessAdditional;
	}
	
	public void setParametroCarteraDataAccessAdditional(ParametroCarteraDataAccessAdditional parametrocarteraDataAccessAdditional) {
		try {
			this.parametrocarteraDataAccessAdditional=parametrocarteraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroCarteraDataAccess() {
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
		ParametroCarteraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroCarteraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroCarteraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroCarteraOriginal(ParametroCartera parametrocartera)throws Exception  {
		parametrocartera.setParametroCarteraOriginal((ParametroCartera)parametrocartera.clone());		
	}
	
	public void setParametroCarterasOriginal(List<ParametroCartera> parametrocarteras)throws Exception  {
		
		for(ParametroCartera parametrocartera:parametrocarteras){
			parametrocartera.setParametroCarteraOriginal((ParametroCartera)parametrocartera.clone());
		}
	}
	
	public static void setParametroCarteraOriginalStatic(ParametroCartera parametrocartera)throws Exception  {
		parametrocartera.setParametroCarteraOriginal((ParametroCartera)parametrocartera.clone());		
	}
	
	public static void setParametroCarterasOriginalStatic(List<ParametroCartera> parametrocarteras)throws Exception  {
		
		for(ParametroCartera parametrocartera:parametrocarteras){
			parametrocartera.setParametroCarteraOriginal((ParametroCartera)parametrocartera.clone());
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
	
	public  ParametroCartera getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroCartera entity = new ParametroCartera();		
		
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
	
	public  ParametroCartera getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroCartera entity = new ParametroCartera();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroCarteraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroCarteraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.ParametroCartera.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroCarteraOriginal(new ParametroCartera());
      	    	entity=super.getEntity("",entity,resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroCartera("",entity,resultSet); 
				
				//entity.setParametroCarteraOriginal(super.getEntity("",entity.getParametroCarteraOriginal(),resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCarteraOriginal(this.getEntityParametroCartera("",entity.getParametroCarteraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroCartera(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroCartera getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroCartera entity = new ParametroCartera();
				
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
	
	public  ParametroCartera getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroCartera entity = new ParametroCartera();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroCarteraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroCarteraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCarteraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ParametroCartera.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroCarteraOriginal(new ParametroCartera());
      	    	entity=super.getEntity("",entity,resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroCartera("",entity,resultSet);    
				
				//entity.setParametroCarteraOriginal(super.getEntity("",entity.getParametroCarteraOriginal(),resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCarteraOriginal(this.getEntityParametroCartera("",entity.getParametroCarteraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroCartera(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroCartera
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroCartera entity = new ParametroCartera();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroCarteraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroCarteraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCarteraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ParametroCartera.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroCartera(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroCartera> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroCartera> entities = new  ArrayList<ParametroCartera>();
		ParametroCartera entity = new ParametroCartera();		  
		
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
	
	public  List<ParametroCartera> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroCartera> entities = new  ArrayList<ParametroCartera>();
		ParametroCartera entity = new ParametroCartera();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroCarteraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroCarteraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCarteraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCartera();
      	    	entity=super.getEntity("",entity,resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroCartera("",entity,resultSet);
      	    	
				//entity.setParametroCarteraOriginal( new ParametroCartera());
      	    	//entity.setParametroCarteraOriginal(super.getEntity("",entity.getParametroCarteraOriginal(),resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCarteraOriginal(this.getEntityParametroCartera("",entity.getParametroCarteraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroCarteras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCartera(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroCartera> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroCartera> entities = new  ArrayList<ParametroCartera>();
		ParametroCartera entity = new ParametroCartera();		  
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
	
	public  List<ParametroCartera> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroCartera> entities = new  ArrayList<ParametroCartera>();
		ParametroCartera entity = new ParametroCartera();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCartera();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroCartera();
					//entity.setMapParametroCartera(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroCarteraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroCartera().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA);         		
					entity=ParametroCarteraDataAccess.getEntityParametroCartera("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroCarteraOriginal( new ParametroCartera());
					////entity.setParametroCarteraOriginal(super.getEntity("",entity.getParametroCarteraOriginal(),resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroCarteraOriginal(this.getEntityParametroCartera("",entity.getParametroCarteraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroCarteras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCartera(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroCartera getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroCartera entity = new ParametroCartera();		  
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
	
	public  ParametroCartera getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroCartera entity = new ParametroCartera();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCartera();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroCartera();
					//entity.setMapParametroCartera(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroCarteraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroCartera().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA);         		
					entity=ParametroCarteraDataAccess.getEntityParametroCartera("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroCarteraOriginal( new ParametroCartera());
					////entity.setParametroCarteraOriginal(super.getEntity("",entity.getParametroCarteraOriginal(),resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroCarteraOriginal(this.getEntityParametroCartera("",entity.getParametroCarteraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroCartera(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCartera(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroCartera getEntityParametroCartera(String strPrefijo,ParametroCartera entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroCartera.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroCartera.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroCarteraDataAccess.setFieldReflectionParametroCartera(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroCartera=ParametroCarteraConstantesFunciones.getTodosTiposColumnasParametroCartera();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroCartera) {
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
							field = ParametroCartera.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroCartera.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroCarteraDataAccess.setFieldReflectionParametroCartera(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroCartera(Field field,String strPrefijo,String sColumn,ParametroCartera entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroCarteraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.IDTRANSACCIONFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.NUMERODIGITOSFACTURA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.PORLOTES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.IDTRANSACCIONDESHABILITA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.IDTRANSACCIONHABILITA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.IDTIPOFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.IDTIPOAUTOPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.NUMEROORDENPAGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.IDCUENTACONTABLECREDITOFISCAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCarteraConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroCartera>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroCartera> entities = new  ArrayList<ParametroCartera>();
		ParametroCartera entity = new ParametroCartera();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroCarteraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroCarteraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCarteraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroCartera();
					entity=super.getEntity("",entity,resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroCartera("",entity,resultSet);
					
					//entity.setParametroCarteraOriginal( new ParametroCartera());
					//entity.setParametroCarteraOriginal(super.getEntity("",entity.getParametroCarteraOriginal(),resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroCarteraOriginal(this.getEntityParametroCartera("",entity.getParametroCarteraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroCarteras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCartera(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroCartera>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroCartera> entities = new  ArrayList<ParametroCartera>();
		ParametroCartera entity = new ParametroCartera();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroCarteraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroCarteraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCarteraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroCartera> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroCartera> entities = new  ArrayList<ParametroCartera>();
		ParametroCartera entity = new ParametroCartera();		  
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
	
	public  List<ParametroCartera> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroCartera> entities = new  ArrayList<ParametroCartera>();
		ParametroCartera entity = new ParametroCartera();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCartera();
      	    	entity=super.getEntity("",entity,resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroCartera("",entity,resultSet);
      	    	
				//entity.setParametroCarteraOriginal( new ParametroCartera());
      	    	//entity.setParametroCarteraOriginal(super.getEntity("",entity.getParametroCarteraOriginal(),resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCarteraOriginal(this.getEntityParametroCartera("",entity.getParametroCarteraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroCarteras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCartera(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroCartera> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroCartera> entities = new  ArrayList<ParametroCartera>();
		ParametroCartera entity = new ParametroCartera();		  
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
	
	public  List<ParametroCartera> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroCartera> entities = new  ArrayList<ParametroCartera>();
		ParametroCartera entity = new ParametroCartera();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCartera();
      	    	entity=super.getEntity("",entity,resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroCartera("",entity,resultSet);
      	    	
				//entity.setParametroCarteraOriginal( new ParametroCartera());
      	    	//entity.setParametroCarteraOriginal(super.getEntity("",entity.getParametroCarteraOriginal(),resultSet,ParametroCarteraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCarteraOriginal(this.getEntityParametroCartera("",entity.getParametroCarteraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroCarteras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroCartera getEntityParametroCartera(String strPrefijo,ParametroCartera entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroCarteraConstantesFunciones.IDEMPRESA));
				entity.setid_transaccion_factura(resultSet.getLong(strPrefijo+ParametroCarteraConstantesFunciones.IDTRANSACCIONFACTURA));
				entity.setnumero_digitos_factura(resultSet.getInt(strPrefijo+ParametroCarteraConstantesFunciones.NUMERODIGITOSFACTURA));
				entity.setpor_lotes(resultSet.getBoolean(strPrefijo+ParametroCarteraConstantesFunciones.PORLOTES));
				entity.setid_empleado(resultSet.getLong(strPrefijo+ParametroCarteraConstantesFunciones.IDEMPLEADO));
				entity.setid_transaccion_deshabilita(resultSet.getLong(strPrefijo+ParametroCarteraConstantesFunciones.IDTRANSACCIONDESHABILITA));
				entity.setid_transaccion_habilita(resultSet.getLong(strPrefijo+ParametroCarteraConstantesFunciones.IDTRANSACCIONHABILITA));
				entity.setid_bodega(resultSet.getLong(strPrefijo+ParametroCarteraConstantesFunciones.IDBODEGA));
				entity.setid_tipo_factura(resultSet.getLong(strPrefijo+ParametroCarteraConstantesFunciones.IDTIPOFACTURA));
				entity.setid_tipo_auto_pago(resultSet.getLong(strPrefijo+ParametroCarteraConstantesFunciones.IDTIPOAUTOPAGO));
				entity.setnumero_orden_pago(resultSet.getString(strPrefijo+ParametroCarteraConstantesFunciones.NUMEROORDENPAGO));
				entity.setid_cuenta_contable_credito_fiscal(resultSet.getLong(strPrefijo+ParametroCarteraConstantesFunciones.IDCUENTACONTABLECREDITOFISCAL));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito_fiscal(null); }
				entity.setdescripcion(resultSet.getString(strPrefijo+ParametroCarteraConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroCartera(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroCartera entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroCarteraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroCarteraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroCarteraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroCarteraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroCarteraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroCarteraDataAccess.TABLENAME,ParametroCarteraDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroCarteraDataAccess.setParametroCarteraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroCartera relparametrocartera)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrocartera.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Transaccion getTransaccionFactura(Connexion connexion,ParametroCartera relparametrocartera)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrocartera.getid_transaccion_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Empleado getEmpleado(Connexion connexion,ParametroCartera relparametrocartera)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relparametrocartera.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Transaccion getTransaccionDeshabilita(Connexion connexion,ParametroCartera relparametrocartera)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrocartera.getid_transaccion_deshabilita());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionHabilita(Connexion connexion,ParametroCartera relparametrocartera)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrocartera.getid_transaccion_habilita());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Bodega getBodega(Connexion connexion,ParametroCartera relparametrocartera)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relparametrocartera.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public TipoFactura getTipoFactura(Connexion connexion,ParametroCartera relparametrocartera)throws SQLException,Exception {

		TipoFactura tipofactura= new TipoFactura();

		try {
			TipoFacturaDataAccess tipofacturaDataAccess=new TipoFacturaDataAccess();

			tipofacturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipofacturaDataAccess.setConnexionType(this.connexionType);
			tipofacturaDataAccess.setParameterDbType(this.parameterDbType);

			tipofactura=tipofacturaDataAccess.getEntity(connexion,relparametrocartera.getid_tipo_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipofactura;

	}

	public TipoAutoPago getTipoAutoPago(Connexion connexion,ParametroCartera relparametrocartera)throws SQLException,Exception {

		TipoAutoPago tipoautopago= new TipoAutoPago();

		try {
			TipoAutoPagoDataAccess tipoautopagoDataAccess=new TipoAutoPagoDataAccess();

			tipoautopagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoautopagoDataAccess.setConnexionType(this.connexionType);
			tipoautopagoDataAccess.setParameterDbType(this.parameterDbType);

			tipoautopago=tipoautopagoDataAccess.getEntity(connexion,relparametrocartera.getid_tipo_auto_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoautopago;

	}

	public CuentaContable getCuentaContableCreditoFiscal(Connexion connexion,ParametroCartera relparametrocartera)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrocartera.getid_cuenta_contable_credito_fiscal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroCartera parametrocartera) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrocartera.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrocartera.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_factura.setValue(parametrocartera.getid_transaccion_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_digitos_factura=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_digitos_factura.setValue(parametrocartera.getnumero_digitos_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_digitos_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepor_lotes=new ParameterValue<Boolean>();
					parameterMaintenanceValuepor_lotes.setValue(parametrocartera.getpor_lotes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepor_lotes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(parametrocartera.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_deshabilita=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_deshabilita.setValue(parametrocartera.getid_transaccion_deshabilita());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_deshabilita);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_habilita=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_habilita.setValue(parametrocartera.getid_transaccion_habilita());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_habilita);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(parametrocartera.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_factura.setValue(parametrocartera.getid_tipo_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_auto_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_auto_pago.setValue(parametrocartera.getid_tipo_auto_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_auto_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_orden_pago=new ParameterValue<String>();
					parameterMaintenanceValuenumero_orden_pago.setValue(parametrocartera.getnumero_orden_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_orden_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito_fiscal=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito_fiscal.setValue(parametrocartera.getid_cuenta_contable_credito_fiscal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito_fiscal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(parametrocartera.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrocartera.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrocartera.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrocartera.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrocartera.getId());
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
	
	public void setIsNewIsChangedFalseParametroCartera(ParametroCartera parametrocartera)throws Exception  {		
		parametrocartera.setIsNew(false);
		parametrocartera.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroCarteras(List<ParametroCartera> parametrocarteras)throws Exception  {				
		for(ParametroCartera parametrocartera:parametrocarteras) {
			parametrocartera.setIsNew(false);
			parametrocartera.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroCartera(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
