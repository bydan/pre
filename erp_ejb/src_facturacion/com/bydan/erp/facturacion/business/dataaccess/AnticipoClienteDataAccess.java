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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//AnticipoClienteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class AnticipoClienteDataAccess extends  AnticipoClienteDataAccessAdditional{ //AnticipoClienteDataAccessAdditional,DataAccessHelper<AnticipoCliente>
	//static Logger logger = Logger.getLogger(AnticipoClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="anticipo_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_estado_anti_cliente,id_tipo_grupo_forma_pago,fecha,valor,descripcion,valor_adicional,valor_prestamo,ingreso1,ingreso2,ingreso3,ingreso4,ingreso5,descuento1,descuento2,descuento3,descuento4,descuento5,tipo_ingreso,tipo_descuento)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_estado_anti_cliente=?,id_tipo_grupo_forma_pago=?,fecha=?,valor=?,descripcion=?,valor_adicional=?,valor_prestamo=?,ingreso1=?,ingreso2=?,ingreso3=?,ingreso4=?,ingreso5=?,descuento1=?,descuento2=?,descuento3=?,descuento4=?,descuento5=?,tipo_ingreso=?,tipo_descuento=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select anticipocliente from "+AnticipoClienteConstantesFunciones.SPERSISTENCENAME+" anticipocliente";
	public static String QUERYSELECTNATIVE="select "+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".id,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".version_row,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".id_empresa,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".id_empleado,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".id_estado_anti_cliente,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".id_tipo_grupo_forma_pago,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".fecha,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".valor,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".descripcion,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".valor_adicional,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".valor_prestamo,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".ingreso1,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".ingreso2,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".ingreso3,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".ingreso4,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".ingreso5,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".descuento1,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".descuento2,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".descuento3,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".descuento4,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".descuento5,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".tipo_ingreso,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".tipo_descuento from "+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME;//+" as "+AnticipoClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".id,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".version_row from "+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME;//+" as "+AnticipoClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_estado_anti_cliente=?,id_tipo_grupo_forma_pago=?,fecha=?,valor=?,descripcion=?,valor_adicional=?,valor_prestamo=?,ingreso1=?,ingreso2=?,ingreso3=?,ingreso4=?,ingreso5=?,descuento1=?,descuento2=?,descuento3=?,descuento4=?,descuento5=?,tipo_ingreso=?,tipo_descuento=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ANTICIPOCLIENTE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ANTICIPOCLIENTE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ANTICIPOCLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ANTICIPOCLIENTE_SELECT(?,?)";
	
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
	
	
	protected AnticipoClienteDataAccessAdditional anticipoclienteDataAccessAdditional=null;
	
	public AnticipoClienteDataAccessAdditional getAnticipoClienteDataAccessAdditional() {
		return this.anticipoclienteDataAccessAdditional;
	}
	
	public void setAnticipoClienteDataAccessAdditional(AnticipoClienteDataAccessAdditional anticipoclienteDataAccessAdditional) {
		try {
			this.anticipoclienteDataAccessAdditional=anticipoclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AnticipoClienteDataAccess() {
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
		AnticipoClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AnticipoClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AnticipoClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAnticipoClienteOriginal(AnticipoCliente anticipocliente)throws Exception  {
		anticipocliente.setAnticipoClienteOriginal((AnticipoCliente)anticipocliente.clone());		
	}
	
	public void setAnticipoClientesOriginal(List<AnticipoCliente> anticipoclientes)throws Exception  {
		
		for(AnticipoCliente anticipocliente:anticipoclientes){
			anticipocliente.setAnticipoClienteOriginal((AnticipoCliente)anticipocliente.clone());
		}
	}
	
	public static void setAnticipoClienteOriginalStatic(AnticipoCliente anticipocliente)throws Exception  {
		anticipocliente.setAnticipoClienteOriginal((AnticipoCliente)anticipocliente.clone());		
	}
	
	public static void setAnticipoClientesOriginalStatic(List<AnticipoCliente> anticipoclientes)throws Exception  {
		
		for(AnticipoCliente anticipocliente:anticipoclientes){
			anticipocliente.setAnticipoClienteOriginal((AnticipoCliente)anticipocliente.clone());
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
	
	public  AnticipoCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AnticipoCliente entity = new AnticipoCliente();		
		
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
	
	public  AnticipoCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AnticipoCliente entity = new AnticipoCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AnticipoClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AnticipoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.AnticipoCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAnticipoClienteOriginal(new AnticipoCliente());
      	    	entity=super.getEntity("",entity,resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAnticipoCliente("",entity,resultSet); 
				
				//entity.setAnticipoClienteOriginal(super.getEntity("",entity.getAnticipoClienteOriginal(),resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAnticipoClienteOriginal(this.getEntityAnticipoCliente("",entity.getAnticipoClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAnticipoCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AnticipoCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AnticipoCliente entity = new AnticipoCliente();
				
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
	
	public  AnticipoCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AnticipoCliente entity = new AnticipoCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AnticipoClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AnticipoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AnticipoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.AnticipoCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAnticipoClienteOriginal(new AnticipoCliente());
      	    	entity=super.getEntity("",entity,resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAnticipoCliente("",entity,resultSet);    
				
				//entity.setAnticipoClienteOriginal(super.getEntity("",entity.getAnticipoClienteOriginal(),resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAnticipoClienteOriginal(this.getEntityAnticipoCliente("",entity.getAnticipoClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAnticipoCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AnticipoCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AnticipoCliente entity = new AnticipoCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AnticipoClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AnticipoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AnticipoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.AnticipoCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAnticipoCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AnticipoCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AnticipoCliente> entities = new  ArrayList<AnticipoCliente>();
		AnticipoCliente entity = new AnticipoCliente();		  
		
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
	
	public  List<AnticipoCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AnticipoCliente> entities = new  ArrayList<AnticipoCliente>();
		AnticipoCliente entity = new AnticipoCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AnticipoClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AnticipoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AnticipoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AnticipoCliente();
      	    	entity=super.getEntity("",entity,resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAnticipoCliente("",entity,resultSet);
      	    	
				//entity.setAnticipoClienteOriginal( new AnticipoCliente());
      	    	//entity.setAnticipoClienteOriginal(super.getEntity("",entity.getAnticipoClienteOriginal(),resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAnticipoClienteOriginal(this.getEntityAnticipoCliente("",entity.getAnticipoClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAnticipoClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAnticipoCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AnticipoCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AnticipoCliente> entities = new  ArrayList<AnticipoCliente>();
		AnticipoCliente entity = new AnticipoCliente();		  
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
	
	public  List<AnticipoCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AnticipoCliente> entities = new  ArrayList<AnticipoCliente>();
		AnticipoCliente entity = new AnticipoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AnticipoCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapAnticipoCliente();
					//entity.setMapAnticipoCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAnticipoClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAnticipoCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA);         		
					entity=AnticipoClienteDataAccess.getEntityAnticipoCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAnticipoClienteOriginal( new AnticipoCliente());
					////entity.setAnticipoClienteOriginal(super.getEntity("",entity.getAnticipoClienteOriginal(),resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setAnticipoClienteOriginal(this.getEntityAnticipoCliente("",entity.getAnticipoClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAnticipoClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAnticipoCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AnticipoCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AnticipoCliente entity = new AnticipoCliente();		  
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
	
	public  AnticipoCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AnticipoCliente entity = new AnticipoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AnticipoCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapAnticipoCliente();
					//entity.setMapAnticipoCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAnticipoClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAnticipoCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA);         		
					entity=AnticipoClienteDataAccess.getEntityAnticipoCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAnticipoClienteOriginal( new AnticipoCliente());
					////entity.setAnticipoClienteOriginal(super.getEntity("",entity.getAnticipoClienteOriginal(),resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setAnticipoClienteOriginal(this.getEntityAnticipoCliente("",entity.getAnticipoClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAnticipoCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAnticipoCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AnticipoCliente getEntityAnticipoCliente(String strPrefijo,AnticipoCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AnticipoCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AnticipoCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AnticipoClienteDataAccess.setFieldReflectionAnticipoCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAnticipoCliente=AnticipoClienteConstantesFunciones.getTodosTiposColumnasAnticipoCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAnticipoCliente) {
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
							field = AnticipoCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AnticipoCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AnticipoClienteDataAccess.setFieldReflectionAnticipoCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAnticipoCliente(Field field,String strPrefijo,String sColumn,AnticipoCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AnticipoClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.IDESTADOANTICLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.IDTIPOGRUPOFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AnticipoClienteConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.VALORADICIONAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.VALORPRESTAMO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.INGRESO1:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.INGRESO2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.INGRESO3:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.INGRESO4:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.INGRESO5:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.DESCUENTO1:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.DESCUENTO2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.DESCUENTO3:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.DESCUENTO4:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.DESCUENTO5:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.TIPOINGRESO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AnticipoClienteConstantesFunciones.TIPODESCUENTO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AnticipoCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AnticipoCliente> entities = new  ArrayList<AnticipoCliente>();
		AnticipoCliente entity = new AnticipoCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AnticipoClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AnticipoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AnticipoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AnticipoCliente();
					entity=super.getEntity("",entity,resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAnticipoCliente("",entity,resultSet);
					
					//entity.setAnticipoClienteOriginal( new AnticipoCliente());
					//entity.setAnticipoClienteOriginal(super.getEntity("",entity.getAnticipoClienteOriginal(),resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setAnticipoClienteOriginal(this.getEntityAnticipoCliente("",entity.getAnticipoClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAnticipoClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAnticipoCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AnticipoCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AnticipoCliente> entities = new  ArrayList<AnticipoCliente>();
		AnticipoCliente entity = new AnticipoCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AnticipoClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AnticipoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AnticipoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AnticipoCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AnticipoCliente> entities = new  ArrayList<AnticipoCliente>();
		AnticipoCliente entity = new AnticipoCliente();		  
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
	
	public  List<AnticipoCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AnticipoCliente> entities = new  ArrayList<AnticipoCliente>();
		AnticipoCliente entity = new AnticipoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AnticipoCliente();
      	    	entity=super.getEntity("",entity,resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAnticipoCliente("",entity,resultSet);
      	    	
				//entity.setAnticipoClienteOriginal( new AnticipoCliente());
      	    	//entity.setAnticipoClienteOriginal(super.getEntity("",entity.getAnticipoClienteOriginal(),resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAnticipoClienteOriginal(this.getEntityAnticipoCliente("",entity.getAnticipoClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAnticipoClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAnticipoCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AnticipoCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AnticipoCliente> entities = new  ArrayList<AnticipoCliente>();
		AnticipoCliente entity = new AnticipoCliente();		  
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
	
	public  List<AnticipoCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AnticipoCliente> entities = new  ArrayList<AnticipoCliente>();
		AnticipoCliente entity = new AnticipoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AnticipoCliente();
      	    	entity=super.getEntity("",entity,resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAnticipoCliente("",entity,resultSet);
      	    	
				//entity.setAnticipoClienteOriginal( new AnticipoCliente());
      	    	//entity.setAnticipoClienteOriginal(super.getEntity("",entity.getAnticipoClienteOriginal(),resultSet,AnticipoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAnticipoClienteOriginal(this.getEntityAnticipoCliente("",entity.getAnticipoClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAnticipoClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AnticipoCliente getEntityAnticipoCliente(String strPrefijo,AnticipoCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+AnticipoClienteConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+AnticipoClienteConstantesFunciones.IDEMPLEADO));
				entity.setid_estado_anti_cliente(resultSet.getLong(strPrefijo+AnticipoClienteConstantesFunciones.IDESTADOANTICLIENTE));
				entity.setid_tipo_grupo_forma_pago(resultSet.getLong(strPrefijo+AnticipoClienteConstantesFunciones.IDTIPOGRUPOFORMAPAGO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+AnticipoClienteConstantesFunciones.FECHA).getTime()));
				entity.setvalor(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.VALOR));
				entity.setdescripcion(resultSet.getString(strPrefijo+AnticipoClienteConstantesFunciones.DESCRIPCION));
				entity.setvalor_adicional(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.VALORADICIONAL));
				entity.setvalor_prestamo(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.VALORPRESTAMO));
				entity.setingreso1(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.INGRESO1));
				entity.setingreso2(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.INGRESO2));
				entity.setingreso3(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.INGRESO3));
				entity.setingreso4(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.INGRESO4));
				entity.setingreso5(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.INGRESO5));
				entity.setdescuento1(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.DESCUENTO1));
				entity.setdescuento2(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.DESCUENTO2));
				entity.setdescuento3(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.DESCUENTO3));
				entity.setdescuento4(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.DESCUENTO4));
				entity.setdescuento5(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.DESCUENTO5));
				entity.settipo_ingreso(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.TIPOINGRESO));
				entity.settipo_descuento(resultSet.getDouble(strPrefijo+AnticipoClienteConstantesFunciones.TIPODESCUENTO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAnticipoCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AnticipoCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AnticipoClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AnticipoClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AnticipoClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AnticipoClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AnticipoClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AnticipoClienteDataAccess.TABLENAME,AnticipoClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			AnticipoClienteDataAccess.setAnticipoClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,AnticipoCliente relanticipocliente)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relanticipocliente.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,AnticipoCliente relanticipocliente)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relanticipocliente.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public EstadoAntiCliente getEstadoAntiCliente(Connexion connexion,AnticipoCliente relanticipocliente)throws SQLException,Exception {

		EstadoAntiCliente estadoanticliente= new EstadoAntiCliente();

		try {
			EstadoAntiClienteDataAccess estadoanticlienteDataAccess=new EstadoAntiClienteDataAccess();

			estadoanticlienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoanticlienteDataAccess.setConnexionType(this.connexionType);
			estadoanticlienteDataAccess.setParameterDbType(this.parameterDbType);

			estadoanticliente=estadoanticlienteDataAccess.getEntity(connexion,relanticipocliente.getid_estado_anti_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoanticliente;

	}

	public TipoGrupoFormaPago getTipoGrupoFormaPago(Connexion connexion,AnticipoCliente relanticipocliente)throws SQLException,Exception {

		TipoGrupoFormaPago tipogrupoformapago= new TipoGrupoFormaPago();

		try {
			TipoGrupoFormaPagoDataAccess tipogrupoformapagoDataAccess=new TipoGrupoFormaPagoDataAccess();

			tipogrupoformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogrupoformapagoDataAccess.setConnexionType(this.connexionType);
			tipogrupoformapagoDataAccess.setParameterDbType(this.parameterDbType);

			tipogrupoformapago=tipogrupoformapagoDataAccess.getEntity(connexion,relanticipocliente.getid_tipo_grupo_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogrupoformapago;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AnticipoCliente anticipocliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!anticipocliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(anticipocliente.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(anticipocliente.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_anti_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_anti_cliente.setValue(anticipocliente.getid_estado_anti_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_anti_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_grupo_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_grupo_forma_pago.setValue(anticipocliente.getid_tipo_grupo_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_grupo_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(anticipocliente.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(anticipocliente.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(anticipocliente.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_adicional=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_adicional.setValue(anticipocliente.getvalor_adicional());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_adicional);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_prestamo=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_prestamo.setValue(anticipocliente.getvalor_prestamo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_prestamo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueingreso1=new ParameterValue<Double>();
					parameterMaintenanceValueingreso1.setValue(anticipocliente.getingreso1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueingreso1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueingreso2=new ParameterValue<Double>();
					parameterMaintenanceValueingreso2.setValue(anticipocliente.getingreso2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueingreso2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueingreso3=new ParameterValue<Double>();
					parameterMaintenanceValueingreso3.setValue(anticipocliente.getingreso3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueingreso3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueingreso4=new ParameterValue<Double>();
					parameterMaintenanceValueingreso4.setValue(anticipocliente.getingreso4());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueingreso4);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueingreso5=new ParameterValue<Double>();
					parameterMaintenanceValueingreso5.setValue(anticipocliente.getingreso5());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueingreso5);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento1=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento1.setValue(anticipocliente.getdescuento1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento2=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento2.setValue(anticipocliente.getdescuento2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento3=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento3.setValue(anticipocliente.getdescuento3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento4=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento4.setValue(anticipocliente.getdescuento4());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento4);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento5=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento5.setValue(anticipocliente.getdescuento5());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento5);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetipo_ingreso=new ParameterValue<Double>();
					parameterMaintenanceValuetipo_ingreso.setValue(anticipocliente.gettipo_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetipo_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetipo_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuetipo_descuento.setValue(anticipocliente.gettipo_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetipo_descuento);
					parametersTemp.add(parameterMaintenance);
					
						if(!anticipocliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(anticipocliente.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(anticipocliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(anticipocliente.getId());
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
	
	public void setIsNewIsChangedFalseAnticipoCliente(AnticipoCliente anticipocliente)throws Exception  {		
		anticipocliente.setIsNew(false);
		anticipocliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAnticipoClientes(List<AnticipoCliente> anticipoclientes)throws Exception  {				
		for(AnticipoCliente anticipocliente:anticipoclientes) {
			anticipocliente.setIsNew(false);
			anticipocliente.setIsChanged(false);
		}
	}
	
	public void generarExportarAnticipoCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
