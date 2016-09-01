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
package com.bydan.erp.cartera.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.cartera.util.GarantiaClienteConstantesFunciones;
import com.bydan.erp.cartera.util.GarantiaClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.GarantiaClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class GarantiaClienteConstantesFunciones extends GarantiaClienteConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="GarantiaCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GarantiaCliente"+GarantiaClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GarantiaClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GarantiaClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GarantiaClienteConstantesFunciones.SCHEMA+"_"+GarantiaClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GarantiaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GarantiaClienteConstantesFunciones.SCHEMA+"_"+GarantiaClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GarantiaClienteConstantesFunciones.SCHEMA+"_"+GarantiaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GarantiaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GarantiaClienteConstantesFunciones.SCHEMA+"_"+GarantiaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GarantiaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GarantiaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GarantiaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GarantiaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GarantiaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GarantiaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GarantiaClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GarantiaClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GarantiaClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GarantiaClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Garantia Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Garantia Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Garantia Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GarantiaCliente";
	public static final String OBJECTNAME="garantiacliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="garantia_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select garantiacliente from "+GarantiaClienteConstantesFunciones.SPERSISTENCENAME+" garantiacliente";
	public static String QUERYSELECTNATIVE="select "+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME+".id,"+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME+".version_row,"+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME+".id_empresa,"+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME+".id_sucursal,"+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME+".id_cliente,"+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME+".id_tipo_garantia_empresa,"+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME+".valor,"+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME+".fecha_recepcion,"+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME+".fecha_firma,"+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME+".fecha_devolucion,"+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME+".beneficiario,"+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME+".id_estado_garantia_cliente from "+GarantiaClienteConstantesFunciones.SCHEMA+"."+GarantiaClienteConstantesFunciones.TABLENAME;//+" as "+GarantiaClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected GarantiaClienteConstantesFuncionesAdditional garantiaclienteConstantesFuncionesAdditional=null;
	
	public GarantiaClienteConstantesFuncionesAdditional getGarantiaClienteConstantesFuncionesAdditional() {
		return this.garantiaclienteConstantesFuncionesAdditional;
	}
	
	public void setGarantiaClienteConstantesFuncionesAdditional(GarantiaClienteConstantesFuncionesAdditional garantiaclienteConstantesFuncionesAdditional) {
		try {
			this.garantiaclienteConstantesFuncionesAdditional=garantiaclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTIPOGARANTIAEMPRESA= "id_tipo_garantia_empresa";
    public static final String VALOR= "valor";
    public static final String FECHARECEPCION= "fecha_recepcion";
    public static final String FECHAFIRMA= "fecha_firma";
    public static final String FECHADEVOLUCION= "fecha_devolucion";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String IDESTADOGARANTIACLIENTE= "id_estado_garantia_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOGARANTIAEMPRESA= "Tipo Garantia Empresa";
		public static final String LABEL_IDTIPOGARANTIAEMPRESA_LOWER= "Tipo Garantia Empresa";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_FECHARECEPCION= "Fecha Recepcion";
		public static final String LABEL_FECHARECEPCION_LOWER= "Fecha Recepcion";
    	public static final String LABEL_FECHAFIRMA= "Fecha Firma";
		public static final String LABEL_FECHAFIRMA_LOWER= "Fecha Firma";
    	public static final String LABEL_FECHADEVOLUCION= "Fecha Devolucion";
		public static final String LABEL_FECHADEVOLUCION_LOWER= "Fecha Devolucion";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
    	public static final String LABEL_IDESTADOGARANTIACLIENTE= "Estado Garantia Cliente";
		public static final String LABEL_IDESTADOGARANTIACLIENTE_LOWER= "Estado Garantia Cliente";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getGarantiaClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GarantiaClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=GarantiaClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GarantiaClienteConstantesFunciones.IDSUCURSAL)) {sLabelColumna=GarantiaClienteConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(GarantiaClienteConstantesFunciones.IDCLIENTE)) {sLabelColumna=GarantiaClienteConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(GarantiaClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA)) {sLabelColumna=GarantiaClienteConstantesFunciones.LABEL_IDTIPOGARANTIAEMPRESA;}
		if(sNombreColumna.equals(GarantiaClienteConstantesFunciones.VALOR)) {sLabelColumna=GarantiaClienteConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(GarantiaClienteConstantesFunciones.FECHARECEPCION)) {sLabelColumna=GarantiaClienteConstantesFunciones.LABEL_FECHARECEPCION;}
		if(sNombreColumna.equals(GarantiaClienteConstantesFunciones.FECHAFIRMA)) {sLabelColumna=GarantiaClienteConstantesFunciones.LABEL_FECHAFIRMA;}
		if(sNombreColumna.equals(GarantiaClienteConstantesFunciones.FECHADEVOLUCION)) {sLabelColumna=GarantiaClienteConstantesFunciones.LABEL_FECHADEVOLUCION;}
		if(sNombreColumna.equals(GarantiaClienteConstantesFunciones.BENEFICIARIO)) {sLabelColumna=GarantiaClienteConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(GarantiaClienteConstantesFunciones.IDESTADOGARANTIACLIENTE)) {sLabelColumna=GarantiaClienteConstantesFunciones.LABEL_IDESTADOGARANTIACLIENTE;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getGarantiaClienteDescripcion(GarantiaCliente garantiacliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(garantiacliente !=null/* && garantiacliente.getId()!=0*/) {
			if(garantiacliente.getId()!=null) {
				sDescripcion=garantiacliente.getId().toString();
			}//garantiaclientegarantiacliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getGarantiaClienteDescripcionDetallado(GarantiaCliente garantiacliente) {
		String sDescripcion="";
			
		sDescripcion+=GarantiaClienteConstantesFunciones.ID+"=";
		sDescripcion+=garantiacliente.getId().toString()+",";
		sDescripcion+=GarantiaClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=garantiacliente.getVersionRow().toString()+",";
		sDescripcion+=GarantiaClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=garantiacliente.getid_empresa().toString()+",";
		sDescripcion+=GarantiaClienteConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=garantiacliente.getid_sucursal().toString()+",";
		sDescripcion+=GarantiaClienteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=garantiacliente.getid_cliente().toString()+",";
		sDescripcion+=GarantiaClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA+"=";
		sDescripcion+=garantiacliente.getid_tipo_garantia_empresa().toString()+",";
		sDescripcion+=GarantiaClienteConstantesFunciones.VALOR+"=";
		sDescripcion+=garantiacliente.getvalor().toString()+",";
		sDescripcion+=GarantiaClienteConstantesFunciones.FECHARECEPCION+"=";
		sDescripcion+=garantiacliente.getfecha_recepcion().toString()+",";
		sDescripcion+=GarantiaClienteConstantesFunciones.FECHAFIRMA+"=";
		sDescripcion+=garantiacliente.getfecha_firma().toString()+",";
		sDescripcion+=GarantiaClienteConstantesFunciones.FECHADEVOLUCION+"=";
		sDescripcion+=garantiacliente.getfecha_devolucion().toString()+",";
		sDescripcion+=GarantiaClienteConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=garantiacliente.getbeneficiario()+",";
		sDescripcion+=GarantiaClienteConstantesFunciones.IDESTADOGARANTIACLIENTE+"=";
		sDescripcion+=garantiacliente.getid_estado_garantia_cliente().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setGarantiaClienteDescripcion(GarantiaCliente garantiacliente,String sValor) throws Exception {			
		if(garantiacliente !=null) {
			//garantiaclientegarantiacliente.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTipoGarantiaEmpresaDescripcion(TipoGarantiaEmpresa tipogarantiaempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogarantiaempresa!=null/*&&tipogarantiaempresa.getId()>0*/) {
			sDescripcion=TipoGarantiaEmpresaConstantesFunciones.getTipoGarantiaEmpresaDescripcion(tipogarantiaempresa);
		}

		return sDescripcion;
	}

	public static String getEstadoGarantiaClienteDescripcion(EstadoGarantiaCliente estadogarantiacliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadogarantiacliente!=null/*&&estadogarantiacliente.getId()>0*/) {
			sDescripcion=EstadoGarantiaClienteConstantesFunciones.getEstadoGarantiaClienteDescripcion(estadogarantiacliente);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoGarantiaCliente")) {
			sNombreIndice="Tipo=  Por Estado Garantia Cliente";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoGarantiaEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Garantia Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoGarantiaCliente(Long id_estado_garantia_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_garantia_cliente!=null) {sDetalleIndice+=" Codigo Unico De Estado Garantia Cliente="+id_estado_garantia_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGarantiaEmpresa(Long id_tipo_garantia_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_garantia_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Garantia Empresa="+id_tipo_garantia_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosGarantiaCliente(GarantiaCliente garantiacliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		garantiacliente.setbeneficiario(garantiacliente.getbeneficiario().trim());
	}
	
	public static void quitarEspaciosGarantiaClientes(List<GarantiaCliente> garantiaclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GarantiaCliente garantiacliente: garantiaclientes) {
			garantiacliente.setbeneficiario(garantiacliente.getbeneficiario().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGarantiaCliente(GarantiaCliente garantiacliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && garantiacliente.getConCambioAuxiliar()) {
			garantiacliente.setIsDeleted(garantiacliente.getIsDeletedAuxiliar());	
			garantiacliente.setIsNew(garantiacliente.getIsNewAuxiliar());	
			garantiacliente.setIsChanged(garantiacliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			garantiacliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			garantiacliente.setIsDeletedAuxiliar(false);	
			garantiacliente.setIsNewAuxiliar(false);	
			garantiacliente.setIsChangedAuxiliar(false);
			
			garantiacliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGarantiaClientes(List<GarantiaCliente> garantiaclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GarantiaCliente garantiacliente : garantiaclientes) {
			if(conAsignarBase && garantiacliente.getConCambioAuxiliar()) {
				garantiacliente.setIsDeleted(garantiacliente.getIsDeletedAuxiliar());	
				garantiacliente.setIsNew(garantiacliente.getIsNewAuxiliar());	
				garantiacliente.setIsChanged(garantiacliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				garantiacliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				garantiacliente.setIsDeletedAuxiliar(false);	
				garantiacliente.setIsNewAuxiliar(false);	
				garantiacliente.setIsChangedAuxiliar(false);
				
				garantiacliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGarantiaCliente(GarantiaCliente garantiacliente,Boolean conEnteros) throws Exception  {
		garantiacliente.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresGarantiaClientes(List<GarantiaCliente> garantiaclientes,Boolean conEnteros) throws Exception  {
		
		for(GarantiaCliente garantiacliente: garantiaclientes) {
			garantiacliente.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaGarantiaCliente(List<GarantiaCliente> garantiaclientes,GarantiaCliente garantiaclienteAux) throws Exception  {
		GarantiaClienteConstantesFunciones.InicializarValoresGarantiaCliente(garantiaclienteAux,true);
		
		for(GarantiaCliente garantiacliente: garantiaclientes) {
			if(garantiacliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			garantiaclienteAux.setvalor(garantiaclienteAux.getvalor()+garantiacliente.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGarantiaCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GarantiaClienteConstantesFunciones.getArrayColumnasGlobalesGarantiaCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGarantiaCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GarantiaClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GarantiaClienteConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GarantiaClienteConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GarantiaClienteConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGarantiaCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GarantiaCliente> garantiaclientes,GarantiaCliente garantiacliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GarantiaCliente garantiaclienteAux: garantiaclientes) {
			if(garantiaclienteAux!=null && garantiacliente!=null) {
				if((garantiaclienteAux.getId()==null && garantiacliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(garantiaclienteAux.getId()!=null && garantiacliente.getId()!=null){
					if(garantiaclienteAux.getId().equals(garantiacliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGarantiaCliente(List<GarantiaCliente> garantiaclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(GarantiaCliente garantiacliente: garantiaclientes) {			
			if(garantiacliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=garantiacliente.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GarantiaClienteConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(GarantiaClienteConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGarantiaCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GarantiaClienteConstantesFunciones.LABEL_ID, GarantiaClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GarantiaClienteConstantesFunciones.LABEL_VERSIONROW, GarantiaClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GarantiaClienteConstantesFunciones.LABEL_IDEMPRESA, GarantiaClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GarantiaClienteConstantesFunciones.LABEL_IDSUCURSAL, GarantiaClienteConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GarantiaClienteConstantesFunciones.LABEL_IDCLIENTE, GarantiaClienteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GarantiaClienteConstantesFunciones.LABEL_IDTIPOGARANTIAEMPRESA, GarantiaClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GarantiaClienteConstantesFunciones.LABEL_VALOR, GarantiaClienteConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GarantiaClienteConstantesFunciones.LABEL_FECHARECEPCION, GarantiaClienteConstantesFunciones.FECHARECEPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GarantiaClienteConstantesFunciones.LABEL_FECHAFIRMA, GarantiaClienteConstantesFunciones.FECHAFIRMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GarantiaClienteConstantesFunciones.LABEL_FECHADEVOLUCION, GarantiaClienteConstantesFunciones.FECHADEVOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GarantiaClienteConstantesFunciones.LABEL_BENEFICIARIO, GarantiaClienteConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GarantiaClienteConstantesFunciones.LABEL_IDESTADOGARANTIACLIENTE, GarantiaClienteConstantesFunciones.IDESTADOGARANTIACLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGarantiaCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GarantiaClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GarantiaClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GarantiaClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GarantiaClienteConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GarantiaClienteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GarantiaClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GarantiaClienteConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GarantiaClienteConstantesFunciones.FECHARECEPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GarantiaClienteConstantesFunciones.FECHAFIRMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GarantiaClienteConstantesFunciones.FECHADEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GarantiaClienteConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GarantiaClienteConstantesFunciones.IDESTADOGARANTIACLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGarantiaCliente() throws Exception  {
		return GarantiaClienteConstantesFunciones.getTiposSeleccionarGarantiaCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGarantiaCliente(Boolean conFk) throws Exception  {
		return GarantiaClienteConstantesFunciones.getTiposSeleccionarGarantiaCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGarantiaCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GarantiaClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GarantiaClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GarantiaClienteConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(GarantiaClienteConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GarantiaClienteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(GarantiaClienteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GarantiaClienteConstantesFunciones.LABEL_IDTIPOGARANTIAEMPRESA);
			reporte.setsDescripcion(GarantiaClienteConstantesFunciones.LABEL_IDTIPOGARANTIAEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GarantiaClienteConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(GarantiaClienteConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GarantiaClienteConstantesFunciones.LABEL_FECHARECEPCION);
			reporte.setsDescripcion(GarantiaClienteConstantesFunciones.LABEL_FECHARECEPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GarantiaClienteConstantesFunciones.LABEL_FECHAFIRMA);
			reporte.setsDescripcion(GarantiaClienteConstantesFunciones.LABEL_FECHAFIRMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GarantiaClienteConstantesFunciones.LABEL_FECHADEVOLUCION);
			reporte.setsDescripcion(GarantiaClienteConstantesFunciones.LABEL_FECHADEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GarantiaClienteConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(GarantiaClienteConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GarantiaClienteConstantesFunciones.LABEL_IDESTADOGARANTIACLIENTE);
			reporte.setsDescripcion(GarantiaClienteConstantesFunciones.LABEL_IDESTADOGARANTIACLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGarantiaCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGarantiaCliente(GarantiaCliente garantiaclienteAux) throws Exception {
		
			garantiaclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(garantiaclienteAux.getEmpresa()));
			garantiaclienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(garantiaclienteAux.getSucursal()));
			garantiaclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(garantiaclienteAux.getCliente()));
			garantiaclienteAux.settipogarantiaempresa_descripcion(TipoGarantiaEmpresaConstantesFunciones.getTipoGarantiaEmpresaDescripcion(garantiaclienteAux.getTipoGarantiaEmpresa()));
			garantiaclienteAux.setestadogarantiacliente_descripcion(EstadoGarantiaClienteConstantesFunciones.getEstadoGarantiaClienteDescripcion(garantiaclienteAux.getEstadoGarantiaCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGarantiaCliente(List<GarantiaCliente> garantiaclientesTemp) throws Exception {
		for(GarantiaCliente garantiaclienteAux:garantiaclientesTemp) {
			
			garantiaclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(garantiaclienteAux.getEmpresa()));
			garantiaclienteAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(garantiaclienteAux.getSucursal()));
			garantiaclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(garantiaclienteAux.getCliente()));
			garantiaclienteAux.settipogarantiaempresa_descripcion(TipoGarantiaEmpresaConstantesFunciones.getTipoGarantiaEmpresaDescripcion(garantiaclienteAux.getTipoGarantiaEmpresa()));
			garantiaclienteAux.setestadogarantiacliente_descripcion(EstadoGarantiaClienteConstantesFunciones.getEstadoGarantiaClienteDescripcion(garantiaclienteAux.getEstadoGarantiaCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGarantiaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoGarantiaEmpresa.class));
				classes.add(new Classe(EstadoGarantiaCliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
						classes.add(new Classe(TipoGarantiaEmpresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoGarantiaCliente.class)) {
						classes.add(new Classe(EstadoGarantiaCliente.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGarantiaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoGarantiaEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGarantiaEmpresa.class)); continue;
					}

					if(EstadoGarantiaCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoGarantiaCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoGarantiaEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGarantiaEmpresa.class)); continue;
					}

					if(EstadoGarantiaCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoGarantiaCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGarantiaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GarantiaClienteConstantesFunciones.getClassesRelationshipsOfGarantiaCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGarantiaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGarantiaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GarantiaClienteConstantesFunciones.getClassesRelationshipsFromStringsOfGarantiaCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGarantiaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(GarantiaCliente garantiacliente,List<GarantiaCliente> garantiaclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			GarantiaCliente garantiaclienteEncontrado=null;
			
			for(GarantiaCliente garantiaclienteLocal:garantiaclientes) {
				if(garantiaclienteLocal.getId().equals(garantiacliente.getId())) {
					garantiaclienteEncontrado=garantiaclienteLocal;
					
					garantiaclienteLocal.setIsChanged(garantiacliente.getIsChanged());
					garantiaclienteLocal.setIsNew(garantiacliente.getIsNew());
					garantiaclienteLocal.setIsDeleted(garantiacliente.getIsDeleted());
					
					garantiaclienteLocal.setGeneralEntityOriginal(garantiacliente.getGeneralEntityOriginal());
					
					garantiaclienteLocal.setId(garantiacliente.getId());	
					garantiaclienteLocal.setVersionRow(garantiacliente.getVersionRow());	
					garantiaclienteLocal.setid_empresa(garantiacliente.getid_empresa());	
					garantiaclienteLocal.setid_sucursal(garantiacliente.getid_sucursal());	
					garantiaclienteLocal.setid_cliente(garantiacliente.getid_cliente());	
					garantiaclienteLocal.setid_tipo_garantia_empresa(garantiacliente.getid_tipo_garantia_empresa());	
					garantiaclienteLocal.setvalor(garantiacliente.getvalor());	
					garantiaclienteLocal.setfecha_recepcion(garantiacliente.getfecha_recepcion());	
					garantiaclienteLocal.setfecha_firma(garantiacliente.getfecha_firma());	
					garantiaclienteLocal.setfecha_devolucion(garantiacliente.getfecha_devolucion());	
					garantiaclienteLocal.setbeneficiario(garantiacliente.getbeneficiario());	
					garantiaclienteLocal.setid_estado_garantia_cliente(garantiacliente.getid_estado_garantia_cliente());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!garantiacliente.getIsDeleted()) {
				if(!existe) {
					garantiaclientes.add(garantiacliente);
				}
			} else {
				if(garantiaclienteEncontrado!=null && permiteQuitar)  {
					garantiaclientes.remove(garantiaclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(GarantiaCliente garantiacliente,List<GarantiaCliente> garantiaclientes) throws Exception {
		try	{			
			for(GarantiaCliente garantiaclienteLocal:garantiaclientes) {
				if(garantiaclienteLocal.getId().equals(garantiacliente.getId())) {
					garantiaclienteLocal.setIsSelected(garantiacliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGarantiaCliente(List<GarantiaCliente> garantiaclientesAux) throws Exception {
		//this.garantiaclientesAux=garantiaclientesAux;
		
		for(GarantiaCliente garantiaclienteAux:garantiaclientesAux) {
			if(garantiaclienteAux.getIsChanged()) {
				garantiaclienteAux.setIsChanged(false);
			}		
			
			if(garantiaclienteAux.getIsNew()) {
				garantiaclienteAux.setIsNew(false);
			}	
			
			if(garantiaclienteAux.getIsDeleted()) {
				garantiaclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGarantiaCliente(GarantiaCliente garantiaclienteAux) throws Exception {
		//this.garantiaclienteAux=garantiaclienteAux;
		
			if(garantiaclienteAux.getIsChanged()) {
				garantiaclienteAux.setIsChanged(false);
			}		
			
			if(garantiaclienteAux.getIsNew()) {
				garantiaclienteAux.setIsNew(false);
			}	
			
			if(garantiaclienteAux.getIsDeleted()) {
				garantiaclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GarantiaCliente garantiaclienteAsignar,GarantiaCliente garantiacliente) throws Exception {
		garantiaclienteAsignar.setId(garantiacliente.getId());	
		garantiaclienteAsignar.setVersionRow(garantiacliente.getVersionRow());	
		garantiaclienteAsignar.setid_empresa(garantiacliente.getid_empresa());
		garantiaclienteAsignar.setempresa_descripcion(garantiacliente.getempresa_descripcion());	
		garantiaclienteAsignar.setid_sucursal(garantiacliente.getid_sucursal());
		garantiaclienteAsignar.setsucursal_descripcion(garantiacliente.getsucursal_descripcion());	
		garantiaclienteAsignar.setid_cliente(garantiacliente.getid_cliente());
		garantiaclienteAsignar.setcliente_descripcion(garantiacliente.getcliente_descripcion());	
		garantiaclienteAsignar.setid_tipo_garantia_empresa(garantiacliente.getid_tipo_garantia_empresa());
		garantiaclienteAsignar.settipogarantiaempresa_descripcion(garantiacliente.gettipogarantiaempresa_descripcion());	
		garantiaclienteAsignar.setvalor(garantiacliente.getvalor());	
		garantiaclienteAsignar.setfecha_recepcion(garantiacliente.getfecha_recepcion());	
		garantiaclienteAsignar.setfecha_firma(garantiacliente.getfecha_firma());	
		garantiaclienteAsignar.setfecha_devolucion(garantiacliente.getfecha_devolucion());	
		garantiaclienteAsignar.setbeneficiario(garantiacliente.getbeneficiario());	
		garantiaclienteAsignar.setid_estado_garantia_cliente(garantiacliente.getid_estado_garantia_cliente());
		garantiaclienteAsignar.setestadogarantiacliente_descripcion(garantiacliente.getestadogarantiacliente_descripcion());	
	}
	
	public static void inicializarGarantiaCliente(GarantiaCliente garantiacliente) throws Exception {
		try {
				garantiacliente.setId(0L);	
					
				garantiacliente.setid_empresa(-1L);	
				garantiacliente.setid_sucursal(-1L);	
				garantiacliente.setid_cliente(-1L);	
				garantiacliente.setid_tipo_garantia_empresa(-1L);	
				garantiacliente.setvalor(0.0);	
				garantiacliente.setfecha_recepcion(new Date());	
				garantiacliente.setfecha_firma(new Date());	
				garantiacliente.setfecha_devolucion(new Date());	
				garantiacliente.setbeneficiario("");	
				garantiacliente.setid_estado_garantia_cliente(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGarantiaCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GarantiaClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GarantiaClienteConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GarantiaClienteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GarantiaClienteConstantesFunciones.LABEL_IDTIPOGARANTIAEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GarantiaClienteConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GarantiaClienteConstantesFunciones.LABEL_FECHARECEPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GarantiaClienteConstantesFunciones.LABEL_FECHAFIRMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GarantiaClienteConstantesFunciones.LABEL_FECHADEVOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GarantiaClienteConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GarantiaClienteConstantesFunciones.LABEL_IDESTADOGARANTIACLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGarantiaCliente(String sTipo,Row row,Workbook workbook,GarantiaCliente garantiacliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(garantiacliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(garantiacliente.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(garantiacliente.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(garantiacliente.gettipogarantiaempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(garantiacliente.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(garantiacliente.getfecha_recepcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(garantiacliente.getfecha_firma());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(garantiacliente.getfecha_devolucion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(garantiacliente.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(garantiacliente.getestadogarantiacliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGarantiaCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryGarantiaCliente() {
		return this.sFinalQueryGarantiaCliente;
	}
	
	public void setsFinalQueryGarantiaCliente(String sFinalQueryGarantiaCliente) {
		this.sFinalQueryGarantiaCliente= sFinalQueryGarantiaCliente;
	}
	
	public Border resaltarSeleccionarGarantiaCliente=null;
	
	public Border setResaltarSeleccionarGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//garantiaclienteBeanSwingJInternalFrame.jTtoolBarGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGarantiaCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGarantiaCliente() {
		return this.resaltarSeleccionarGarantiaCliente;
	}
	
	public void setResaltarSeleccionarGarantiaCliente(Border borderResaltarSeleccionarGarantiaCliente) {
		this.resaltarSeleccionarGarantiaCliente= borderResaltarSeleccionarGarantiaCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGarantiaCliente=null;
	public Boolean mostraridGarantiaCliente=true;
	public Boolean activaridGarantiaCliente=true;

	public Border resaltarid_empresaGarantiaCliente=null;
	public Boolean mostrarid_empresaGarantiaCliente=true;
	public Boolean activarid_empresaGarantiaCliente=true;
	public Boolean cargarid_empresaGarantiaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGarantiaCliente=false;//ConEventDepend=true

	public Border resaltarid_sucursalGarantiaCliente=null;
	public Boolean mostrarid_sucursalGarantiaCliente=true;
	public Boolean activarid_sucursalGarantiaCliente=true;
	public Boolean cargarid_sucursalGarantiaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalGarantiaCliente=false;//ConEventDepend=true

	public Border resaltarid_clienteGarantiaCliente=null;
	public Boolean mostrarid_clienteGarantiaCliente=true;
	public Boolean activarid_clienteGarantiaCliente=true;
	public Boolean cargarid_clienteGarantiaCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteGarantiaCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_garantia_empresaGarantiaCliente=null;
	public Boolean mostrarid_tipo_garantia_empresaGarantiaCliente=true;
	public Boolean activarid_tipo_garantia_empresaGarantiaCliente=true;
	public Boolean cargarid_tipo_garantia_empresaGarantiaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_garantia_empresaGarantiaCliente=false;//ConEventDepend=true

	public Border resaltarvalorGarantiaCliente=null;
	public Boolean mostrarvalorGarantiaCliente=true;
	public Boolean activarvalorGarantiaCliente=true;

	public Border resaltarfecha_recepcionGarantiaCliente=null;
	public Boolean mostrarfecha_recepcionGarantiaCliente=true;
	public Boolean activarfecha_recepcionGarantiaCliente=false;

	public Border resaltarfecha_firmaGarantiaCliente=null;
	public Boolean mostrarfecha_firmaGarantiaCliente=true;
	public Boolean activarfecha_firmaGarantiaCliente=false;

	public Border resaltarfecha_devolucionGarantiaCliente=null;
	public Boolean mostrarfecha_devolucionGarantiaCliente=true;
	public Boolean activarfecha_devolucionGarantiaCliente=false;

	public Border resaltarbeneficiarioGarantiaCliente=null;
	public Boolean mostrarbeneficiarioGarantiaCliente=true;
	public Boolean activarbeneficiarioGarantiaCliente=true;

	public Border resaltarid_estado_garantia_clienteGarantiaCliente=null;
	public Boolean mostrarid_estado_garantia_clienteGarantiaCliente=true;
	public Boolean activarid_estado_garantia_clienteGarantiaCliente=true;
	public Boolean cargarid_estado_garantia_clienteGarantiaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_garantia_clienteGarantiaCliente=false;//ConEventDepend=true

	
	

	public Border setResaltaridGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//garantiaclienteBeanSwingJInternalFrame.jTtoolBarGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltaridGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGarantiaCliente() {
		return this.resaltaridGarantiaCliente;
	}

	public void setResaltaridGarantiaCliente(Border borderResaltar) {
		this.resaltaridGarantiaCliente= borderResaltar;
	}

	public Boolean getMostraridGarantiaCliente() {
		return this.mostraridGarantiaCliente;
	}

	public void setMostraridGarantiaCliente(Boolean mostraridGarantiaCliente) {
		this.mostraridGarantiaCliente= mostraridGarantiaCliente;
	}

	public Boolean getActivaridGarantiaCliente() {
		return this.activaridGarantiaCliente;
	}

	public void setActivaridGarantiaCliente(Boolean activaridGarantiaCliente) {
		this.activaridGarantiaCliente= activaridGarantiaCliente;
	}

	public Border setResaltarid_empresaGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//garantiaclienteBeanSwingJInternalFrame.jTtoolBarGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGarantiaCliente() {
		return this.resaltarid_empresaGarantiaCliente;
	}

	public void setResaltarid_empresaGarantiaCliente(Border borderResaltar) {
		this.resaltarid_empresaGarantiaCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaGarantiaCliente() {
		return this.mostrarid_empresaGarantiaCliente;
	}

	public void setMostrarid_empresaGarantiaCliente(Boolean mostrarid_empresaGarantiaCliente) {
		this.mostrarid_empresaGarantiaCliente= mostrarid_empresaGarantiaCliente;
	}

	public Boolean getActivarid_empresaGarantiaCliente() {
		return this.activarid_empresaGarantiaCliente;
	}

	public void setActivarid_empresaGarantiaCliente(Boolean activarid_empresaGarantiaCliente) {
		this.activarid_empresaGarantiaCliente= activarid_empresaGarantiaCliente;
	}

	public Boolean getCargarid_empresaGarantiaCliente() {
		return this.cargarid_empresaGarantiaCliente;
	}

	public void setCargarid_empresaGarantiaCliente(Boolean cargarid_empresaGarantiaCliente) {
		this.cargarid_empresaGarantiaCliente= cargarid_empresaGarantiaCliente;
	}

	public Border setResaltarid_sucursalGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//garantiaclienteBeanSwingJInternalFrame.jTtoolBarGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarid_sucursalGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalGarantiaCliente() {
		return this.resaltarid_sucursalGarantiaCliente;
	}

	public void setResaltarid_sucursalGarantiaCliente(Border borderResaltar) {
		this.resaltarid_sucursalGarantiaCliente= borderResaltar;
	}

	public Boolean getMostrarid_sucursalGarantiaCliente() {
		return this.mostrarid_sucursalGarantiaCliente;
	}

	public void setMostrarid_sucursalGarantiaCliente(Boolean mostrarid_sucursalGarantiaCliente) {
		this.mostrarid_sucursalGarantiaCliente= mostrarid_sucursalGarantiaCliente;
	}

	public Boolean getActivarid_sucursalGarantiaCliente() {
		return this.activarid_sucursalGarantiaCliente;
	}

	public void setActivarid_sucursalGarantiaCliente(Boolean activarid_sucursalGarantiaCliente) {
		this.activarid_sucursalGarantiaCliente= activarid_sucursalGarantiaCliente;
	}

	public Boolean getCargarid_sucursalGarantiaCliente() {
		return this.cargarid_sucursalGarantiaCliente;
	}

	public void setCargarid_sucursalGarantiaCliente(Boolean cargarid_sucursalGarantiaCliente) {
		this.cargarid_sucursalGarantiaCliente= cargarid_sucursalGarantiaCliente;
	}

	public Border setResaltarid_clienteGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//garantiaclienteBeanSwingJInternalFrame.jTtoolBarGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarid_clienteGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteGarantiaCliente() {
		return this.resaltarid_clienteGarantiaCliente;
	}

	public void setResaltarid_clienteGarantiaCliente(Border borderResaltar) {
		this.resaltarid_clienteGarantiaCliente= borderResaltar;
	}

	public Boolean getMostrarid_clienteGarantiaCliente() {
		return this.mostrarid_clienteGarantiaCliente;
	}

	public void setMostrarid_clienteGarantiaCliente(Boolean mostrarid_clienteGarantiaCliente) {
		this.mostrarid_clienteGarantiaCliente= mostrarid_clienteGarantiaCliente;
	}

	public Boolean getActivarid_clienteGarantiaCliente() {
		return this.activarid_clienteGarantiaCliente;
	}

	public void setActivarid_clienteGarantiaCliente(Boolean activarid_clienteGarantiaCliente) {
		this.activarid_clienteGarantiaCliente= activarid_clienteGarantiaCliente;
	}

	public Boolean getCargarid_clienteGarantiaCliente() {
		return this.cargarid_clienteGarantiaCliente;
	}

	public void setCargarid_clienteGarantiaCliente(Boolean cargarid_clienteGarantiaCliente) {
		this.cargarid_clienteGarantiaCliente= cargarid_clienteGarantiaCliente;
	}

	public Border setResaltarid_tipo_garantia_empresaGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//garantiaclienteBeanSwingJInternalFrame.jTtoolBarGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_garantia_empresaGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_garantia_empresaGarantiaCliente() {
		return this.resaltarid_tipo_garantia_empresaGarantiaCliente;
	}

	public void setResaltarid_tipo_garantia_empresaGarantiaCliente(Border borderResaltar) {
		this.resaltarid_tipo_garantia_empresaGarantiaCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_garantia_empresaGarantiaCliente() {
		return this.mostrarid_tipo_garantia_empresaGarantiaCliente;
	}

	public void setMostrarid_tipo_garantia_empresaGarantiaCliente(Boolean mostrarid_tipo_garantia_empresaGarantiaCliente) {
		this.mostrarid_tipo_garantia_empresaGarantiaCliente= mostrarid_tipo_garantia_empresaGarantiaCliente;
	}

	public Boolean getActivarid_tipo_garantia_empresaGarantiaCliente() {
		return this.activarid_tipo_garantia_empresaGarantiaCliente;
	}

	public void setActivarid_tipo_garantia_empresaGarantiaCliente(Boolean activarid_tipo_garantia_empresaGarantiaCliente) {
		this.activarid_tipo_garantia_empresaGarantiaCliente= activarid_tipo_garantia_empresaGarantiaCliente;
	}

	public Boolean getCargarid_tipo_garantia_empresaGarantiaCliente() {
		return this.cargarid_tipo_garantia_empresaGarantiaCliente;
	}

	public void setCargarid_tipo_garantia_empresaGarantiaCliente(Boolean cargarid_tipo_garantia_empresaGarantiaCliente) {
		this.cargarid_tipo_garantia_empresaGarantiaCliente= cargarid_tipo_garantia_empresaGarantiaCliente;
	}

	public Border setResaltarvalorGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//garantiaclienteBeanSwingJInternalFrame.jTtoolBarGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarvalorGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorGarantiaCliente() {
		return this.resaltarvalorGarantiaCliente;
	}

	public void setResaltarvalorGarantiaCliente(Border borderResaltar) {
		this.resaltarvalorGarantiaCliente= borderResaltar;
	}

	public Boolean getMostrarvalorGarantiaCliente() {
		return this.mostrarvalorGarantiaCliente;
	}

	public void setMostrarvalorGarantiaCliente(Boolean mostrarvalorGarantiaCliente) {
		this.mostrarvalorGarantiaCliente= mostrarvalorGarantiaCliente;
	}

	public Boolean getActivarvalorGarantiaCliente() {
		return this.activarvalorGarantiaCliente;
	}

	public void setActivarvalorGarantiaCliente(Boolean activarvalorGarantiaCliente) {
		this.activarvalorGarantiaCliente= activarvalorGarantiaCliente;
	}

	public Border setResaltarfecha_recepcionGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//garantiaclienteBeanSwingJInternalFrame.jTtoolBarGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_recepcionGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_recepcionGarantiaCliente() {
		return this.resaltarfecha_recepcionGarantiaCliente;
	}

	public void setResaltarfecha_recepcionGarantiaCliente(Border borderResaltar) {
		this.resaltarfecha_recepcionGarantiaCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_recepcionGarantiaCliente() {
		return this.mostrarfecha_recepcionGarantiaCliente;
	}

	public void setMostrarfecha_recepcionGarantiaCliente(Boolean mostrarfecha_recepcionGarantiaCliente) {
		this.mostrarfecha_recepcionGarantiaCliente= mostrarfecha_recepcionGarantiaCliente;
	}

	public Boolean getActivarfecha_recepcionGarantiaCliente() {
		return this.activarfecha_recepcionGarantiaCliente;
	}

	public void setActivarfecha_recepcionGarantiaCliente(Boolean activarfecha_recepcionGarantiaCliente) {
		this.activarfecha_recepcionGarantiaCliente= activarfecha_recepcionGarantiaCliente;
	}

	public Border setResaltarfecha_firmaGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//garantiaclienteBeanSwingJInternalFrame.jTtoolBarGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_firmaGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_firmaGarantiaCliente() {
		return this.resaltarfecha_firmaGarantiaCliente;
	}

	public void setResaltarfecha_firmaGarantiaCliente(Border borderResaltar) {
		this.resaltarfecha_firmaGarantiaCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_firmaGarantiaCliente() {
		return this.mostrarfecha_firmaGarantiaCliente;
	}

	public void setMostrarfecha_firmaGarantiaCliente(Boolean mostrarfecha_firmaGarantiaCliente) {
		this.mostrarfecha_firmaGarantiaCliente= mostrarfecha_firmaGarantiaCliente;
	}

	public Boolean getActivarfecha_firmaGarantiaCliente() {
		return this.activarfecha_firmaGarantiaCliente;
	}

	public void setActivarfecha_firmaGarantiaCliente(Boolean activarfecha_firmaGarantiaCliente) {
		this.activarfecha_firmaGarantiaCliente= activarfecha_firmaGarantiaCliente;
	}

	public Border setResaltarfecha_devolucionGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//garantiaclienteBeanSwingJInternalFrame.jTtoolBarGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_devolucionGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_devolucionGarantiaCliente() {
		return this.resaltarfecha_devolucionGarantiaCliente;
	}

	public void setResaltarfecha_devolucionGarantiaCliente(Border borderResaltar) {
		this.resaltarfecha_devolucionGarantiaCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_devolucionGarantiaCliente() {
		return this.mostrarfecha_devolucionGarantiaCliente;
	}

	public void setMostrarfecha_devolucionGarantiaCliente(Boolean mostrarfecha_devolucionGarantiaCliente) {
		this.mostrarfecha_devolucionGarantiaCliente= mostrarfecha_devolucionGarantiaCliente;
	}

	public Boolean getActivarfecha_devolucionGarantiaCliente() {
		return this.activarfecha_devolucionGarantiaCliente;
	}

	public void setActivarfecha_devolucionGarantiaCliente(Boolean activarfecha_devolucionGarantiaCliente) {
		this.activarfecha_devolucionGarantiaCliente= activarfecha_devolucionGarantiaCliente;
	}

	public Border setResaltarbeneficiarioGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//garantiaclienteBeanSwingJInternalFrame.jTtoolBarGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioGarantiaCliente() {
		return this.resaltarbeneficiarioGarantiaCliente;
	}

	public void setResaltarbeneficiarioGarantiaCliente(Border borderResaltar) {
		this.resaltarbeneficiarioGarantiaCliente= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioGarantiaCliente() {
		return this.mostrarbeneficiarioGarantiaCliente;
	}

	public void setMostrarbeneficiarioGarantiaCliente(Boolean mostrarbeneficiarioGarantiaCliente) {
		this.mostrarbeneficiarioGarantiaCliente= mostrarbeneficiarioGarantiaCliente;
	}

	public Boolean getActivarbeneficiarioGarantiaCliente() {
		return this.activarbeneficiarioGarantiaCliente;
	}

	public void setActivarbeneficiarioGarantiaCliente(Boolean activarbeneficiarioGarantiaCliente) {
		this.activarbeneficiarioGarantiaCliente= activarbeneficiarioGarantiaCliente;
	}

	public Border setResaltarid_estado_garantia_clienteGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//garantiaclienteBeanSwingJInternalFrame.jTtoolBarGarantiaCliente.setBorder(borderResaltar);
		
		this.resaltarid_estado_garantia_clienteGarantiaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_garantia_clienteGarantiaCliente() {
		return this.resaltarid_estado_garantia_clienteGarantiaCliente;
	}

	public void setResaltarid_estado_garantia_clienteGarantiaCliente(Border borderResaltar) {
		this.resaltarid_estado_garantia_clienteGarantiaCliente= borderResaltar;
	}

	public Boolean getMostrarid_estado_garantia_clienteGarantiaCliente() {
		return this.mostrarid_estado_garantia_clienteGarantiaCliente;
	}

	public void setMostrarid_estado_garantia_clienteGarantiaCliente(Boolean mostrarid_estado_garantia_clienteGarantiaCliente) {
		this.mostrarid_estado_garantia_clienteGarantiaCliente= mostrarid_estado_garantia_clienteGarantiaCliente;
	}

	public Boolean getActivarid_estado_garantia_clienteGarantiaCliente() {
		return this.activarid_estado_garantia_clienteGarantiaCliente;
	}

	public void setActivarid_estado_garantia_clienteGarantiaCliente(Boolean activarid_estado_garantia_clienteGarantiaCliente) {
		this.activarid_estado_garantia_clienteGarantiaCliente= activarid_estado_garantia_clienteGarantiaCliente;
	}

	public Boolean getCargarid_estado_garantia_clienteGarantiaCliente() {
		return this.cargarid_estado_garantia_clienteGarantiaCliente;
	}

	public void setCargarid_estado_garantia_clienteGarantiaCliente(Boolean cargarid_estado_garantia_clienteGarantiaCliente) {
		this.cargarid_estado_garantia_clienteGarantiaCliente= cargarid_estado_garantia_clienteGarantiaCliente;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridGarantiaCliente(esInicial);
		this.setMostrarid_empresaGarantiaCliente(esInicial);
		this.setMostrarid_sucursalGarantiaCliente(esInicial);
		this.setMostrarid_clienteGarantiaCliente(esInicial);
		this.setMostrarid_tipo_garantia_empresaGarantiaCliente(esInicial);
		this.setMostrarvalorGarantiaCliente(esInicial);
		this.setMostrarfecha_recepcionGarantiaCliente(esInicial);
		this.setMostrarfecha_firmaGarantiaCliente(esInicial);
		this.setMostrarfecha_devolucionGarantiaCliente(esInicial);
		this.setMostrarbeneficiarioGarantiaCliente(esInicial);
		this.setMostrarid_estado_garantia_clienteGarantiaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.ID)) {
				this.setMostraridGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA)) {
				this.setMostrarid_tipo_garantia_empresaGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.VALOR)) {
				this.setMostrarvalorGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.FECHARECEPCION)) {
				this.setMostrarfecha_recepcionGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.FECHAFIRMA)) {
				this.setMostrarfecha_firmaGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.FECHADEVOLUCION)) {
				this.setMostrarfecha_devolucionGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDESTADOGARANTIACLIENTE)) {
				this.setMostrarid_estado_garantia_clienteGarantiaCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridGarantiaCliente(esInicial);
		this.setActivarid_empresaGarantiaCliente(esInicial);
		this.setActivarid_sucursalGarantiaCliente(esInicial);
		this.setActivarid_clienteGarantiaCliente(esInicial);
		this.setActivarid_tipo_garantia_empresaGarantiaCliente(esInicial);
		this.setActivarvalorGarantiaCliente(esInicial);
		this.setActivarfecha_recepcionGarantiaCliente(esInicial);
		this.setActivarfecha_firmaGarantiaCliente(esInicial);
		this.setActivarfecha_devolucionGarantiaCliente(esInicial);
		this.setActivarbeneficiarioGarantiaCliente(esInicial);
		this.setActivarid_estado_garantia_clienteGarantiaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.ID)) {
				this.setActivaridGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA)) {
				this.setActivarid_tipo_garantia_empresaGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.VALOR)) {
				this.setActivarvalorGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.FECHARECEPCION)) {
				this.setActivarfecha_recepcionGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.FECHAFIRMA)) {
				this.setActivarfecha_firmaGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.FECHADEVOLUCION)) {
				this.setActivarfecha_devolucionGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDESTADOGARANTIACLIENTE)) {
				this.setActivarid_estado_garantia_clienteGarantiaCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGarantiaCliente(esInicial);
		this.setResaltarid_empresaGarantiaCliente(esInicial);
		this.setResaltarid_sucursalGarantiaCliente(esInicial);
		this.setResaltarid_clienteGarantiaCliente(esInicial);
		this.setResaltarid_tipo_garantia_empresaGarantiaCliente(esInicial);
		this.setResaltarvalorGarantiaCliente(esInicial);
		this.setResaltarfecha_recepcionGarantiaCliente(esInicial);
		this.setResaltarfecha_firmaGarantiaCliente(esInicial);
		this.setResaltarfecha_devolucionGarantiaCliente(esInicial);
		this.setResaltarbeneficiarioGarantiaCliente(esInicial);
		this.setResaltarid_estado_garantia_clienteGarantiaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.ID)) {
				this.setResaltaridGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA)) {
				this.setResaltarid_tipo_garantia_empresaGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.VALOR)) {
				this.setResaltarvalorGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.FECHARECEPCION)) {
				this.setResaltarfecha_recepcionGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.FECHAFIRMA)) {
				this.setResaltarfecha_firmaGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.FECHADEVOLUCION)) {
				this.setResaltarfecha_devolucionGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioGarantiaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(GarantiaClienteConstantesFunciones.IDESTADOGARANTIACLIENTE)) {
				this.setResaltarid_estado_garantia_clienteGarantiaCliente(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdClienteGarantiaCliente=true;

	public Boolean getMostrarFK_IdClienteGarantiaCliente() {
		return this.mostrarFK_IdClienteGarantiaCliente;
	}

	public void setMostrarFK_IdClienteGarantiaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteGarantiaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaGarantiaCliente=true;

	public Boolean getMostrarFK_IdEmpresaGarantiaCliente() {
		return this.mostrarFK_IdEmpresaGarantiaCliente;
	}

	public void setMostrarFK_IdEmpresaGarantiaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaGarantiaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoGarantiaClienteGarantiaCliente=true;

	public Boolean getMostrarFK_IdEstadoGarantiaClienteGarantiaCliente() {
		return this.mostrarFK_IdEstadoGarantiaClienteGarantiaCliente;
	}

	public void setMostrarFK_IdEstadoGarantiaClienteGarantiaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoGarantiaClienteGarantiaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalGarantiaCliente=true;

	public Boolean getMostrarFK_IdSucursalGarantiaCliente() {
		return this.mostrarFK_IdSucursalGarantiaCliente;
	}

	public void setMostrarFK_IdSucursalGarantiaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalGarantiaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGarantiaEmpresaGarantiaCliente=true;

	public Boolean getMostrarFK_IdTipoGarantiaEmpresaGarantiaCliente() {
		return this.mostrarFK_IdTipoGarantiaEmpresaGarantiaCliente;
	}

	public void setMostrarFK_IdTipoGarantiaEmpresaGarantiaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGarantiaEmpresaGarantiaCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteGarantiaCliente=true;

	public Boolean getActivarFK_IdClienteGarantiaCliente() {
		return this.activarFK_IdClienteGarantiaCliente;
	}

	public void setActivarFK_IdClienteGarantiaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClienteGarantiaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaGarantiaCliente=true;

	public Boolean getActivarFK_IdEmpresaGarantiaCliente() {
		return this.activarFK_IdEmpresaGarantiaCliente;
	}

	public void setActivarFK_IdEmpresaGarantiaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaGarantiaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoGarantiaClienteGarantiaCliente=true;

	public Boolean getActivarFK_IdEstadoGarantiaClienteGarantiaCliente() {
		return this.activarFK_IdEstadoGarantiaClienteGarantiaCliente;
	}

	public void setActivarFK_IdEstadoGarantiaClienteGarantiaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoGarantiaClienteGarantiaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalGarantiaCliente=true;

	public Boolean getActivarFK_IdSucursalGarantiaCliente() {
		return this.activarFK_IdSucursalGarantiaCliente;
	}

	public void setActivarFK_IdSucursalGarantiaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalGarantiaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGarantiaEmpresaGarantiaCliente=true;

	public Boolean getActivarFK_IdTipoGarantiaEmpresaGarantiaCliente() {
		return this.activarFK_IdTipoGarantiaEmpresaGarantiaCliente;
	}

	public void setActivarFK_IdTipoGarantiaEmpresaGarantiaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGarantiaEmpresaGarantiaCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteGarantiaCliente=null;

	public Border getResaltarFK_IdClienteGarantiaCliente() {
		return this.resaltarFK_IdClienteGarantiaCliente;
	}

	public void setResaltarFK_IdClienteGarantiaCliente(Border borderResaltar) {
		this.resaltarFK_IdClienteGarantiaCliente= borderResaltar;
	}

	public void setResaltarFK_IdClienteGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteGarantiaCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaGarantiaCliente=null;

	public Border getResaltarFK_IdEmpresaGarantiaCliente() {
		return this.resaltarFK_IdEmpresaGarantiaCliente;
	}

	public void setResaltarFK_IdEmpresaGarantiaCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaGarantiaCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaGarantiaCliente= borderResaltar;
	}

	public Border resaltarFK_IdEstadoGarantiaClienteGarantiaCliente=null;

	public Border getResaltarFK_IdEstadoGarantiaClienteGarantiaCliente() {
		return this.resaltarFK_IdEstadoGarantiaClienteGarantiaCliente;
	}

	public void setResaltarFK_IdEstadoGarantiaClienteGarantiaCliente(Border borderResaltar) {
		this.resaltarFK_IdEstadoGarantiaClienteGarantiaCliente= borderResaltar;
	}

	public void setResaltarFK_IdEstadoGarantiaClienteGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoGarantiaClienteGarantiaCliente= borderResaltar;
	}

	public Border resaltarFK_IdSucursalGarantiaCliente=null;

	public Border getResaltarFK_IdSucursalGarantiaCliente() {
		return this.resaltarFK_IdSucursalGarantiaCliente;
	}

	public void setResaltarFK_IdSucursalGarantiaCliente(Border borderResaltar) {
		this.resaltarFK_IdSucursalGarantiaCliente= borderResaltar;
	}

	public void setResaltarFK_IdSucursalGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalGarantiaCliente= borderResaltar;
	}

	public Border resaltarFK_IdTipoGarantiaEmpresaGarantiaCliente=null;

	public Border getResaltarFK_IdTipoGarantiaEmpresaGarantiaCliente() {
		return this.resaltarFK_IdTipoGarantiaEmpresaGarantiaCliente;
	}

	public void setResaltarFK_IdTipoGarantiaEmpresaGarantiaCliente(Border borderResaltar) {
		this.resaltarFK_IdTipoGarantiaEmpresaGarantiaCliente= borderResaltar;
	}

	public void setResaltarFK_IdTipoGarantiaEmpresaGarantiaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*GarantiaClienteBeanSwingJInternalFrame garantiaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGarantiaEmpresaGarantiaCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}