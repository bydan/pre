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
import com.bydan.erp.cartera.util.*;//SubClienteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class SubClienteDataAccess extends  SubClienteDataAccessAdditional{ //SubClienteDataAccessAdditional,DataAccessHelper<SubCliente>
	//static Logger logger = Logger.getLogger(SubClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="sub_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cliente,id_sucursal,id_tipo_identificacion,identificacion,ruc,nombre,apellido,nombre_completo,direccion,telefono,numero_celular,mail,fecha_nacimiento,fechao,observacion,id_pais,id_ciudad,id_zona,id_pais_nacionalidad,id_tipo_genero,id_estado_civil,id_estado_legal,id_tipo_nivel_edu,path_imagen_firma,id_cuenta_contable,numero_carga,limite_credito,descuento,codigo_contrato,valor_contrato,fecha_inicio,fecha_fin,plazo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,id_sucursal=?,id_tipo_identificacion=?,identificacion=?,ruc=?,nombre=?,apellido=?,nombre_completo=?,direccion=?,telefono=?,numero_celular=?,mail=?,fecha_nacimiento=?,fechao=?,observacion=?,id_pais=?,id_ciudad=?,id_zona=?,id_pais_nacionalidad=?,id_tipo_genero=?,id_estado_civil=?,id_estado_legal=?,id_tipo_nivel_edu=?,path_imagen_firma=?,id_cuenta_contable=?,numero_carga=?,limite_credito=?,descuento=?,codigo_contrato=?,valor_contrato=?,fecha_inicio=?,fecha_fin=?,plazo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select subcliente from "+SubClienteConstantesFunciones.SPERSISTENCENAME+" subcliente";
	public static String QUERYSELECTNATIVE="select "+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".version_row,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_empresa,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_cliente,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_sucursal,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_tipo_identificacion,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".identificacion,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".ruc,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".nombre,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".apellido,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".nombre_completo,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".direccion,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".telefono,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".numero_celular,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".mail,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".fecha_nacimiento,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".fechao,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".observacion,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_pais,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_ciudad,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_zona,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_pais_nacionalidad,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_tipo_genero,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_estado_civil,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_estado_legal,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_tipo_nivel_edu,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".path_imagen_firma,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id_cuenta_contable,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".numero_carga,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".limite_credito,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".descuento,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".codigo_contrato,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".valor_contrato,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".fecha_inicio,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".fecha_fin,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".plazo from "+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME;//+" as "+SubClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".id,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".version_row,"+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+".nombre from "+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME;//+" as "+SubClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+SubClienteConstantesFunciones.SCHEMA+"."+SubClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,id_sucursal=?,id_tipo_identificacion=?,identificacion=?,ruc=?,nombre=?,apellido=?,nombre_completo=?,direccion=?,telefono=?,numero_celular=?,mail=?,fecha_nacimiento=?,fechao=?,observacion=?,id_pais=?,id_ciudad=?,id_zona=?,id_pais_nacionalidad=?,id_tipo_genero=?,id_estado_civil=?,id_estado_legal=?,id_tipo_nivel_edu=?,path_imagen_firma=?,id_cuenta_contable=?,numero_carga=?,limite_credito=?,descuento=?,codigo_contrato=?,valor_contrato=?,fecha_inicio=?,fecha_fin=?,plazo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SUBCLIENTE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SUBCLIENTE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SUBCLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SUBCLIENTE_SELECT(?,?)";
	
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
	
	
	protected SubClienteDataAccessAdditional subclienteDataAccessAdditional=null;
	
	public SubClienteDataAccessAdditional getSubClienteDataAccessAdditional() {
		return this.subclienteDataAccessAdditional;
	}
	
	public void setSubClienteDataAccessAdditional(SubClienteDataAccessAdditional subclienteDataAccessAdditional) {
		try {
			this.subclienteDataAccessAdditional=subclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public SubClienteDataAccess() {
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
		SubClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		SubClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		SubClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setSubClienteOriginal(SubCliente subcliente)throws Exception  {
		subcliente.setSubClienteOriginal((SubCliente)subcliente.clone());		
	}
	
	public void setSubClientesOriginal(List<SubCliente> subclientes)throws Exception  {
		
		for(SubCliente subcliente:subclientes){
			subcliente.setSubClienteOriginal((SubCliente)subcliente.clone());
		}
	}
	
	public static void setSubClienteOriginalStatic(SubCliente subcliente)throws Exception  {
		subcliente.setSubClienteOriginal((SubCliente)subcliente.clone());		
	}
	
	public static void setSubClientesOriginalStatic(List<SubCliente> subclientes)throws Exception  {
		
		for(SubCliente subcliente:subclientes){
			subcliente.setSubClienteOriginal((SubCliente)subcliente.clone());
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
	
	public  SubCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		SubCliente entity = new SubCliente();		
		
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
	
	public  SubCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		SubCliente entity = new SubCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SubClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SubClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.SubCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setSubClienteOriginal(new SubCliente());
      	    	entity=super.getEntity("",entity,resultSet,SubClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySubCliente("",entity,resultSet); 
				
				//entity.setSubClienteOriginal(super.getEntity("",entity.getSubClienteOriginal(),resultSet,SubClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubClienteOriginal(this.getEntitySubCliente("",entity.getSubClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseSubCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  SubCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SubCliente entity = new SubCliente();
				
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
	
	public  SubCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SubCliente entity = new SubCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SubClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SubClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.SubCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setSubClienteOriginal(new SubCliente());
      	    	entity=super.getEntity("",entity,resultSet,SubClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySubCliente("",entity,resultSet);    
				
				//entity.setSubClienteOriginal(super.getEntity("",entity.getSubClienteOriginal(),resultSet,SubClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubClienteOriginal(this.getEntitySubCliente("",entity.getSubClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseSubCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //SubCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		SubCliente entity = new SubCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SubClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SubClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.SubCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseSubCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<SubCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SubCliente> entities = new  ArrayList<SubCliente>();
		SubCliente entity = new SubCliente();		  
		
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
	
	public  List<SubCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SubCliente> entities = new  ArrayList<SubCliente>();
		SubCliente entity = new SubCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=SubClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SubClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubCliente();
      	    	entity=super.getEntity("",entity,resultSet,SubClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySubCliente("",entity,resultSet);
      	    	
				//entity.setSubClienteOriginal( new SubCliente());
      	    	//entity.setSubClienteOriginal(super.getEntity("",entity.getSubClienteOriginal(),resultSet,SubClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubClienteOriginal(this.getEntitySubCliente("",entity.getSubClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSubClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SubCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SubCliente> entities = new  ArrayList<SubCliente>();
		SubCliente entity = new SubCliente();		  
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
	
	public  List<SubCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SubCliente> entities = new  ArrayList<SubCliente>();
		SubCliente entity = new SubCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapSubCliente();
					//entity.setMapSubCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapSubClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSubCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SubClienteDataAccess.ISWITHSCHEMA);         		
					entity=SubClienteDataAccess.getEntitySubCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSubClienteOriginal( new SubCliente());
					////entity.setSubClienteOriginal(super.getEntity("",entity.getSubClienteOriginal(),resultSet,SubClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setSubClienteOriginal(this.getEntitySubCliente("",entity.getSubClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSubClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public SubCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SubCliente entity = new SubCliente();		  
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
	
	public  SubCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SubCliente entity = new SubCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapSubCliente();
					//entity.setMapSubCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapSubClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSubCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SubClienteDataAccess.ISWITHSCHEMA);         		
					entity=SubClienteDataAccess.getEntitySubCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSubClienteOriginal( new SubCliente());
					////entity.setSubClienteOriginal(super.getEntity("",entity.getSubClienteOriginal(),resultSet,SubClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setSubClienteOriginal(this.getEntitySubCliente("",entity.getSubClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseSubCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SubCliente getEntitySubCliente(String strPrefijo,SubCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = SubCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = SubCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					SubClienteDataAccess.setFieldReflectionSubCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasSubCliente=SubClienteConstantesFunciones.getTodosTiposColumnasSubCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasSubCliente) {
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
							field = SubCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = SubCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						SubClienteDataAccess.setFieldReflectionSubCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSubCliente(Field field,String strPrefijo,String sColumn,SubCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SubClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDTIPOIDENTIFICACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDENTIFICACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.APELLIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.NUMEROCELULAR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.MAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.FECHANACIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SubClienteConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SubClienteConstantesFunciones.OBSERVACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDZONA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDPAISNACIONALIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDTIPOGENERO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDESTADOCIVIL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDESTADOLEGAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDTIPONIVELEDU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.PATHIMAGENFIRMA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubClienteConstantesFunciones.NUMEROCARGA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case SubClienteConstantesFunciones.LIMITECREDITO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SubClienteConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SubClienteConstantesFunciones.CODIGOCONTRATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubClienteConstantesFunciones.VALORCONTRATO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SubClienteConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SubClienteConstantesFunciones.FECHAFIN:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SubClienteConstantesFunciones.PLAZO:
					field.set(entity,resultSet.getInt(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SubCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<SubCliente> entities = new  ArrayList<SubCliente>();
		SubCliente entity = new SubCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SubClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SubClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new SubCliente();
					entity=super.getEntity("",entity,resultSet,SubClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntitySubCliente("",entity,resultSet);
					
					//entity.setSubClienteOriginal( new SubCliente());
					//entity.setSubClienteOriginal(super.getEntity("",entity.getSubClienteOriginal(),resultSet,SubClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setSubClienteOriginal(this.getEntitySubCliente("",entity.getSubClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseSubClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SubCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<SubCliente> entities = new  ArrayList<SubCliente>();
		SubCliente entity = new SubCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SubClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SubClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<SubCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubCliente> entities = new  ArrayList<SubCliente>();
		SubCliente entity = new SubCliente();		  
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
	
	public  List<SubCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubCliente> entities = new  ArrayList<SubCliente>();
		SubCliente entity = new SubCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubCliente();
      	    	entity=super.getEntity("",entity,resultSet,SubClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySubCliente("",entity,resultSet);
      	    	
				//entity.setSubClienteOriginal( new SubCliente());
      	    	//entity.setSubClienteOriginal(super.getEntity("",entity.getSubClienteOriginal(),resultSet,SubClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubClienteOriginal(this.getEntitySubCliente("",entity.getSubClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseSubClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SubCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubCliente> entities = new  ArrayList<SubCliente>();
		SubCliente entity = new SubCliente();		  
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
	
	public  List<SubCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubCliente> entities = new  ArrayList<SubCliente>();
		SubCliente entity = new SubCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubCliente();
      	    	entity=super.getEntity("",entity,resultSet,SubClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySubCliente("",entity,resultSet);
      	    	
				//entity.setSubClienteOriginal( new SubCliente());
      	    	//entity.setSubClienteOriginal(super.getEntity("",entity.getSubClienteOriginal(),resultSet,SubClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubClienteOriginal(this.getEntitySubCliente("",entity.getSubClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSubClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public SubCliente getEntitySubCliente(String strPrefijo,SubCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDEMPRESA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDCLIENTE));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDSUCURSAL));
				entity.setid_tipo_identificacion(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDTIPOIDENTIFICACION));
				entity.setidentificacion(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.IDENTIFICACION));
				entity.setruc(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.RUC));
				entity.setnombre(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.NOMBRE));
				entity.setapellido(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.APELLIDO));
				entity.setnombre_completo(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.NOMBRECOMPLETO));
				entity.setdireccion(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.DIRECCION));
				entity.settelefono(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.TELEFONO));
				entity.setnumero_celular(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.NUMEROCELULAR));
				entity.setmail(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.MAIL));
				entity.setfecha_nacimiento(new Date(resultSet.getDate(strPrefijo+SubClienteConstantesFunciones.FECHANACIMIENTO).getTime()));
				entity.setfechao(new Date(resultSet.getDate(strPrefijo+SubClienteConstantesFunciones.FECHA).getTime()));
				entity.setobservacion(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.OBSERVACION));
				entity.setid_pais(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDCIUDAD));
				entity.setid_zona(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDZONA));
				entity.setid_pais_nacionalidad(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDPAISNACIONALIDAD));
				entity.setid_tipo_genero(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDTIPOGENERO));
				entity.setid_estado_civil(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDESTADOCIVIL));
				entity.setid_estado_legal(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDESTADOLEGAL));
				entity.setid_tipo_nivel_edu(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDTIPONIVELEDU));
				entity.setpath_imagen_firma(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.PATHIMAGENFIRMA));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+SubClienteConstantesFunciones.IDCUENTACONTABLE));
				entity.setnumero_carga(resultSet.getInt(strPrefijo+SubClienteConstantesFunciones.NUMEROCARGA));
				entity.setlimite_credito(resultSet.getDouble(strPrefijo+SubClienteConstantesFunciones.LIMITECREDITO));
				entity.setdescuento(resultSet.getDouble(strPrefijo+SubClienteConstantesFunciones.DESCUENTO));
				entity.setcodigo_contrato(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.CODIGOCONTRATO));
				entity.setvalor_contrato(resultSet.getDouble(strPrefijo+SubClienteConstantesFunciones.VALORCONTRATO));
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+SubClienteConstantesFunciones.FECHAINICIO).getTime()));
				entity.setfecha_fin(new Date(resultSet.getDate(strPrefijo+SubClienteConstantesFunciones.FECHAFIN).getTime()));
				entity.setplazo(resultSet.getInt(strPrefijo+SubClienteConstantesFunciones.PLAZO));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+SubClienteConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowSubCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(SubCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=SubClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=SubClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=SubClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=SubClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(SubClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,SubClienteDataAccess.TABLENAME,SubClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			SubClienteDataAccess.setSubClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relsubcliente.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relsubcliente.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Sucursal getSucursal(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relsubcliente.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoIdentificacion getTipoIdentificacion(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		TipoIdentificacion tipoidentificacion= new TipoIdentificacion();

		try {
			TipoIdentificacionDataAccess tipoidentificacionDataAccess=new TipoIdentificacionDataAccess();

			tipoidentificacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoidentificacionDataAccess.setConnexionType(this.connexionType);
			tipoidentificacionDataAccess.setParameterDbType(this.parameterDbType);

			tipoidentificacion=tipoidentificacionDataAccess.getEntity(connexion,relsubcliente.getid_tipo_identificacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoidentificacion;

	}

	public Pais getPais(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relsubcliente.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relsubcliente.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public Zona getZona(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);

			zona=zonaDataAccess.getEntity(connexion,relsubcliente.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}

	public Pais getPaisNacionalidad(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relsubcliente.getid_pais_nacionalidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public TipoGenero getTipoGenero(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		TipoGenero tipogenero= new TipoGenero();

		try {
			TipoGeneroDataAccess tipogeneroDataAccess=new TipoGeneroDataAccess();

			tipogeneroDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogeneroDataAccess.setConnexionType(this.connexionType);
			tipogeneroDataAccess.setParameterDbType(this.parameterDbType);

			tipogenero=tipogeneroDataAccess.getEntity(connexion,relsubcliente.getid_tipo_genero());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogenero;

	}

	public EstadoCivil getEstadoCivil(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		EstadoCivil estadocivil= new EstadoCivil();

		try {
			EstadoCivilDataAccess estadocivilDataAccess=new EstadoCivilDataAccess();

			estadocivilDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadocivilDataAccess.setConnexionType(this.connexionType);
			estadocivilDataAccess.setParameterDbType(this.parameterDbType);

			estadocivil=estadocivilDataAccess.getEntity(connexion,relsubcliente.getid_estado_civil());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadocivil;

	}

	public EstadoLegal getEstadoLegal(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		EstadoLegal estadolegal= new EstadoLegal();

		try {
			EstadoLegalDataAccess estadolegalDataAccess=new EstadoLegalDataAccess();

			estadolegalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadolegalDataAccess.setConnexionType(this.connexionType);
			estadolegalDataAccess.setParameterDbType(this.parameterDbType);

			estadolegal=estadolegalDataAccess.getEntity(connexion,relsubcliente.getid_estado_legal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadolegal;

	}

	public TipoNivelEdu getTipoNivelEdu(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		TipoNivelEdu tiponiveledu= new TipoNivelEdu();

		try {
			TipoNivelEduDataAccess tiponiveleduDataAccess=new TipoNivelEduDataAccess();

			tiponiveleduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiponiveleduDataAccess.setConnexionType(this.connexionType);
			tiponiveleduDataAccess.setParameterDbType(this.parameterDbType);

			tiponiveledu=tiponiveleduDataAccess.getEntity(connexion,relsubcliente.getid_tipo_nivel_edu());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiponiveledu;

	}

	public CuentaContable getCuentaContable(Connexion connexion,SubCliente relsubcliente)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relsubcliente.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<Factura> getFacturas(Connexion connexion,SubCliente subcliente)throws SQLException,Exception {

		List<Factura> facturas= new ArrayList<Factura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente ON "+FacturaConstantesFunciones.SCHEMA+".factura.id_sub_cliente="+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id WHERE "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id="+String.valueOf(subcliente.getId());
			} else {
				sQuery=" INNER JOIN factura.SubCliente WHERE factura.SubCliente.id="+String.valueOf(subcliente.getId());

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

	public List<Consignacion> getConsignacions(Connexion connexion,SubCliente subcliente)throws SQLException,Exception {

		List<Consignacion> consignacions= new ArrayList<Consignacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente ON "+ConsignacionConstantesFunciones.SCHEMA+".consignacion.id_sub_cliente="+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id WHERE "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id="+String.valueOf(subcliente.getId());
			} else {
				sQuery=" INNER JOIN consignacion.SubCliente WHERE consignacion.SubCliente.id="+String.valueOf(subcliente.getId());

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

	public List<GuiaRemision> getGuiaRemisions(Connexion connexion,SubCliente subcliente)throws SQLException,Exception {

		List<GuiaRemision> guiaremisions= new ArrayList<GuiaRemision>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente ON "+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision.id_sub_cliente="+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id WHERE "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id="+String.valueOf(subcliente.getId());
			} else {
				sQuery=" INNER JOIN guiaremision.SubCliente WHERE guiaremision.SubCliente.id="+String.valueOf(subcliente.getId());

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

	public List<Proforma> getProformas(Connexion connexion,SubCliente subcliente)throws SQLException,Exception {

		List<Proforma> proformas= new ArrayList<Proforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente ON "+ProformaConstantesFunciones.SCHEMA+".proforma.id_sub_cliente="+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id WHERE "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id="+String.valueOf(subcliente.getId());
			} else {
				sQuery=" INNER JOIN proforma.SubCliente WHERE proforma.SubCliente.id="+String.valueOf(subcliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProformaDataAccess proformaDataAccess=new ProformaDataAccess();

			proformaDataAccess.setConnexionType(this.connexionType);
			proformaDataAccess.setParameterDbType(this.parameterDbType);
			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return proformas;

	}

	public List<PedidoExpor> getPedidoExpors(Connexion connexion,SubCliente subcliente)throws SQLException,Exception {

		List<PedidoExpor> pedidoexpors= new ArrayList<PedidoExpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente ON "+PedidoExporConstantesFunciones.SCHEMA+".pedido_expor.id_sub_cliente="+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id WHERE "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id="+String.valueOf(subcliente.getId());
			} else {
				sQuery=" INNER JOIN pedidoexpor.SubCliente WHERE pedidoexpor.SubCliente.id="+String.valueOf(subcliente.getId());

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

	public List<Pedido> getPedidos(Connexion connexion,SubCliente subcliente)throws SQLException,Exception {

		List<Pedido> pedidos= new ArrayList<Pedido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente ON "+PedidoConstantesFunciones.SCHEMA+".pedido.id_sub_cliente="+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id WHERE "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id="+String.valueOf(subcliente.getId());
			} else {
				sQuery=" INNER JOIN pedido.SubCliente WHERE pedido.SubCliente.id="+String.valueOf(subcliente.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,SubCliente subcliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!subcliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(subcliente.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(subcliente.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(subcliente.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_identificacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_identificacion.setValue(subcliente.getid_tipo_identificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_identificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueidentificacion=new ParameterValue<String>();
					parameterMaintenanceValueidentificacion.setValue(subcliente.getidentificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidentificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(subcliente.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(subcliente.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueapellido=new ParameterValue<String>();
					parameterMaintenanceValueapellido.setValue(subcliente.getapellido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueapellido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_completo=new ParameterValue<String>();
					parameterMaintenanceValuenombre_completo.setValue(subcliente.getnombre_completo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_completo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(subcliente.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(subcliente.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_celular=new ParameterValue<String>();
					parameterMaintenanceValuenumero_celular.setValue(subcliente.getnumero_celular());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_celular);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemail=new ParameterValue<String>();
					parameterMaintenanceValuemail.setValue(subcliente.getmail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_nacimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_nacimiento.setValue(subcliente.getfecha_nacimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_nacimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefechao=new ParameterValue<Date>();
					parameterMaintenanceValuefechao.setValue(subcliente.getfechao());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefechao);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion=new ParameterValue<String>();
					parameterMaintenanceValueobservacion.setValue(subcliente.getobservacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(subcliente.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(subcliente.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_zona=new ParameterValue<Long>();
					parameterMaintenanceValueid_zona.setValue(subcliente.getid_zona());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_zona);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais_nacionalidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais_nacionalidad.setValue(subcliente.getid_pais_nacionalidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais_nacionalidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_genero=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_genero.setValue(subcliente.getid_tipo_genero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_genero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_civil=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_civil.setValue(subcliente.getid_estado_civil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_civil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_legal=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_legal.setValue(subcliente.getid_estado_legal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_legal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_nivel_edu=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_nivel_edu.setValue(subcliente.getid_tipo_nivel_edu());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_nivel_edu);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepath_imagen_firma=new ParameterValue<String>();
					parameterMaintenanceValuepath_imagen_firma.setValue(subcliente.getpath_imagen_firma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepath_imagen_firma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(subcliente.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_carga=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_carga.setValue(subcliente.getnumero_carga());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_carga);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuelimite_credito=new ParameterValue<Double>();
					parameterMaintenanceValuelimite_credito.setValue(subcliente.getlimite_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelimite_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(subcliente.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_contrato=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_contrato.setValue(subcliente.getcodigo_contrato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_contrato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_contrato=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_contrato.setValue(subcliente.getvalor_contrato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_contrato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicio=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicio.setValue(subcliente.getfecha_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_fin=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_fin.setValue(subcliente.getfecha_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueplazo=new ParameterValue<Integer>();
					parameterMaintenanceValueplazo.setValue(subcliente.getplazo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueplazo);
					parametersTemp.add(parameterMaintenance);
					
						if(!subcliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(subcliente.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(subcliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(subcliente.getId());
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
	
	public void setIsNewIsChangedFalseSubCliente(SubCliente subcliente)throws Exception  {		
		subcliente.setIsNew(false);
		subcliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseSubClientes(List<SubCliente> subclientes)throws Exception  {				
		for(SubCliente subcliente:subclientes) {
			subcliente.setIsNew(false);
			subcliente.setIsChanged(false);
		}
	}
	
	public void generarExportarSubCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
