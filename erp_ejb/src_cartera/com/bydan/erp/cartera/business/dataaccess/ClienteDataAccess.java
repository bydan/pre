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
import com.bydan.erp.cartera.util.*;//ClienteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;




@SuppressWarnings("unused")
final public class ClienteDataAccess extends  ClienteDataAccessAdditional{ //ClienteDataAccessAdditional,DataAccessHelper<Cliente>
	//static Logger logger = Logger.getLogger(ClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,codigo,id_tipo_identificacion,identificacion,ruc,nombre,apellido,nombre_completo,nombre_comercial,telefono,direccion,es_prove,id_grupo_cliente,id_titulo_cliente,id_area_cr,id_estado_cliente,observacion,id_pais,id_region,id_provincia,id_ciudad,id_zona,id_pais_nacionalidad,id_tipo_cargo_labo,id_tipo_nivel_edu,id_profesion,id_tipo_genero,id_estado_civil,id_estado_legal,fecha_nacimiento,path_imagen_firma,contacto,id_cuenta_contable,id_ruta,id_vendedor,id_centro_actividad,representante,id_tipo_garantia_empresa,nombre_garantia,valor_garantia,id_cate_tipo_afiliacion,numero_carga,credito_usado,limite_credito,credito_disponible,total_documentos,fecha_ultima_factura,descuento,id_dia,hora_pago,id_empleado,cobranzas,motivo,preferencia,con_separacion_bienes,id_tipo_precio,id_tipo_lista_precio,detalle_estado,es_contribuyente_especial)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,codigo=?,id_tipo_identificacion=?,identificacion=?,ruc=?,nombre=?,apellido=?,nombre_completo=?,nombre_comercial=?,telefono=?,direccion=?,es_prove=?,id_grupo_cliente=?,id_titulo_cliente=?,id_area_cr=?,id_estado_cliente=?,observacion=?,id_pais=?,id_region=?,id_provincia=?,id_ciudad=?,id_zona=?,id_pais_nacionalidad=?,id_tipo_cargo_labo=?,id_tipo_nivel_edu=?,id_profesion=?,id_tipo_genero=?,id_estado_civil=?,id_estado_legal=?,fecha_nacimiento=?,path_imagen_firma=?,contacto=?,id_cuenta_contable=?,id_ruta=?,id_vendedor=?,id_centro_actividad=?,representante=?,id_tipo_garantia_empresa=?,nombre_garantia=?,valor_garantia=?,id_cate_tipo_afiliacion=?,numero_carga=?,credito_usado=?,limite_credito=?,credito_disponible=?,total_documentos=?,fecha_ultima_factura=?,descuento=?,id_dia=?,hora_pago=?,id_empleado=?,cobranzas=?,motivo=?,preferencia=?,con_separacion_bienes=?,id_tipo_precio=?,id_tipo_lista_precio=?,detalle_estado=?,es_contribuyente_especial=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cliente from "+ClienteConstantesFunciones.SPERSISTENCENAME+" cliente";
	public static String QUERYSELECTNATIVE="select "+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".version_row,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_empresa,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_sucursal,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".codigo,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_identificacion,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".identificacion,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".ruc,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".nombre,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".apellido,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".nombre_completo,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".nombre_comercial,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".telefono,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".direccion,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".es_prove,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_grupo_cliente,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_titulo_cliente,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_area_cr,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_estado_cliente,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".observacion,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_pais,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_region,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_provincia,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_ciudad,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_zona,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_pais_nacionalidad,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_cargo_labo,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_nivel_edu,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_profesion,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_genero,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_estado_civil,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_estado_legal,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".fecha_nacimiento,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".path_imagen_firma,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".contacto,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_cuenta_contable,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_ruta,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_vendedor,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_centro_actividad,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".representante,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_garantia_empresa,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".nombre_garantia,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".valor_garantia,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_cate_tipo_afiliacion,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".numero_carga,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".credito_usado,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".limite_credito,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".credito_disponible,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".total_documentos,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".fecha_ultima_factura,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".descuento,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_dia,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".hora_pago,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_empleado,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".cobranzas,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".motivo,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".preferencia,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".con_separacion_bienes,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_precio,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id_tipo_lista_precio,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".detalle_estado,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".es_contribuyente_especial from "+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME;//+" as "+ClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".id,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".version_row,"+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+".nombre_completo from "+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME;//+" as "+ClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ClienteConstantesFunciones.SCHEMA+"."+ClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,codigo=?,id_tipo_identificacion=?,identificacion=?,ruc=?,nombre=?,apellido=?,nombre_completo=?,nombre_comercial=?,telefono=?,direccion=?,es_prove=?,id_grupo_cliente=?,id_titulo_cliente=?,id_area_cr=?,id_estado_cliente=?,observacion=?,id_pais=?,id_region=?,id_provincia=?,id_ciudad=?,id_zona=?,id_pais_nacionalidad=?,id_tipo_cargo_labo=?,id_tipo_nivel_edu=?,id_profesion=?,id_tipo_genero=?,id_estado_civil=?,id_estado_legal=?,fecha_nacimiento=?,path_imagen_firma=?,contacto=?,id_cuenta_contable=?,id_ruta=?,id_vendedor=?,id_centro_actividad=?,representante=?,id_tipo_garantia_empresa=?,nombre_garantia=?,valor_garantia=?,id_cate_tipo_afiliacion=?,numero_carga=?,credito_usado=?,limite_credito=?,credito_disponible=?,total_documentos=?,fecha_ultima_factura=?,descuento=?,id_dia=?,hora_pago=?,id_empleado=?,cobranzas=?,motivo=?,preferencia=?,con_separacion_bienes=?,id_tipo_precio=?,id_tipo_lista_precio=?,detalle_estado=?,es_contribuyente_especial=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CLIENTE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CLIENTE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CLIENTE_SELECT(?,?)";
	
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
	
	
	protected ClienteDataAccessAdditional clienteDataAccessAdditional=null;
	
	public ClienteDataAccessAdditional getClienteDataAccessAdditional() {
		return this.clienteDataAccessAdditional;
	}
	
