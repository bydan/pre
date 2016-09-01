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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//PoliticasClienteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class PoliticasClienteDataAccess extends  PoliticasClienteDataAccessAdditional{ //PoliticasClienteDataAccessAdditional,DataAccessHelper<PoliticasCliente>
	//static Logger logger = Logger.getLogger(PoliticasClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="politicas_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+"(id,version_row,id_empresa,limite_credito,fecha_inicio,fecha_renovacion,fecha_fin,dias_neto_pago,dias_gracia,cupo,descuento_general,descuento_pronto_pago,id_tipo_precio,con_lista_precio,con_impuestos,activar_monto_facturacion,valor_sobregiro,fecha_venci_sobregiro,id_transporte,valor_solicitado,valor_aprobado,id_linea_negocio,fecha_solicitud,obsevacion,web,casilla_postal,forma_envio,id_banco,id_tipo_cuenta_banco_global,numero_cuenta,id_estado_politicas_cliente)values(?,current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_empresa=?,limite_credito=?,fecha_inicio=?,fecha_renovacion=?,fecha_fin=?,dias_neto_pago=?,dias_gracia=?,cupo=?,descuento_general=?,descuento_pronto_pago=?,id_tipo_precio=?,con_lista_precio=?,con_impuestos=?,activar_monto_facturacion=?,valor_sobregiro=?,fecha_venci_sobregiro=?,id_transporte=?,valor_solicitado=?,valor_aprobado=?,id_linea_negocio=?,fecha_solicitud=?,obsevacion=?,web=?,casilla_postal=?,forma_envio=?,id_banco=?,id_tipo_cuenta_banco_global=?,numero_cuenta=?,id_estado_politicas_cliente=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select politicascliente from "+PoliticasClienteConstantesFunciones.SPERSISTENCENAME+" politicascliente";
	public static String QUERYSELECTNATIVE="select "+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".version_row,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_empresa,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".limite_credito,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".fecha_inicio,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".fecha_renovacion,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".fecha_fin,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".dias_neto_pago,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".dias_gracia,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".cupo,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".descuento_general,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".descuento_pronto_pago,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_tipo_precio,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".con_lista_precio,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".con_impuestos,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".activar_monto_facturacion,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".valor_sobregiro,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".fecha_venci_sobregiro,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_transporte,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".valor_solicitado,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".valor_aprobado,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_linea_negocio,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".fecha_solicitud,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".obsevacion,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".web,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".casilla_postal,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".forma_envio,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_banco,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco_global,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".numero_cuenta,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_estado_politicas_cliente from "+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME;//+" as "+PoliticasClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".version_row,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".fecha_inicio from "+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME;//+" as "+PoliticasClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_empresa=?,limite_credito=?,fecha_inicio=?,fecha_renovacion=?,fecha_fin=?,dias_neto_pago=?,dias_gracia=?,cupo=?,descuento_general=?,descuento_pronto_pago=?,id_tipo_precio=?,con_lista_precio=?,con_impuestos=?,activar_monto_facturacion=?,valor_sobregiro=?,fecha_venci_sobregiro=?,id_transporte=?,valor_solicitado=?,valor_aprobado=?,id_linea_negocio=?,fecha_solicitud=?,obsevacion=?,web=?,casilla_postal=?,forma_envio=?,id_banco=?,id_tipo_cuenta_banco_global=?,numero_cuenta=?,id_estado_politicas_cliente=?";
	
	public static String STOREPROCEDUREINSERT="call SP_POLITICASCLIENTE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_POLITICASCLIENTE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_POLITICASCLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_POLITICASCLIENTE_SELECT(?,?)";
	
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
	
	
	protected PoliticasClienteDataAccessAdditional politicasclienteDataAccessAdditional=null;
	
	public PoliticasClienteDataAccessAdditional getPoliticasClienteDataAccessAdditional() {
		return this.politicasclienteDataAccessAdditional;
	}
	
	public void setPoliticasClienteDataAccessAdditional(PoliticasClienteDataAccessAdditional politicasclienteDataAccessAdditional) {
		try {
			this.politicasclienteDataAccessAdditional=politicasclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PoliticasClienteDataAccess() {
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
		PoliticasClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PoliticasClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PoliticasClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPoliticasClienteOriginal(PoliticasCliente politicascliente)throws Exception  {
		politicascliente.setPoliticasClienteOriginal((PoliticasCliente)politicascliente.clone());		
	}
	
	public void setPoliticasClientesOriginal(List<PoliticasCliente> politicasclientes)throws Exception  {
		
		for(PoliticasCliente politicascliente:politicasclientes){
			politicascliente.setPoliticasClienteOriginal((PoliticasCliente)politicascliente.clone());
		}
	}
	
	public static void setPoliticasClienteOriginalStatic(PoliticasCliente politicascliente)throws Exception  {
		politicascliente.setPoliticasClienteOriginal((PoliticasCliente)politicascliente.clone());		
	}
	
	public static void setPoliticasClientesOriginalStatic(List<PoliticasCliente> politicasclientes)throws Exception  {
		
		for(PoliticasCliente politicascliente:politicasclientes){
			politicascliente.setPoliticasClienteOriginal((PoliticasCliente)politicascliente.clone());
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
	
	public  PoliticasCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PoliticasCliente entity = new PoliticasCliente();		
		
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
	
	public  PoliticasCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PoliticasCliente entity = new PoliticasCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PoliticasClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PoliticasClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.PoliticasCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPoliticasClienteOriginal(new PoliticasCliente());
      	    	entity=super.getEntity("",entity,resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPoliticasCliente("",entity,resultSet); 
				
				//entity.setPoliticasClienteOriginal(super.getEntity("",entity.getPoliticasClienteOriginal(),resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPoliticasClienteOriginal(this.getEntityPoliticasCliente("",entity.getPoliticasClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePoliticasCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PoliticasCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PoliticasCliente entity = new PoliticasCliente();
				
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
	
	public  PoliticasCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PoliticasCliente entity = new PoliticasCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PoliticasClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PoliticasClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PoliticasClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.PoliticasCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPoliticasClienteOriginal(new PoliticasCliente());
      	    	entity=super.getEntity("",entity,resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPoliticasCliente("",entity,resultSet);    
				
				//entity.setPoliticasClienteOriginal(super.getEntity("",entity.getPoliticasClienteOriginal(),resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPoliticasClienteOriginal(this.getEntityPoliticasCliente("",entity.getPoliticasClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePoliticasCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PoliticasCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PoliticasCliente entity = new PoliticasCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PoliticasClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PoliticasClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PoliticasClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.PoliticasCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePoliticasCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PoliticasCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PoliticasCliente> entities = new  ArrayList<PoliticasCliente>();
		PoliticasCliente entity = new PoliticasCliente();		  
		
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
	
	public  List<PoliticasCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PoliticasCliente> entities = new  ArrayList<PoliticasCliente>();
		PoliticasCliente entity = new PoliticasCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PoliticasClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PoliticasClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PoliticasClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PoliticasCliente();
      	    	entity=super.getEntity("",entity,resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPoliticasCliente("",entity,resultSet);
      	    	
				//entity.setPoliticasClienteOriginal( new PoliticasCliente());
      	    	//entity.setPoliticasClienteOriginal(super.getEntity("",entity.getPoliticasClienteOriginal(),resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPoliticasClienteOriginal(this.getEntityPoliticasCliente("",entity.getPoliticasClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePoliticasClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPoliticasCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PoliticasCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PoliticasCliente> entities = new  ArrayList<PoliticasCliente>();
		PoliticasCliente entity = new PoliticasCliente();		  
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
	
	public  List<PoliticasCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PoliticasCliente> entities = new  ArrayList<PoliticasCliente>();
		PoliticasCliente entity = new PoliticasCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PoliticasCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapPoliticasCliente();
					//entity.setMapPoliticasCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPoliticasClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPoliticasCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA);         		
					entity=PoliticasClienteDataAccess.getEntityPoliticasCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPoliticasClienteOriginal( new PoliticasCliente());
					////entity.setPoliticasClienteOriginal(super.getEntity("",entity.getPoliticasClienteOriginal(),resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setPoliticasClienteOriginal(this.getEntityPoliticasCliente("",entity.getPoliticasClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePoliticasClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPoliticasCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PoliticasCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PoliticasCliente entity = new PoliticasCliente();		  
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
	
	public  PoliticasCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PoliticasCliente entity = new PoliticasCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PoliticasCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapPoliticasCliente();
					//entity.setMapPoliticasCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPoliticasClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPoliticasCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA);         		
					entity=PoliticasClienteDataAccess.getEntityPoliticasCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPoliticasClienteOriginal( new PoliticasCliente());
					////entity.setPoliticasClienteOriginal(super.getEntity("",entity.getPoliticasClienteOriginal(),resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setPoliticasClienteOriginal(this.getEntityPoliticasCliente("",entity.getPoliticasClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePoliticasCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPoliticasCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PoliticasCliente getEntityPoliticasCliente(String strPrefijo,PoliticasCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PoliticasCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PoliticasCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PoliticasClienteDataAccess.setFieldReflectionPoliticasCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPoliticasCliente=PoliticasClienteConstantesFunciones.getTodosTiposColumnasPoliticasCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPoliticasCliente) {
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
							field = PoliticasCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PoliticasCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PoliticasClienteDataAccess.setFieldReflectionPoliticasCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPoliticasCliente(Field field,String strPrefijo,String sColumn,PoliticasCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PoliticasClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.LIMITECREDITO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PoliticasClienteConstantesFunciones.FECHARENOVACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PoliticasClienteConstantesFunciones.FECHAFIN:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PoliticasClienteConstantesFunciones.DIASNETOPAGO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.DIASGRACIA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.CUPO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.DESCUENTOGENERAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.DESCUENTOPRONTOPAGO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.CONLISTAPRECIO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.CONIMPUESTOS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.ACTIVARMONTOFACTURACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.VALORSOBREGIRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.FECHAVENCISOBREGIRO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PoliticasClienteConstantesFunciones.IDTRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.VALORSOLICITADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.VALORAPROBADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.IDLINEANEGOCIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.FECHASOLICITUD:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PoliticasClienteConstantesFunciones.OBSEVACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.WEB:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.CASILLAPOSTAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.FORMAENVIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.IDTIPOCUENTABANCOGLOBAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.NUMEROCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PoliticasClienteConstantesFunciones.IDESTADOPOLITICASCLIENTE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PoliticasCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PoliticasCliente> entities = new  ArrayList<PoliticasCliente>();
		PoliticasCliente entity = new PoliticasCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PoliticasClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PoliticasClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PoliticasClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PoliticasCliente();
					entity=super.getEntity("",entity,resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPoliticasCliente("",entity,resultSet);
					
					//entity.setPoliticasClienteOriginal( new PoliticasCliente());
					//entity.setPoliticasClienteOriginal(super.getEntity("",entity.getPoliticasClienteOriginal(),resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setPoliticasClienteOriginal(this.getEntityPoliticasCliente("",entity.getPoliticasClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePoliticasClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPoliticasCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PoliticasCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PoliticasCliente> entities = new  ArrayList<PoliticasCliente>();
		PoliticasCliente entity = new PoliticasCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PoliticasClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PoliticasClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,PoliticasClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PoliticasCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PoliticasCliente> entities = new  ArrayList<PoliticasCliente>();
		PoliticasCliente entity = new PoliticasCliente();		  
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
	
	public  List<PoliticasCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PoliticasCliente> entities = new  ArrayList<PoliticasCliente>();
		PoliticasCliente entity = new PoliticasCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PoliticasCliente();
      	    	entity=super.getEntity("",entity,resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPoliticasCliente("",entity,resultSet);
      	    	
				//entity.setPoliticasClienteOriginal( new PoliticasCliente());
      	    	//entity.setPoliticasClienteOriginal(super.getEntity("",entity.getPoliticasClienteOriginal(),resultSet,PoliticasClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPoliticasClienteOriginal(this.getEntityPoliticasCliente("",entity.getPoliticasClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePoliticasClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPoliticasCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public PoliticasCliente getEntityPoliticasCliente(String strPrefijo,PoliticasCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PoliticasClienteConstantesFunciones.IDEMPRESA));
				entity.setlimite_credito(resultSet.getDouble(strPrefijo+PoliticasClienteConstantesFunciones.LIMITECREDITO));
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+PoliticasClienteConstantesFunciones.FECHAINICIO).getTime()));
				entity.setfecha_renovacion(new Date(resultSet.getDate(strPrefijo+PoliticasClienteConstantesFunciones.FECHARENOVACION).getTime()));
				entity.setfecha_fin(new Date(resultSet.getDate(strPrefijo+PoliticasClienteConstantesFunciones.FECHAFIN).getTime()));
				entity.setdias_neto_pago(resultSet.getInt(strPrefijo+PoliticasClienteConstantesFunciones.DIASNETOPAGO));
				entity.setdias_gracia(resultSet.getInt(strPrefijo+PoliticasClienteConstantesFunciones.DIASGRACIA));
				entity.setcupo(resultSet.getDouble(strPrefijo+PoliticasClienteConstantesFunciones.CUPO));
				entity.setdescuento_general(resultSet.getDouble(strPrefijo+PoliticasClienteConstantesFunciones.DESCUENTOGENERAL));
				entity.setdescuento_pronto_pago(resultSet.getDouble(strPrefijo+PoliticasClienteConstantesFunciones.DESCUENTOPRONTOPAGO));
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+PoliticasClienteConstantesFunciones.IDTIPOPRECIO));
				entity.setcon_lista_precio(resultSet.getBoolean(strPrefijo+PoliticasClienteConstantesFunciones.CONLISTAPRECIO));
				entity.setcon_impuestos(resultSet.getBoolean(strPrefijo+PoliticasClienteConstantesFunciones.CONIMPUESTOS));
				entity.setactivar_monto_facturacion(resultSet.getBoolean(strPrefijo+PoliticasClienteConstantesFunciones.ACTIVARMONTOFACTURACION));
				entity.setvalor_sobregiro(resultSet.getDouble(strPrefijo+PoliticasClienteConstantesFunciones.VALORSOBREGIRO));
				entity.setfecha_venci_sobregiro(new Date(resultSet.getDate(strPrefijo+PoliticasClienteConstantesFunciones.FECHAVENCISOBREGIRO).getTime()));
				entity.setid_transporte(resultSet.getLong(strPrefijo+PoliticasClienteConstantesFunciones.IDTRANSPORTE));
				entity.setvalor_solicitado(resultSet.getDouble(strPrefijo+PoliticasClienteConstantesFunciones.VALORSOLICITADO));
				entity.setvalor_aprobado(resultSet.getDouble(strPrefijo+PoliticasClienteConstantesFunciones.VALORAPROBADO));
				entity.setid_linea_negocio(resultSet.getLong(strPrefijo+PoliticasClienteConstantesFunciones.IDLINEANEGOCIO));
				entity.setfecha_solicitud(new Date(resultSet.getDate(strPrefijo+PoliticasClienteConstantesFunciones.FECHASOLICITUD).getTime()));
				entity.setobsevacion(resultSet.getString(strPrefijo+PoliticasClienteConstantesFunciones.OBSEVACION));
				entity.setweb(resultSet.getString(strPrefijo+PoliticasClienteConstantesFunciones.WEB));
				entity.setcasilla_postal(resultSet.getString(strPrefijo+PoliticasClienteConstantesFunciones.CASILLAPOSTAL));
				entity.setforma_envio(resultSet.getString(strPrefijo+PoliticasClienteConstantesFunciones.FORMAENVIO));
				entity.setid_banco(resultSet.getLong(strPrefijo+PoliticasClienteConstantesFunciones.IDBANCO));
				entity.setid_tipo_cuenta_banco_global(resultSet.getLong(strPrefijo+PoliticasClienteConstantesFunciones.IDTIPOCUENTABANCOGLOBAL));
				entity.setnumero_cuenta(resultSet.getString(strPrefijo+PoliticasClienteConstantesFunciones.NUMEROCUENTA));
				entity.setid_estado_politicas_cliente(resultSet.getLong(strPrefijo+PoliticasClienteConstantesFunciones.IDESTADOPOLITICASCLIENTE));
			} else {
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+PoliticasClienteConstantesFunciones.FECHAINICIO).getTime()));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPoliticasCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PoliticasCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PoliticasClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PoliticasClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PoliticasClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PoliticasClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PoliticasClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,PoliticasClienteDataAccess.TABLENAME,PoliticasClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			PoliticasClienteDataAccess.setPoliticasClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Cliente getCliente(Connexion connexion,PoliticasCliente relpoliticascliente)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relpoliticascliente.getId());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Empresa getEmpresa(Connexion connexion,PoliticasCliente relpoliticascliente)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpoliticascliente.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,PoliticasCliente relpoliticascliente)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relpoliticascliente.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public Transporte getTransporte(Connexion connexion,PoliticasCliente relpoliticascliente)throws SQLException,Exception {

		Transporte transporte= new Transporte();

		try {
			TransporteDataAccess transporteDataAccess=new TransporteDataAccess();

			transporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transporteDataAccess.setConnexionType(this.connexionType);
			transporteDataAccess.setParameterDbType(this.parameterDbType);

			transporte=transporteDataAccess.getEntity(connexion,relpoliticascliente.getid_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transporte;

	}

	public LineaNegocio getLineaNegocio(Connexion connexion,PoliticasCliente relpoliticascliente)throws SQLException,Exception {

		LineaNegocio lineanegocio= new LineaNegocio();

		try {
			LineaNegocioDataAccess lineanegocioDataAccess=new LineaNegocioDataAccess();

			lineanegocioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineanegocioDataAccess.setConnexionType(this.connexionType);
			lineanegocioDataAccess.setParameterDbType(this.parameterDbType);

			lineanegocio=lineanegocioDataAccess.getEntity(connexion,relpoliticascliente.getid_linea_negocio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return lineanegocio;

	}

	public Banco getBanco(Connexion connexion,PoliticasCliente relpoliticascliente)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,relpoliticascliente.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobal(Connexion connexion,PoliticasCliente relpoliticascliente)throws SQLException,Exception {

		TipoCuentaBancoGlobal tipocuentabancoglobal= new TipoCuentaBancoGlobal();

		try {
			TipoCuentaBancoGlobalDataAccess tipocuentabancoglobalDataAccess=new TipoCuentaBancoGlobalDataAccess();

			tipocuentabancoglobalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocuentabancoglobalDataAccess.setConnexionType(this.connexionType);
			tipocuentabancoglobalDataAccess.setParameterDbType(this.parameterDbType);

			tipocuentabancoglobal=tipocuentabancoglobalDataAccess.getEntity(connexion,relpoliticascliente.getid_tipo_cuenta_banco_global());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocuentabancoglobal;

	}

	public EstadoPoliticasCliente getEstadoPoliticasCliente(Connexion connexion,PoliticasCliente relpoliticascliente)throws SQLException,Exception {

		EstadoPoliticasCliente estadopoliticascliente= new EstadoPoliticasCliente();

		try {
			EstadoPoliticasClienteDataAccess estadopoliticasclienteDataAccess=new EstadoPoliticasClienteDataAccess();

			estadopoliticasclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopoliticasclienteDataAccess.setConnexionType(this.connexionType);
			estadopoliticasclienteDataAccess.setParameterDbType(this.parameterDbType);

			estadopoliticascliente=estadopoliticasclienteDataAccess.getEntity(connexion,relpoliticascliente.getid_estado_politicas_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopoliticascliente;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PoliticasCliente politicascliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!politicascliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(politicascliente.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(politicascliente.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuelimite_credito=new ParameterValue<Double>();
					parameterMaintenanceValuelimite_credito.setValue(politicascliente.getlimite_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelimite_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicio=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicio.setValue(politicascliente.getfecha_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_renovacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_renovacion.setValue(politicascliente.getfecha_renovacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_renovacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_fin=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_fin.setValue(politicascliente.getfecha_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedias_neto_pago=new ParameterValue<Integer>();
					parameterMaintenanceValuedias_neto_pago.setValue(politicascliente.getdias_neto_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias_neto_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedias_gracia=new ParameterValue<Integer>();
					parameterMaintenanceValuedias_gracia.setValue(politicascliente.getdias_gracia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias_gracia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecupo=new ParameterValue<Double>();
					parameterMaintenanceValuecupo.setValue(politicascliente.getcupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_general=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_general.setValue(politicascliente.getdescuento_general());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_general);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_pronto_pago=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_pronto_pago.setValue(politicascliente.getdescuento_pronto_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_pronto_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(politicascliente.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_lista_precio=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_lista_precio.setValue(politicascliente.getcon_lista_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_lista_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_impuestos=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_impuestos.setValue(politicascliente.getcon_impuestos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_impuestos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueactivar_monto_facturacion=new ParameterValue<Boolean>();
					parameterMaintenanceValueactivar_monto_facturacion.setValue(politicascliente.getactivar_monto_facturacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueactivar_monto_facturacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_sobregiro=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_sobregiro.setValue(politicascliente.getvalor_sobregiro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_sobregiro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_venci_sobregiro=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_venci_sobregiro.setValue(politicascliente.getfecha_venci_sobregiro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_venci_sobregiro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_transporte.setValue(politicascliente.getid_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_solicitado=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_solicitado.setValue(politicascliente.getvalor_solicitado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_solicitado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_aprobado=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_aprobado.setValue(politicascliente.getvalor_aprobado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_aprobado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_negocio=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_negocio.setValue(politicascliente.getid_linea_negocio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_negocio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_solicitud=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_solicitud.setValue(politicascliente.getfecha_solicitud());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_solicitud);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobsevacion=new ParameterValue<String>();
					parameterMaintenanceValueobsevacion.setValue(politicascliente.getobsevacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobsevacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueweb=new ParameterValue<String>();
					parameterMaintenanceValueweb.setValue(politicascliente.getweb());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueweb);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecasilla_postal=new ParameterValue<String>();
					parameterMaintenanceValuecasilla_postal.setValue(politicascliente.getcasilla_postal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecasilla_postal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueforma_envio=new ParameterValue<String>();
					parameterMaintenanceValueforma_envio.setValue(politicascliente.getforma_envio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueforma_envio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco.setValue(politicascliente.getid_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cuenta_banco_global=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cuenta_banco_global.setValue(politicascliente.getid_tipo_cuenta_banco_global());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cuenta_banco_global);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cuenta=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cuenta.setValue(politicascliente.getnumero_cuenta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cuenta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_politicas_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_politicas_cliente.setValue(politicascliente.getid_estado_politicas_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_politicas_cliente);
					parametersTemp.add(parameterMaintenance);
					
						if(!politicascliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(politicascliente.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(politicascliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(politicascliente.getId());
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
	
	public void setIsNewIsChangedFalsePoliticasCliente(PoliticasCliente politicascliente)throws Exception  {		
		politicascliente.setIsNew(false);
		politicascliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePoliticasClientes(List<PoliticasCliente> politicasclientes)throws Exception  {				
		for(PoliticasCliente politicascliente:politicasclientes) {
			politicascliente.setIsNew(false);
			politicascliente.setIsChanged(false);
		}
	}
	
	public void generarExportarPoliticasCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
