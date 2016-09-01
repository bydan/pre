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
package com.bydan.erp.sris.business.dataaccess;

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

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.util.*;//FacturaDiarioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class FacturaDiarioDataAccess extends  FacturaDiarioDataAccessAdditional{ //FacturaDiarioDataAccessAdditional,DataAccessHelper<FacturaDiario>
	//static Logger logger = Logger.getLogger(FacturaDiarioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="factura_diario";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_cliente,id_periodo_declara,id_tipo_iva,fecha_emision,fecha_vencimiento,numero_serie,ruc,numero_autoriza,es_devolucion,valor_factura,base_imponible,monto_iva,bim_tarjeta)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_cliente=?,id_periodo_declara=?,id_tipo_iva=?,fecha_emision=?,fecha_vencimiento=?,numero_serie=?,ruc=?,numero_autoriza=?,es_devolucion=?,valor_factura=?,base_imponible=?,monto_iva=?,bim_tarjeta=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select facturadiario from "+FacturaDiarioConstantesFunciones.SPERSISTENCENAME+" facturadiario";
	public static String QUERYSELECTNATIVE="select "+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".version_row,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id_empresa,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id_sucursal,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id_cliente,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id_periodo_declara,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id_tipo_iva,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".fecha_emision,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".fecha_vencimiento,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".numero_serie,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".ruc,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".numero_autoriza,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".es_devolucion,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".valor_factura,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".base_imponible,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".monto_iva,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".bim_tarjeta from "+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME;//+" as "+FacturaDiarioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".id,"+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+".version_row from "+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME;//+" as "+FacturaDiarioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FacturaDiarioConstantesFunciones.SCHEMA+"."+FacturaDiarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_cliente=?,id_periodo_declara=?,id_tipo_iva=?,fecha_emision=?,fecha_vencimiento=?,numero_serie=?,ruc=?,numero_autoriza=?,es_devolucion=?,valor_factura=?,base_imponible=?,monto_iva=?,bim_tarjeta=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FACTURADIARIO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FACTURADIARIO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FACTURADIARIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FACTURADIARIO_SELECT(?,?)";
	
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
	
	
	protected FacturaDiarioDataAccessAdditional facturadiarioDataAccessAdditional=null;
	
	public FacturaDiarioDataAccessAdditional getFacturaDiarioDataAccessAdditional() {
		return this.facturadiarioDataAccessAdditional;
	}
	
	public void setFacturaDiarioDataAccessAdditional(FacturaDiarioDataAccessAdditional facturadiarioDataAccessAdditional) {
		try {
			this.facturadiarioDataAccessAdditional=facturadiarioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FacturaDiarioDataAccess() {
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
		FacturaDiarioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FacturaDiarioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FacturaDiarioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFacturaDiarioOriginal(FacturaDiario facturadiario)throws Exception  {
		facturadiario.setFacturaDiarioOriginal((FacturaDiario)facturadiario.clone());		
	}
	
	public void setFacturaDiariosOriginal(List<FacturaDiario> facturadiarios)throws Exception  {
		
		for(FacturaDiario facturadiario:facturadiarios){
			facturadiario.setFacturaDiarioOriginal((FacturaDiario)facturadiario.clone());
		}
	}
	
	public static void setFacturaDiarioOriginalStatic(FacturaDiario facturadiario)throws Exception  {
		facturadiario.setFacturaDiarioOriginal((FacturaDiario)facturadiario.clone());		
	}
	
	public static void setFacturaDiariosOriginalStatic(List<FacturaDiario> facturadiarios)throws Exception  {
		
		for(FacturaDiario facturadiario:facturadiarios){
			facturadiario.setFacturaDiarioOriginal((FacturaDiario)facturadiario.clone());
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
	
	public  FacturaDiario getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FacturaDiario entity = new FacturaDiario();		
		
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
	
	public  FacturaDiario getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FacturaDiario entity = new FacturaDiario();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaDiarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaDiarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Sris.FacturaDiario.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFacturaDiarioOriginal(new FacturaDiario());
      	    	entity=super.getEntity("",entity,resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFacturaDiario("",entity,resultSet); 
				
				//entity.setFacturaDiarioOriginal(super.getEntity("",entity.getFacturaDiarioOriginal(),resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaDiarioOriginal(this.getEntityFacturaDiario("",entity.getFacturaDiarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFacturaDiario(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FacturaDiario getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FacturaDiario entity = new FacturaDiario();
				
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
	
	public  FacturaDiario getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FacturaDiario entity = new FacturaDiario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaDiarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaDiarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaDiarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Sris.FacturaDiario.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFacturaDiarioOriginal(new FacturaDiario());
      	    	entity=super.getEntity("",entity,resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFacturaDiario("",entity,resultSet);    
				
				//entity.setFacturaDiarioOriginal(super.getEntity("",entity.getFacturaDiarioOriginal(),resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaDiarioOriginal(this.getEntityFacturaDiario("",entity.getFacturaDiarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFacturaDiario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FacturaDiario
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FacturaDiario entity = new FacturaDiario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaDiarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaDiarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaDiarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Sris.FacturaDiario.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFacturaDiario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FacturaDiario> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FacturaDiario> entities = new  ArrayList<FacturaDiario>();
		FacturaDiario entity = new FacturaDiario();		  
		
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
	
	public  List<FacturaDiario> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FacturaDiario> entities = new  ArrayList<FacturaDiario>();
		FacturaDiario entity = new FacturaDiario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaDiarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaDiarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaDiarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaDiario();
      	    	entity=super.getEntity("",entity,resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaDiario("",entity,resultSet);
      	    	
				//entity.setFacturaDiarioOriginal( new FacturaDiario());
      	    	//entity.setFacturaDiarioOriginal(super.getEntity("",entity.getFacturaDiarioOriginal(),resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaDiarioOriginal(this.getEntityFacturaDiario("",entity.getFacturaDiarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaDiarios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaDiario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FacturaDiario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturaDiario> entities = new  ArrayList<FacturaDiario>();
		FacturaDiario entity = new FacturaDiario();		  
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
	
	public  List<FacturaDiario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturaDiario> entities = new  ArrayList<FacturaDiario>();
		FacturaDiario entity = new FacturaDiario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaDiario();
				
				if(conMapGenerico) {
					entity.inicializarMapFacturaDiario();
					//entity.setMapFacturaDiario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFacturaDiarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFacturaDiario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA);         		
					entity=FacturaDiarioDataAccess.getEntityFacturaDiario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFacturaDiarioOriginal( new FacturaDiario());
					////entity.setFacturaDiarioOriginal(super.getEntity("",entity.getFacturaDiarioOriginal(),resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturaDiarioOriginal(this.getEntityFacturaDiario("",entity.getFacturaDiarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaDiarios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaDiario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FacturaDiario getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FacturaDiario entity = new FacturaDiario();		  
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
	
	public  FacturaDiario getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FacturaDiario entity = new FacturaDiario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaDiario();
				
				if(conMapGenerico) {
					entity.inicializarMapFacturaDiario();
					//entity.setMapFacturaDiario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFacturaDiarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFacturaDiario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA);         		
					entity=FacturaDiarioDataAccess.getEntityFacturaDiario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFacturaDiarioOriginal( new FacturaDiario());
					////entity.setFacturaDiarioOriginal(super.getEntity("",entity.getFacturaDiarioOriginal(),resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturaDiarioOriginal(this.getEntityFacturaDiario("",entity.getFacturaDiarioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFacturaDiario(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaDiario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FacturaDiario getEntityFacturaDiario(String strPrefijo,FacturaDiario entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FacturaDiario.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FacturaDiario.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FacturaDiarioDataAccess.setFieldReflectionFacturaDiario(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFacturaDiario=FacturaDiarioConstantesFunciones.getTodosTiposColumnasFacturaDiario();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFacturaDiario) {
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
							field = FacturaDiario.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FacturaDiario.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FacturaDiarioDataAccess.setFieldReflectionFacturaDiario(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFacturaDiario(Field field,String strPrefijo,String sColumn,FacturaDiario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FacturaDiarioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.IDPERIODODECLARA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.IDTIPOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaDiarioConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaDiarioConstantesFunciones.NUMEROSERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.NUMEROAUTORIZA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.ESDEVOLUCION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.VALORFACTURA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.BASEIMPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.MONTOIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaDiarioConstantesFunciones.BIMTARJETA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FacturaDiario>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FacturaDiario> entities = new  ArrayList<FacturaDiario>();
		FacturaDiario entity = new FacturaDiario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaDiarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaDiarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaDiarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new FacturaDiario();
					entity=super.getEntity("",entity,resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFacturaDiario("",entity,resultSet);
					
					//entity.setFacturaDiarioOriginal( new FacturaDiario());
					//entity.setFacturaDiarioOriginal(super.getEntity("",entity.getFacturaDiarioOriginal(),resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA));         		
					//entity.setFacturaDiarioOriginal(this.getEntityFacturaDiario("",entity.getFacturaDiarioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFacturaDiarios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaDiario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FacturaDiario>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FacturaDiario> entities = new  ArrayList<FacturaDiario>();
		FacturaDiario entity = new FacturaDiario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaDiarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaDiarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaDiarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<FacturaDiario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaDiario> entities = new  ArrayList<FacturaDiario>();
		FacturaDiario entity = new FacturaDiario();		  
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
	
	public  List<FacturaDiario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaDiario> entities = new  ArrayList<FacturaDiario>();
		FacturaDiario entity = new FacturaDiario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaDiario();
      	    	entity=super.getEntity("",entity,resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaDiario("",entity,resultSet);
      	    	
				//entity.setFacturaDiarioOriginal( new FacturaDiario());
      	    	//entity.setFacturaDiarioOriginal(super.getEntity("",entity.getFacturaDiarioOriginal(),resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaDiarioOriginal(this.getEntityFacturaDiario("",entity.getFacturaDiarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFacturaDiarios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaDiario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FacturaDiario> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaDiario> entities = new  ArrayList<FacturaDiario>();
		FacturaDiario entity = new FacturaDiario();		  
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
	
	public  List<FacturaDiario> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaDiario> entities = new  ArrayList<FacturaDiario>();
		FacturaDiario entity = new FacturaDiario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaDiario();
      	    	entity=super.getEntity("",entity,resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaDiario("",entity,resultSet);
      	    	
				//entity.setFacturaDiarioOriginal( new FacturaDiario());
      	    	//entity.setFacturaDiarioOriginal(super.getEntity("",entity.getFacturaDiarioOriginal(),resultSet,FacturaDiarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaDiarioOriginal(this.getEntityFacturaDiario("",entity.getFacturaDiarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaDiarios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FacturaDiario getEntityFacturaDiario(String strPrefijo,FacturaDiario entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FacturaDiarioConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+FacturaDiarioConstantesFunciones.IDSUCURSAL));
				entity.setid_cliente(resultSet.getLong(strPrefijo+FacturaDiarioConstantesFunciones.IDCLIENTE));
				entity.setid_periodo_declara(resultSet.getLong(strPrefijo+FacturaDiarioConstantesFunciones.IDPERIODODECLARA));
				entity.setid_tipo_iva(resultSet.getLong(strPrefijo+FacturaDiarioConstantesFunciones.IDTIPOIVA));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+FacturaDiarioConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+FacturaDiarioConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setnumero_serie(resultSet.getString(strPrefijo+FacturaDiarioConstantesFunciones.NUMEROSERIE));
				entity.setruc(resultSet.getString(strPrefijo+FacturaDiarioConstantesFunciones.RUC));
				entity.setnumero_autoriza(resultSet.getString(strPrefijo+FacturaDiarioConstantesFunciones.NUMEROAUTORIZA));
				entity.setes_devolucion(resultSet.getBoolean(strPrefijo+FacturaDiarioConstantesFunciones.ESDEVOLUCION));
				entity.setvalor_factura(resultSet.getDouble(strPrefijo+FacturaDiarioConstantesFunciones.VALORFACTURA));
				entity.setbase_imponible(resultSet.getDouble(strPrefijo+FacturaDiarioConstantesFunciones.BASEIMPONIBLE));
				entity.setmonto_iva(resultSet.getDouble(strPrefijo+FacturaDiarioConstantesFunciones.MONTOIVA));
				entity.setbim_tarjeta(resultSet.getDouble(strPrefijo+FacturaDiarioConstantesFunciones.BIMTARJETA));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFacturaDiario(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FacturaDiario entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FacturaDiarioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FacturaDiarioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FacturaDiarioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FacturaDiarioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FacturaDiarioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FacturaDiarioDataAccess.TABLENAME,FacturaDiarioDataAccess.ISWITHSTOREPROCEDURES);
			
			FacturaDiarioDataAccess.setFacturaDiarioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FacturaDiario relfacturadiario)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relfacturadiario.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,FacturaDiario relfacturadiario)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relfacturadiario.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Cliente getCliente(Connexion connexion,FacturaDiario relfacturadiario)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relfacturadiario.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public PeriodoDeclara getPeriodoDeclara(Connexion connexion,FacturaDiario relfacturadiario)throws SQLException,Exception {

		PeriodoDeclara periododeclara= new PeriodoDeclara();

		try {
			PeriodoDeclaraDataAccess periododeclaraDataAccess=new PeriodoDeclaraDataAccess();

			periododeclaraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periododeclaraDataAccess.setConnexionType(this.connexionType);
			periododeclaraDataAccess.setParameterDbType(this.parameterDbType);

			periododeclara=periododeclaraDataAccess.getEntity(connexion,relfacturadiario.getid_periodo_declara());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periododeclara;

	}

	public TipoIva getTipoIva(Connexion connexion,FacturaDiario relfacturadiario)throws SQLException,Exception {

		TipoIva tipoiva= new TipoIva();

		try {
			TipoIvaDataAccess tipoivaDataAccess=new TipoIvaDataAccess();

			tipoivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoivaDataAccess.setConnexionType(this.connexionType);
			tipoivaDataAccess.setParameterDbType(this.parameterDbType);

			tipoiva=tipoivaDataAccess.getEntity(connexion,relfacturadiario.getid_tipo_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoiva;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FacturaDiario facturadiario) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!facturadiario.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(facturadiario.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(facturadiario.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(facturadiario.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo_declara=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo_declara.setValue(facturadiario.getid_periodo_declara());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo_declara);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_iva.setValue(facturadiario.getid_tipo_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(facturadiario.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(facturadiario.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_serie=new ParameterValue<String>();
					parameterMaintenanceValuenumero_serie.setValue(facturadiario.getnumero_serie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_serie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(facturadiario.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_autoriza=new ParameterValue<String>();
					parameterMaintenanceValuenumero_autoriza.setValue(facturadiario.getnumero_autoriza());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_autoriza);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_devolucion=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_devolucion.setValue(facturadiario.getes_devolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_devolucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_factura=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_factura.setValue(facturadiario.getvalor_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebase_imponible=new ParameterValue<Double>();
					parameterMaintenanceValuebase_imponible.setValue(facturadiario.getbase_imponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebase_imponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_iva=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_iva.setValue(facturadiario.getmonto_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebim_tarjeta=new ParameterValue<Double>();
					parameterMaintenanceValuebim_tarjeta.setValue(facturadiario.getbim_tarjeta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebim_tarjeta);
					parametersTemp.add(parameterMaintenance);
					
						if(!facturadiario.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(facturadiario.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(facturadiario.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(facturadiario.getId());
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
	
	public void setIsNewIsChangedFalseFacturaDiario(FacturaDiario facturadiario)throws Exception  {		
		facturadiario.setIsNew(false);
		facturadiario.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFacturaDiarios(List<FacturaDiario> facturadiarios)throws Exception  {				
		for(FacturaDiario facturadiario:facturadiarios) {
			facturadiario.setIsNew(false);
			facturadiario.setIsChanged(false);
		}
	}
	
	public void generarExportarFacturaDiario(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