	public void setClienteDataAccessAdditional(ClienteDataAccessAdditional clienteDataAccessAdditional) {
		try {
			this.clienteDataAccessAdditional=clienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ClienteDataAccess() {
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
		ClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setClienteOriginal(Cliente cliente)throws Exception  {
		cliente.setClienteOriginal((Cliente)cliente.clone());		
	}
	
	public void setClientesOriginal(List<Cliente> clientes)throws Exception  {
		
		for(Cliente cliente:clientes){
			cliente.setClienteOriginal((Cliente)cliente.clone());
		}
	}
	
	public static void setClienteOriginalStatic(Cliente cliente)throws Exception  {
		cliente.setClienteOriginal((Cliente)cliente.clone());		
	}
	
	public static void setClientesOriginalStatic(List<Cliente> clientes)throws Exception  {
		
		for(Cliente cliente:clientes){
			cliente.setClienteOriginal((Cliente)cliente.clone());
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
	
	public  Cliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Cliente entity = new Cliente();		
		
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
	
	public  Cliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Cliente entity = new Cliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.Cliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setClienteOriginal(new Cliente());
      	    	entity=super.getEntity("",entity,resultSet,ClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCliente("",entity,resultSet); 
				
				//entity.setClienteOriginal(super.getEntity("",entity.getClienteOriginal(),resultSet,ClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteOriginal(this.getEntityCliente("",entity.getClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Cliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Cliente entity = new Cliente();
				
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
	
	public  Cliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Cliente entity = new Cliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.Cliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setClienteOriginal(new Cliente());
      	    	entity=super.getEntity("",entity,resultSet,ClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCliente("",entity,resultSet);    
				
				//entity.setClienteOriginal(super.getEntity("",entity.getClienteOriginal(),resultSet,ClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteOriginal(this.getEntityCliente("",entity.getClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Cliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Cliente entity = new Cliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.Cliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Cliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Cliente> entities = new  ArrayList<Cliente>();
		Cliente entity = new Cliente();		  
		
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
	
	public  List<Cliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Cliente> entities = new  ArrayList<Cliente>();
		Cliente entity = new Cliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cliente();
      	    	entity=super.getEntity("",entity,resultSet,ClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCliente("",entity,resultSet);
      	    	
				//entity.setClienteOriginal( new Cliente());
      	    	//entity.setClienteOriginal(super.getEntity("",entity.getClienteOriginal(),resultSet,ClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteOriginal(this.getEntityCliente("",entity.getClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Cliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Cliente> entities = new  ArrayList<Cliente>();
		Cliente entity = new Cliente();		  
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
	
	public  List<Cliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Cliente> entities = new  ArrayList<Cliente>();
		Cliente entity = new Cliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cliente();
				
				if(conMapGenerico) {
					entity.inicializarMapCliente();
					//entity.setMapCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ClienteDataAccess.ISWITHSCHEMA);         		
					entity=ClienteDataAccess.getEntityCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setClienteOriginal( new Cliente());
					////entity.setClienteOriginal(super.getEntity("",entity.getClienteOriginal(),resultSet,ClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setClienteOriginal(this.getEntityCliente("",entity.getClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Cliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Cliente entity = new Cliente();		  
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
	
	public  Cliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Cliente entity = new Cliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cliente();
				
				if(conMapGenerico) {
					entity.inicializarMapCliente();
					//entity.setMapCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ClienteDataAccess.ISWITHSCHEMA);         		
					entity=ClienteDataAccess.getEntityCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setClienteOriginal( new Cliente());
					////entity.setClienteOriginal(super.getEntity("",entity.getClienteOriginal(),resultSet,ClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setClienteOriginal(this.getEntityCliente("",entity.getClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Cliente getEntityCliente(String strPrefijo,Cliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Cliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Cliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ClienteDataAccess.setFieldReflectionCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCliente=ClienteConstantesFunciones.getTodosTiposColumnasCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCliente) {
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
							field = Cliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Cliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ClienteDataAccess.setFieldReflectionCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCliente(Field field,String strPrefijo,String sColumn,Cliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDTIPOIDENTIFICACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDENTIFICACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.APELLIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.NOMBRECOMERCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.ESPROVE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDGRUPOCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDTITULOCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDAREACR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDESTADOCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.OBSERVACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDREGION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDPROVINCIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDZONA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDPAISNACIONALIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDTIPOCARGOLABO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDTIPONIVELEDU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDPROFESION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDTIPOGENERO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDESTADOCIVIL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDESTADOLEGAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.FECHANACIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ClienteConstantesFunciones.PATHIMAGENFIRMA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.CONTACTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDRUTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDCENTROACTIVIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.REPRESENTANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.NOMBREGARANTIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.VALORGARANTIA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDCATETIPOAFILIACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.NUMEROCARGA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ClienteConstantesFunciones.CREDITOUSADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteConstantesFunciones.LIMITECREDITO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteConstantesFunciones.CREDITODISPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteConstantesFunciones.TOTALDOCUMENTOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteConstantesFunciones.FECHAULTIMAFACTURA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ClienteConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDDIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.HORAPAGO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.COBRANZAS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.MOTIVO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.PREFERENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.CONSEPARACIONBIENES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.IDTIPOLISTAPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteConstantesFunciones.DETALLEESTADO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteConstantesFunciones.ESCONTRIBUYENTEESPECIAL:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Cliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Cliente> entities = new  ArrayList<Cliente>();
		Cliente entity = new Cliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Cliente();
					entity=super.getEntity("",entity,resultSet,ClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCliente("",entity,resultSet);
					
					//entity.setClienteOriginal( new Cliente());
					//entity.setClienteOriginal(super.getEntity("",entity.getClienteOriginal(),resultSet,ClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setClienteOriginal(this.getEntityCliente("",entity.getClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Cliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Cliente> entities = new  ArrayList<Cliente>();
		Cliente entity = new Cliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Cliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Cliente> entities = new  ArrayList<Cliente>();
		Cliente entity = new Cliente();		  
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
	
	public  List<Cliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Cliente> entities = new  ArrayList<Cliente>();
		Cliente entity = new Cliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cliente();
      	    	entity=super.getEntity("",entity,resultSet,ClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCliente("",entity,resultSet);
      	    	
				//entity.setClienteOriginal( new Cliente());
      	    	//entity.setClienteOriginal(super.getEntity("",entity.getClienteOriginal(),resultSet,ClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteOriginal(this.getEntityCliente("",entity.getClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Cliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Cliente> entities = new  ArrayList<Cliente>();
		Cliente entity = new Cliente();		  
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
	
	public  List<Cliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Cliente> entities = new  ArrayList<Cliente>();
		Cliente entity = new Cliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cliente();
      	    	entity=super.getEntity("",entity,resultSet,ClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCliente("",entity,resultSet);
      	    	
				//entity.setClienteOriginal( new Cliente());
      	    	//entity.setClienteOriginal(super.getEntity("",entity.getClienteOriginal(),resultSet,ClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteOriginal(this.getEntityCliente("",entity.getClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Cliente getEntityCliente(String strPrefijo,Cliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDSUCURSAL));
				entity.setcodigo(resultSet.getString(strPrefijo+ClienteConstantesFunciones.CODIGO));
				entity.setid_tipo_identificacion(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDTIPOIDENTIFICACION));
				entity.setidentificacion(resultSet.getString(strPrefijo+ClienteConstantesFunciones.IDENTIFICACION));
				entity.setruc(resultSet.getString(strPrefijo+ClienteConstantesFunciones.RUC));
				entity.setnombre(resultSet.getString(strPrefijo+ClienteConstantesFunciones.NOMBRE));
				entity.setapellido(resultSet.getString(strPrefijo+ClienteConstantesFunciones.APELLIDO));
				entity.setnombre_completo(resultSet.getString(strPrefijo+ClienteConstantesFunciones.NOMBRECOMPLETO));
				entity.setnombre_comercial(resultSet.getString(strPrefijo+ClienteConstantesFunciones.NOMBRECOMERCIAL));
				entity.settelefono(resultSet.getString(strPrefijo+ClienteConstantesFunciones.TELEFONO));
				entity.setdireccion(resultSet.getString(strPrefijo+ClienteConstantesFunciones.DIRECCION));
				entity.setes_prove(resultSet.getBoolean(strPrefijo+ClienteConstantesFunciones.ESPROVE));
				entity.setid_grupo_cliente(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDGRUPOCLIENTE));
				entity.setid_titulo_cliente(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDTITULOCLIENTE));
				entity.setid_area_cr(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDAREACR));
				entity.setid_estado_cliente(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDESTADOCLIENTE));
				entity.setobservacion(resultSet.getString(strPrefijo+ClienteConstantesFunciones.OBSERVACION));
				entity.setid_pais(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDPAIS));
				entity.setid_region(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDREGION));
				entity.setid_provincia(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDPROVINCIA));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDCIUDAD));
				entity.setid_zona(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDZONA));
				entity.setid_pais_nacionalidad(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDPAISNACIONALIDAD));
				entity.setid_tipo_cargo_labo(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDTIPOCARGOLABO));
				entity.setid_tipo_nivel_edu(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDTIPONIVELEDU));
				entity.setid_profesion(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDPROFESION));
				entity.setid_tipo_genero(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDTIPOGENERO));
				entity.setid_estado_civil(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDESTADOCIVIL));
				entity.setid_estado_legal(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDESTADOLEGAL));
				entity.setfecha_nacimiento(new Date(resultSet.getDate(strPrefijo+ClienteConstantesFunciones.FECHANACIMIENTO).getTime()));
				entity.setpath_imagen_firma(resultSet.getString(strPrefijo+ClienteConstantesFunciones.PATHIMAGENFIRMA));
				entity.setcontacto(resultSet.getString(strPrefijo+ClienteConstantesFunciones.CONTACTO));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_ruta(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDRUTA));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDVENDEDOR));
				entity.setid_centro_actividad(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDCENTROACTIVIDAD));if(resultSet.wasNull()) {entity.setid_centro_actividad(null); }
				entity.setrepresentante(resultSet.getString(strPrefijo+ClienteConstantesFunciones.REPRESENTANTE));
				entity.setid_tipo_garantia_empresa(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA));
				entity.setnombre_garantia(resultSet.getString(strPrefijo+ClienteConstantesFunciones.NOMBREGARANTIA));
				entity.setvalor_garantia(resultSet.getDouble(strPrefijo+ClienteConstantesFunciones.VALORGARANTIA));
				entity.setid_cate_tipo_afiliacion(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDCATETIPOAFILIACION));
				entity.setnumero_carga(resultSet.getInt(strPrefijo+ClienteConstantesFunciones.NUMEROCARGA));
				entity.setcredito_usado(resultSet.getDouble(strPrefijo+ClienteConstantesFunciones.CREDITOUSADO));
				entity.setlimite_credito(resultSet.getDouble(strPrefijo+ClienteConstantesFunciones.LIMITECREDITO));
				entity.setcredito_disponible(resultSet.getDouble(strPrefijo+ClienteConstantesFunciones.CREDITODISPONIBLE));
				entity.settotal_documentos(resultSet.getDouble(strPrefijo+ClienteConstantesFunciones.TOTALDOCUMENTOS));
				entity.setfecha_ultima_factura(new Date(resultSet.getDate(strPrefijo+ClienteConstantesFunciones.FECHAULTIMAFACTURA).getTime()));
				entity.setdescuento(resultSet.getDouble(strPrefijo+ClienteConstantesFunciones.DESCUENTO));
				entity.setid_dia(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDDIA));
				entity.sethora_pago(resultSet.getTime(strPrefijo+ClienteConstantesFunciones.HORAPAGO));
				entity.setid_empleado(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDEMPLEADO));
				entity.setcobranzas(resultSet.getString(strPrefijo+ClienteConstantesFunciones.COBRANZAS));
				entity.setmotivo(resultSet.getString(strPrefijo+ClienteConstantesFunciones.MOTIVO));
				entity.setpreferencia(resultSet.getString(strPrefijo+ClienteConstantesFunciones.PREFERENCIA));
				entity.setcon_separacion_bienes(resultSet.getBoolean(strPrefijo+ClienteConstantesFunciones.CONSEPARACIONBIENES));
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDTIPOPRECIO));
				entity.setid_tipo_lista_precio(resultSet.getLong(strPrefijo+ClienteConstantesFunciones.IDTIPOLISTAPRECIO));
				entity.setdetalle_estado(resultSet.getString(strPrefijo+ClienteConstantesFunciones.DETALLEESTADO));
				entity.setes_contribuyente_especial(resultSet.getBoolean(strPrefijo+ClienteConstantesFunciones.ESCONTRIBUYENTEESPECIAL));
			} else {
				entity.setnombre_completo(resultSet.getString(strPrefijo+ClienteConstantesFunciones.NOMBRECOMPLETO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Cliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ClienteDataAccess.TABLENAME,ClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			ClienteDataAccess.setClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcliente.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcliente.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoIdentificacion getTipoIdentificacion(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		TipoIdentificacion tipoidentificacion= new TipoIdentificacion();

		try {
			TipoIdentificacionDataAccess tipoidentificacionDataAccess=new TipoIdentificacionDataAccess();

			tipoidentificacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoidentificacionDataAccess.setConnexionType(this.connexionType);
			tipoidentificacionDataAccess.setParameterDbType(this.parameterDbType);

			tipoidentificacion=tipoidentificacionDataAccess.getEntity(connexion,relcliente.getid_tipo_identificacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoidentificacion;

	}

	public GrupoCliente getGrupoCliente(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		GrupoCliente grupocliente= new GrupoCliente();

		try {
			GrupoClienteDataAccess grupoclienteDataAccess=new GrupoClienteDataAccess();

			grupoclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoclienteDataAccess.setConnexionType(this.connexionType);
			grupoclienteDataAccess.setParameterDbType(this.parameterDbType);

			grupocliente=grupoclienteDataAccess.getEntity(connexion,relcliente.getid_grupo_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupocliente;

	}

	public TituloCliente getTituloCliente(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		TituloCliente titulocliente= new TituloCliente();

		try {
			TituloClienteDataAccess tituloclienteDataAccess=new TituloClienteDataAccess();

			tituloclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tituloclienteDataAccess.setConnexionType(this.connexionType);
			tituloclienteDataAccess.setParameterDbType(this.parameterDbType);

			titulocliente=tituloclienteDataAccess.getEntity(connexion,relcliente.getid_titulo_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return titulocliente;

	}

	public AreaCr getAreaCr(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		AreaCr areacr= new AreaCr();

		try {
			AreaCrDataAccess areacrDataAccess=new AreaCrDataAccess();

			areacrDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			areacrDataAccess.setConnexionType(this.connexionType);
			areacrDataAccess.setParameterDbType(this.parameterDbType);

			areacr=areacrDataAccess.getEntity(connexion,relcliente.getid_area_cr());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return areacr;

	}

	public EstadoCliente getEstadoCliente(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		EstadoCliente estadocliente= new EstadoCliente();

		try {
			EstadoClienteDataAccess estadoclienteDataAccess=new EstadoClienteDataAccess();

			estadoclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoclienteDataAccess.setConnexionType(this.connexionType);
			estadoclienteDataAccess.setParameterDbType(this.parameterDbType);

			estadocliente=estadoclienteDataAccess.getEntity(connexion,relcliente.getid_estado_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadocliente;

	}

	public Pais getPais(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relcliente.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Region getRegion(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Region region= new Region();

		try {
			RegionDataAccess regionDataAccess=new RegionDataAccess();

			regionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			regionDataAccess.setConnexionType(this.connexionType);
			regionDataAccess.setParameterDbType(this.parameterDbType);

			region=regionDataAccess.getEntity(connexion,relcliente.getid_region());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return region;

	}

	public Provincia getProvincia(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Provincia provincia= new Provincia();

		try {
			ProvinciaDataAccess provinciaDataAccess=new ProvinciaDataAccess();

			provinciaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			provinciaDataAccess.setConnexionType(this.connexionType);
			provinciaDataAccess.setParameterDbType(this.parameterDbType);

			provincia=provinciaDataAccess.getEntity(connexion,relcliente.getid_provincia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return provincia;

	}

	public Ciudad getCiudad(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relcliente.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public Zona getZona(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);

			zona=zonaDataAccess.getEntity(connexion,relcliente.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}

	public Pais getPaisNacionalidad(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relcliente.getid_pais_nacionalidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public TipoCargoLabo getTipoCargoLabo(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		TipoCargoLabo tipocargolabo= new TipoCargoLabo();

		try {
			TipoCargoLaboDataAccess tipocargolaboDataAccess=new TipoCargoLaboDataAccess();

			tipocargolaboDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocargolaboDataAccess.setConnexionType(this.connexionType);
			tipocargolaboDataAccess.setParameterDbType(this.parameterDbType);

			tipocargolabo=tipocargolaboDataAccess.getEntity(connexion,relcliente.getid_tipo_cargo_labo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocargolabo;

	}

	public TipoNivelEdu getTipoNivelEdu(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		TipoNivelEdu tiponiveledu= new TipoNivelEdu();

		try {
			TipoNivelEduDataAccess tiponiveleduDataAccess=new TipoNivelEduDataAccess();

			tiponiveleduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiponiveleduDataAccess.setConnexionType(this.connexionType);
			tiponiveleduDataAccess.setParameterDbType(this.parameterDbType);

			tiponiveledu=tiponiveleduDataAccess.getEntity(connexion,relcliente.getid_tipo_nivel_edu());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiponiveledu;

	}

	public Profesion getProfesion(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Profesion profesion= new Profesion();

		try {
			ProfesionDataAccess profesionDataAccess=new ProfesionDataAccess();

			profesionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			profesionDataAccess.setConnexionType(this.connexionType);
			profesionDataAccess.setParameterDbType(this.parameterDbType);

			profesion=profesionDataAccess.getEntity(connexion,relcliente.getid_profesion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return profesion;

	}

	public TipoGenero getTipoGenero(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		TipoGenero tipogenero= new TipoGenero();

		try {
			TipoGeneroDataAccess tipogeneroDataAccess=new TipoGeneroDataAccess();

			tipogeneroDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogeneroDataAccess.setConnexionType(this.connexionType);
			tipogeneroDataAccess.setParameterDbType(this.parameterDbType);

			tipogenero=tipogeneroDataAccess.getEntity(connexion,relcliente.getid_tipo_genero());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogenero;

	}

	public EstadoCivil getEstadoCivil(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		EstadoCivil estadocivil= new EstadoCivil();

		try {
			EstadoCivilDataAccess estadocivilDataAccess=new EstadoCivilDataAccess();

			estadocivilDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadocivilDataAccess.setConnexionType(this.connexionType);
			estadocivilDataAccess.setParameterDbType(this.parameterDbType);

			estadocivil=estadocivilDataAccess.getEntity(connexion,relcliente.getid_estado_civil());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadocivil;

	}

	public EstadoLegal getEstadoLegal(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		EstadoLegal estadolegal= new EstadoLegal();

		try {
			EstadoLegalDataAccess estadolegalDataAccess=new EstadoLegalDataAccess();

			estadolegalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadolegalDataAccess.setConnexionType(this.connexionType);
			estadolegalDataAccess.setParameterDbType(this.parameterDbType);

			estadolegal=estadolegalDataAccess.getEntity(connexion,relcliente.getid_estado_legal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadolegal;

	}

	public CuentaContable getCuentaContable(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcliente.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Ruta getRuta(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Ruta ruta= new Ruta();

		try {
			RutaDataAccess rutaDataAccess=new RutaDataAccess();

			rutaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rutaDataAccess.setConnexionType(this.connexionType);
			rutaDataAccess.setParameterDbType(this.parameterDbType);

			ruta=rutaDataAccess.getEntity(connexion,relcliente.getid_ruta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ruta;

	}

	public Vendedor getVendedor(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relcliente.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public CentroActividad getCentroActividad(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		CentroActividad centroactividad= new CentroActividad();

		try {
			CentroActividadDataAccess centroactividadDataAccess=new CentroActividadDataAccess();

			centroactividadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centroactividadDataAccess.setConnexionType(this.connexionType);
			centroactividadDataAccess.setParameterDbType(this.parameterDbType);

			centroactividad=centroactividadDataAccess.getEntity(connexion,relcliente.getid_centro_actividad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centroactividad;

	}

	public TipoGarantiaEmpresa getTipoGarantiaEmpresa(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		TipoGarantiaEmpresa tipogarantiaempresa= new TipoGarantiaEmpresa();

		try {
			TipoGarantiaEmpresaDataAccess tipogarantiaempresaDataAccess=new TipoGarantiaEmpresaDataAccess();

			tipogarantiaempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogarantiaempresaDataAccess.setConnexionType(this.connexionType);
			tipogarantiaempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipogarantiaempresa=tipogarantiaempresaDataAccess.getEntity(connexion,relcliente.getid_tipo_garantia_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogarantiaempresa;

	}

	public CateTipoAfiliacion getCateTipoAfiliacion(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		CateTipoAfiliacion catetipoafiliacion= new CateTipoAfiliacion();

		try {
			CateTipoAfiliacionDataAccess catetipoafiliacionDataAccess=new CateTipoAfiliacionDataAccess();

			catetipoafiliacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			catetipoafiliacionDataAccess.setConnexionType(this.connexionType);
			catetipoafiliacionDataAccess.setParameterDbType(this.parameterDbType);

			catetipoafiliacion=catetipoafiliacionDataAccess.getEntity(connexion,relcliente.getid_cate_tipo_afiliacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return catetipoafiliacion;

	}

	public Dia getDia(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Dia dia= new Dia();

		try {
			DiaDataAccess diaDataAccess=new DiaDataAccess();

			diaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			diaDataAccess.setConnexionType(this.connexionType);
			diaDataAccess.setParameterDbType(this.parameterDbType);

			dia=diaDataAccess.getEntity(connexion,relcliente.getid_dia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return dia;

	}

	public Empleado getEmpleado(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relcliente.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relcliente.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public TipoListaPrecio getTipoListaPrecio(Connexion connexion,Cliente relcliente)throws SQLException,Exception {

		TipoListaPrecio tipolistaprecio= new TipoListaPrecio();

		try {
			TipoListaPrecioDataAccess tipolistaprecioDataAccess=new TipoListaPrecioDataAccess();

			tipolistaprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipolistaprecioDataAccess.setConnexionType(this.connexionType);
			tipolistaprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipolistaprecio=tipolistaprecioDataAccess.getEntity(connexion,relcliente.getid_tipo_lista_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipolistaprecio;

	}


		
		public List<TransaccionLocal> getTransaccionLocals(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<TransaccionLocal> transaccionlocals= new ArrayList<TransaccionLocal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+TransaccionLocalConstantesFunciones.SCHEMA+".transaccion_local.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN transaccionlocal.Cliente WHERE transaccionlocal.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransaccionLocalDataAccess transaccionlocalDataAccess=new TransaccionLocalDataAccess();

			transaccionlocalDataAccess.setConnexionType(this.connexionType);
			transaccionlocalDataAccess.setParameterDbType(this.parameterDbType);
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccionlocals;

	}

	public List<Proforma> getProformas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Proforma> proformas= new ArrayList<Proforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ProformaConstantesFunciones.SCHEMA+".proforma.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN proforma.Cliente WHERE proforma.Cliente.id="+String.valueOf(cliente.getId());

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

	public List<Producto> getProductos(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Producto> productos= new ArrayList<Producto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ProductoConstantesFunciones.SCHEMA+".producto.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN producto.Cliente WHERE producto.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productos;

	}

	public List<InformacionLaboral> getInformacionLaborals(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<InformacionLaboral> informacionlaborals= new ArrayList<InformacionLaboral>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+InformacionLaboralConstantesFunciones.SCHEMA+".informacionlaboral.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN informacionlaboral.Cliente WHERE informacionlaboral.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			InformacionLaboralDataAccess informacionlaboralDataAccess=new InformacionLaboralDataAccess();

			informacionlaboralDataAccess.setConnexionType(this.connexionType);
			informacionlaboralDataAccess.setParameterDbType(this.parameterDbType);
			informacionlaborals=informacionlaboralDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return informacionlaborals;

	}

	public List<Transportista> getTransportistas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Transportista> transportistas= new ArrayList<Transportista>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+TransportistaConstantesFunciones.SCHEMA+".transportista.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN transportista.Cliente WHERE transportista.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);
			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportistas;

	}

	public List<RegistroFormaPagoBanco> getRegistroFormaPagoBancos(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<RegistroFormaPagoBanco> registroformapagobancos= new ArrayList<RegistroFormaPagoBanco>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+".registro_forma_pago_banco.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN registroformapagobanco.Cliente WHERE registroformapagobanco.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RegistroFormaPagoBancoDataAccess registroformapagobancoDataAccess=new RegistroFormaPagoBancoDataAccess();

			registroformapagobancoDataAccess.setConnexionType(this.connexionType);
			registroformapagobancoDataAccess.setParameterDbType(this.parameterDbType);
			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return registroformapagobancos;

	}

	public List<Novedad> getNovedads(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Novedad> novedads= new ArrayList<Novedad>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+NovedadConstantesFunciones.SCHEMA+".novedad.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN novedad.Cliente WHERE novedad.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NovedadDataAccess novedadDataAccess=new NovedadDataAccess();

			novedadDataAccess.setConnexionType(this.connexionType);
			novedadDataAccess.setParameterDbType(this.parameterDbType);
			novedads=novedadDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedads;

	}

	public PoliticasCliente getPoliticasCliente(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		PoliticasCliente politicascliente= new PoliticasCliente();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+PoliticasClienteConstantesFunciones.SCHEMA+".politicas_cliente.id="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN politicascliente.Cliente WHERE politicascliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PoliticasClienteDataAccess politicasclienteDataAccess=new PoliticasClienteDataAccess();

			politicasclienteDataAccess.setConnexionType(this.connexionType);
			politicasclienteDataAccess.setParameterDbType(this.parameterDbType);
			politicascliente=politicasclienteDataAccess.getEntity(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return politicascliente;

	}

	public List<FacturaProveedor> getFacturaProveedors(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<FacturaProveedor> facturaproveedors= new ArrayList<FacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedor.Cliente WHERE facturaproveedor.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorDataAccess facturaproveedorDataAccess=new FacturaProveedorDataAccess();

			facturaproveedorDataAccess.setConnexionType(this.connexionType);
			facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedors;

	}

	public List<ReferenciaPersonal> getReferenciaPersonals(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ReferenciaPersonal> referenciapersonals= new ArrayList<ReferenciaPersonal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ReferenciaPersonalConstantesFunciones.SCHEMA+".referenciapersonal.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN referenciapersonal.Cliente WHERE referenciapersonal.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ReferenciaPersonalDataAccess referenciapersonalDataAccess=new ReferenciaPersonalDataAccess();

			referenciapersonalDataAccess.setConnexionType(this.connexionType);
			referenciapersonalDataAccess.setParameterDbType(this.parameterDbType);
			referenciapersonals=referenciapersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return referenciapersonals;

	}

	public List<BalanceGeneralCliente> getBalanceGeneralClientes(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<BalanceGeneralCliente> balancegeneralclientes= new ArrayList<BalanceGeneralCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+BalanceGeneralClienteConstantesFunciones.SCHEMA+".balance_general_cliente.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN balancegeneralcliente.Cliente WHERE balancegeneralcliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			BalanceGeneralClienteDataAccess balancegeneralclienteDataAccess=new BalanceGeneralClienteDataAccess();

			balancegeneralclienteDataAccess.setConnexionType(this.connexionType);
			balancegeneralclienteDataAccess.setParameterDbType(this.parameterDbType);
			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return balancegeneralclientes;

	}

	public List<CajaIngresoDetalle> getCajaIngresoDetalles(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<CajaIngresoDetalle> cajaingresodetalles= new ArrayList<CajaIngresoDetalle>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+CajaIngresoDetalleConstantesFunciones.SCHEMA+".caja_ingreso_detalle.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN cajaingresodetalle.Cliente WHERE cajaingresodetalle.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajaIngresoDetalleDataAccess cajaingresodetalleDataAccess=new CajaIngresoDetalleDataAccess();

			cajaingresodetalleDataAccess.setConnexionType(this.connexionType);
			cajaingresodetalleDataAccess.setParameterDbType(this.parameterDbType);
			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajaingresodetalles;

	}

	public List<PoliticaCliente> getPoliticaClientes(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<PoliticaCliente> politicaclientes= new ArrayList<PoliticaCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+PoliticaClienteConstantesFunciones.SCHEMA+".politica_cliente.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN politicacliente.Cliente WHERE politicacliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PoliticaClienteDataAccess politicaclienteDataAccess=new PoliticaClienteDataAccess();

			politicaclienteDataAccess.setConnexionType(this.connexionType);
			politicaclienteDataAccess.setParameterDbType(this.parameterDbType);
			politicaclientes=politicaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return politicaclientes;

	}

	public List<AutoriConsep> getAutoriConseps(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<AutoriConsep> autoriconseps= new ArrayList<AutoriConsep>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+AutoriConsepConstantesFunciones.SCHEMA+".autori_consep.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN autoriconsep.Cliente WHERE autoriconsep.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriConsepDataAccess autoriconsepDataAccess=new AutoriConsepDataAccess();

			autoriconsepDataAccess.setConnexionType(this.connexionType);
			autoriconsepDataAccess.setParameterDbType(this.parameterDbType);
			autoriconseps=autoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoriconseps;

	}

	public List<DetalleActivoFijo> getDetalleActivoFijos(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<DetalleActivoFijo> detalleactivofijos= new ArrayList<DetalleActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN detalleactivofijo.Cliente WHERE detalleactivofijo.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijos;

	}

	public List<ReciboPuntoVenta> getReciboPuntoVentas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ReciboPuntoVenta> recibopuntoventas= new ArrayList<ReciboPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ReciboPuntoVentaConstantesFunciones.SCHEMA+".recibo_punto_venta.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN recibopuntoventa.Cliente WHERE recibopuntoventa.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ReciboPuntoVentaDataAccess recibopuntoventaDataAccess=new ReciboPuntoVentaDataAccess();

			recibopuntoventaDataAccess.setConnexionType(this.connexionType);
			recibopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			recibopuntoventas=recibopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return recibopuntoventas;

	}

	public List<ClienteRetencion> getClienteRetencions(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ClienteRetencion> clienteretencions= new ArrayList<ClienteRetencion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ClienteRetencionConstantesFunciones.SCHEMA+".cliente_retencion.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN clienteretencion.Cliente WHERE clienteretencion.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteRetencionDataAccess clienteretencionDataAccess=new ClienteRetencionDataAccess();

			clienteretencionDataAccess.setConnexionType(this.connexionType);
			clienteretencionDataAccess.setParameterDbType(this.parameterDbType);
			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clienteretencions;

	}

	public List<AsientoContable> getAsientoContables(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<AsientoContable> asientocontables= new ArrayList<AsientoContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN asientocontable.Cliente WHERE asientocontable.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);
			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontables;

	}

	public List<AutoriPagoOrdenCompra> getAutoriPagoOrdenCompras(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<AutoriPagoOrdenCompra> autoripagoordencompras= new ArrayList<AutoriPagoOrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+".autori_pago_orden_compra.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN autoripagoordencompra.Cliente WHERE autoripagoordencompra.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriPagoOrdenCompraDataAccess autoripagoordencompraDataAccess=new AutoriPagoOrdenCompraDataAccess();

			autoripagoordencompraDataAccess.setConnexionType(this.connexionType);
			autoripagoordencompraDataAccess.setParameterDbType(this.parameterDbType);
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoripagoordencompras;

	}

	public List<OrdenCompra> getOrdenCompras(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<OrdenCompra> ordencompras= new ArrayList<OrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN ordencompra.Cliente WHERE ordencompra.Cliente.id="+String.valueOf(cliente.getId());

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

	public List<AsientoContableCajaChica> getAsientoContableCajaChicas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<AsientoContableCajaChica> asientocontablecajachicas= new ArrayList<AsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+".asiento_contable_caja_chica.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN asientocontablecajachica.Cliente WHERE asientocontablecajachica.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableCajaChicaDataAccess asientocontablecajachicaDataAccess=new AsientoContableCajaChicaDataAccess();

			asientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			asientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontablecajachicas;

	}

	public List<Retencion> getRetencions(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Retencion> retencions= new ArrayList<Retencion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+RetencionConstantesFunciones.SCHEMA+".retencion.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN retencion.Cliente WHERE retencion.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RetencionDataAccess retencionDataAccess=new RetencionDataAccess();

			retencionDataAccess.setConnexionType(this.connexionType);
			retencionDataAccess.setParameterDbType(this.parameterDbType);
			retencions=retencionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return retencions;

	}

	public List<NotaCredito> getNotaCreditos(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<NotaCredito> notacreditos= new ArrayList<NotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+NotaCreditoConstantesFunciones.SCHEMA+".nota_credito.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN notacredito.Cliente WHERE notacredito.Cliente.id="+String.valueOf(cliente.getId());

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

	public List<DetalleRecap> getDetalleRecaps(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<DetalleRecap> detallerecaps= new ArrayList<DetalleRecap>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+DetalleRecapConstantesFunciones.SCHEMA+".detalle_recap.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN detallerecap.Cliente WHERE detallerecap.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleRecapDataAccess detallerecapDataAccess=new DetalleRecapDataAccess();

			detallerecapDataAccess.setConnexionType(this.connexionType);
			detallerecapDataAccess.setParameterDbType(this.parameterDbType);
			detallerecaps=detallerecapDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallerecaps;

	}

	public List<VehiculoCliente> getVehiculoClientes(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<VehiculoCliente> vehiculoclientes= new ArrayList<VehiculoCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+VehiculoClienteConstantesFunciones.SCHEMA+".vehiculo_cliente.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN vehiculocliente.Cliente WHERE vehiculocliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			VehiculoClienteDataAccess vehiculoclienteDataAccess=new VehiculoClienteDataAccess();

			vehiculoclienteDataAccess.setConnexionType(this.connexionType);
			vehiculoclienteDataAccess.setParameterDbType(this.parameterDbType);
			vehiculoclientes=vehiculoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vehiculoclientes;

	}

	public List<ProductoProveedor> getProductoProveedors(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ProductoProveedor> productoproveedors= new ArrayList<ProductoProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ProductoProveedorConstantesFunciones.SCHEMA+".producto_proveedord.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN productoproveedor.Cliente WHERE productoproveedor.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoProveedorDataAccess productoproveedorDataAccess=new ProductoProveedorDataAccess();

			productoproveedorDataAccess.setConnexionType(this.connexionType);
			productoproveedorDataAccess.setParameterDbType(this.parameterDbType);
			productoproveedors=productoproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoproveedors;

	}

	public List<RequisicionCompra> getRequisicionCompras(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<RequisicionCompra> requisicioncompras= new ArrayList<RequisicionCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+RequisicionCompraConstantesFunciones.SCHEMA+".requisicion_compra.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN requisicioncompra.Cliente WHERE requisicioncompra.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RequisicionCompraDataAccess requisicioncompraDataAccess=new RequisicionCompraDataAccess();

			requisicioncompraDataAccess.setConnexionType(this.connexionType);
			requisicioncompraDataAccess.setParameterDbType(this.parameterDbType);
			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return requisicioncompras;

	}

	public List<Responsable> getResponsables(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Responsable> responsables= new ArrayList<Responsable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ResponsableConstantesFunciones.SCHEMA+".responsable.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN responsable.Cliente WHERE responsable.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ResponsableDataAccess responsableDataAccess=new ResponsableDataAccess();

			responsableDataAccess.setConnexionType(this.connexionType);
			responsableDataAccess.setParameterDbType(this.parameterDbType);
			responsables=responsableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return responsables;

	}

	public List<FacturaPuntoVenta> getFacturaPuntoVentas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<FacturaPuntoVenta> facturapuntoventas= new ArrayList<FacturaPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+FacturaPuntoVentaConstantesFunciones.SCHEMA+".factura_punto_venta.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN facturapuntoventa.Cliente WHERE facturapuntoventa.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaPuntoVentaDataAccess facturapuntoventaDataAccess=new FacturaPuntoVentaDataAccess();

			facturapuntoventaDataAccess.setConnexionType(this.connexionType);
			facturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			facturapuntoventas=facturapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturapuntoventas;

	}

	public List<InformacionFinanciera> getInformacionFinancieras(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<InformacionFinanciera> informacionfinancieras= new ArrayList<InformacionFinanciera>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+InformacionFinancieraConstantesFunciones.SCHEMA+".informacionfinanciera.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN informacionfinanciera.Cliente WHERE informacionfinanciera.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			InformacionFinancieraDataAccess informacionfinancieraDataAccess=new InformacionFinancieraDataAccess();

			informacionfinancieraDataAccess.setConnexionType(this.connexionType);
			informacionfinancieraDataAccess.setParameterDbType(this.parameterDbType);
			informacionfinancieras=informacionfinancieraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return informacionfinancieras;

	}

	public List<CajaEgresoDetalle> getCajaEgresoDetalles(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<CajaEgresoDetalle> cajaegresodetalles= new ArrayList<CajaEgresoDetalle>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+CajaEgresoDetalleConstantesFunciones.SCHEMA+".caja_egreso_detalle.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN cajaegresodetalle.Cliente WHERE cajaegresodetalle.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajaEgresoDetalleDataAccess cajaegresodetalleDataAccess=new CajaEgresoDetalleDataAccess();

			cajaegresodetalleDataAccess.setConnexionType(this.connexionType);
			cajaegresodetalleDataAccess.setParameterDbType(this.parameterDbType);
			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajaegresodetalles;

	}

	public List<Consignatario> getConsignatarios(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Consignatario> consignatarios= new ArrayList<Consignatario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ConsignatarioConstantesFunciones.SCHEMA+".consignatario.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN consignatario.Cliente WHERE consignatario.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConsignatarioDataAccess consignatarioDataAccess=new ConsignatarioDataAccess();

			consignatarioDataAccess.setConnexionType(this.connexionType);
			consignatarioDataAccess.setParameterDbType(this.parameterDbType);
			consignatarios=consignatarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consignatarios;

	}

	public List<ClienteImagen> getClienteImagens(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ClienteImagen> clienteimagens= new ArrayList<ClienteImagen>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ClienteImagenConstantesFunciones.SCHEMA+".cliente_imagen.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN clienteimagen.Cliente WHERE clienteimagen.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteImagenDataAccess clienteimagenDataAccess=new ClienteImagenDataAccess();

			clienteimagenDataAccess.setConnexionType(this.connexionType);
			clienteimagenDataAccess.setParameterDbType(this.parameterDbType);
			clienteimagens=clienteimagenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clienteimagens;

	}

	public List<FacturaDiario> getFacturaDiarios(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<FacturaDiario> facturadiarios= new ArrayList<FacturaDiario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+FacturaDiarioConstantesFunciones.SCHEMA+".factura_diario.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN facturadiario.Cliente WHERE facturadiario.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaDiarioDataAccess facturadiarioDataAccess=new FacturaDiarioDataAccess();

			facturadiarioDataAccess.setConnexionType(this.connexionType);
			facturadiarioDataAccess.setParameterDbType(this.parameterDbType);
			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturadiarios;

	}

	public List<GarantiaCliente> getGarantiaClientes(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<GarantiaCliente> garantiaclientes= new ArrayList<GarantiaCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+GarantiaClienteConstantesFunciones.SCHEMA+".garantia_cliente.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN garantiacliente.Cliente WHERE garantiacliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GarantiaClienteDataAccess garantiaclienteDataAccess=new GarantiaClienteDataAccess();

			garantiaclienteDataAccess.setConnexionType(this.connexionType);
			garantiaclienteDataAccess.setParameterDbType(this.parameterDbType);
			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return garantiaclientes;

	}

	public List<InformacionEconomica> getInformacionEconomicas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<InformacionEconomica> informacioneconomicas= new ArrayList<InformacionEconomica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+InformacionEconomicaConstantesFunciones.SCHEMA+".informacioneconomica.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN informacioneconomica.Cliente WHERE informacioneconomica.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			InformacionEconomicaDataAccess informacioneconomicaDataAccess=new InformacionEconomicaDataAccess();

			informacioneconomicaDataAccess.setConnexionType(this.connexionType);
			informacioneconomicaDataAccess.setParameterDbType(this.parameterDbType);
			informacioneconomicas=informacioneconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return informacioneconomicas;

	}

	public List<ReferenciaComercial> getReferenciaComercials(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ReferenciaComercial> referenciacomercials= new ArrayList<ReferenciaComercial>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ReferenciaComercialConstantesFunciones.SCHEMA+".referenciacomercial.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN referenciacomercial.Cliente WHERE referenciacomercial.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ReferenciaComercialDataAccess referenciacomercialDataAccess=new ReferenciaComercialDataAccess();

			referenciacomercialDataAccess.setConnexionType(this.connexionType);
			referenciacomercialDataAccess.setParameterDbType(this.parameterDbType);
			referenciacomercials=referenciacomercialDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return referenciacomercials;

	}

	public List<Bien> getBiens(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Bien> biens= new ArrayList<Bien>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+BienConstantesFunciones.SCHEMA+".bien.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN bien.Cliente WHERE bien.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			BienDataAccess bienDataAccess=new BienDataAccess();

			bienDataAccess.setConnexionType(this.connexionType);
			bienDataAccess.setParameterDbType(this.parameterDbType);
			biens=bienDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return biens;

	}

	public List<ServicioTransporte> getServicioTransporteProveedors(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ServicioTransporte> serviciotransporteproveedors= new ArrayList<ServicioTransporte>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ServicioTransporteConstantesFunciones.SCHEMA+".servicio_transporte.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN serviciotransporte.ClienteProveedor WHERE serviciotransporte.ClienteProveedor.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ServicioTransporteDataAccess serviciotransporteDataAccess=new ServicioTransporteDataAccess();

			serviciotransporteDataAccess.setConnexionType(this.connexionType);
			serviciotransporteDataAccess.setParameterDbType(this.parameterDbType);
			serviciotransporteproveedors=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return serviciotransporteproveedors;

	}

	public List<PedidoPuntoVenta> getPedidoPuntoVentas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<PedidoPuntoVenta> pedidopuntoventas= new ArrayList<PedidoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+PedidoPuntoVentaConstantesFunciones.SCHEMA+".pedido_punto_venta.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN pedidopuntoventa.Cliente WHERE pedidopuntoventa.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoPuntoVentaDataAccess pedidopuntoventaDataAccess=new PedidoPuntoVentaDataAccess();

			pedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			pedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidopuntoventas;

	}

	public List<NotaCreditoSoli> getNotaCreditoSolis(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<NotaCreditoSoli> notacreditosolis= new ArrayList<NotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN notacreditosoli.Cliente WHERE notacreditosoli.Cliente.id="+String.valueOf(cliente.getId());

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

	public List<ProveedorProducto> getProveedorProductos(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ProveedorProducto> proveedorproductos= new ArrayList<ProveedorProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ProveedorProductoConstantesFunciones.SCHEMA+".proveedor_producto.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN proveedorproducto.Cliente WHERE proveedorproducto.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProveedorProductoDataAccess proveedorproductoDataAccess=new ProveedorProductoDataAccess();

			proveedorproductoDataAccess.setConnexionType(this.connexionType);
			proveedorproductoDataAccess.setParameterDbType(this.parameterDbType);
			proveedorproductos=proveedorproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return proveedorproductos;

	}

	public List<ServicioCliente> getServicioClientes(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ServicioCliente> servicioclientes= new ArrayList<ServicioCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ServicioClienteConstantesFunciones.SCHEMA+".servicio_cliente.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN serviciocliente.Cliente WHERE serviciocliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ServicioClienteDataAccess servicioclienteDataAccess=new ServicioClienteDataAccess();

			servicioclienteDataAccess.setConnexionType(this.connexionType);
			servicioclienteDataAccess.setParameterDbType(this.parameterDbType);
			servicioclientes=servicioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return servicioclientes;

	}

	public List<Consignacion> getConsignacions(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Consignacion> consignacions= new ArrayList<Consignacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ConsignacionConstantesFunciones.SCHEMA+".consignacion.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN consignacion.Cliente WHERE consignacion.Cliente.id="+String.valueOf(cliente.getId());

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

	public List<ContactoCliente> getContactoClientes(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ContactoCliente> contactoclientes= new ArrayList<ContactoCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ContactoClienteConstantesFunciones.SCHEMA+".contacto_cliente.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN contactocliente.Cliente WHERE contactocliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ContactoClienteDataAccess contactoclienteDataAccess=new ContactoClienteDataAccess();

			contactoclienteDataAccess.setConnexionType(this.connexionType);
			contactoclienteDataAccess.setParameterDbType(this.parameterDbType);
			contactoclientes=contactoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return contactoclientes;

	}

	public List<LiquidacionImpuestoImpor> getLiquidacionImpuestoImpors(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors= new ArrayList<LiquidacionImpuestoImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+LiquidacionImpuestoImporConstantesFunciones.SCHEMA+".liquidacion_impuesto_impor.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN liquidacionimpuestoimpor.Cliente WHERE liquidacionimpuestoimpor.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			LiquidacionImpuestoImporDataAccess liquidacionimpuestoimporDataAccess=new LiquidacionImpuestoImporDataAccess();

			liquidacionimpuestoimporDataAccess.setConnexionType(this.connexionType);
			liquidacionimpuestoimporDataAccess.setParameterDbType(this.parameterDbType);
			liquidacionimpuestoimpors=liquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return liquidacionimpuestoimpors;

	}

	public List<DetalleCliente> getDetalleClientes(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<DetalleCliente> detalleclientes= new ArrayList<DetalleCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+DetalleClienteConstantesFunciones.SCHEMA+".detalle_cliente.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN detallecliente.Cliente WHERE detallecliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleClienteDataAccess detalleclienteDataAccess=new DetalleClienteDataAccess();

			detalleclienteDataAccess.setConnexionType(this.connexionType);
			detalleclienteDataAccess.setParameterDbType(this.parameterDbType);
			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleclientes;

	}

	public List<Pedido> getPedidos(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Pedido> pedidos= new ArrayList<Pedido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+PedidoConstantesFunciones.SCHEMA+".pedido.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN pedido.Cliente WHERE pedido.Cliente.id="+String.valueOf(cliente.getId());

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

	public List<DatoConstitucion> getDatoConstitucions(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<DatoConstitucion> datoconstitucions= new ArrayList<DatoConstitucion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+DatoConstitucionConstantesFunciones.SCHEMA+".datoconstitucion.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN datoconstitucion.Cliente WHERE datoconstitucion.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DatoConstitucionDataAccess datoconstitucionDataAccess=new DatoConstitucionDataAccess();

			datoconstitucionDataAccess.setConnexionType(this.connexionType);
			datoconstitucionDataAccess.setParameterDbType(this.parameterDbType);
			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datoconstitucions;

	}

	public List<ClienteCoa> getClienteCoas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ClienteCoa> clientecoas= new ArrayList<ClienteCoa>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ClienteCoaConstantesFunciones.SCHEMA+".cliente_coa.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN clientecoa.Cliente WHERE clientecoa.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteCoaDataAccess clientecoaDataAccess=new ClienteCoaDataAccess();

			clientecoaDataAccess.setConnexionType(this.connexionType);
			clientecoaDataAccess.setParameterDbType(this.parameterDbType);
			clientecoas=clientecoaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clientecoas;

	}

	public List<HobbyCliente> getHobbyClientes(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<HobbyCliente> hobbyclientes= new ArrayList<HobbyCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+HobbyClienteConstantesFunciones.SCHEMA+".hobby_cliente.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN hobbycliente.Cliente WHERE hobbycliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			HobbyClienteDataAccess hobbyclienteDataAccess=new HobbyClienteDataAccess();

			hobbyclienteDataAccess.setConnexionType(this.connexionType);
			hobbyclienteDataAccess.setParameterDbType(this.parameterDbType);
			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return hobbyclientes;

	}

	public List<PagoAuto> getPagoAutos(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<PagoAuto> pagoautos= new ArrayList<PagoAuto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+PagoAutoConstantesFunciones.SCHEMA+".pago_auto.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN pagoauto.Cliente WHERE pagoauto.Cliente.id="+String.valueOf(cliente.getId());

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

	public List<TareaCliente> getTareaClientes(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<TareaCliente> tareaclientes= new ArrayList<TareaCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+TareaClienteConstantesFunciones.SCHEMA+".tarea_cliente.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN tareacliente.Cliente WHERE tareacliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TareaClienteDataAccess tareaclienteDataAccess=new TareaClienteDataAccess();

			tareaclienteDataAccess.setConnexionType(this.connexionType);
			tareaclienteDataAccess.setParameterDbType(this.parameterDbType);
			tareaclientes=tareaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tareaclientes;

	}

	public List<CargaFamiliar> getCargaFamiliars(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<CargaFamiliar> cargafamiliars= new ArrayList<CargaFamiliar>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+CargaFamiliarConstantesFunciones.SCHEMA+".carga_familiar.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN cargafamiliar.Cliente WHERE cargafamiliar.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CargaFamiliarDataAccess cargafamiliarDataAccess=new CargaFamiliarDataAccess();

			cargafamiliarDataAccess.setConnexionType(this.connexionType);
			cargafamiliarDataAccess.setParameterDbType(this.parameterDbType);
			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargafamiliars;

	}

	public List<PedidoCompraImpor> getPedidoCompraImporProveedors(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<PedidoCompraImpor> pedidocompraimporproveedors= new ArrayList<PedidoCompraImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN pedidocompraimpor.ClienteProveedor WHERE pedidocompraimpor.ClienteProveedor.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraImporDataAccess pedidocompraimporDataAccess=new PedidoCompraImporDataAccess();

			pedidocompraimporDataAccess.setConnexionType(this.connexionType);
			pedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompraimporproveedors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompraimporproveedors;

	}

	public List<EvaluacionProveedor> getEvaluacionProveedors(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<EvaluacionProveedor> evaluacionproveedors= new ArrayList<EvaluacionProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+EvaluacionProveedorConstantesFunciones.SCHEMA+".evaluacion_proveedor.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN evaluacionproveedor.Cliente WHERE evaluacionproveedor.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EvaluacionProveedorDataAccess evaluacionproveedorDataAccess=new EvaluacionProveedorDataAccess();

			evaluacionproveedorDataAccess.setConnexionType(this.connexionType);
			evaluacionproveedorDataAccess.setParameterDbType(this.parameterDbType);
			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return evaluacionproveedors;

	}

	public List<EMail> getEMails(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<EMail> emails= new ArrayList<EMail>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+EMailConstantesFunciones.SCHEMA+".e_mail.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN email.Cliente WHERE email.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EMailDataAccess emailDataAccess=new EMailDataAccess();

			emailDataAccess.setConnexionType(this.connexionType);
			emailDataAccess.setParameterDbType(this.parameterDbType);
			emails=emailDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return emails;

	}

	public Conyuge getConyuge(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		Conyuge conyuge= new Conyuge();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ConyugeConstantesFunciones.SCHEMA+".conyuge.id="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN conyuge.Cliente WHERE conyuge.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConyugeDataAccess conyugeDataAccess=new ConyugeDataAccess();

			conyugeDataAccess.setConnexionType(this.connexionType);
			conyugeDataAccess.setParameterDbType(this.parameterDbType);
			conyuge=conyugeDataAccess.getEntity(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return conyuge;

	}

	public List<PedidoCompra> getPedidoCompras(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<PedidoCompra> pedidocompras= new ArrayList<PedidoCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+PedidoCompraConstantesFunciones.SCHEMA+".pedido_compra.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN pedidocompra.Cliente WHERE pedidocompra.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraDataAccess pedidocompraDataAccess=new PedidoCompraDataAccess();

			pedidocompraDataAccess.setConnexionType(this.connexionType);
			pedidocompraDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompras;

	}

	public List<PedidoExpor> getPedidoExpors(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<PedidoExpor> pedidoexpors= new ArrayList<PedidoExpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+PedidoExporConstantesFunciones.SCHEMA+".pedido_expor.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN pedidoexpor.Cliente WHERE pedidoexpor.Cliente.id="+String.valueOf(cliente.getId());

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

	public List<DetalleProve> getDetalleProves(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<DetalleProve> detalleproves= new ArrayList<DetalleProve>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+DetalleProveConstantesFunciones.SCHEMA+".detalle_prove.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN detalleprove.Cliente WHERE detalleprove.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleProveDataAccess detalleproveDataAccess=new DetalleProveDataAccess();

			detalleproveDataAccess.setConnexionType(this.connexionType);
			detalleproveDataAccess.setParameterDbType(this.parameterDbType);
			detalleproves=detalleproveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleproves;

	}

	public List<CuentaPorCobrar> getCuentaPorCobrars(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<CuentaPorCobrar> cuentaporcobrars= new ArrayList<CuentaPorCobrar>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+CuentaPorCobrarConstantesFunciones.SCHEMA+".cuenta_por_cobrar.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN cuentaporcobrar.Cliente WHERE cuentaporcobrar.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaPorCobrarDataAccess cuentaporcobrarDataAccess=new CuentaPorCobrarDataAccess();

			cuentaporcobrarDataAccess.setConnexionType(this.connexionType);
			cuentaporcobrarDataAccess.setParameterDbType(this.parameterDbType);
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentaporcobrars;

	}

	public List<Factura> getFacturas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Factura> facturas= new ArrayList<Factura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+FacturaConstantesFunciones.SCHEMA+".factura.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN factura.Cliente WHERE factura.Cliente.id="+String.valueOf(cliente.getId());

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

	public List<ImportarExportar> getImportarExportars(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ImportarExportar> importarexportars= new ArrayList<ImportarExportar>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ImportarExportarConstantesFunciones.SCHEMA+".importar_exportar.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN importarexportar.Cliente WHERE importarexportar.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ImportarExportarDataAccess importarexportarDataAccess=new ImportarExportarDataAccess();

			importarexportarDataAccess.setConnexionType(this.connexionType);
			importarexportarDataAccess.setParameterDbType(this.parameterDbType);
			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return importarexportars;

	}

	public List<FirmaCliente> getFirmaClientes(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<FirmaCliente> firmaclientes= new ArrayList<FirmaCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+FirmaClienteConstantesFunciones.SCHEMA+".firma_cliente.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN firmacliente.Cliente WHERE firmacliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FirmaClienteDataAccess firmaclienteDataAccess=new FirmaClienteDataAccess();

			firmaclienteDataAccess.setConnexionType(this.connexionType);
			firmaclienteDataAccess.setParameterDbType(this.parameterDbType);
			firmaclientes=firmaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return firmaclientes;

	}

	public List<DetalleDescuenPoliVenta> getDetalleDescuenPoliVentas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<DetalleDescuenPoliVenta> detalledescuenpoliventas= new ArrayList<DetalleDescuenPoliVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+DetalleDescuenPoliVentaConstantesFunciones.SCHEMA+".detalle_descuen_poli_venta.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN detalledescuenpoliventa.Cliente WHERE detalledescuenpoliventa.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleDescuenPoliVentaDataAccess detalledescuenpoliventaDataAccess=new DetalleDescuenPoliVentaDataAccess();

			detalledescuenpoliventaDataAccess.setConnexionType(this.connexionType);
			detalledescuenpoliventaDataAccess.setParameterDbType(this.parameterDbType);
			detalledescuenpoliventas=detalledescuenpoliventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalledescuenpoliventas;

	}

	public List<ProductoProduGasto> getProductoProduGastoProveedors(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ProductoProduGasto> productoprodugastoproveedors= new ArrayList<ProductoProduGasto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ProductoProduGastoConstantesFunciones.SCHEMA+".producto_produ_gasto.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN productoprodugasto.ClienteProveedor WHERE productoprodugasto.ClienteProveedor.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoProduGastoDataAccess productoprodugastoDataAccess=new ProductoProduGastoDataAccess();

			productoprodugastoDataAccess.setConnexionType(this.connexionType);
			productoprodugastoDataAccess.setParameterDbType(this.parameterDbType);
			productoprodugastoproveedors=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoprodugastoproveedors;

	}

	public List<Sri> getSris(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Sri> sris= new ArrayList<Sri>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+SriConstantesFunciones.SCHEMA+".sri.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN sri.Cliente WHERE sri.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SriDataAccess sriDataAccess=new SriDataAccess();

			sriDataAccess.setConnexionType(this.connexionType);
			sriDataAccess.setParameterDbType(this.parameterDbType);
			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sris;

	}

	public List<GuiaRemision> getGuiaRemisions(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<GuiaRemision> guiaremisions= new ArrayList<GuiaRemision>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN guiaremision.Cliente WHERE guiaremision.Cliente.id="+String.valueOf(cliente.getId());

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

	public List<CuentaBancoPunVen> getCuentaBancoPunVens(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<CuentaBancoPunVen> cuentabancopunvens= new ArrayList<CuentaBancoPunVen>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+CuentaBancoPunVenConstantesFunciones.SCHEMA+".cuenta_banco_pun_ven.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN cuentabancopunven.Cliente WHERE cuentabancopunven.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaBancoPunVenDataAccess cuentabancopunvenDataAccess=new CuentaBancoPunVenDataAccess();

			cuentabancopunvenDataAccess.setConnexionType(this.connexionType);
			cuentabancopunvenDataAccess.setParameterDbType(this.parameterDbType);
			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentabancopunvens;

	}

	public List<RepresentanteLegal> getRepresentanteLegals(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<RepresentanteLegal> representantelegals= new ArrayList<RepresentanteLegal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+RepresentanteLegalConstantesFunciones.SCHEMA+".representantelegal.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN representantelegal.Cliente WHERE representantelegal.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RepresentanteLegalDataAccess representantelegalDataAccess=new RepresentanteLegalDataAccess();

			representantelegalDataAccess.setConnexionType(this.connexionType);
			representantelegalDataAccess.setParameterDbType(this.parameterDbType);
			representantelegals=representantelegalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return representantelegals;

	}

	public List<Telefono> getTelefonos(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Telefono> telefonos= new ArrayList<Telefono>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+TelefonoConstantesFunciones.SCHEMA+".telefono.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN telefono.Cliente WHERE telefono.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TelefonoDataAccess telefonoDataAccess=new TelefonoDataAccess();

			telefonoDataAccess.setConnexionType(this.connexionType);
			telefonoDataAccess.setParameterDbType(this.parameterDbType);
			telefonos=telefonoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return telefonos;

	}

	public List<NotaCreditoPuntoVenta> getNotaCreditoPuntoVentas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<NotaCreditoPuntoVenta> notacreditopuntoventas= new ArrayList<NotaCreditoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+".nota_credito_punto_venta.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN notacreditopuntoventa.Cliente WHERE notacreditopuntoventa.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoPuntoVentaDataAccess notacreditopuntoventaDataAccess=new NotaCreditoPuntoVentaDataAccess();

			notacreditopuntoventaDataAccess.setConnexionType(this.connexionType);
			notacreditopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditopuntoventas;

	}

	public List<NegocioCliente> getNegocioClientes(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<NegocioCliente> negocioclientes= new ArrayList<NegocioCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+NegocioClienteConstantesFunciones.SCHEMA+".negocio_cliente.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN negociocliente.Cliente WHERE negociocliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NegocioClienteDataAccess negocioclienteDataAccess=new NegocioClienteDataAccess();

			negocioclienteDataAccess.setConnexionType(this.connexionType);
			negocioclienteDataAccess.setParameterDbType(this.parameterDbType);
			negocioclientes=negocioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return negocioclientes;

	}

	public List<ReferenciaBancaria> getReferenciaBancarias(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ReferenciaBancaria> referenciabancarias= new ArrayList<ReferenciaBancaria>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ReferenciaBancariaConstantesFunciones.SCHEMA+".referenciabancaria.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN referenciabancaria.Cliente WHERE referenciabancaria.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ReferenciaBancariaDataAccess referenciabancariaDataAccess=new ReferenciaBancariaDataAccess();

			referenciabancariaDataAccess.setConnexionType(this.connexionType);
			referenciabancariaDataAccess.setParameterDbType(this.parameterDbType);
			referenciabancarias=referenciabancariaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return referenciabancarias;

	}

	public List<Monto> getMontos(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Monto> montos= new ArrayList<Monto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+MontoConstantesFunciones.SCHEMA+".monto.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN monto.Cliente WHERE monto.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MontoDataAccess montoDataAccess=new MontoDataAccess();

			montoDataAccess.setConnexionType(this.connexionType);
			montoDataAccess.setParameterDbType(this.parameterDbType);
			montos=montoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return montos;

	}

	public List<ConfiguracionPunVen> getConfiguracionPunVenConsumidorFinals(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ConfiguracionPunVen> configuracionpunvenconsumidorfinals= new ArrayList<ConfiguracionPunVen>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ConfiguracionPunVenConstantesFunciones.SCHEMA+".configuracion_pun_ven.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN configuracionpunven.ClienteConsumidorFinal WHERE configuracionpunven.ClienteConsumidorFinal.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConfiguracionPunVenDataAccess configuracionpunvenDataAccess=new ConfiguracionPunVenDataAccess();

			configuracionpunvenDataAccess.setConnexionType(this.connexionType);
			configuracionpunvenDataAccess.setParameterDbType(this.parameterDbType);
			configuracionpunvenconsumidorfinals=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return configuracionpunvenconsumidorfinals;

	}

	public List<ParametroFactuEmpresa> getParametroFactuEmpresaOrigens(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ParametroFactuEmpresa> parametrofactuempresaorigens= new ArrayList<ParametroFactuEmpresa>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ParametroFactuEmpresaConstantesFunciones.SCHEMA+".parametro_factu_empresa.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN parametrofactuempresa.ClienteOrigen WHERE parametrofactuempresa.ClienteOrigen.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFactuEmpresaDataAccess parametrofactuempresaDataAccess=new ParametroFactuEmpresaDataAccess();

			parametrofactuempresaDataAccess.setConnexionType(this.connexionType);
			parametrofactuempresaDataAccess.setParameterDbType(this.parameterDbType);
			parametrofactuempresaorigens=parametrofactuempresaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrofactuempresaorigens;

	}

	public List<ProductoOrdenDetaProduGasto> getProductoOrdenDetaProduGastoProveedors(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ProductoOrdenDetaProduGasto> productoordendetaprodugastoproveedors= new ArrayList<ProductoOrdenDetaProduGasto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+".producto_orden_deta_produ_gasto.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN productoordendetaprodugasto.ClienteProveedor WHERE productoordendetaprodugasto.ClienteProveedor.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoOrdenDetaProduGastoDataAccess productoordendetaprodugastoDataAccess=new ProductoOrdenDetaProduGastoDataAccess();

			productoordendetaprodugastoDataAccess.setConnexionType(this.connexionType);
			productoordendetaprodugastoDataAccess.setParameterDbType(this.parameterDbType);
			productoordendetaprodugastoproveedors=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoordendetaprodugastoproveedors;

	}

	public List<ClienteArchivo> getClienteArchivos(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ClienteArchivo> clientearchivos= new ArrayList<ClienteArchivo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ClienteArchivoConstantesFunciones.SCHEMA+".cliente_archivo.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN clientearchivo.Cliente WHERE clientearchivo.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteArchivoDataAccess clientearchivoDataAccess=new ClienteArchivoDataAccess();

			clientearchivoDataAccess.setConnexionType(this.connexionType);
			clientearchivoDataAccess.setParameterDbType(this.parameterDbType);
			clientearchivos=clientearchivoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clientearchivos;

	}

	public List<Accionista> getAccionistas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Accionista> accionistas= new ArrayList<Accionista>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+AccionistaConstantesFunciones.SCHEMA+".accionista.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN accionista.Cliente WHERE accionista.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AccionistaDataAccess accionistaDataAccess=new AccionistaDataAccess();

			accionistaDataAccess.setConnexionType(this.connexionType);
			accionistaDataAccess.setParameterDbType(this.parameterDbType);
			accionistas=accionistaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return accionistas;

	}

	public List<ActividadEconomica> getActividadEconomicas(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ActividadEconomica> actividadeconomicas= new ArrayList<ActividadEconomica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ActividadEconomicaConstantesFunciones.SCHEMA+".actividad_economica.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN actividadeconomica.Cliente WHERE actividadeconomica.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ActividadEconomicaDataAccess actividadeconomicaDataAccess=new ActividadEconomicaDataAccess();

			actividadeconomicaDataAccess.setConnexionType(this.connexionType);
			actividadeconomicaDataAccess.setParameterDbType(this.parameterDbType);
			actividadeconomicas=actividadeconomicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return actividadeconomicas;

	}

	public List<OrdenProdu> getOrdenProdus(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<OrdenProdu> ordenprodus= new ArrayList<OrdenProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+OrdenProduConstantesFunciones.SCHEMA+".orden_produ.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN ordenprodu.Cliente WHERE ordenprodu.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OrdenProduDataAccess ordenproduDataAccess=new OrdenProduDataAccess();

			ordenproduDataAccess.setConnexionType(this.connexionType);
			ordenproduDataAccess.setParameterDbType(this.parameterDbType);
			ordenprodus=ordenproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordenprodus;

	}

	public List<AutoriPago> getAutoriPagos(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<AutoriPago> autoripagos= new ArrayList<AutoriPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+AutoriPagoConstantesFunciones.SCHEMA+".autori_pago.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN autoripago.Cliente WHERE autoripago.Cliente.id="+String.valueOf(cliente.getId());

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

	public List<DetalleMoviClienProve> getDetalleMoviClienProves(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<DetalleMoviClienProve> detallemoviclienproves= new ArrayList<DetalleMoviClienProve>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+DetalleMoviClienProveConstantesFunciones.SCHEMA+".detalle_movi_clien_prove.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN detallemoviclienprove.Cliente WHERE detallemoviclienprove.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleMoviClienProveDataAccess detallemoviclienproveDataAccess=new DetalleMoviClienProveDataAccess();

			detallemoviclienproveDataAccess.setConnexionType(this.connexionType);
			detallemoviclienproveDataAccess.setParameterDbType(this.parameterDbType);
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallemoviclienproves;

	}

	public List<FacturaProveedorServicio> getFacturaProveedorServicios(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<FacturaProveedorServicio> facturaproveedorservicios= new ArrayList<FacturaProveedorServicio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+FacturaProveedorServicioConstantesFunciones.SCHEMA+".factura_proveedor_servicio.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedorservicio.Cliente WHERE facturaproveedorservicio.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorServicioDataAccess facturaproveedorservicioDataAccess=new FacturaProveedorServicioDataAccess();

			facturaproveedorservicioDataAccess.setConnexionType(this.connexionType);
			facturaproveedorservicioDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedorservicios;

	}

	public List<Compra> getCompras(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Compra> compras= new ArrayList<Compra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+CompraConstantesFunciones.SCHEMA+".compra.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN compra.Cliente WHERE compra.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CompraDataAccess compraDataAccess=new CompraDataAccess();

			compraDataAccess.setConnexionType(this.connexionType);
			compraDataAccess.setParameterDbType(this.parameterDbType);
			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return compras;

	}

	public List<PedidoProdu> getPedidoProdus(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<PedidoProdu> pedidoprodus= new ArrayList<PedidoProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+PedidoProduConstantesFunciones.SCHEMA+".pedido_produ.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN pedidoprodu.Cliente WHERE pedidoprodu.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoProduDataAccess pedidoproduDataAccess=new PedidoProduDataAccess();

			pedidoproduDataAccess.setConnexionType(this.connexionType);
			pedidoproduDataAccess.setParameterDbType(this.parameterDbType);
			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoprodus;

	}

	public List<Direccion> getDireccions(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<Direccion> direccions= new ArrayList<Direccion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+DireccionConstantesFunciones.SCHEMA+".direccion.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN direccion.Cliente WHERE direccion.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DireccionDataAccess direccionDataAccess=new DireccionDataAccess();

			direccionDataAccess.setConnexionType(this.connexionType);
			direccionDataAccess.setParameterDbType(this.parameterDbType);
			direccions=direccionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return direccions;

	}

	public List<ChequePostFechado> getChequePostFechados(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<ChequePostFechado> chequepostfechados= new ArrayList<ChequePostFechado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+ChequePostFechadoConstantesFunciones.SCHEMA+".cheque_post_fechado.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN chequepostfechado.Cliente WHERE chequepostfechado.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ChequePostFechadoDataAccess chequepostfechadoDataAccess=new ChequePostFechadoDataAccess();

			chequepostfechadoDataAccess.setConnexionType(this.connexionType);
			chequepostfechadoDataAccess.setParameterDbType(this.parameterDbType);
			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return chequepostfechados;

	}

	public List<SubCliente> getSubClientes(Connexion connexion,Cliente cliente)throws SQLException,Exception {

		List<SubCliente> subclientes= new ArrayList<SubCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ClienteConstantesFunciones.SCHEMA+".cliente ON "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id_cliente="+ClienteConstantesFunciones.SCHEMA+".cliente.id WHERE "+ClienteConstantesFunciones.SCHEMA+".cliente.id="+String.valueOf(cliente.getId());
			} else {
				sQuery=" INNER JOIN subcliente.Cliente WHERE subcliente.Cliente.id="+String.valueOf(cliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SubClienteDataAccess subclienteDataAccess=new SubClienteDataAccess();

			subclienteDataAccess.setConnexionType(this.connexionType);
			subclienteDataAccess.setParameterDbType(this.parameterDbType);
			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subclientes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Cliente cliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cliente.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(cliente.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(cliente.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_identificacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_identificacion.setValue(cliente.getid_tipo_identificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_identificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueidentificacion=new ParameterValue<String>();
					parameterMaintenanceValueidentificacion.setValue(cliente.getidentificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidentificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(cliente.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(cliente.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueapellido=new ParameterValue<String>();
					parameterMaintenanceValueapellido.setValue(cliente.getapellido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueapellido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_completo=new ParameterValue<String>();
					parameterMaintenanceValuenombre_completo.setValue(cliente.getnombre_completo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_completo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_comercial=new ParameterValue<String>();
					parameterMaintenanceValuenombre_comercial.setValue(cliente.getnombre_comercial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_comercial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(cliente.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(cliente.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_prove=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_prove.setValue(cliente.getes_prove());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_prove);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_grupo_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_grupo_cliente.setValue(cliente.getid_grupo_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_grupo_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_titulo_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_titulo_cliente.setValue(cliente.getid_titulo_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_titulo_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_area_cr=new ParameterValue<Long>();
					parameterMaintenanceValueid_area_cr.setValue(cliente.getid_area_cr());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_area_cr);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_cliente.setValue(cliente.getid_estado_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion=new ParameterValue<String>();
					parameterMaintenanceValueobservacion.setValue(cliente.getobservacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(cliente.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_region=new ParameterValue<Long>();
					parameterMaintenanceValueid_region.setValue(cliente.getid_region());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_region);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_provincia=new ParameterValue<Long>();
					parameterMaintenanceValueid_provincia.setValue(cliente.getid_provincia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_provincia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(cliente.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_zona=new ParameterValue<Long>();
					parameterMaintenanceValueid_zona.setValue(cliente.getid_zona());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_zona);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais_nacionalidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais_nacionalidad.setValue(cliente.getid_pais_nacionalidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais_nacionalidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cargo_labo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cargo_labo.setValue(cliente.getid_tipo_cargo_labo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cargo_labo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_nivel_edu=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_nivel_edu.setValue(cliente.getid_tipo_nivel_edu());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_nivel_edu);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_profesion=new ParameterValue<Long>();
					parameterMaintenanceValueid_profesion.setValue(cliente.getid_profesion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_profesion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_genero=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_genero.setValue(cliente.getid_tipo_genero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_genero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_civil=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_civil.setValue(cliente.getid_estado_civil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_civil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_legal=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_legal.setValue(cliente.getid_estado_legal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_legal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_nacimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_nacimiento.setValue(cliente.getfecha_nacimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_nacimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepath_imagen_firma=new ParameterValue<String>();
					parameterMaintenanceValuepath_imagen_firma.setValue(cliente.getpath_imagen_firma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepath_imagen_firma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecontacto=new ParameterValue<String>();
					parameterMaintenanceValuecontacto.setValue(cliente.getcontacto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecontacto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(cliente.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ruta=new ParameterValue<Long>();
					parameterMaintenanceValueid_ruta.setValue(cliente.getid_ruta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ruta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(cliente.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_actividad=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_actividad.setValue(cliente.getid_centro_actividad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_actividad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuerepresentante=new ParameterValue<String>();
					parameterMaintenanceValuerepresentante.setValue(cliente.getrepresentante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerepresentante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_garantia_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_garantia_empresa.setValue(cliente.getid_tipo_garantia_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_garantia_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_garantia=new ParameterValue<String>();
					parameterMaintenanceValuenombre_garantia.setValue(cliente.getnombre_garantia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_garantia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_garantia=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_garantia.setValue(cliente.getvalor_garantia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_garantia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cate_tipo_afiliacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cate_tipo_afiliacion.setValue(cliente.getid_cate_tipo_afiliacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cate_tipo_afiliacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_carga=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_carga.setValue(cliente.getnumero_carga());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_carga);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_usado=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_usado.setValue(cliente.getcredito_usado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_usado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuelimite_credito=new ParameterValue<Double>();
					parameterMaintenanceValuelimite_credito.setValue(cliente.getlimite_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelimite_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_disponible=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_disponible.setValue(cliente.getcredito_disponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_disponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_documentos=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_documentos.setValue(cliente.gettotal_documentos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_documentos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_factura=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_factura.setValue(cliente.getfecha_ultima_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(cliente.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_dia=new ParameterValue<Long>();
					parameterMaintenanceValueid_dia.setValue(cliente.getid_dia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_dia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_pago=new ParameterValue<Time>();
					parameterMaintenanceValuehora_pago.setValue(cliente.gethora_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(cliente.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecobranzas=new ParameterValue<String>();
					parameterMaintenanceValuecobranzas.setValue(cliente.getcobranzas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecobranzas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemotivo=new ParameterValue<String>();
					parameterMaintenanceValuemotivo.setValue(cliente.getmotivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemotivo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepreferencia=new ParameterValue<String>();
					parameterMaintenanceValuepreferencia.setValue(cliente.getpreferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepreferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_separacion_bienes=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_separacion_bienes.setValue(cliente.getcon_separacion_bienes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_separacion_bienes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(cliente.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_lista_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_lista_precio.setValue(cliente.getid_tipo_lista_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_lista_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedetalle_estado=new ParameterValue<String>();
					parameterMaintenanceValuedetalle_estado.setValue(cliente.getdetalle_estado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedetalle_estado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_contribuyente_especial=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_contribuyente_especial.setValue(cliente.getes_contribuyente_especial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_contribuyente_especial);
					parametersTemp.add(parameterMaintenance);
					
						if(!cliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cliente.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cliente.getId());
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
	
	public void setIsNewIsChangedFalseCliente(Cliente cliente)throws Exception  {		
		cliente.setIsNew(false);
		cliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseClientes(List<Cliente> clientes)throws Exception  {				
		for(Cliente cliente:clientes) {
			cliente.setIsNew(false);
			cliente.setIsChanged(false);
		}
	}
	
	public void generarExportarCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
