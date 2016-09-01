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
import com.bydan.erp.facturacion.util.*;//TransportistaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class TransportistaDataAccess extends  TransportistaDataAccessAdditional{ //TransportistaDataAccessAdditional,DataAccessHelper<Transportista>
	//static Logger logger = Logger.getLogger(TransportistaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="transportista";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_tipo_via_transporte,identificacion,ruc,nombre,apellido,nombre_completo,telefono,direccion,id_cliente,placa,numero,observacion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_via_transporte=?,identificacion=?,ruc=?,nombre=?,apellido=?,nombre_completo=?,telefono=?,direccion=?,id_cliente=?,placa=?,numero=?,observacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select transportista from "+TransportistaConstantesFunciones.SPERSISTENCENAME+" transportista";
	public static String QUERYSELECTNATIVE="select "+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".id,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".version_row,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".id_empresa,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".id_sucursal,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".id_tipo_via_transporte,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".identificacion,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".ruc,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".nombre,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".apellido,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".nombre_completo,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".telefono,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".direccion,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".id_cliente,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".placa,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".numero,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".observacion from "+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME;//+" as "+TransportistaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".id,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".version_row,"+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+".nombre from "+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME;//+" as "+TransportistaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TransportistaConstantesFunciones.SCHEMA+"."+TransportistaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_via_transporte=?,identificacion=?,ruc=?,nombre=?,apellido=?,nombre_completo=?,telefono=?,direccion=?,id_cliente=?,placa=?,numero=?,observacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TRANSPORTISTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TRANSPORTISTA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TRANSPORTISTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TRANSPORTISTA_SELECT(?,?)";
	
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
	
	
	protected TransportistaDataAccessAdditional transportistaDataAccessAdditional=null;
	
	public TransportistaDataAccessAdditional getTransportistaDataAccessAdditional() {
		return this.transportistaDataAccessAdditional;
	}
	
	public void setTransportistaDataAccessAdditional(TransportistaDataAccessAdditional transportistaDataAccessAdditional) {
		try {
			this.transportistaDataAccessAdditional=transportistaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TransportistaDataAccess() {
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
		TransportistaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TransportistaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TransportistaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTransportistaOriginal(Transportista transportista)throws Exception  {
		transportista.setTransportistaOriginal((Transportista)transportista.clone());		
	}
	
	public void setTransportistasOriginal(List<Transportista> transportistas)throws Exception  {
		
		for(Transportista transportista:transportistas){
			transportista.setTransportistaOriginal((Transportista)transportista.clone());
		}
	}
	
	public static void setTransportistaOriginalStatic(Transportista transportista)throws Exception  {
		transportista.setTransportistaOriginal((Transportista)transportista.clone());		
	}
	
	public static void setTransportistasOriginalStatic(List<Transportista> transportistas)throws Exception  {
		
		for(Transportista transportista:transportistas){
			transportista.setTransportistaOriginal((Transportista)transportista.clone());
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
	
	public  Transportista getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Transportista entity = new Transportista();		
		
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
	
	public  Transportista getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Transportista entity = new Transportista();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransportistaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransportistaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.Transportista.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTransportistaOriginal(new Transportista());
      	    	entity=super.getEntity("",entity,resultSet,TransportistaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransportista("",entity,resultSet); 
				
				//entity.setTransportistaOriginal(super.getEntity("",entity.getTransportistaOriginal(),resultSet,TransportistaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransportistaOriginal(this.getEntityTransportista("",entity.getTransportistaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTransportista(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Transportista getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Transportista entity = new Transportista();
				
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
	
	public  Transportista getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Transportista entity = new Transportista();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransportistaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransportistaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransportistaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.Transportista.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTransportistaOriginal(new Transportista());
      	    	entity=super.getEntity("",entity,resultSet,TransportistaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransportista("",entity,resultSet);    
				
				//entity.setTransportistaOriginal(super.getEntity("",entity.getTransportistaOriginal(),resultSet,TransportistaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransportistaOriginal(this.getEntityTransportista("",entity.getTransportistaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTransportista(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Transportista
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Transportista entity = new Transportista();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransportistaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransportistaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransportistaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.Transportista.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTransportista(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Transportista> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Transportista> entities = new  ArrayList<Transportista>();
		Transportista entity = new Transportista();		  
		
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
	
	public  List<Transportista> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Transportista> entities = new  ArrayList<Transportista>();
		Transportista entity = new Transportista();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TransportistaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransportistaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransportistaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transportista();
      	    	entity=super.getEntity("",entity,resultSet,TransportistaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransportista("",entity,resultSet);
      	    	
				//entity.setTransportistaOriginal( new Transportista());
      	    	//entity.setTransportistaOriginal(super.getEntity("",entity.getTransportistaOriginal(),resultSet,TransportistaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransportistaOriginal(this.getEntityTransportista("",entity.getTransportistaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransportistas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransportista(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Transportista> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Transportista> entities = new  ArrayList<Transportista>();
		Transportista entity = new Transportista();		  
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
	
	public  List<Transportista> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Transportista> entities = new  ArrayList<Transportista>();
		Transportista entity = new Transportista();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transportista();
				
				if(conMapGenerico) {
					entity.inicializarMapTransportista();
					//entity.setMapTransportista(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTransportistaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransportista().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransportistaDataAccess.ISWITHSCHEMA);         		
					entity=TransportistaDataAccess.getEntityTransportista("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransportistaOriginal( new Transportista());
					////entity.setTransportistaOriginal(super.getEntity("",entity.getTransportistaOriginal(),resultSet,TransportistaDataAccess.ISWITHSCHEMA));         		
					////entity.setTransportistaOriginal(this.getEntityTransportista("",entity.getTransportistaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransportistas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransportista(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Transportista getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Transportista entity = new Transportista();		  
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
	
	public  Transportista getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Transportista entity = new Transportista();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transportista();
				
				if(conMapGenerico) {
					entity.inicializarMapTransportista();
					//entity.setMapTransportista(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTransportistaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransportista().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransportistaDataAccess.ISWITHSCHEMA);         		
					entity=TransportistaDataAccess.getEntityTransportista("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransportistaOriginal( new Transportista());
					////entity.setTransportistaOriginal(super.getEntity("",entity.getTransportistaOriginal(),resultSet,TransportistaDataAccess.ISWITHSCHEMA));         		
					////entity.setTransportistaOriginal(this.getEntityTransportista("",entity.getTransportistaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTransportista(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransportista(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Transportista getEntityTransportista(String strPrefijo,Transportista entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Transportista.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Transportista.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TransportistaDataAccess.setFieldReflectionTransportista(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTransportista=TransportistaConstantesFunciones.getTodosTiposColumnasTransportista();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTransportista) {
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
							field = Transportista.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Transportista.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TransportistaDataAccess.setFieldReflectionTransportista(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTransportista(Field field,String strPrefijo,String sColumn,Transportista entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TransportistaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransportistaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransportistaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransportistaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransportistaConstantesFunciones.IDTIPOVIATRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransportistaConstantesFunciones.IDENTIFICACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransportistaConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransportistaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransportistaConstantesFunciones.APELLIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransportistaConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransportistaConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransportistaConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransportistaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransportistaConstantesFunciones.PLACA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransportistaConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransportistaConstantesFunciones.OBSERVACION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Transportista>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Transportista> entities = new  ArrayList<Transportista>();
		Transportista entity = new Transportista();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransportistaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransportistaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransportistaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Transportista();
					entity=super.getEntity("",entity,resultSet,TransportistaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTransportista("",entity,resultSet);
					
					//entity.setTransportistaOriginal( new Transportista());
					//entity.setTransportistaOriginal(super.getEntity("",entity.getTransportistaOriginal(),resultSet,TransportistaDataAccess.ISWITHSCHEMA));         		
					//entity.setTransportistaOriginal(this.getEntityTransportista("",entity.getTransportistaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTransportistas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransportista(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Transportista>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Transportista> entities = new  ArrayList<Transportista>();
		Transportista entity = new Transportista();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransportistaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransportistaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TransportistaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Transportista> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transportista> entities = new  ArrayList<Transportista>();
		Transportista entity = new Transportista();		  
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
	
	public  List<Transportista> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transportista> entities = new  ArrayList<Transportista>();
		Transportista entity = new Transportista();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transportista();
      	    	entity=super.getEntity("",entity,resultSet,TransportistaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransportista("",entity,resultSet);
      	    	
				//entity.setTransportistaOriginal( new Transportista());
      	    	//entity.setTransportistaOriginal(super.getEntity("",entity.getTransportistaOriginal(),resultSet,TransportistaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransportistaOriginal(this.getEntityTransportista("",entity.getTransportistaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTransportistas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransportista(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Transportista> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transportista> entities = new  ArrayList<Transportista>();
		Transportista entity = new Transportista();		  
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
	
	public  List<Transportista> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Transportista> entities = new  ArrayList<Transportista>();
		Transportista entity = new Transportista();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Transportista();
      	    	entity=super.getEntity("",entity,resultSet,TransportistaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransportista("",entity,resultSet);
      	    	
				//entity.setTransportistaOriginal( new Transportista());
      	    	//entity.setTransportistaOriginal(super.getEntity("",entity.getTransportistaOriginal(),resultSet,TransportistaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransportistaOriginal(this.getEntityTransportista("",entity.getTransportistaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransportistas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Transportista getEntityTransportista(String strPrefijo,Transportista entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TransportistaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+TransportistaConstantesFunciones.IDSUCURSAL));
				entity.setid_tipo_via_transporte(resultSet.getLong(strPrefijo+TransportistaConstantesFunciones.IDTIPOVIATRANSPORTE));
				entity.setidentificacion(resultSet.getString(strPrefijo+TransportistaConstantesFunciones.IDENTIFICACION));
				entity.setruc(resultSet.getString(strPrefijo+TransportistaConstantesFunciones.RUC));
				entity.setnombre(resultSet.getString(strPrefijo+TransportistaConstantesFunciones.NOMBRE));
				entity.setapellido(resultSet.getString(strPrefijo+TransportistaConstantesFunciones.APELLIDO));
				entity.setnombre_completo(resultSet.getString(strPrefijo+TransportistaConstantesFunciones.NOMBRECOMPLETO));
				entity.settelefono(resultSet.getString(strPrefijo+TransportistaConstantesFunciones.TELEFONO));
				entity.setdireccion(resultSet.getString(strPrefijo+TransportistaConstantesFunciones.DIRECCION));
				entity.setid_cliente(resultSet.getLong(strPrefijo+TransportistaConstantesFunciones.IDCLIENTE));
				entity.setplaca(resultSet.getString(strPrefijo+TransportistaConstantesFunciones.PLACA));
				entity.setnumero(resultSet.getString(strPrefijo+TransportistaConstantesFunciones.NUMERO));
				entity.setobservacion(resultSet.getString(strPrefijo+TransportistaConstantesFunciones.OBSERVACION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TransportistaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTransportista(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Transportista entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TransportistaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TransportistaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TransportistaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TransportistaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TransportistaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TransportistaDataAccess.TABLENAME,TransportistaDataAccess.ISWITHSTOREPROCEDURES);
			
			TransportistaDataAccess.setTransportistaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Transportista reltransportista)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltransportista.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Transportista reltransportista)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reltransportista.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoViaTransporte getTipoViaTransporte(Connexion connexion,Transportista reltransportista)throws SQLException,Exception {

		TipoViaTransporte tipoviatransporte= new TipoViaTransporte();

		try {
			TipoViaTransporteDataAccess tipoviatransporteDataAccess=new TipoViaTransporteDataAccess();

			tipoviatransporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoviatransporteDataAccess.setConnexionType(this.connexionType);
			tipoviatransporteDataAccess.setParameterDbType(this.parameterDbType);

			tipoviatransporte=tipoviatransporteDataAccess.getEntity(connexion,reltransportista.getid_tipo_via_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoviatransporte;

	}

	public Cliente getCliente(Connexion connexion,Transportista reltransportista)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,reltransportista.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


		
		public List<NotaCreditoSoli> getNotaCreditoSolis(Connexion connexion,Transportista transportista)throws SQLException,Exception {

		List<NotaCreditoSoli> notacreditosolis= new ArrayList<NotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransportistaConstantesFunciones.SCHEMA+".transportista ON "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id_transportista="+TransportistaConstantesFunciones.SCHEMA+".transportista.id WHERE "+TransportistaConstantesFunciones.SCHEMA+".transportista.id="+String.valueOf(transportista.getId());
			} else {
				sQuery=" INNER JOIN notacreditosoli.Transportista WHERE notacreditosoli.Transportista.id="+String.valueOf(transportista.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoSoliDataAccess notacreditosoliDataAccess=new NotaCreditoSoliDataAccess();

			notacreditosoliDataAccess.setConnexionType(this.connexionType);
			notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditosolis;

	}

	public List<GuiaRemision> getGuiaRemisions(Connexion connexion,Transportista transportista)throws SQLException,Exception {

		List<GuiaRemision> guiaremisions= new ArrayList<GuiaRemision>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransportistaConstantesFunciones.SCHEMA+".transportista ON "+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision.id_transportista="+TransportistaConstantesFunciones.SCHEMA+".transportista.id WHERE "+TransportistaConstantesFunciones.SCHEMA+".transportista.id="+String.valueOf(transportista.getId());
			} else {
				sQuery=" INNER JOIN guiaremision.Transportista WHERE guiaremision.Transportista.id="+String.valueOf(transportista.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GuiaRemisionDataAccess guiaremisionDataAccess=new GuiaRemisionDataAccess();

			guiaremisionDataAccess.setConnexionType(this.connexionType);
			guiaremisionDataAccess.setParameterDbType(this.parameterDbType);
			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return guiaremisions;

	}

	public List<PedidoExpor> getPedidoExpors(Connexion connexion,Transportista transportista)throws SQLException,Exception {

		List<PedidoExpor> pedidoexpors= new ArrayList<PedidoExpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransportistaConstantesFunciones.SCHEMA+".transportista ON "+PedidoExporConstantesFunciones.SCHEMA+".pedido_expor.id_transportista="+TransportistaConstantesFunciones.SCHEMA+".transportista.id WHERE "+TransportistaConstantesFunciones.SCHEMA+".transportista.id="+String.valueOf(transportista.getId());
			} else {
				sQuery=" INNER JOIN pedidoexpor.Transportista WHERE pedidoexpor.Transportista.id="+String.valueOf(transportista.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoExporDataAccess pedidoexporDataAccess=new PedidoExporDataAccess();

			pedidoexporDataAccess.setConnexionType(this.connexionType);
			pedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoexpors;

	}

	public List<MovimientoInventario> getMovimientoInventarios(Connexion connexion,Transportista transportista)throws SQLException,Exception {

		List<MovimientoInventario> movimientoinventarios= new ArrayList<MovimientoInventario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransportistaConstantesFunciones.SCHEMA+".transportista ON "+MovimientoInventarioConstantesFunciones.SCHEMA+".movimiento_inventario.id_transportista="+TransportistaConstantesFunciones.SCHEMA+".transportista.id WHERE "+TransportistaConstantesFunciones.SCHEMA+".transportista.id="+String.valueOf(transportista.getId());
			} else {
				sQuery=" INNER JOIN movimientoinventario.Transportista WHERE movimientoinventario.Transportista.id="+String.valueOf(transportista.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MovimientoInventarioDataAccess movimientoinventarioDataAccess=new MovimientoInventarioDataAccess();

			movimientoinventarioDataAccess.setConnexionType(this.connexionType);
			movimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			movimientoinventarios=movimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return movimientoinventarios;

	}

	public List<OrdenCompra> getOrdenCompras(Connexion connexion,Transportista transportista)throws SQLException,Exception {

		List<OrdenCompra> ordencompras= new ArrayList<OrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransportistaConstantesFunciones.SCHEMA+".transportista ON "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id_transportista="+TransportistaConstantesFunciones.SCHEMA+".transportista.id WHERE "+TransportistaConstantesFunciones.SCHEMA+".transportista.id="+String.valueOf(transportista.getId());
			} else {
				sQuery=" INNER JOIN ordencompra.Transportista WHERE ordencompra.Transportista.id="+String.valueOf(transportista.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OrdenCompraDataAccess ordencompraDataAccess=new OrdenCompraDataAccess();

			ordencompraDataAccess.setConnexionType(this.connexionType);
			ordencompraDataAccess.setParameterDbType(this.parameterDbType);
			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordencompras;

	}

	public List<Factura> getFacturas(Connexion connexion,Transportista transportista)throws SQLException,Exception {

		List<Factura> facturas= new ArrayList<Factura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransportistaConstantesFunciones.SCHEMA+".transportista ON "+FacturaConstantesFunciones.SCHEMA+".factura.id_transportista="+TransportistaConstantesFunciones.SCHEMA+".transportista.id WHERE "+TransportistaConstantesFunciones.SCHEMA+".transportista.id="+String.valueOf(transportista.getId());
			} else {
				sQuery=" INNER JOIN factura.Transportista WHERE factura.Transportista.id="+String.valueOf(transportista.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);
			facturas=facturaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturas;

	}

	public List<Pedido> getPedidos(Connexion connexion,Transportista transportista)throws SQLException,Exception {

		List<Pedido> pedidos= new ArrayList<Pedido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransportistaConstantesFunciones.SCHEMA+".transportista ON "+PedidoConstantesFunciones.SCHEMA+".pedido.id_transportista="+TransportistaConstantesFunciones.SCHEMA+".transportista.id WHERE "+TransportistaConstantesFunciones.SCHEMA+".transportista.id="+String.valueOf(transportista.getId());
			} else {
				sQuery=" INNER JOIN pedido.Transportista WHERE pedido.Transportista.id="+String.valueOf(transportista.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoDataAccess pedidoDataAccess=new PedidoDataAccess();

			pedidoDataAccess.setConnexionType(this.connexionType);
			pedidoDataAccess.setParameterDbType(this.parameterDbType);
			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidos;

	}

	public List<Consignacion> getConsignacions(Connexion connexion,Transportista transportista)throws SQLException,Exception {

		List<Consignacion> consignacions= new ArrayList<Consignacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransportistaConstantesFunciones.SCHEMA+".transportista ON "+ConsignacionConstantesFunciones.SCHEMA+".consignacion.id_transportista="+TransportistaConstantesFunciones.SCHEMA+".transportista.id WHERE "+TransportistaConstantesFunciones.SCHEMA+".transportista.id="+String.valueOf(transportista.getId());
			} else {
				sQuery=" INNER JOIN consignacion.Transportista WHERE consignacion.Transportista.id="+String.valueOf(transportista.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConsignacionDataAccess consignacionDataAccess=new ConsignacionDataAccess();

			consignacionDataAccess.setConnexionType(this.connexionType);
			consignacionDataAccess.setParameterDbType(this.parameterDbType);
			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consignacions;

	}

	public List<NotaCredito> getNotaCreditos(Connexion connexion,Transportista transportista)throws SQLException,Exception {

		List<NotaCredito> notacreditos= new ArrayList<NotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransportistaConstantesFunciones.SCHEMA+".transportista ON "+NotaCreditoConstantesFunciones.SCHEMA+".nota_credito.id_transportista="+TransportistaConstantesFunciones.SCHEMA+".transportista.id WHERE "+TransportistaConstantesFunciones.SCHEMA+".transportista.id="+String.valueOf(transportista.getId());
			} else {
				sQuery=" INNER JOIN notacredito.Transportista WHERE notacredito.Transportista.id="+String.valueOf(transportista.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoDataAccess notacreditoDataAccess=new NotaCreditoDataAccess();

			notacreditoDataAccess.setConnexionType(this.connexionType);
			notacreditoDataAccess.setParameterDbType(this.parameterDbType);
			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditos;

	}

	public List<ServicioTransporte> getServicioTransportes(Connexion connexion,Transportista transportista)throws SQLException,Exception {

		List<ServicioTransporte> serviciotransportes= new ArrayList<ServicioTransporte>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransportistaConstantesFunciones.SCHEMA+".transportista ON "+ServicioTransporteConstantesFunciones.SCHEMA+".servicio_transporte.id_transportista="+TransportistaConstantesFunciones.SCHEMA+".transportista.id WHERE "+TransportistaConstantesFunciones.SCHEMA+".transportista.id="+String.valueOf(transportista.getId());
			} else {
				sQuery=" INNER JOIN serviciotransporte.Transportista WHERE serviciotransporte.Transportista.id="+String.valueOf(transportista.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ServicioTransporteDataAccess serviciotransporteDataAccess=new ServicioTransporteDataAccess();

			serviciotransporteDataAccess.setConnexionType(this.connexionType);
			serviciotransporteDataAccess.setParameterDbType(this.parameterDbType);
			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return serviciotransportes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Transportista transportista) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!transportista.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(transportista.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(transportista.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_via_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_via_transporte.setValue(transportista.getid_tipo_via_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_via_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueidentificacion=new ParameterValue<String>();
					parameterMaintenanceValueidentificacion.setValue(transportista.getidentificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidentificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(transportista.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(transportista.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueapellido=new ParameterValue<String>();
					parameterMaintenanceValueapellido.setValue(transportista.getapellido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueapellido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_completo=new ParameterValue<String>();
					parameterMaintenanceValuenombre_completo.setValue(transportista.getnombre_completo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_completo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(transportista.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(transportista.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(transportista.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueplaca=new ParameterValue<String>();
					parameterMaintenanceValueplaca.setValue(transportista.getplaca());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueplaca);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero=new ParameterValue<String>();
					parameterMaintenanceValuenumero.setValue(transportista.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion=new ParameterValue<String>();
					parameterMaintenanceValueobservacion.setValue(transportista.getobservacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!transportista.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(transportista.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(transportista.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(transportista.getId());
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
	
	public void setIsNewIsChangedFalseTransportista(Transportista transportista)throws Exception  {		
		transportista.setIsNew(false);
		transportista.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTransportistas(List<Transportista> transportistas)throws Exception  {				
		for(Transportista transportista:transportistas) {
			transportista.setIsNew(false);
			transportista.setIsChanged(false);
		}
	}
	
	public void generarExportarTransportista(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
