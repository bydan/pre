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
import com.bydan.erp.cartera.util.*;//ClienteRetencionConstantesFunciones;


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
final public class ClienteRetencionDataAccess extends  ClienteRetencionDataAccessAdditional{ //ClienteRetencionDataAccessAdditional,DataAccessHelper<ClienteRetencion>
	//static Logger logger = Logger.getLogger(ClienteRetencionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cliente_retencion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,fecha,id_cliente,id_factura,id_transaccion,id_tipo_retencion,porcentaje,base_imponible,valor,numero_retencion,descripcion,id_asiento_contable,id_cuenta_contable_retencion,valor_tipo_cambio,debito_mone_local,credito_mone_local,debito_mone_extra,credito_mone_extra,beneficiario,nombre_benef,direccion_benef,telefono_benef,ruc_benef,id_estado_retencion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,fecha=?,id_cliente=?,id_factura=?,id_transaccion=?,id_tipo_retencion=?,porcentaje=?,base_imponible=?,valor=?,numero_retencion=?,descripcion=?,id_asiento_contable=?,id_cuenta_contable_retencion=?,valor_tipo_cambio=?,debito_mone_local=?,credito_mone_local=?,debito_mone_extra=?,credito_mone_extra=?,beneficiario=?,nombre_benef=?,direccion_benef=?,telefono_benef=?,ruc_benef=?,id_estado_retencion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select clienteretencion from "+ClienteRetencionConstantesFunciones.SPERSISTENCENAME+" clienteretencion";
	public static String QUERYSELECTNATIVE="select "+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".version_row,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_empresa,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_sucursal,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_ejercicio,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_periodo,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_anio,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_mes,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".fecha,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_cliente,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_factura,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_transaccion,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_tipo_retencion,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".porcentaje,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".base_imponible,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".valor,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".numero_retencion,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".descripcion,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_asiento_contable,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_cuenta_contable_retencion,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".valor_tipo_cambio,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".debito_mone_local,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".credito_mone_local,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".debito_mone_extra,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".credito_mone_extra,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".beneficiario,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".nombre_benef,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".direccion_benef,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".telefono_benef,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".ruc_benef,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id_estado_retencion from "+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME;//+" as "+ClienteRetencionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".id,"+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+".version_row from "+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME;//+" as "+ClienteRetencionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ClienteRetencionConstantesFunciones.SCHEMA+"."+ClienteRetencionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,fecha=?,id_cliente=?,id_factura=?,id_transaccion=?,id_tipo_retencion=?,porcentaje=?,base_imponible=?,valor=?,numero_retencion=?,descripcion=?,id_asiento_contable=?,id_cuenta_contable_retencion=?,valor_tipo_cambio=?,debito_mone_local=?,credito_mone_local=?,debito_mone_extra=?,credito_mone_extra=?,beneficiario=?,nombre_benef=?,direccion_benef=?,telefono_benef=?,ruc_benef=?,id_estado_retencion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CLIENTERETENCION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CLIENTERETENCION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CLIENTERETENCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CLIENTERETENCION_SELECT(?,?)";
	
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
	
	
	protected ClienteRetencionDataAccessAdditional clienteretencionDataAccessAdditional=null;
	
	public ClienteRetencionDataAccessAdditional getClienteRetencionDataAccessAdditional() {
		return this.clienteretencionDataAccessAdditional;
	}
	
