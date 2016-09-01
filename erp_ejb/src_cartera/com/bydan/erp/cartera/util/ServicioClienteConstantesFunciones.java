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


import com.bydan.erp.cartera.util.ServicioClienteConstantesFunciones;
import com.bydan.erp.cartera.util.ServicioClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ServicioClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ServicioClienteConstantesFunciones extends ServicioClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ServicioCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ServicioCliente"+ServicioClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ServicioClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ServicioClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ServicioClienteConstantesFunciones.SCHEMA+"_"+ServicioClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ServicioClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ServicioClienteConstantesFunciones.SCHEMA+"_"+ServicioClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ServicioClienteConstantesFunciones.SCHEMA+"_"+ServicioClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ServicioClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ServicioClienteConstantesFunciones.SCHEMA+"_"+ServicioClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ServicioClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ServicioClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ServicioClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ServicioClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ServicioClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ServicioClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ServicioClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ServicioClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ServicioClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ServicioClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Servicio Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Servicio Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Servicio Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ServicioCliente";
	public static final String OBJECTNAME="serviciocliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="servicio_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select serviciocliente from "+ServicioClienteConstantesFunciones.SPERSISTENCENAME+" serviciocliente";
	public static String QUERYSELECTNATIVE="select "+ServicioClienteConstantesFunciones.SCHEMA+"."+ServicioClienteConstantesFunciones.TABLENAME+".id,"+ServicioClienteConstantesFunciones.SCHEMA+"."+ServicioClienteConstantesFunciones.TABLENAME+".version_row,"+ServicioClienteConstantesFunciones.SCHEMA+"."+ServicioClienteConstantesFunciones.TABLENAME+".id_empresa,"+ServicioClienteConstantesFunciones.SCHEMA+"."+ServicioClienteConstantesFunciones.TABLENAME+".id_cliente,"+ServicioClienteConstantesFunciones.SCHEMA+"."+ServicioClienteConstantesFunciones.TABLENAME+".id_bodega,"+ServicioClienteConstantesFunciones.SCHEMA+"."+ServicioClienteConstantesFunciones.TABLENAME+".id_producto,"+ServicioClienteConstantesFunciones.SCHEMA+"."+ServicioClienteConstantesFunciones.TABLENAME+".id_tipo_precio,"+ServicioClienteConstantesFunciones.SCHEMA+"."+ServicioClienteConstantesFunciones.TABLENAME+".precio,"+ServicioClienteConstantesFunciones.SCHEMA+"."+ServicioClienteConstantesFunciones.TABLENAME+".descripcion from "+ServicioClienteConstantesFunciones.SCHEMA+"."+ServicioClienteConstantesFunciones.TABLENAME;//+" as "+ServicioClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ServicioClienteConstantesFuncionesAdditional servicioclienteConstantesFuncionesAdditional=null;
	
	public ServicioClienteConstantesFuncionesAdditional getServicioClienteConstantesFuncionesAdditional() {
		return this.servicioclienteConstantesFuncionesAdditional;
	}
	
	public void setServicioClienteConstantesFuncionesAdditional(ServicioClienteConstantesFuncionesAdditional servicioclienteConstantesFuncionesAdditional) {
		try {
			this.servicioclienteConstantesFuncionesAdditional=servicioclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String PRECIO= "precio";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getServicioClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ServicioClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=ServicioClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ServicioClienteConstantesFunciones.IDCLIENTE)) {sLabelColumna=ServicioClienteConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ServicioClienteConstantesFunciones.IDBODEGA)) {sLabelColumna=ServicioClienteConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ServicioClienteConstantesFunciones.IDPRODUCTO)) {sLabelColumna=ServicioClienteConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(ServicioClienteConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=ServicioClienteConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(ServicioClienteConstantesFunciones.PRECIO)) {sLabelColumna=ServicioClienteConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(ServicioClienteConstantesFunciones.DESCRIPCION)) {sLabelColumna=ServicioClienteConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getServicioClienteDescripcion(ServicioCliente serviciocliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(serviciocliente !=null/* && serviciocliente.getId()!=0*/) {
			if(serviciocliente.getId()!=null) {
				sDescripcion=serviciocliente.getId().toString();
			}//servicioclienteserviciocliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getServicioClienteDescripcionDetallado(ServicioCliente serviciocliente) {
		String sDescripcion="";
			
		sDescripcion+=ServicioClienteConstantesFunciones.ID+"=";
		sDescripcion+=serviciocliente.getId().toString()+",";
		sDescripcion+=ServicioClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=serviciocliente.getVersionRow().toString()+",";
		sDescripcion+=ServicioClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=serviciocliente.getid_empresa().toString()+",";
		sDescripcion+=ServicioClienteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=serviciocliente.getid_cliente().toString()+",";
		sDescripcion+=ServicioClienteConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=serviciocliente.getid_bodega().toString()+",";
		sDescripcion+=ServicioClienteConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=serviciocliente.getid_producto().toString()+",";
		sDescripcion+=ServicioClienteConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=serviciocliente.getid_tipo_precio().toString()+",";
		sDescripcion+=ServicioClienteConstantesFunciones.PRECIO+"=";
		sDescripcion+=serviciocliente.getprecio().toString()+",";
		sDescripcion+=ServicioClienteConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=serviciocliente.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setServicioClienteDescripcion(ServicioCliente serviciocliente,String sValor) throws Exception {			
		if(serviciocliente !=null) {
			//servicioclienteserviciocliente.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosServicioCliente(ServicioCliente serviciocliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		serviciocliente.setdescripcion(serviciocliente.getdescripcion().trim());
	}
	
	public static void quitarEspaciosServicioClientes(List<ServicioCliente> servicioclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ServicioCliente serviciocliente: servicioclientes) {
			serviciocliente.setdescripcion(serviciocliente.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresServicioCliente(ServicioCliente serviciocliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && serviciocliente.getConCambioAuxiliar()) {
			serviciocliente.setIsDeleted(serviciocliente.getIsDeletedAuxiliar());	
			serviciocliente.setIsNew(serviciocliente.getIsNewAuxiliar());	
			serviciocliente.setIsChanged(serviciocliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			serviciocliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			serviciocliente.setIsDeletedAuxiliar(false);	
			serviciocliente.setIsNewAuxiliar(false);	
			serviciocliente.setIsChangedAuxiliar(false);
			
			serviciocliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresServicioClientes(List<ServicioCliente> servicioclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ServicioCliente serviciocliente : servicioclientes) {
			if(conAsignarBase && serviciocliente.getConCambioAuxiliar()) {
				serviciocliente.setIsDeleted(serviciocliente.getIsDeletedAuxiliar());	
				serviciocliente.setIsNew(serviciocliente.getIsNewAuxiliar());	
				serviciocliente.setIsChanged(serviciocliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				serviciocliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				serviciocliente.setIsDeletedAuxiliar(false);	
				serviciocliente.setIsNewAuxiliar(false);	
				serviciocliente.setIsChangedAuxiliar(false);
				
				serviciocliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresServicioCliente(ServicioCliente serviciocliente,Boolean conEnteros) throws Exception  {
		serviciocliente.setprecio(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresServicioClientes(List<ServicioCliente> servicioclientes,Boolean conEnteros) throws Exception  {
		
		for(ServicioCliente serviciocliente: servicioclientes) {
			serviciocliente.setprecio(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaServicioCliente(List<ServicioCliente> servicioclientes,ServicioCliente servicioclienteAux) throws Exception  {
		ServicioClienteConstantesFunciones.InicializarValoresServicioCliente(servicioclienteAux,true);
		
		for(ServicioCliente serviciocliente: servicioclientes) {
			if(serviciocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			servicioclienteAux.setprecio(servicioclienteAux.getprecio()+serviciocliente.getprecio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesServicioCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ServicioClienteConstantesFunciones.getArrayColumnasGlobalesServicioCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesServicioCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ServicioClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ServicioClienteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoServicioCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ServicioCliente> servicioclientes,ServicioCliente serviciocliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ServicioCliente servicioclienteAux: servicioclientes) {
			if(servicioclienteAux!=null && serviciocliente!=null) {
				if((servicioclienteAux.getId()==null && serviciocliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(servicioclienteAux.getId()!=null && serviciocliente.getId()!=null){
					if(servicioclienteAux.getId().equals(serviciocliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaServicioCliente(List<ServicioCliente> servicioclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
	
		for(ServicioCliente serviciocliente: servicioclientes) {			
			if(serviciocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=serviciocliente.getprecio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ServicioClienteConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ServicioClienteConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaServicioCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ServicioClienteConstantesFunciones.LABEL_ID, ServicioClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioClienteConstantesFunciones.LABEL_VERSIONROW, ServicioClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioClienteConstantesFunciones.LABEL_IDEMPRESA, ServicioClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioClienteConstantesFunciones.LABEL_IDCLIENTE, ServicioClienteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioClienteConstantesFunciones.LABEL_IDBODEGA, ServicioClienteConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioClienteConstantesFunciones.LABEL_IDPRODUCTO, ServicioClienteConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioClienteConstantesFunciones.LABEL_IDTIPOPRECIO, ServicioClienteConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioClienteConstantesFunciones.LABEL_PRECIO, ServicioClienteConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ServicioClienteConstantesFunciones.LABEL_DESCRIPCION, ServicioClienteConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasServicioCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ServicioClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioClienteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioClienteConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioClienteConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioClienteConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioClienteConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ServicioClienteConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarServicioCliente() throws Exception  {
		return ServicioClienteConstantesFunciones.getTiposSeleccionarServicioCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarServicioCliente(Boolean conFk) throws Exception  {
		return ServicioClienteConstantesFunciones.getTiposSeleccionarServicioCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarServicioCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ServicioClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioClienteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ServicioClienteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioClienteConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ServicioClienteConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioClienteConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(ServicioClienteConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioClienteConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(ServicioClienteConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioClienteConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(ServicioClienteConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ServicioClienteConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ServicioClienteConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesServicioCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesServicioCliente(ServicioCliente servicioclienteAux) throws Exception {
		
			servicioclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(servicioclienteAux.getEmpresa()));
			servicioclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(servicioclienteAux.getCliente()));
			servicioclienteAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(servicioclienteAux.getBodega()));
			servicioclienteAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(servicioclienteAux.getProducto()));
			servicioclienteAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(servicioclienteAux.getTipoPrecio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesServicioCliente(List<ServicioCliente> servicioclientesTemp) throws Exception {
		for(ServicioCliente servicioclienteAux:servicioclientesTemp) {
			
			servicioclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(servicioclienteAux.getEmpresa()));
			servicioclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(servicioclienteAux.getCliente()));
			servicioclienteAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(servicioclienteAux.getBodega()));
			servicioclienteAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(servicioclienteAux.getProducto()));
			servicioclienteAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(servicioclienteAux.getTipoPrecio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfServicioCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(TipoPrecio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfServicioCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfServicioCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ServicioClienteConstantesFunciones.getClassesRelationshipsOfServicioCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfServicioCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfServicioCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ServicioClienteConstantesFunciones.getClassesRelationshipsFromStringsOfServicioCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfServicioCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ServicioCliente serviciocliente,List<ServicioCliente> servicioclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ServicioCliente servicioclienteEncontrado=null;
			
			for(ServicioCliente servicioclienteLocal:servicioclientes) {
				if(servicioclienteLocal.getId().equals(serviciocliente.getId())) {
					servicioclienteEncontrado=servicioclienteLocal;
					
					servicioclienteLocal.setIsChanged(serviciocliente.getIsChanged());
					servicioclienteLocal.setIsNew(serviciocliente.getIsNew());
					servicioclienteLocal.setIsDeleted(serviciocliente.getIsDeleted());
					
					servicioclienteLocal.setGeneralEntityOriginal(serviciocliente.getGeneralEntityOriginal());
					
					servicioclienteLocal.setId(serviciocliente.getId());	
					servicioclienteLocal.setVersionRow(serviciocliente.getVersionRow());	
					servicioclienteLocal.setid_empresa(serviciocliente.getid_empresa());	
					servicioclienteLocal.setid_cliente(serviciocliente.getid_cliente());	
					servicioclienteLocal.setid_bodega(serviciocliente.getid_bodega());	
					servicioclienteLocal.setid_producto(serviciocliente.getid_producto());	
					servicioclienteLocal.setid_tipo_precio(serviciocliente.getid_tipo_precio());	
					servicioclienteLocal.setprecio(serviciocliente.getprecio());	
					servicioclienteLocal.setdescripcion(serviciocliente.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!serviciocliente.getIsDeleted()) {
				if(!existe) {
					servicioclientes.add(serviciocliente);
				}
			} else {
				if(servicioclienteEncontrado!=null && permiteQuitar)  {
					servicioclientes.remove(servicioclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ServicioCliente serviciocliente,List<ServicioCliente> servicioclientes) throws Exception {
		try	{			
			for(ServicioCliente servicioclienteLocal:servicioclientes) {
				if(servicioclienteLocal.getId().equals(serviciocliente.getId())) {
					servicioclienteLocal.setIsSelected(serviciocliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesServicioCliente(List<ServicioCliente> servicioclientesAux) throws Exception {
		//this.servicioclientesAux=servicioclientesAux;
		
		for(ServicioCliente servicioclienteAux:servicioclientesAux) {
			if(servicioclienteAux.getIsChanged()) {
				servicioclienteAux.setIsChanged(false);
			}		
			
			if(servicioclienteAux.getIsNew()) {
				servicioclienteAux.setIsNew(false);
			}	
			
			if(servicioclienteAux.getIsDeleted()) {
				servicioclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesServicioCliente(ServicioCliente servicioclienteAux) throws Exception {
		//this.servicioclienteAux=servicioclienteAux;
		
			if(servicioclienteAux.getIsChanged()) {
				servicioclienteAux.setIsChanged(false);
			}		
			
			if(servicioclienteAux.getIsNew()) {
				servicioclienteAux.setIsNew(false);
			}	
			
			if(servicioclienteAux.getIsDeleted()) {
				servicioclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ServicioCliente servicioclienteAsignar,ServicioCliente serviciocliente) throws Exception {
		servicioclienteAsignar.setId(serviciocliente.getId());	
		servicioclienteAsignar.setVersionRow(serviciocliente.getVersionRow());	
		servicioclienteAsignar.setid_empresa(serviciocliente.getid_empresa());
		servicioclienteAsignar.setempresa_descripcion(serviciocliente.getempresa_descripcion());	
		servicioclienteAsignar.setid_cliente(serviciocliente.getid_cliente());
		servicioclienteAsignar.setcliente_descripcion(serviciocliente.getcliente_descripcion());	
		servicioclienteAsignar.setid_bodega(serviciocliente.getid_bodega());
		servicioclienteAsignar.setbodega_descripcion(serviciocliente.getbodega_descripcion());	
		servicioclienteAsignar.setid_producto(serviciocliente.getid_producto());
		servicioclienteAsignar.setproducto_descripcion(serviciocliente.getproducto_descripcion());	
		servicioclienteAsignar.setid_tipo_precio(serviciocliente.getid_tipo_precio());
		servicioclienteAsignar.settipoprecio_descripcion(serviciocliente.gettipoprecio_descripcion());	
		servicioclienteAsignar.setprecio(serviciocliente.getprecio());	
		servicioclienteAsignar.setdescripcion(serviciocliente.getdescripcion());	
	}
	
	public static void inicializarServicioCliente(ServicioCliente serviciocliente) throws Exception {
		try {
				serviciocliente.setId(0L);	
					
				serviciocliente.setid_empresa(-1L);	
				serviciocliente.setid_cliente(-1L);	
				serviciocliente.setid_bodega(-1L);	
				serviciocliente.setid_producto(-1L);	
				serviciocliente.setid_tipo_precio(-1L);	
				serviciocliente.setprecio(0.0);	
				serviciocliente.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderServicioCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioClienteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioClienteConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioClienteConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioClienteConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioClienteConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ServicioClienteConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataServicioCliente(String sTipo,Row row,Workbook workbook,ServicioCliente serviciocliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciocliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciocliente.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciocliente.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciocliente.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciocliente.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciocliente.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(serviciocliente.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryServicioCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryServicioCliente() {
		return this.sFinalQueryServicioCliente;
	}
	
	public void setsFinalQueryServicioCliente(String sFinalQueryServicioCliente) {
		this.sFinalQueryServicioCliente= sFinalQueryServicioCliente;
	}
	
	public Border resaltarSeleccionarServicioCliente=null;
	
	public Border setResaltarSeleccionarServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//servicioclienteBeanSwingJInternalFrame.jTtoolBarServicioCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarServicioCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarServicioCliente() {
		return this.resaltarSeleccionarServicioCliente;
	}
	
	public void setResaltarSeleccionarServicioCliente(Border borderResaltarSeleccionarServicioCliente) {
		this.resaltarSeleccionarServicioCliente= borderResaltarSeleccionarServicioCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridServicioCliente=null;
	public Boolean mostraridServicioCliente=true;
	public Boolean activaridServicioCliente=true;

	public Border resaltarid_empresaServicioCliente=null;
	public Boolean mostrarid_empresaServicioCliente=true;
	public Boolean activarid_empresaServicioCliente=true;
	public Boolean cargarid_empresaServicioCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaServicioCliente=false;//ConEventDepend=true

	public Border resaltarid_clienteServicioCliente=null;
	public Boolean mostrarid_clienteServicioCliente=true;
	public Boolean activarid_clienteServicioCliente=true;
	public Boolean cargarid_clienteServicioCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteServicioCliente=false;//ConEventDepend=true

	public Border resaltarid_bodegaServicioCliente=null;
	public Boolean mostrarid_bodegaServicioCliente=true;
	public Boolean activarid_bodegaServicioCliente=true;
	public Boolean cargarid_bodegaServicioCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaServicioCliente=false;//ConEventDepend=true

	public Border resaltarid_productoServicioCliente=null;
	public Boolean mostrarid_productoServicioCliente=true;
	public Boolean activarid_productoServicioCliente=true;
	public Boolean cargarid_productoServicioCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoServicioCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioServicioCliente=null;
	public Boolean mostrarid_tipo_precioServicioCliente=true;
	public Boolean activarid_tipo_precioServicioCliente=true;
	public Boolean cargarid_tipo_precioServicioCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioServicioCliente=false;//ConEventDepend=true

	public Border resaltarprecioServicioCliente=null;
	public Boolean mostrarprecioServicioCliente=true;
	public Boolean activarprecioServicioCliente=true;

	public Border resaltardescripcionServicioCliente=null;
	public Boolean mostrardescripcionServicioCliente=true;
	public Boolean activardescripcionServicioCliente=true;

	
	

	public Border setResaltaridServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioclienteBeanSwingJInternalFrame.jTtoolBarServicioCliente.setBorder(borderResaltar);
		
		this.resaltaridServicioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridServicioCliente() {
		return this.resaltaridServicioCliente;
	}

	public void setResaltaridServicioCliente(Border borderResaltar) {
		this.resaltaridServicioCliente= borderResaltar;
	}

	public Boolean getMostraridServicioCliente() {
		return this.mostraridServicioCliente;
	}

	public void setMostraridServicioCliente(Boolean mostraridServicioCliente) {
		this.mostraridServicioCliente= mostraridServicioCliente;
	}

	public Boolean getActivaridServicioCliente() {
		return this.activaridServicioCliente;
	}

	public void setActivaridServicioCliente(Boolean activaridServicioCliente) {
		this.activaridServicioCliente= activaridServicioCliente;
	}

	public Border setResaltarid_empresaServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioclienteBeanSwingJInternalFrame.jTtoolBarServicioCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaServicioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaServicioCliente() {
		return this.resaltarid_empresaServicioCliente;
	}

	public void setResaltarid_empresaServicioCliente(Border borderResaltar) {
		this.resaltarid_empresaServicioCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaServicioCliente() {
		return this.mostrarid_empresaServicioCliente;
	}

	public void setMostrarid_empresaServicioCliente(Boolean mostrarid_empresaServicioCliente) {
		this.mostrarid_empresaServicioCliente= mostrarid_empresaServicioCliente;
	}

	public Boolean getActivarid_empresaServicioCliente() {
		return this.activarid_empresaServicioCliente;
	}

	public void setActivarid_empresaServicioCliente(Boolean activarid_empresaServicioCliente) {
		this.activarid_empresaServicioCliente= activarid_empresaServicioCliente;
	}

	public Boolean getCargarid_empresaServicioCliente() {
		return this.cargarid_empresaServicioCliente;
	}

	public void setCargarid_empresaServicioCliente(Boolean cargarid_empresaServicioCliente) {
		this.cargarid_empresaServicioCliente= cargarid_empresaServicioCliente;
	}

	public Border setResaltarid_clienteServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioclienteBeanSwingJInternalFrame.jTtoolBarServicioCliente.setBorder(borderResaltar);
		
		this.resaltarid_clienteServicioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteServicioCliente() {
		return this.resaltarid_clienteServicioCliente;
	}

	public void setResaltarid_clienteServicioCliente(Border borderResaltar) {
		this.resaltarid_clienteServicioCliente= borderResaltar;
	}

	public Boolean getMostrarid_clienteServicioCliente() {
		return this.mostrarid_clienteServicioCliente;
	}

	public void setMostrarid_clienteServicioCliente(Boolean mostrarid_clienteServicioCliente) {
		this.mostrarid_clienteServicioCliente= mostrarid_clienteServicioCliente;
	}

	public Boolean getActivarid_clienteServicioCliente() {
		return this.activarid_clienteServicioCliente;
	}

	public void setActivarid_clienteServicioCliente(Boolean activarid_clienteServicioCliente) {
		this.activarid_clienteServicioCliente= activarid_clienteServicioCliente;
	}

	public Boolean getCargarid_clienteServicioCliente() {
		return this.cargarid_clienteServicioCliente;
	}

	public void setCargarid_clienteServicioCliente(Boolean cargarid_clienteServicioCliente) {
		this.cargarid_clienteServicioCliente= cargarid_clienteServicioCliente;
	}

	public Border setResaltarid_bodegaServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioclienteBeanSwingJInternalFrame.jTtoolBarServicioCliente.setBorder(borderResaltar);
		
		this.resaltarid_bodegaServicioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaServicioCliente() {
		return this.resaltarid_bodegaServicioCliente;
	}

	public void setResaltarid_bodegaServicioCliente(Border borderResaltar) {
		this.resaltarid_bodegaServicioCliente= borderResaltar;
	}

	public Boolean getMostrarid_bodegaServicioCliente() {
		return this.mostrarid_bodegaServicioCliente;
	}

	public void setMostrarid_bodegaServicioCliente(Boolean mostrarid_bodegaServicioCliente) {
		this.mostrarid_bodegaServicioCliente= mostrarid_bodegaServicioCliente;
	}

	public Boolean getActivarid_bodegaServicioCliente() {
		return this.activarid_bodegaServicioCliente;
	}

	public void setActivarid_bodegaServicioCliente(Boolean activarid_bodegaServicioCliente) {
		this.activarid_bodegaServicioCliente= activarid_bodegaServicioCliente;
	}

	public Boolean getCargarid_bodegaServicioCliente() {
		return this.cargarid_bodegaServicioCliente;
	}

	public void setCargarid_bodegaServicioCliente(Boolean cargarid_bodegaServicioCliente) {
		this.cargarid_bodegaServicioCliente= cargarid_bodegaServicioCliente;
	}

	public Border setResaltarid_productoServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioclienteBeanSwingJInternalFrame.jTtoolBarServicioCliente.setBorder(borderResaltar);
		
		this.resaltarid_productoServicioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoServicioCliente() {
		return this.resaltarid_productoServicioCliente;
	}

	public void setResaltarid_productoServicioCliente(Border borderResaltar) {
		this.resaltarid_productoServicioCliente= borderResaltar;
	}

	public Boolean getMostrarid_productoServicioCliente() {
		return this.mostrarid_productoServicioCliente;
	}

	public void setMostrarid_productoServicioCliente(Boolean mostrarid_productoServicioCliente) {
		this.mostrarid_productoServicioCliente= mostrarid_productoServicioCliente;
	}

	public Boolean getActivarid_productoServicioCliente() {
		return this.activarid_productoServicioCliente;
	}

	public void setActivarid_productoServicioCliente(Boolean activarid_productoServicioCliente) {
		this.activarid_productoServicioCliente= activarid_productoServicioCliente;
	}

	public Boolean getCargarid_productoServicioCliente() {
		return this.cargarid_productoServicioCliente;
	}

	public void setCargarid_productoServicioCliente(Boolean cargarid_productoServicioCliente) {
		this.cargarid_productoServicioCliente= cargarid_productoServicioCliente;
	}

	public Border setResaltarid_tipo_precioServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioclienteBeanSwingJInternalFrame.jTtoolBarServicioCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioServicioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioServicioCliente() {
		return this.resaltarid_tipo_precioServicioCliente;
	}

	public void setResaltarid_tipo_precioServicioCliente(Border borderResaltar) {
		this.resaltarid_tipo_precioServicioCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioServicioCliente() {
		return this.mostrarid_tipo_precioServicioCliente;
	}

	public void setMostrarid_tipo_precioServicioCliente(Boolean mostrarid_tipo_precioServicioCliente) {
		this.mostrarid_tipo_precioServicioCliente= mostrarid_tipo_precioServicioCliente;
	}

	public Boolean getActivarid_tipo_precioServicioCliente() {
		return this.activarid_tipo_precioServicioCliente;
	}

	public void setActivarid_tipo_precioServicioCliente(Boolean activarid_tipo_precioServicioCliente) {
		this.activarid_tipo_precioServicioCliente= activarid_tipo_precioServicioCliente;
	}

	public Boolean getCargarid_tipo_precioServicioCliente() {
		return this.cargarid_tipo_precioServicioCliente;
	}

	public void setCargarid_tipo_precioServicioCliente(Boolean cargarid_tipo_precioServicioCliente) {
		this.cargarid_tipo_precioServicioCliente= cargarid_tipo_precioServicioCliente;
	}

	public Border setResaltarprecioServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioclienteBeanSwingJInternalFrame.jTtoolBarServicioCliente.setBorder(borderResaltar);
		
		this.resaltarprecioServicioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioServicioCliente() {
		return this.resaltarprecioServicioCliente;
	}

	public void setResaltarprecioServicioCliente(Border borderResaltar) {
		this.resaltarprecioServicioCliente= borderResaltar;
	}

	public Boolean getMostrarprecioServicioCliente() {
		return this.mostrarprecioServicioCliente;
	}

	public void setMostrarprecioServicioCliente(Boolean mostrarprecioServicioCliente) {
		this.mostrarprecioServicioCliente= mostrarprecioServicioCliente;
	}

	public Boolean getActivarprecioServicioCliente() {
		return this.activarprecioServicioCliente;
	}

	public void setActivarprecioServicioCliente(Boolean activarprecioServicioCliente) {
		this.activarprecioServicioCliente= activarprecioServicioCliente;
	}

	public Border setResaltardescripcionServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//servicioclienteBeanSwingJInternalFrame.jTtoolBarServicioCliente.setBorder(borderResaltar);
		
		this.resaltardescripcionServicioCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionServicioCliente() {
		return this.resaltardescripcionServicioCliente;
	}

	public void setResaltardescripcionServicioCliente(Border borderResaltar) {
		this.resaltardescripcionServicioCliente= borderResaltar;
	}

	public Boolean getMostrardescripcionServicioCliente() {
		return this.mostrardescripcionServicioCliente;
	}

	public void setMostrardescripcionServicioCliente(Boolean mostrardescripcionServicioCliente) {
		this.mostrardescripcionServicioCliente= mostrardescripcionServicioCliente;
	}

	public Boolean getActivardescripcionServicioCliente() {
		return this.activardescripcionServicioCliente;
	}

	public void setActivardescripcionServicioCliente(Boolean activardescripcionServicioCliente) {
		this.activardescripcionServicioCliente= activardescripcionServicioCliente;
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
		
		
		this.setMostraridServicioCliente(esInicial);
		this.setMostrarid_empresaServicioCliente(esInicial);
		this.setMostrarid_clienteServicioCliente(esInicial);
		this.setMostrarid_bodegaServicioCliente(esInicial);
		this.setMostrarid_productoServicioCliente(esInicial);
		this.setMostrarid_tipo_precioServicioCliente(esInicial);
		this.setMostrarprecioServicioCliente(esInicial);
		this.setMostrardescripcionServicioCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ServicioClienteConstantesFunciones.ID)) {
				this.setMostraridServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.PRECIO)) {
				this.setMostrarprecioServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionServicioCliente(esAsigna);
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
		
		
		this.setActivaridServicioCliente(esInicial);
		this.setActivarid_empresaServicioCliente(esInicial);
		this.setActivarid_clienteServicioCliente(esInicial);
		this.setActivarid_bodegaServicioCliente(esInicial);
		this.setActivarid_productoServicioCliente(esInicial);
		this.setActivarid_tipo_precioServicioCliente(esInicial);
		this.setActivarprecioServicioCliente(esInicial);
		this.setActivardescripcionServicioCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ServicioClienteConstantesFunciones.ID)) {
				this.setActivaridServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.PRECIO)) {
				this.setActivarprecioServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionServicioCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridServicioCliente(esInicial);
		this.setResaltarid_empresaServicioCliente(esInicial);
		this.setResaltarid_clienteServicioCliente(esInicial);
		this.setResaltarid_bodegaServicioCliente(esInicial);
		this.setResaltarid_productoServicioCliente(esInicial);
		this.setResaltarid_tipo_precioServicioCliente(esInicial);
		this.setResaltarprecioServicioCliente(esInicial);
		this.setResaltardescripcionServicioCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ServicioClienteConstantesFunciones.ID)) {
				this.setResaltaridServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.PRECIO)) {
				this.setResaltarprecioServicioCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(ServicioClienteConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionServicioCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaServicioCliente=true;

	public Boolean getMostrarFK_IdBodegaServicioCliente() {
		return this.mostrarFK_IdBodegaServicioCliente;
	}

	public void setMostrarFK_IdBodegaServicioCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaServicioCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteServicioCliente=true;

	public Boolean getMostrarFK_IdClienteServicioCliente() {
		return this.mostrarFK_IdClienteServicioCliente;
	}

	public void setMostrarFK_IdClienteServicioCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteServicioCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaServicioCliente=true;

	public Boolean getMostrarFK_IdEmpresaServicioCliente() {
		return this.mostrarFK_IdEmpresaServicioCliente;
	}

	public void setMostrarFK_IdEmpresaServicioCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaServicioCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoServicioCliente=true;

	public Boolean getMostrarFK_IdProductoServicioCliente() {
		return this.mostrarFK_IdProductoServicioCliente;
	}

	public void setMostrarFK_IdProductoServicioCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoServicioCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioServicioCliente=true;

	public Boolean getMostrarFK_IdTipoPrecioServicioCliente() {
		return this.mostrarFK_IdTipoPrecioServicioCliente;
	}

	public void setMostrarFK_IdTipoPrecioServicioCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioServicioCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaServicioCliente=true;

	public Boolean getActivarFK_IdBodegaServicioCliente() {
		return this.activarFK_IdBodegaServicioCliente;
	}

	public void setActivarFK_IdBodegaServicioCliente(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaServicioCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteServicioCliente=true;

	public Boolean getActivarFK_IdClienteServicioCliente() {
		return this.activarFK_IdClienteServicioCliente;
	}

	public void setActivarFK_IdClienteServicioCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClienteServicioCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaServicioCliente=true;

	public Boolean getActivarFK_IdEmpresaServicioCliente() {
		return this.activarFK_IdEmpresaServicioCliente;
	}

	public void setActivarFK_IdEmpresaServicioCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaServicioCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoServicioCliente=true;

	public Boolean getActivarFK_IdProductoServicioCliente() {
		return this.activarFK_IdProductoServicioCliente;
	}

	public void setActivarFK_IdProductoServicioCliente(Boolean habilitarResaltar) {
		this.activarFK_IdProductoServicioCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioServicioCliente=true;

	public Boolean getActivarFK_IdTipoPrecioServicioCliente() {
		return this.activarFK_IdTipoPrecioServicioCliente;
	}

	public void setActivarFK_IdTipoPrecioServicioCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioServicioCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaServicioCliente=null;

	public Border getResaltarFK_IdBodegaServicioCliente() {
		return this.resaltarFK_IdBodegaServicioCliente;
	}

	public void setResaltarFK_IdBodegaServicioCliente(Border borderResaltar) {
		this.resaltarFK_IdBodegaServicioCliente= borderResaltar;
	}

	public void setResaltarFK_IdBodegaServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaServicioCliente= borderResaltar;
	}

	public Border resaltarFK_IdClienteServicioCliente=null;

	public Border getResaltarFK_IdClienteServicioCliente() {
		return this.resaltarFK_IdClienteServicioCliente;
	}

	public void setResaltarFK_IdClienteServicioCliente(Border borderResaltar) {
		this.resaltarFK_IdClienteServicioCliente= borderResaltar;
	}

	public void setResaltarFK_IdClienteServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteServicioCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaServicioCliente=null;

	public Border getResaltarFK_IdEmpresaServicioCliente() {
		return this.resaltarFK_IdEmpresaServicioCliente;
	}

	public void setResaltarFK_IdEmpresaServicioCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaServicioCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaServicioCliente= borderResaltar;
	}

	public Border resaltarFK_IdProductoServicioCliente=null;

	public Border getResaltarFK_IdProductoServicioCliente() {
		return this.resaltarFK_IdProductoServicioCliente;
	}

	public void setResaltarFK_IdProductoServicioCliente(Border borderResaltar) {
		this.resaltarFK_IdProductoServicioCliente= borderResaltar;
	}

	public void setResaltarFK_IdProductoServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoServicioCliente= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioServicioCliente=null;

	public Border getResaltarFK_IdTipoPrecioServicioCliente() {
		return this.resaltarFK_IdTipoPrecioServicioCliente;
	}

	public void setResaltarFK_IdTipoPrecioServicioCliente(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioServicioCliente= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioServicioCliente(ParametroGeneralUsuario parametroGeneralUsuario/*ServicioClienteBeanSwingJInternalFrame servicioclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioServicioCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}