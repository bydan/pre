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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.TareaClienteConstantesFunciones;
import com.bydan.erp.facturacion.util.TareaClienteParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TareaClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TareaClienteConstantesFunciones extends TareaClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TareaCliente";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TareaCliente"+TareaClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TareaClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TareaClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TareaClienteConstantesFunciones.SCHEMA+"_"+TareaClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TareaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TareaClienteConstantesFunciones.SCHEMA+"_"+TareaClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TareaClienteConstantesFunciones.SCHEMA+"_"+TareaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TareaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TareaClienteConstantesFunciones.SCHEMA+"_"+TareaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TareaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TareaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TareaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TareaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TareaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TareaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TareaClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TareaClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TareaClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TareaClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tarea Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tarea Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Tarea Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TareaCliente";
	public static final String OBJECTNAME="tareacliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="tarea_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tareacliente from "+TareaClienteConstantesFunciones.SPERSISTENCENAME+" tareacliente";
	public static String QUERYSELECTNATIVE="select "+TareaClienteConstantesFunciones.SCHEMA+"."+TareaClienteConstantesFunciones.TABLENAME+".id,"+TareaClienteConstantesFunciones.SCHEMA+"."+TareaClienteConstantesFunciones.TABLENAME+".version_row,"+TareaClienteConstantesFunciones.SCHEMA+"."+TareaClienteConstantesFunciones.TABLENAME+".id_empresa,"+TareaClienteConstantesFunciones.SCHEMA+"."+TareaClienteConstantesFunciones.TABLENAME+".id_cliente,"+TareaClienteConstantesFunciones.SCHEMA+"."+TareaClienteConstantesFunciones.TABLENAME+".id_factura,"+TareaClienteConstantesFunciones.SCHEMA+"."+TareaClienteConstantesFunciones.TABLENAME+".id_producto,"+TareaClienteConstantesFunciones.SCHEMA+"."+TareaClienteConstantesFunciones.TABLENAME+".id_unidad,"+TareaClienteConstantesFunciones.SCHEMA+"."+TareaClienteConstantesFunciones.TABLENAME+".precio,"+TareaClienteConstantesFunciones.SCHEMA+"."+TareaClienteConstantesFunciones.TABLENAME+".numero_metros,"+TareaClienteConstantesFunciones.SCHEMA+"."+TareaClienteConstantesFunciones.TABLENAME+".numero_litros,"+TareaClienteConstantesFunciones.SCHEMA+"."+TareaClienteConstantesFunciones.TABLENAME+".tarea from "+TareaClienteConstantesFunciones.SCHEMA+"."+TareaClienteConstantesFunciones.TABLENAME;//+" as "+TareaClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TareaClienteConstantesFuncionesAdditional tareaclienteConstantesFuncionesAdditional=null;
	
	public TareaClienteConstantesFuncionesAdditional getTareaClienteConstantesFuncionesAdditional() {
		return this.tareaclienteConstantesFuncionesAdditional;
	}
	
	public void setTareaClienteConstantesFuncionesAdditional(TareaClienteConstantesFuncionesAdditional tareaclienteConstantesFuncionesAdditional) {
		try {
			this.tareaclienteConstantesFuncionesAdditional=tareaclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDFACTURA= "id_factura";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String PRECIO= "precio";
    public static final String NUMEROMETROS= "numero_metros";
    public static final String NUMEROLITROS= "numero_litros";
    public static final String TAREA= "tarea";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_NUMEROMETROS= "Numero Metros";
		public static final String LABEL_NUMEROMETROS_LOWER= "Numero Metros";
    	public static final String LABEL_NUMEROLITROS= "Numero Litros";
		public static final String LABEL_NUMEROLITROS_LOWER= "Numero Litros";
    	public static final String LABEL_TAREA= "Tarea";
		public static final String LABEL_TAREA_LOWER= "Tarea";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXTAREA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTAREA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTareaClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TareaClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=TareaClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TareaClienteConstantesFunciones.IDCLIENTE)) {sLabelColumna=TareaClienteConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(TareaClienteConstantesFunciones.IDFACTURA)) {sLabelColumna=TareaClienteConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(TareaClienteConstantesFunciones.IDPRODUCTO)) {sLabelColumna=TareaClienteConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(TareaClienteConstantesFunciones.IDUNIDAD)) {sLabelColumna=TareaClienteConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(TareaClienteConstantesFunciones.PRECIO)) {sLabelColumna=TareaClienteConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(TareaClienteConstantesFunciones.NUMEROMETROS)) {sLabelColumna=TareaClienteConstantesFunciones.LABEL_NUMEROMETROS;}
		if(sNombreColumna.equals(TareaClienteConstantesFunciones.NUMEROLITROS)) {sLabelColumna=TareaClienteConstantesFunciones.LABEL_NUMEROLITROS;}
		if(sNombreColumna.equals(TareaClienteConstantesFunciones.TAREA)) {sLabelColumna=TareaClienteConstantesFunciones.LABEL_TAREA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTareaClienteDescripcion(TareaCliente tareacliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tareacliente !=null/* && tareacliente.getId()!=0*/) {
			if(tareacliente.getId()!=null) {
				sDescripcion=tareacliente.getId().toString();
			}//tareaclientetareacliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTareaClienteDescripcionDetallado(TareaCliente tareacliente) {
		String sDescripcion="";
			
		sDescripcion+=TareaClienteConstantesFunciones.ID+"=";
		sDescripcion+=tareacliente.getId().toString()+",";
		sDescripcion+=TareaClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tareacliente.getVersionRow().toString()+",";
		sDescripcion+=TareaClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tareacliente.getid_empresa().toString()+",";
		sDescripcion+=TareaClienteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=tareacliente.getid_cliente().toString()+",";
		sDescripcion+=TareaClienteConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=tareacliente.getid_factura().toString()+",";
		sDescripcion+=TareaClienteConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=tareacliente.getid_producto().toString()+",";
		sDescripcion+=TareaClienteConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=tareacliente.getid_unidad().toString()+",";
		sDescripcion+=TareaClienteConstantesFunciones.PRECIO+"=";
		sDescripcion+=tareacliente.getprecio().toString()+",";
		sDescripcion+=TareaClienteConstantesFunciones.NUMEROMETROS+"=";
		sDescripcion+=tareacliente.getnumero_metros().toString()+",";
		sDescripcion+=TareaClienteConstantesFunciones.NUMEROLITROS+"=";
		sDescripcion+=tareacliente.getnumero_litros().toString()+",";
		sDescripcion+=TareaClienteConstantesFunciones.TAREA+"=";
		sDescripcion+=tareacliente.gettarea()+",";
			
		return sDescripcion;
	}
	
	public static void setTareaClienteDescripcion(TareaCliente tareacliente,String sValor) throws Exception {			
		if(tareacliente !=null) {
			//tareaclientetareacliente.getId().toString();
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

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
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

	public static String getUnidadDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
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
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unad";
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

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTareaCliente(TareaCliente tareacliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tareacliente.settarea(tareacliente.gettarea().trim());
	}
	
	public static void quitarEspaciosTareaClientes(List<TareaCliente> tareaclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TareaCliente tareacliente: tareaclientes) {
			tareacliente.settarea(tareacliente.gettarea().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTareaCliente(TareaCliente tareacliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tareacliente.getConCambioAuxiliar()) {
			tareacliente.setIsDeleted(tareacliente.getIsDeletedAuxiliar());	
			tareacliente.setIsNew(tareacliente.getIsNewAuxiliar());	
			tareacliente.setIsChanged(tareacliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tareacliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tareacliente.setIsDeletedAuxiliar(false);	
			tareacliente.setIsNewAuxiliar(false);	
			tareacliente.setIsChangedAuxiliar(false);
			
			tareacliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTareaClientes(List<TareaCliente> tareaclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TareaCliente tareacliente : tareaclientes) {
			if(conAsignarBase && tareacliente.getConCambioAuxiliar()) {
				tareacliente.setIsDeleted(tareacliente.getIsDeletedAuxiliar());	
				tareacliente.setIsNew(tareacliente.getIsNewAuxiliar());	
				tareacliente.setIsChanged(tareacliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tareacliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tareacliente.setIsDeletedAuxiliar(false);	
				tareacliente.setIsNewAuxiliar(false);	
				tareacliente.setIsChangedAuxiliar(false);
				
				tareacliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTareaCliente(TareaCliente tareacliente,Boolean conEnteros) throws Exception  {
		tareacliente.setprecio(0.0);
		tareacliente.setnumero_metros(0.0);
		tareacliente.setnumero_litros(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTareaClientes(List<TareaCliente> tareaclientes,Boolean conEnteros) throws Exception  {
		
		for(TareaCliente tareacliente: tareaclientes) {
			tareacliente.setprecio(0.0);
			tareacliente.setnumero_metros(0.0);
			tareacliente.setnumero_litros(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTareaCliente(List<TareaCliente> tareaclientes,TareaCliente tareaclienteAux) throws Exception  {
		TareaClienteConstantesFunciones.InicializarValoresTareaCliente(tareaclienteAux,true);
		
		for(TareaCliente tareacliente: tareaclientes) {
			if(tareacliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tareaclienteAux.setprecio(tareaclienteAux.getprecio()+tareacliente.getprecio());			
			tareaclienteAux.setnumero_metros(tareaclienteAux.getnumero_metros()+tareacliente.getnumero_metros());			
			tareaclienteAux.setnumero_litros(tareaclienteAux.getnumero_litros()+tareacliente.getnumero_litros());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTareaCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TareaClienteConstantesFunciones.getArrayColumnasGlobalesTareaCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTareaCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TareaClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TareaClienteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTareaCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TareaCliente> tareaclientes,TareaCliente tareacliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TareaCliente tareaclienteAux: tareaclientes) {
			if(tareaclienteAux!=null && tareacliente!=null) {
				if((tareaclienteAux.getId()==null && tareacliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tareaclienteAux.getId()!=null && tareacliente.getId()!=null){
					if(tareaclienteAux.getId().equals(tareacliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTareaCliente(List<TareaCliente> tareaclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double numero_metrosTotal=0.0;
		Double numero_litrosTotal=0.0;
	
		for(TareaCliente tareacliente: tareaclientes) {			
			if(tareacliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=tareacliente.getprecio();
			numero_metrosTotal+=tareacliente.getnumero_metros();
			numero_litrosTotal+=tareacliente.getnumero_litros();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TareaClienteConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(TareaClienteConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TareaClienteConstantesFunciones.NUMEROMETROS);
		datoGeneral.setsDescripcion(TareaClienteConstantesFunciones.LABEL_NUMEROMETROS);
		datoGeneral.setdValorDouble(numero_metrosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TareaClienteConstantesFunciones.NUMEROLITROS);
		datoGeneral.setsDescripcion(TareaClienteConstantesFunciones.LABEL_NUMEROLITROS);
		datoGeneral.setdValorDouble(numero_litrosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTareaCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TareaClienteConstantesFunciones.LABEL_ID, TareaClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TareaClienteConstantesFunciones.LABEL_VERSIONROW, TareaClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TareaClienteConstantesFunciones.LABEL_IDEMPRESA, TareaClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TareaClienteConstantesFunciones.LABEL_IDCLIENTE, TareaClienteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TareaClienteConstantesFunciones.LABEL_IDFACTURA, TareaClienteConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TareaClienteConstantesFunciones.LABEL_IDPRODUCTO, TareaClienteConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TareaClienteConstantesFunciones.LABEL_IDUNIDAD, TareaClienteConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TareaClienteConstantesFunciones.LABEL_PRECIO, TareaClienteConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TareaClienteConstantesFunciones.LABEL_NUMEROMETROS, TareaClienteConstantesFunciones.NUMEROMETROS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TareaClienteConstantesFunciones.LABEL_NUMEROLITROS, TareaClienteConstantesFunciones.NUMEROLITROS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TareaClienteConstantesFunciones.LABEL_TAREA, TareaClienteConstantesFunciones.TAREA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTareaCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TareaClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TareaClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TareaClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TareaClienteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TareaClienteConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TareaClienteConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TareaClienteConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TareaClienteConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TareaClienteConstantesFunciones.NUMEROMETROS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TareaClienteConstantesFunciones.NUMEROLITROS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TareaClienteConstantesFunciones.TAREA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTareaCliente() throws Exception  {
		return TareaClienteConstantesFunciones.getTiposSeleccionarTareaCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTareaCliente(Boolean conFk) throws Exception  {
		return TareaClienteConstantesFunciones.getTiposSeleccionarTareaCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTareaCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TareaClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TareaClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TareaClienteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(TareaClienteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TareaClienteConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(TareaClienteConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TareaClienteConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(TareaClienteConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TareaClienteConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(TareaClienteConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TareaClienteConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(TareaClienteConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TareaClienteConstantesFunciones.LABEL_NUMEROMETROS);
			reporte.setsDescripcion(TareaClienteConstantesFunciones.LABEL_NUMEROMETROS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TareaClienteConstantesFunciones.LABEL_NUMEROLITROS);
			reporte.setsDescripcion(TareaClienteConstantesFunciones.LABEL_NUMEROLITROS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TareaClienteConstantesFunciones.LABEL_TAREA);
			reporte.setsDescripcion(TareaClienteConstantesFunciones.LABEL_TAREA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTareaCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTareaCliente(TareaCliente tareaclienteAux) throws Exception {
		
			tareaclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tareaclienteAux.getEmpresa()));
			tareaclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(tareaclienteAux.getCliente()));
			tareaclienteAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(tareaclienteAux.getFactura()));
			tareaclienteAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(tareaclienteAux.getProducto()));
			tareaclienteAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(tareaclienteAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTareaCliente(List<TareaCliente> tareaclientesTemp) throws Exception {
		for(TareaCliente tareaclienteAux:tareaclientesTemp) {
			
			tareaclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tareaclienteAux.getEmpresa()));
			tareaclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(tareaclienteAux.getCliente()));
			tareaclienteAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(tareaclienteAux.getFactura()));
			tareaclienteAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(tareaclienteAux.getProducto()));
			tareaclienteAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(tareaclienteAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTareaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				
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
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTareaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
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

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTareaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TareaClienteConstantesFunciones.getClassesRelationshipsOfTareaCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTareaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTareaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TareaClienteConstantesFunciones.getClassesRelationshipsFromStringsOfTareaCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTareaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TareaCliente tareacliente,List<TareaCliente> tareaclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TareaCliente tareaclienteEncontrado=null;
			
			for(TareaCliente tareaclienteLocal:tareaclientes) {
				if(tareaclienteLocal.getId().equals(tareacliente.getId())) {
					tareaclienteEncontrado=tareaclienteLocal;
					
					tareaclienteLocal.setIsChanged(tareacliente.getIsChanged());
					tareaclienteLocal.setIsNew(tareacliente.getIsNew());
					tareaclienteLocal.setIsDeleted(tareacliente.getIsDeleted());
					
					tareaclienteLocal.setGeneralEntityOriginal(tareacliente.getGeneralEntityOriginal());
					
					tareaclienteLocal.setId(tareacliente.getId());	
					tareaclienteLocal.setVersionRow(tareacliente.getVersionRow());	
					tareaclienteLocal.setid_empresa(tareacliente.getid_empresa());	
					tareaclienteLocal.setid_cliente(tareacliente.getid_cliente());	
					tareaclienteLocal.setid_factura(tareacliente.getid_factura());	
					tareaclienteLocal.setid_producto(tareacliente.getid_producto());	
					tareaclienteLocal.setid_unidad(tareacliente.getid_unidad());	
					tareaclienteLocal.setprecio(tareacliente.getprecio());	
					tareaclienteLocal.setnumero_metros(tareacliente.getnumero_metros());	
					tareaclienteLocal.setnumero_litros(tareacliente.getnumero_litros());	
					tareaclienteLocal.settarea(tareacliente.gettarea());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tareacliente.getIsDeleted()) {
				if(!existe) {
					tareaclientes.add(tareacliente);
				}
			} else {
				if(tareaclienteEncontrado!=null && permiteQuitar)  {
					tareaclientes.remove(tareaclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TareaCliente tareacliente,List<TareaCliente> tareaclientes) throws Exception {
		try	{			
			for(TareaCliente tareaclienteLocal:tareaclientes) {
				if(tareaclienteLocal.getId().equals(tareacliente.getId())) {
					tareaclienteLocal.setIsSelected(tareacliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTareaCliente(List<TareaCliente> tareaclientesAux) throws Exception {
		//this.tareaclientesAux=tareaclientesAux;
		
		for(TareaCliente tareaclienteAux:tareaclientesAux) {
			if(tareaclienteAux.getIsChanged()) {
				tareaclienteAux.setIsChanged(false);
			}		
			
			if(tareaclienteAux.getIsNew()) {
				tareaclienteAux.setIsNew(false);
			}	
			
			if(tareaclienteAux.getIsDeleted()) {
				tareaclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTareaCliente(TareaCliente tareaclienteAux) throws Exception {
		//this.tareaclienteAux=tareaclienteAux;
		
			if(tareaclienteAux.getIsChanged()) {
				tareaclienteAux.setIsChanged(false);
			}		
			
			if(tareaclienteAux.getIsNew()) {
				tareaclienteAux.setIsNew(false);
			}	
			
			if(tareaclienteAux.getIsDeleted()) {
				tareaclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TareaCliente tareaclienteAsignar,TareaCliente tareacliente) throws Exception {
		tareaclienteAsignar.setId(tareacliente.getId());	
		tareaclienteAsignar.setVersionRow(tareacliente.getVersionRow());	
		tareaclienteAsignar.setid_empresa(tareacliente.getid_empresa());
		tareaclienteAsignar.setempresa_descripcion(tareacliente.getempresa_descripcion());	
		tareaclienteAsignar.setid_cliente(tareacliente.getid_cliente());
		tareaclienteAsignar.setcliente_descripcion(tareacliente.getcliente_descripcion());	
		tareaclienteAsignar.setid_factura(tareacliente.getid_factura());
		tareaclienteAsignar.setfactura_descripcion(tareacliente.getfactura_descripcion());	
		tareaclienteAsignar.setid_producto(tareacliente.getid_producto());
		tareaclienteAsignar.setproducto_descripcion(tareacliente.getproducto_descripcion());	
		tareaclienteAsignar.setid_unidad(tareacliente.getid_unidad());
		tareaclienteAsignar.setunidad_descripcion(tareacliente.getunidad_descripcion());	
		tareaclienteAsignar.setprecio(tareacliente.getprecio());	
		tareaclienteAsignar.setnumero_metros(tareacliente.getnumero_metros());	
		tareaclienteAsignar.setnumero_litros(tareacliente.getnumero_litros());	
		tareaclienteAsignar.settarea(tareacliente.gettarea());	
	}
	
	public static void inicializarTareaCliente(TareaCliente tareacliente) throws Exception {
		try {
				tareacliente.setId(0L);	
					
				tareacliente.setid_empresa(-1L);	
				tareacliente.setid_cliente(-1L);	
				tareacliente.setid_factura(-1L);	
				tareacliente.setid_producto(-1L);	
				tareacliente.setid_unidad(-1L);	
				tareacliente.setprecio(0.0);	
				tareacliente.setnumero_metros(0.0);	
				tareacliente.setnumero_litros(0.0);	
				tareacliente.settarea("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTareaCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TareaClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TareaClienteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TareaClienteConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TareaClienteConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TareaClienteConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TareaClienteConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TareaClienteConstantesFunciones.LABEL_NUMEROMETROS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TareaClienteConstantesFunciones.LABEL_NUMEROLITROS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TareaClienteConstantesFunciones.LABEL_TAREA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTareaCliente(String sTipo,Row row,Workbook workbook,TareaCliente tareacliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tareacliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tareacliente.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tareacliente.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tareacliente.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tareacliente.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tareacliente.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tareacliente.getnumero_metros());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tareacliente.getnumero_litros());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tareacliente.gettarea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTareaCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTareaCliente() {
		return this.sFinalQueryTareaCliente;
	}
	
	public void setsFinalQueryTareaCliente(String sFinalQueryTareaCliente) {
		this.sFinalQueryTareaCliente= sFinalQueryTareaCliente;
	}
	
	public Border resaltarSeleccionarTareaCliente=null;
	
	public Border setResaltarSeleccionarTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tareaclienteBeanSwingJInternalFrame.jTtoolBarTareaCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTareaCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTareaCliente() {
		return this.resaltarSeleccionarTareaCliente;
	}
	
	public void setResaltarSeleccionarTareaCliente(Border borderResaltarSeleccionarTareaCliente) {
		this.resaltarSeleccionarTareaCliente= borderResaltarSeleccionarTareaCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTareaCliente=null;
	public Boolean mostraridTareaCliente=true;
	public Boolean activaridTareaCliente=true;

	public Border resaltarid_empresaTareaCliente=null;
	public Boolean mostrarid_empresaTareaCliente=true;
	public Boolean activarid_empresaTareaCliente=true;
	public Boolean cargarid_empresaTareaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTareaCliente=false;//ConEventDepend=true

	public Border resaltarid_clienteTareaCliente=null;
	public Boolean mostrarid_clienteTareaCliente=true;
	public Boolean activarid_clienteTareaCliente=true;
	public Boolean cargarid_clienteTareaCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteTareaCliente=false;//ConEventDepend=true

	public Border resaltarid_facturaTareaCliente=null;
	public Boolean mostrarid_facturaTareaCliente=true;
	public Boolean activarid_facturaTareaCliente=true;
	public Boolean cargarid_facturaTareaCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaTareaCliente=false;//ConEventDepend=true

	public Border resaltarid_productoTareaCliente=null;
	public Boolean mostrarid_productoTareaCliente=true;
	public Boolean activarid_productoTareaCliente=true;
	public Boolean cargarid_productoTareaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoTareaCliente=false;//ConEventDepend=true

	public Border resaltarid_unidadTareaCliente=null;
	public Boolean mostrarid_unidadTareaCliente=true;
	public Boolean activarid_unidadTareaCliente=true;
	public Boolean cargarid_unidadTareaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadTareaCliente=false;//ConEventDepend=true

	public Border resaltarprecioTareaCliente=null;
	public Boolean mostrarprecioTareaCliente=true;
	public Boolean activarprecioTareaCliente=true;

	public Border resaltarnumero_metrosTareaCliente=null;
	public Boolean mostrarnumero_metrosTareaCliente=true;
	public Boolean activarnumero_metrosTareaCliente=true;

	public Border resaltarnumero_litrosTareaCliente=null;
	public Boolean mostrarnumero_litrosTareaCliente=true;
	public Boolean activarnumero_litrosTareaCliente=true;

	public Border resaltartareaTareaCliente=null;
	public Boolean mostrartareaTareaCliente=true;
	public Boolean activartareaTareaCliente=true;

	
	

	public Border setResaltaridTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tareaclienteBeanSwingJInternalFrame.jTtoolBarTareaCliente.setBorder(borderResaltar);
		
		this.resaltaridTareaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTareaCliente() {
		return this.resaltaridTareaCliente;
	}

	public void setResaltaridTareaCliente(Border borderResaltar) {
		this.resaltaridTareaCliente= borderResaltar;
	}

	public Boolean getMostraridTareaCliente() {
		return this.mostraridTareaCliente;
	}

	public void setMostraridTareaCliente(Boolean mostraridTareaCliente) {
		this.mostraridTareaCliente= mostraridTareaCliente;
	}

	public Boolean getActivaridTareaCliente() {
		return this.activaridTareaCliente;
	}

	public void setActivaridTareaCliente(Boolean activaridTareaCliente) {
		this.activaridTareaCliente= activaridTareaCliente;
	}

	public Border setResaltarid_empresaTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tareaclienteBeanSwingJInternalFrame.jTtoolBarTareaCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaTareaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTareaCliente() {
		return this.resaltarid_empresaTareaCliente;
	}

	public void setResaltarid_empresaTareaCliente(Border borderResaltar) {
		this.resaltarid_empresaTareaCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaTareaCliente() {
		return this.mostrarid_empresaTareaCliente;
	}

	public void setMostrarid_empresaTareaCliente(Boolean mostrarid_empresaTareaCliente) {
		this.mostrarid_empresaTareaCliente= mostrarid_empresaTareaCliente;
	}

	public Boolean getActivarid_empresaTareaCliente() {
		return this.activarid_empresaTareaCliente;
	}

	public void setActivarid_empresaTareaCliente(Boolean activarid_empresaTareaCliente) {
		this.activarid_empresaTareaCliente= activarid_empresaTareaCliente;
	}

	public Boolean getCargarid_empresaTareaCliente() {
		return this.cargarid_empresaTareaCliente;
	}

	public void setCargarid_empresaTareaCliente(Boolean cargarid_empresaTareaCliente) {
		this.cargarid_empresaTareaCliente= cargarid_empresaTareaCliente;
	}

	public Border setResaltarid_clienteTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tareaclienteBeanSwingJInternalFrame.jTtoolBarTareaCliente.setBorder(borderResaltar);
		
		this.resaltarid_clienteTareaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteTareaCliente() {
		return this.resaltarid_clienteTareaCliente;
	}

	public void setResaltarid_clienteTareaCliente(Border borderResaltar) {
		this.resaltarid_clienteTareaCliente= borderResaltar;
	}

	public Boolean getMostrarid_clienteTareaCliente() {
		return this.mostrarid_clienteTareaCliente;
	}

	public void setMostrarid_clienteTareaCliente(Boolean mostrarid_clienteTareaCliente) {
		this.mostrarid_clienteTareaCliente= mostrarid_clienteTareaCliente;
	}

	public Boolean getActivarid_clienteTareaCliente() {
		return this.activarid_clienteTareaCliente;
	}

	public void setActivarid_clienteTareaCliente(Boolean activarid_clienteTareaCliente) {
		this.activarid_clienteTareaCliente= activarid_clienteTareaCliente;
	}

	public Boolean getCargarid_clienteTareaCliente() {
		return this.cargarid_clienteTareaCliente;
	}

	public void setCargarid_clienteTareaCliente(Boolean cargarid_clienteTareaCliente) {
		this.cargarid_clienteTareaCliente= cargarid_clienteTareaCliente;
	}

	public Border setResaltarid_facturaTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tareaclienteBeanSwingJInternalFrame.jTtoolBarTareaCliente.setBorder(borderResaltar);
		
		this.resaltarid_facturaTareaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaTareaCliente() {
		return this.resaltarid_facturaTareaCliente;
	}

	public void setResaltarid_facturaTareaCliente(Border borderResaltar) {
		this.resaltarid_facturaTareaCliente= borderResaltar;
	}

	public Boolean getMostrarid_facturaTareaCliente() {
		return this.mostrarid_facturaTareaCliente;
	}

	public void setMostrarid_facturaTareaCliente(Boolean mostrarid_facturaTareaCliente) {
		this.mostrarid_facturaTareaCliente= mostrarid_facturaTareaCliente;
	}

	public Boolean getActivarid_facturaTareaCliente() {
		return this.activarid_facturaTareaCliente;
	}

	public void setActivarid_facturaTareaCliente(Boolean activarid_facturaTareaCliente) {
		this.activarid_facturaTareaCliente= activarid_facturaTareaCliente;
	}

	public Boolean getCargarid_facturaTareaCliente() {
		return this.cargarid_facturaTareaCliente;
	}

	public void setCargarid_facturaTareaCliente(Boolean cargarid_facturaTareaCliente) {
		this.cargarid_facturaTareaCliente= cargarid_facturaTareaCliente;
	}

	public Border setResaltarid_productoTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tareaclienteBeanSwingJInternalFrame.jTtoolBarTareaCliente.setBorder(borderResaltar);
		
		this.resaltarid_productoTareaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoTareaCliente() {
		return this.resaltarid_productoTareaCliente;
	}

	public void setResaltarid_productoTareaCliente(Border borderResaltar) {
		this.resaltarid_productoTareaCliente= borderResaltar;
	}

	public Boolean getMostrarid_productoTareaCliente() {
		return this.mostrarid_productoTareaCliente;
	}

	public void setMostrarid_productoTareaCliente(Boolean mostrarid_productoTareaCliente) {
		this.mostrarid_productoTareaCliente= mostrarid_productoTareaCliente;
	}

	public Boolean getActivarid_productoTareaCliente() {
		return this.activarid_productoTareaCliente;
	}

	public void setActivarid_productoTareaCliente(Boolean activarid_productoTareaCliente) {
		this.activarid_productoTareaCliente= activarid_productoTareaCliente;
	}

	public Boolean getCargarid_productoTareaCliente() {
		return this.cargarid_productoTareaCliente;
	}

	public void setCargarid_productoTareaCliente(Boolean cargarid_productoTareaCliente) {
		this.cargarid_productoTareaCliente= cargarid_productoTareaCliente;
	}

	public Border setResaltarid_unidadTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tareaclienteBeanSwingJInternalFrame.jTtoolBarTareaCliente.setBorder(borderResaltar);
		
		this.resaltarid_unidadTareaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadTareaCliente() {
		return this.resaltarid_unidadTareaCliente;
	}

	public void setResaltarid_unidadTareaCliente(Border borderResaltar) {
		this.resaltarid_unidadTareaCliente= borderResaltar;
	}

	public Boolean getMostrarid_unidadTareaCliente() {
		return this.mostrarid_unidadTareaCliente;
	}

	public void setMostrarid_unidadTareaCliente(Boolean mostrarid_unidadTareaCliente) {
		this.mostrarid_unidadTareaCliente= mostrarid_unidadTareaCliente;
	}

	public Boolean getActivarid_unidadTareaCliente() {
		return this.activarid_unidadTareaCliente;
	}

	public void setActivarid_unidadTareaCliente(Boolean activarid_unidadTareaCliente) {
		this.activarid_unidadTareaCliente= activarid_unidadTareaCliente;
	}

	public Boolean getCargarid_unidadTareaCliente() {
		return this.cargarid_unidadTareaCliente;
	}

	public void setCargarid_unidadTareaCliente(Boolean cargarid_unidadTareaCliente) {
		this.cargarid_unidadTareaCliente= cargarid_unidadTareaCliente;
	}

	public Border setResaltarprecioTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tareaclienteBeanSwingJInternalFrame.jTtoolBarTareaCliente.setBorder(borderResaltar);
		
		this.resaltarprecioTareaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioTareaCliente() {
		return this.resaltarprecioTareaCliente;
	}

	public void setResaltarprecioTareaCliente(Border borderResaltar) {
		this.resaltarprecioTareaCliente= borderResaltar;
	}

	public Boolean getMostrarprecioTareaCliente() {
		return this.mostrarprecioTareaCliente;
	}

	public void setMostrarprecioTareaCliente(Boolean mostrarprecioTareaCliente) {
		this.mostrarprecioTareaCliente= mostrarprecioTareaCliente;
	}

	public Boolean getActivarprecioTareaCliente() {
		return this.activarprecioTareaCliente;
	}

	public void setActivarprecioTareaCliente(Boolean activarprecioTareaCliente) {
		this.activarprecioTareaCliente= activarprecioTareaCliente;
	}

	public Border setResaltarnumero_metrosTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tareaclienteBeanSwingJInternalFrame.jTtoolBarTareaCliente.setBorder(borderResaltar);
		
		this.resaltarnumero_metrosTareaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_metrosTareaCliente() {
		return this.resaltarnumero_metrosTareaCliente;
	}

	public void setResaltarnumero_metrosTareaCliente(Border borderResaltar) {
		this.resaltarnumero_metrosTareaCliente= borderResaltar;
	}

	public Boolean getMostrarnumero_metrosTareaCliente() {
		return this.mostrarnumero_metrosTareaCliente;
	}

	public void setMostrarnumero_metrosTareaCliente(Boolean mostrarnumero_metrosTareaCliente) {
		this.mostrarnumero_metrosTareaCliente= mostrarnumero_metrosTareaCliente;
	}

	public Boolean getActivarnumero_metrosTareaCliente() {
		return this.activarnumero_metrosTareaCliente;
	}

	public void setActivarnumero_metrosTareaCliente(Boolean activarnumero_metrosTareaCliente) {
		this.activarnumero_metrosTareaCliente= activarnumero_metrosTareaCliente;
	}

	public Border setResaltarnumero_litrosTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tareaclienteBeanSwingJInternalFrame.jTtoolBarTareaCliente.setBorder(borderResaltar);
		
		this.resaltarnumero_litrosTareaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_litrosTareaCliente() {
		return this.resaltarnumero_litrosTareaCliente;
	}

	public void setResaltarnumero_litrosTareaCliente(Border borderResaltar) {
		this.resaltarnumero_litrosTareaCliente= borderResaltar;
	}

	public Boolean getMostrarnumero_litrosTareaCliente() {
		return this.mostrarnumero_litrosTareaCliente;
	}

	public void setMostrarnumero_litrosTareaCliente(Boolean mostrarnumero_litrosTareaCliente) {
		this.mostrarnumero_litrosTareaCliente= mostrarnumero_litrosTareaCliente;
	}

	public Boolean getActivarnumero_litrosTareaCliente() {
		return this.activarnumero_litrosTareaCliente;
	}

	public void setActivarnumero_litrosTareaCliente(Boolean activarnumero_litrosTareaCliente) {
		this.activarnumero_litrosTareaCliente= activarnumero_litrosTareaCliente;
	}

	public Border setResaltartareaTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tareaclienteBeanSwingJInternalFrame.jTtoolBarTareaCliente.setBorder(borderResaltar);
		
		this.resaltartareaTareaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartareaTareaCliente() {
		return this.resaltartareaTareaCliente;
	}

	public void setResaltartareaTareaCliente(Border borderResaltar) {
		this.resaltartareaTareaCliente= borderResaltar;
	}

	public Boolean getMostrartareaTareaCliente() {
		return this.mostrartareaTareaCliente;
	}

	public void setMostrartareaTareaCliente(Boolean mostrartareaTareaCliente) {
		this.mostrartareaTareaCliente= mostrartareaTareaCliente;
	}

	public Boolean getActivartareaTareaCliente() {
		return this.activartareaTareaCliente;
	}

	public void setActivartareaTareaCliente(Boolean activartareaTareaCliente) {
		this.activartareaTareaCliente= activartareaTareaCliente;
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
		
		
		this.setMostraridTareaCliente(esInicial);
		this.setMostrarid_empresaTareaCliente(esInicial);
		this.setMostrarid_clienteTareaCliente(esInicial);
		this.setMostrarid_facturaTareaCliente(esInicial);
		this.setMostrarid_productoTareaCliente(esInicial);
		this.setMostrarid_unidadTareaCliente(esInicial);
		this.setMostrarprecioTareaCliente(esInicial);
		this.setMostrarnumero_metrosTareaCliente(esInicial);
		this.setMostrarnumero_litrosTareaCliente(esInicial);
		this.setMostrartareaTareaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TareaClienteConstantesFunciones.ID)) {
				this.setMostraridTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.PRECIO)) {
				this.setMostrarprecioTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.NUMEROMETROS)) {
				this.setMostrarnumero_metrosTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.NUMEROLITROS)) {
				this.setMostrarnumero_litrosTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.TAREA)) {
				this.setMostrartareaTareaCliente(esAsigna);
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
		
		
		this.setActivaridTareaCliente(esInicial);
		this.setActivarid_empresaTareaCliente(esInicial);
		this.setActivarid_clienteTareaCliente(esInicial);
		this.setActivarid_facturaTareaCliente(esInicial);
		this.setActivarid_productoTareaCliente(esInicial);
		this.setActivarid_unidadTareaCliente(esInicial);
		this.setActivarprecioTareaCliente(esInicial);
		this.setActivarnumero_metrosTareaCliente(esInicial);
		this.setActivarnumero_litrosTareaCliente(esInicial);
		this.setActivartareaTareaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TareaClienteConstantesFunciones.ID)) {
				this.setActivaridTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.PRECIO)) {
				this.setActivarprecioTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.NUMEROMETROS)) {
				this.setActivarnumero_metrosTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.NUMEROLITROS)) {
				this.setActivarnumero_litrosTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.TAREA)) {
				this.setActivartareaTareaCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTareaCliente(esInicial);
		this.setResaltarid_empresaTareaCliente(esInicial);
		this.setResaltarid_clienteTareaCliente(esInicial);
		this.setResaltarid_facturaTareaCliente(esInicial);
		this.setResaltarid_productoTareaCliente(esInicial);
		this.setResaltarid_unidadTareaCliente(esInicial);
		this.setResaltarprecioTareaCliente(esInicial);
		this.setResaltarnumero_metrosTareaCliente(esInicial);
		this.setResaltarnumero_litrosTareaCliente(esInicial);
		this.setResaltartareaTareaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TareaClienteConstantesFunciones.ID)) {
				this.setResaltaridTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.PRECIO)) {
				this.setResaltarprecioTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.NUMEROMETROS)) {
				this.setResaltarnumero_metrosTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.NUMEROLITROS)) {
				this.setResaltarnumero_litrosTareaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TareaClienteConstantesFunciones.TAREA)) {
				this.setResaltartareaTareaCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteTareaCliente=true;

	public Boolean getMostrarFK_IdClienteTareaCliente() {
		return this.mostrarFK_IdClienteTareaCliente;
	}

	public void setMostrarFK_IdClienteTareaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteTareaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTareaCliente=true;

	public Boolean getMostrarFK_IdEmpresaTareaCliente() {
		return this.mostrarFK_IdEmpresaTareaCliente;
	}

	public void setMostrarFK_IdEmpresaTareaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTareaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaTareaCliente=true;

	public Boolean getMostrarFK_IdFacturaTareaCliente() {
		return this.mostrarFK_IdFacturaTareaCliente;
	}

	public void setMostrarFK_IdFacturaTareaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaTareaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoTareaCliente=true;

	public Boolean getMostrarFK_IdProductoTareaCliente() {
		return this.mostrarFK_IdProductoTareaCliente;
	}

	public void setMostrarFK_IdProductoTareaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoTareaCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadTareaCliente=true;

	public Boolean getMostrarFK_IdUnidadTareaCliente() {
		return this.mostrarFK_IdUnidadTareaCliente;
	}

	public void setMostrarFK_IdUnidadTareaCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadTareaCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteTareaCliente=true;

	public Boolean getActivarFK_IdClienteTareaCliente() {
		return this.activarFK_IdClienteTareaCliente;
	}

	public void setActivarFK_IdClienteTareaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClienteTareaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTareaCliente=true;

	public Boolean getActivarFK_IdEmpresaTareaCliente() {
		return this.activarFK_IdEmpresaTareaCliente;
	}

	public void setActivarFK_IdEmpresaTareaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTareaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaTareaCliente=true;

	public Boolean getActivarFK_IdFacturaTareaCliente() {
		return this.activarFK_IdFacturaTareaCliente;
	}

	public void setActivarFK_IdFacturaTareaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaTareaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoTareaCliente=true;

	public Boolean getActivarFK_IdProductoTareaCliente() {
		return this.activarFK_IdProductoTareaCliente;
	}

	public void setActivarFK_IdProductoTareaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdProductoTareaCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadTareaCliente=true;

	public Boolean getActivarFK_IdUnidadTareaCliente() {
		return this.activarFK_IdUnidadTareaCliente;
	}

	public void setActivarFK_IdUnidadTareaCliente(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadTareaCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteTareaCliente=null;

	public Border getResaltarFK_IdClienteTareaCliente() {
		return this.resaltarFK_IdClienteTareaCliente;
	}

	public void setResaltarFK_IdClienteTareaCliente(Border borderResaltar) {
		this.resaltarFK_IdClienteTareaCliente= borderResaltar;
	}

	public void setResaltarFK_IdClienteTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteTareaCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTareaCliente=null;

	public Border getResaltarFK_IdEmpresaTareaCliente() {
		return this.resaltarFK_IdEmpresaTareaCliente;
	}

	public void setResaltarFK_IdEmpresaTareaCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTareaCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTareaCliente= borderResaltar;
	}

	public Border resaltarFK_IdFacturaTareaCliente=null;

	public Border getResaltarFK_IdFacturaTareaCliente() {
		return this.resaltarFK_IdFacturaTareaCliente;
	}

	public void setResaltarFK_IdFacturaTareaCliente(Border borderResaltar) {
		this.resaltarFK_IdFacturaTareaCliente= borderResaltar;
	}

	public void setResaltarFK_IdFacturaTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaTareaCliente= borderResaltar;
	}

	public Border resaltarFK_IdProductoTareaCliente=null;

	public Border getResaltarFK_IdProductoTareaCliente() {
		return this.resaltarFK_IdProductoTareaCliente;
	}

	public void setResaltarFK_IdProductoTareaCliente(Border borderResaltar) {
		this.resaltarFK_IdProductoTareaCliente= borderResaltar;
	}

	public void setResaltarFK_IdProductoTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoTareaCliente= borderResaltar;
	}

	public Border resaltarFK_IdUnidadTareaCliente=null;

	public Border getResaltarFK_IdUnidadTareaCliente() {
		return this.resaltarFK_IdUnidadTareaCliente;
	}

	public void setResaltarFK_IdUnidadTareaCliente(Border borderResaltar) {
		this.resaltarFK_IdUnidadTareaCliente= borderResaltar;
	}

	public void setResaltarFK_IdUnidadTareaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TareaClienteBeanSwingJInternalFrame tareaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadTareaCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}