	public void setClienteRetencionDataAccessAdditional(ClienteRetencionDataAccessAdditional clienteretencionDataAccessAdditional) {
		try {
			this.clienteretencionDataAccessAdditional=clienteretencionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ClienteRetencionDataAccess() {
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
		ClienteRetencionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ClienteRetencionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ClienteRetencionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setClienteRetencionOriginal(ClienteRetencion clienteretencion)throws Exception  {
		clienteretencion.setClienteRetencionOriginal((ClienteRetencion)clienteretencion.clone());		
	}
	
	public void setClienteRetencionsOriginal(List<ClienteRetencion> clienteretencions)throws Exception  {
		
		for(ClienteRetencion clienteretencion:clienteretencions){
			clienteretencion.setClienteRetencionOriginal((ClienteRetencion)clienteretencion.clone());
		}
	}
	
	public static void setClienteRetencionOriginalStatic(ClienteRetencion clienteretencion)throws Exception  {
		clienteretencion.setClienteRetencionOriginal((ClienteRetencion)clienteretencion.clone());		
	}
	
	public static void setClienteRetencionsOriginalStatic(List<ClienteRetencion> clienteretencions)throws Exception  {
		
		for(ClienteRetencion clienteretencion:clienteretencions){
			clienteretencion.setClienteRetencionOriginal((ClienteRetencion)clienteretencion.clone());
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
	
	public  ClienteRetencion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ClienteRetencion entity = new ClienteRetencion();		
		
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
	
	public  ClienteRetencion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ClienteRetencion entity = new ClienteRetencion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteRetencionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.ClienteRetencion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setClienteRetencionOriginal(new ClienteRetencion());
      	    	entity=super.getEntity("",entity,resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityClienteRetencion("",entity,resultSet); 
				
				//entity.setClienteRetencionOriginal(super.getEntity("",entity.getClienteRetencionOriginal(),resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteRetencionOriginal(this.getEntityClienteRetencion("",entity.getClienteRetencionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseClienteRetencion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ClienteRetencion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ClienteRetencion entity = new ClienteRetencion();
				
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
	
	public  ClienteRetencion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ClienteRetencion entity = new ClienteRetencion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteRetencionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ClienteRetencion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setClienteRetencionOriginal(new ClienteRetencion());
      	    	entity=super.getEntity("",entity,resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityClienteRetencion("",entity,resultSet);    
				
				//entity.setClienteRetencionOriginal(super.getEntity("",entity.getClienteRetencionOriginal(),resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteRetencionOriginal(this.getEntityClienteRetencion("",entity.getClienteRetencionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseClienteRetencion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ClienteRetencion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ClienteRetencion entity = new ClienteRetencion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteRetencionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ClienteRetencion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseClienteRetencion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ClienteRetencion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ClienteRetencion> entities = new  ArrayList<ClienteRetencion>();
		ClienteRetencion entity = new ClienteRetencion();		  
		
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
	
	public  List<ClienteRetencion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ClienteRetencion> entities = new  ArrayList<ClienteRetencion>();
		ClienteRetencion entity = new ClienteRetencion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteRetencionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteRetencion();
      	    	entity=super.getEntity("",entity,resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityClienteRetencion("",entity,resultSet);
      	    	
				//entity.setClienteRetencionOriginal( new ClienteRetencion());
      	    	//entity.setClienteRetencionOriginal(super.getEntity("",entity.getClienteRetencionOriginal(),resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteRetencionOriginal(this.getEntityClienteRetencion("",entity.getClienteRetencionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClienteRetencions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteRetencion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ClienteRetencion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ClienteRetencion> entities = new  ArrayList<ClienteRetencion>();
		ClienteRetencion entity = new ClienteRetencion();		  
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
	
	public  List<ClienteRetencion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ClienteRetencion> entities = new  ArrayList<ClienteRetencion>();
		ClienteRetencion entity = new ClienteRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteRetencion();
				
				if(conMapGenerico) {
					entity.inicializarMapClienteRetencion();
					//entity.setMapClienteRetencion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapClienteRetencionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapClienteRetencion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA);         		
					entity=ClienteRetencionDataAccess.getEntityClienteRetencion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setClienteRetencionOriginal( new ClienteRetencion());
					////entity.setClienteRetencionOriginal(super.getEntity("",entity.getClienteRetencionOriginal(),resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA));         		
					////entity.setClienteRetencionOriginal(this.getEntityClienteRetencion("",entity.getClienteRetencionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClienteRetencions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteRetencion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ClienteRetencion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ClienteRetencion entity = new ClienteRetencion();		  
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
	
	public  ClienteRetencion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ClienteRetencion entity = new ClienteRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteRetencion();
				
				if(conMapGenerico) {
					entity.inicializarMapClienteRetencion();
					//entity.setMapClienteRetencion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapClienteRetencionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapClienteRetencion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA);         		
					entity=ClienteRetencionDataAccess.getEntityClienteRetencion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setClienteRetencionOriginal( new ClienteRetencion());
					////entity.setClienteRetencionOriginal(super.getEntity("",entity.getClienteRetencionOriginal(),resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA));         		
					////entity.setClienteRetencionOriginal(this.getEntityClienteRetencion("",entity.getClienteRetencionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseClienteRetencion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteRetencion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ClienteRetencion getEntityClienteRetencion(String strPrefijo,ClienteRetencion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ClienteRetencion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ClienteRetencion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ClienteRetencionDataAccess.setFieldReflectionClienteRetencion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasClienteRetencion=ClienteRetencionConstantesFunciones.getTodosTiposColumnasClienteRetencion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasClienteRetencion) {
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
							field = ClienteRetencion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ClienteRetencion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ClienteRetencionDataAccess.setFieldReflectionClienteRetencion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionClienteRetencion(Field field,String strPrefijo,String sColumn,ClienteRetencion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ClienteRetencionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ClienteRetencionConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.IDTIPORETENCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.BASEIMPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.NUMERORETENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.IDCUENTACONTABLECLIENTERETENCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.VALORTIPOCAMBIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.DEBITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.CREDITOMONELOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.DEBITOMONEEXTRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.CREDITOMONEEXTRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.BENEFICIARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.NOMBREBENEF:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.DIRECCIONBENEF:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.TELEFONOBENEF:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.RUCBENEF:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteRetencionConstantesFunciones.IDESTADORETENCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ClienteRetencion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ClienteRetencion> entities = new  ArrayList<ClienteRetencion>();
		ClienteRetencion entity = new ClienteRetencion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteRetencionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ClienteRetencion();
					entity=super.getEntity("",entity,resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityClienteRetencion("",entity,resultSet);
					
					//entity.setClienteRetencionOriginal( new ClienteRetencion());
					//entity.setClienteRetencionOriginal(super.getEntity("",entity.getClienteRetencionOriginal(),resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA));         		
					//entity.setClienteRetencionOriginal(this.getEntityClienteRetencion("",entity.getClienteRetencionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseClienteRetencions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteRetencion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ClienteRetencion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ClienteRetencion> entities = new  ArrayList<ClienteRetencion>();
		ClienteRetencion entity = new ClienteRetencion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteRetencionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ClienteRetencion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteRetencion> entities = new  ArrayList<ClienteRetencion>();
		ClienteRetencion entity = new ClienteRetencion();		  
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
	
	public  List<ClienteRetencion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteRetencion> entities = new  ArrayList<ClienteRetencion>();
		ClienteRetencion entity = new ClienteRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteRetencion();
      	    	entity=super.getEntity("",entity,resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityClienteRetencion("",entity,resultSet);
      	    	
				//entity.setClienteRetencionOriginal( new ClienteRetencion());
      	    	//entity.setClienteRetencionOriginal(super.getEntity("",entity.getClienteRetencionOriginal(),resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteRetencionOriginal(this.getEntityClienteRetencion("",entity.getClienteRetencionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseClienteRetencions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteRetencion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ClienteRetencion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteRetencion> entities = new  ArrayList<ClienteRetencion>();
		ClienteRetencion entity = new ClienteRetencion();		  
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
	
	public  List<ClienteRetencion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteRetencion> entities = new  ArrayList<ClienteRetencion>();
		ClienteRetencion entity = new ClienteRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteRetencion();
      	    	entity=super.getEntity("",entity,resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityClienteRetencion("",entity,resultSet);
      	    	
				//entity.setClienteRetencionOriginal( new ClienteRetencion());
      	    	//entity.setClienteRetencionOriginal(super.getEntity("",entity.getClienteRetencionOriginal(),resultSet,ClienteRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteRetencionOriginal(this.getEntityClienteRetencion("",entity.getClienteRetencionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClienteRetencions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ClienteRetencion getEntityClienteRetencion(String strPrefijo,ClienteRetencion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+ClienteRetencionConstantesFunciones.FECHA).getTime()));
				entity.setid_cliente(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDCLIENTE));
				entity.setid_factura(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDFACTURA));if(resultSet.wasNull()) {entity.setid_factura(null); }
				entity.setid_transaccion(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDTRANSACCION));
				entity.setid_tipo_retencion(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDTIPORETENCION));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+ClienteRetencionConstantesFunciones.PORCENTAJE));
				entity.setbase_imponible(resultSet.getDouble(strPrefijo+ClienteRetencionConstantesFunciones.BASEIMPONIBLE));
				entity.setvalor(resultSet.getDouble(strPrefijo+ClienteRetencionConstantesFunciones.VALOR));
				entity.setnumero_retencion(resultSet.getString(strPrefijo+ClienteRetencionConstantesFunciones.NUMERORETENCION));
				entity.setdescripcion(resultSet.getString(strPrefijo+ClienteRetencionConstantesFunciones.DESCRIPCION));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDASIENTOCONTABLE));
				entity.setid_cuenta_contable_retencion(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDCUENTACONTABLECLIENTERETENCION));
				entity.setvalor_tipo_cambio(resultSet.getDouble(strPrefijo+ClienteRetencionConstantesFunciones.VALORTIPOCAMBIO));
				entity.setdebito_mone_local(resultSet.getDouble(strPrefijo+ClienteRetencionConstantesFunciones.DEBITOMONELOCAL));
				entity.setcredito_mone_local(resultSet.getDouble(strPrefijo+ClienteRetencionConstantesFunciones.CREDITOMONELOCAL));
				entity.setdebito_mone_extra(resultSet.getDouble(strPrefijo+ClienteRetencionConstantesFunciones.DEBITOMONEEXTRA));
				entity.setcredito_mone_extra(resultSet.getDouble(strPrefijo+ClienteRetencionConstantesFunciones.CREDITOMONEEXTRA));
				entity.setbeneficiario(resultSet.getString(strPrefijo+ClienteRetencionConstantesFunciones.BENEFICIARIO));
				entity.setnombre_benef(resultSet.getString(strPrefijo+ClienteRetencionConstantesFunciones.NOMBREBENEF));
				entity.setdireccion_benef(resultSet.getString(strPrefijo+ClienteRetencionConstantesFunciones.DIRECCIONBENEF));
				entity.settelefono_benef(resultSet.getString(strPrefijo+ClienteRetencionConstantesFunciones.TELEFONOBENEF));
				entity.setruc_benef(resultSet.getString(strPrefijo+ClienteRetencionConstantesFunciones.RUCBENEF));
				entity.setid_estado_retencion(resultSet.getLong(strPrefijo+ClienteRetencionConstantesFunciones.IDESTADORETENCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowClienteRetencion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ClienteRetencion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ClienteRetencionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ClienteRetencionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ClienteRetencionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ClienteRetencionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ClienteRetencionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ClienteRetencionDataAccess.TABLENAME,ClienteRetencionDataAccess.ISWITHSTOREPROCEDURES);
			
			ClienteRetencionDataAccess.setClienteRetencionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relclienteretencion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relclienteretencion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relclienteretencion.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relclienteretencion.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relclienteretencion.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relclienteretencion.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Cliente getCliente(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relclienteretencion.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Factura getFactura(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relclienteretencion.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public Transaccion getTransaccion(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relclienteretencion.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public TipoRetencion getTipoRetencion(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relclienteretencion.getid_tipo_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public AsientoContable getAsientoContable(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relclienteretencion.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public CuentaContable getCuentaContableClienteRetencion(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relclienteretencion.getid_cuenta_contable_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public EstadoRetencion getEstadoRetencion(Connexion connexion,ClienteRetencion relclienteretencion)throws SQLException,Exception {

		EstadoRetencion estadoretencion= new EstadoRetencion();

		try {
			EstadoRetencionDataAccess estadoretencionDataAccess=new EstadoRetencionDataAccess();

			estadoretencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoretencionDataAccess.setConnexionType(this.connexionType);
			estadoretencionDataAccess.setParameterDbType(this.parameterDbType);

			estadoretencion=estadoretencionDataAccess.getEntity(connexion,relclienteretencion.getid_estado_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoretencion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ClienteRetencion clienteretencion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!clienteretencion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(clienteretencion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(clienteretencion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(clienteretencion.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(clienteretencion.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(clienteretencion.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(clienteretencion.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(clienteretencion.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(clienteretencion.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(clienteretencion.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(clienteretencion.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion.setValue(clienteretencion.getid_tipo_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(clienteretencion.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebase_imponible=new ParameterValue<Double>();
					parameterMaintenanceValuebase_imponible.setValue(clienteretencion.getbase_imponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebase_imponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(clienteretencion.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_retencion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_retencion.setValue(clienteretencion.getnumero_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(clienteretencion.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(clienteretencion.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_retencion.setValue(clienteretencion.getid_cuenta_contable_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_tipo_cambio=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_tipo_cambio.setValue(clienteretencion.getvalor_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedebito_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuedebito_mone_local.setValue(clienteretencion.getdebito_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedebito_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_mone_local=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_mone_local.setValue(clienteretencion.getcredito_mone_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_mone_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedebito_mone_extra=new ParameterValue<Double>();
					parameterMaintenanceValuedebito_mone_extra.setValue(clienteretencion.getdebito_mone_extra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedebito_mone_extra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_mone_extra=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_mone_extra.setValue(clienteretencion.getcredito_mone_extra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_mone_extra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuebeneficiario=new ParameterValue<String>();
					parameterMaintenanceValuebeneficiario.setValue(clienteretencion.getbeneficiario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebeneficiario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_benef=new ParameterValue<String>();
					parameterMaintenanceValuenombre_benef.setValue(clienteretencion.getnombre_benef());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_benef);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion_benef=new ParameterValue<String>();
					parameterMaintenanceValuedireccion_benef.setValue(clienteretencion.getdireccion_benef());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion_benef);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono_benef=new ParameterValue<String>();
					parameterMaintenanceValuetelefono_benef.setValue(clienteretencion.gettelefono_benef());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono_benef);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc_benef=new ParameterValue<String>();
					parameterMaintenanceValueruc_benef.setValue(clienteretencion.getruc_benef());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc_benef);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_retencion.setValue(clienteretencion.getid_estado_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_retencion);
					parametersTemp.add(parameterMaintenance);
					
						if(!clienteretencion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(clienteretencion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(clienteretencion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(clienteretencion.getId());
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
	
	public void setIsNewIsChangedFalseClienteRetencion(ClienteRetencion clienteretencion)throws Exception  {		
		clienteretencion.setIsNew(false);
		clienteretencion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseClienteRetencions(List<ClienteRetencion> clienteretencions)throws Exception  {				
		for(ClienteRetencion clienteretencion:clienteretencions) {
			clienteretencion.setIsNew(false);
			clienteretencion.setIsChanged(false);
		}
	}
	
	public void generarExportarClienteRetencion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
