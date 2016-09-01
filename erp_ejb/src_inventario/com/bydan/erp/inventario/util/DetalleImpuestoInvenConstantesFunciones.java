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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.DetalleImpuestoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleImpuestoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleImpuestoInvenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleImpuestoInvenConstantesFunciones extends DetalleImpuestoInvenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleImpuestoInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleImpuestoInven"+DetalleImpuestoInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleImpuestoInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleImpuestoInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleImpuestoInvenConstantesFunciones.SCHEMA+"_"+DetalleImpuestoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleImpuestoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleImpuestoInvenConstantesFunciones.SCHEMA+"_"+DetalleImpuestoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleImpuestoInvenConstantesFunciones.SCHEMA+"_"+DetalleImpuestoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleImpuestoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleImpuestoInvenConstantesFunciones.SCHEMA+"_"+DetalleImpuestoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleImpuestoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleImpuestoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleImpuestoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleImpuestoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleImpuestoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleImpuestoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleImpuestoInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleImpuestoInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleImpuestoInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleImpuestoInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Impuesto Invenes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Impuesto Inven";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Impuesto Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleImpuestoInven";
	public static final String OBJECTNAME="detalleimpuestoinven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_impuesto_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleimpuestoinven from "+DetalleImpuestoInvenConstantesFunciones.SPERSISTENCENAME+" detalleimpuestoinven";
	public static String QUERYSELECTNATIVE="select "+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".version_row,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id_empresa,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id_bodega,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id_producto,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id_impuesto_inven,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".porcentaje,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".valor,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".descripcion from "+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME;//+" as "+DetalleImpuestoInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleImpuestoInvenConstantesFuncionesAdditional detalleimpuestoinvenConstantesFuncionesAdditional=null;
	
	public DetalleImpuestoInvenConstantesFuncionesAdditional getDetalleImpuestoInvenConstantesFuncionesAdditional() {
		return this.detalleimpuestoinvenConstantesFuncionesAdditional;
	}
	
	public void setDetalleImpuestoInvenConstantesFuncionesAdditional(DetalleImpuestoInvenConstantesFuncionesAdditional detalleimpuestoinvenConstantesFuncionesAdditional) {
		try {
			this.detalleimpuestoinvenConstantesFuncionesAdditional=detalleimpuestoinvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDIMPUESTOINVEN= "id_impuesto_inven";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDIMPUESTOINVEN= "Impuesto Inven";
		public static final String LABEL_IDIMPUESTOINVEN_LOWER= "Impuesto Inven";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleImpuestoInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleImpuestoInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleImpuestoInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleImpuestoInvenConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleImpuestoInvenConstantesFunciones.IDBODEGA)) {sLabelColumna=DetalleImpuestoInvenConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetalleImpuestoInvenConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleImpuestoInvenConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleImpuestoInvenConstantesFunciones.IDIMPUESTOINVEN)) {sLabelColumna=DetalleImpuestoInvenConstantesFunciones.LABEL_IDIMPUESTOINVEN;}
		if(sNombreColumna.equals(DetalleImpuestoInvenConstantesFunciones.PORCENTAJE)) {sLabelColumna=DetalleImpuestoInvenConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(DetalleImpuestoInvenConstantesFunciones.VALOR)) {sLabelColumna=DetalleImpuestoInvenConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(DetalleImpuestoInvenConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleImpuestoInvenConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleImpuestoInvenDescripcion(DetalleImpuestoInven detalleimpuestoinven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleimpuestoinven !=null/* && detalleimpuestoinven.getId()!=0*/) {
			if(detalleimpuestoinven.getId()!=null) {
				sDescripcion=detalleimpuestoinven.getId().toString();
			}//detalleimpuestoinvendetalleimpuestoinven.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleImpuestoInvenDescripcionDetallado(DetalleImpuestoInven detalleimpuestoinven) {
		String sDescripcion="";
			
		sDescripcion+=DetalleImpuestoInvenConstantesFunciones.ID+"=";
		sDescripcion+=detalleimpuestoinven.getId().toString()+",";
		sDescripcion+=DetalleImpuestoInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleimpuestoinven.getVersionRow().toString()+",";
		sDescripcion+=DetalleImpuestoInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleimpuestoinven.getid_empresa().toString()+",";
		sDescripcion+=DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleimpuestoinven.getid_sucursal().toString()+",";
		sDescripcion+=DetalleImpuestoInvenConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detalleimpuestoinven.getid_bodega().toString()+",";
		sDescripcion+=DetalleImpuestoInvenConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detalleimpuestoinven.getid_producto().toString()+",";
		sDescripcion+=DetalleImpuestoInvenConstantesFunciones.IDIMPUESTOINVEN+"=";
		sDescripcion+=detalleimpuestoinven.getid_impuesto_inven().toString()+",";
		sDescripcion+=DetalleImpuestoInvenConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=detalleimpuestoinven.getporcentaje().toString()+",";
		sDescripcion+=DetalleImpuestoInvenConstantesFunciones.VALOR+"=";
		sDescripcion+=detalleimpuestoinven.getvalor().toString()+",";
		sDescripcion+=DetalleImpuestoInvenConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalleimpuestoinven.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleImpuestoInvenDescripcion(DetalleImpuestoInven detalleimpuestoinven,String sValor) throws Exception {			
		if(detalleimpuestoinven !=null) {
			//detalleimpuestoinvendetalleimpuestoinven.getId().toString();
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

	public static String getImpuestoInvenDescripcion(ImpuestoInven impuestoinven) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(impuestoinven!=null/*&&impuestoinven.getId()>0*/) {
			sDescripcion=ImpuestoInvenConstantesFunciones.getImpuestoInvenDescripcion(impuestoinven);
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdImpuestoInven")) {
			sNombreIndice="Tipo=  Por Impuesto Inven";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdImpuestoInven(Long id_impuesto_inven) {
		String sDetalleIndice=" Parametros->";
		if(id_impuesto_inven!=null) {sDetalleIndice+=" Codigo Unico De Impuesto Inven="+id_impuesto_inven.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleImpuestoInven(DetalleImpuestoInven detalleimpuestoinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleimpuestoinven.setdescripcion(detalleimpuestoinven.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleImpuestoInvens(List<DetalleImpuestoInven> detalleimpuestoinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleImpuestoInven detalleimpuestoinven: detalleimpuestoinvens) {
			detalleimpuestoinven.setdescripcion(detalleimpuestoinven.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleImpuestoInven(DetalleImpuestoInven detalleimpuestoinven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleimpuestoinven.getConCambioAuxiliar()) {
			detalleimpuestoinven.setIsDeleted(detalleimpuestoinven.getIsDeletedAuxiliar());	
			detalleimpuestoinven.setIsNew(detalleimpuestoinven.getIsNewAuxiliar());	
			detalleimpuestoinven.setIsChanged(detalleimpuestoinven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleimpuestoinven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleimpuestoinven.setIsDeletedAuxiliar(false);	
			detalleimpuestoinven.setIsNewAuxiliar(false);	
			detalleimpuestoinven.setIsChangedAuxiliar(false);
			
			detalleimpuestoinven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleImpuestoInvens(List<DetalleImpuestoInven> detalleimpuestoinvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleImpuestoInven detalleimpuestoinven : detalleimpuestoinvens) {
			if(conAsignarBase && detalleimpuestoinven.getConCambioAuxiliar()) {
				detalleimpuestoinven.setIsDeleted(detalleimpuestoinven.getIsDeletedAuxiliar());	
				detalleimpuestoinven.setIsNew(detalleimpuestoinven.getIsNewAuxiliar());	
				detalleimpuestoinven.setIsChanged(detalleimpuestoinven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleimpuestoinven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleimpuestoinven.setIsDeletedAuxiliar(false);	
				detalleimpuestoinven.setIsNewAuxiliar(false);	
				detalleimpuestoinven.setIsChangedAuxiliar(false);
				
				detalleimpuestoinven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleImpuestoInven(DetalleImpuestoInven detalleimpuestoinven,Boolean conEnteros) throws Exception  {
		detalleimpuestoinven.setporcentaje(0.0);
		detalleimpuestoinven.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleImpuestoInvens(List<DetalleImpuestoInven> detalleimpuestoinvens,Boolean conEnteros) throws Exception  {
		
		for(DetalleImpuestoInven detalleimpuestoinven: detalleimpuestoinvens) {
			detalleimpuestoinven.setporcentaje(0.0);
			detalleimpuestoinven.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleImpuestoInven(List<DetalleImpuestoInven> detalleimpuestoinvens,DetalleImpuestoInven detalleimpuestoinvenAux) throws Exception  {
		DetalleImpuestoInvenConstantesFunciones.InicializarValoresDetalleImpuestoInven(detalleimpuestoinvenAux,true);
		
		for(DetalleImpuestoInven detalleimpuestoinven: detalleimpuestoinvens) {
			if(detalleimpuestoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleimpuestoinvenAux.setporcentaje(detalleimpuestoinvenAux.getporcentaje()+detalleimpuestoinven.getporcentaje());			
			detalleimpuestoinvenAux.setvalor(detalleimpuestoinvenAux.getvalor()+detalleimpuestoinven.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleImpuestoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleImpuestoInvenConstantesFunciones.getArrayColumnasGlobalesDetalleImpuestoInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleImpuestoInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleImpuestoInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleImpuestoInvenConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleImpuestoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleImpuestoInven> detalleimpuestoinvens,DetalleImpuestoInven detalleimpuestoinven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleImpuestoInven detalleimpuestoinvenAux: detalleimpuestoinvens) {
			if(detalleimpuestoinvenAux!=null && detalleimpuestoinven!=null) {
				if((detalleimpuestoinvenAux.getId()==null && detalleimpuestoinven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleimpuestoinvenAux.getId()!=null && detalleimpuestoinven.getId()!=null){
					if(detalleimpuestoinvenAux.getId().equals(detalleimpuestoinven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleImpuestoInven(List<DetalleImpuestoInven> detalleimpuestoinvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(DetalleImpuestoInven detalleimpuestoinven: detalleimpuestoinvens) {			
			if(detalleimpuestoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=detalleimpuestoinven.getporcentaje();
			valorTotal+=detalleimpuestoinven.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleImpuestoInvenConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(DetalleImpuestoInvenConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleImpuestoInvenConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetalleImpuestoInvenConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleImpuestoInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleImpuestoInvenConstantesFunciones.LABEL_ID, DetalleImpuestoInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleImpuestoInvenConstantesFunciones.LABEL_VERSIONROW, DetalleImpuestoInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleImpuestoInvenConstantesFunciones.LABEL_IDEMPRESA, DetalleImpuestoInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleImpuestoInvenConstantesFunciones.LABEL_IDSUCURSAL, DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleImpuestoInvenConstantesFunciones.LABEL_IDBODEGA, DetalleImpuestoInvenConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleImpuestoInvenConstantesFunciones.LABEL_IDPRODUCTO, DetalleImpuestoInvenConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleImpuestoInvenConstantesFunciones.LABEL_IDIMPUESTOINVEN, DetalleImpuestoInvenConstantesFunciones.IDIMPUESTOINVEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleImpuestoInvenConstantesFunciones.LABEL_PORCENTAJE, DetalleImpuestoInvenConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleImpuestoInvenConstantesFunciones.LABEL_VALOR, DetalleImpuestoInvenConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleImpuestoInvenConstantesFunciones.LABEL_DESCRIPCION, DetalleImpuestoInvenConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleImpuestoInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleImpuestoInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleImpuestoInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleImpuestoInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleImpuestoInvenConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleImpuestoInvenConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleImpuestoInvenConstantesFunciones.IDIMPUESTOINVEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleImpuestoInvenConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleImpuestoInvenConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleImpuestoInvenConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleImpuestoInven() throws Exception  {
		return DetalleImpuestoInvenConstantesFunciones.getTiposSeleccionarDetalleImpuestoInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleImpuestoInven(Boolean conFk) throws Exception  {
		return DetalleImpuestoInvenConstantesFunciones.getTiposSeleccionarDetalleImpuestoInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleImpuestoInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleImpuestoInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleImpuestoInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleImpuestoInvenConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleImpuestoInvenConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleImpuestoInvenConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetalleImpuestoInvenConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleImpuestoInvenConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleImpuestoInvenConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleImpuestoInvenConstantesFunciones.LABEL_IDIMPUESTOINVEN);
			reporte.setsDescripcion(DetalleImpuestoInvenConstantesFunciones.LABEL_IDIMPUESTOINVEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleImpuestoInvenConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(DetalleImpuestoInvenConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleImpuestoInvenConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(DetalleImpuestoInvenConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleImpuestoInvenConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleImpuestoInvenConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleImpuestoInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleImpuestoInven(DetalleImpuestoInven detalleimpuestoinvenAux) throws Exception {
		
			detalleimpuestoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleimpuestoinvenAux.getEmpresa()));
			detalleimpuestoinvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleimpuestoinvenAux.getSucursal()));
			detalleimpuestoinvenAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalleimpuestoinvenAux.getBodega()));
			detalleimpuestoinvenAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleimpuestoinvenAux.getProducto()));
			detalleimpuestoinvenAux.setimpuestoinven_descripcion(ImpuestoInvenConstantesFunciones.getImpuestoInvenDescripcion(detalleimpuestoinvenAux.getImpuestoInven()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleImpuestoInven(List<DetalleImpuestoInven> detalleimpuestoinvensTemp) throws Exception {
		for(DetalleImpuestoInven detalleimpuestoinvenAux:detalleimpuestoinvensTemp) {
			
			detalleimpuestoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleimpuestoinvenAux.getEmpresa()));
			detalleimpuestoinvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleimpuestoinvenAux.getSucursal()));
			detalleimpuestoinvenAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detalleimpuestoinvenAux.getBodega()));
			detalleimpuestoinvenAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleimpuestoinvenAux.getProducto()));
			detalleimpuestoinvenAux.setimpuestoinven_descripcion(ImpuestoInvenConstantesFunciones.getImpuestoInvenDescripcion(detalleimpuestoinvenAux.getImpuestoInven()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleImpuestoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(ImpuestoInven.class));
				
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
					if(clas.clas.equals(ImpuestoInven.class)) {
						classes.add(new Classe(ImpuestoInven.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleImpuestoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ImpuestoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImpuestoInven.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ImpuestoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImpuestoInven.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleImpuestoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleImpuestoInvenConstantesFunciones.getClassesRelationshipsOfDetalleImpuestoInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleImpuestoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleImpuestoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleImpuestoInvenConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleImpuestoInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleImpuestoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleImpuestoInven detalleimpuestoinven,List<DetalleImpuestoInven> detalleimpuestoinvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleImpuestoInven detalleimpuestoinvenEncontrado=null;
			
			for(DetalleImpuestoInven detalleimpuestoinvenLocal:detalleimpuestoinvens) {
				if(detalleimpuestoinvenLocal.getId().equals(detalleimpuestoinven.getId())) {
					detalleimpuestoinvenEncontrado=detalleimpuestoinvenLocal;
					
					detalleimpuestoinvenLocal.setIsChanged(detalleimpuestoinven.getIsChanged());
					detalleimpuestoinvenLocal.setIsNew(detalleimpuestoinven.getIsNew());
					detalleimpuestoinvenLocal.setIsDeleted(detalleimpuestoinven.getIsDeleted());
					
					detalleimpuestoinvenLocal.setGeneralEntityOriginal(detalleimpuestoinven.getGeneralEntityOriginal());
					
					detalleimpuestoinvenLocal.setId(detalleimpuestoinven.getId());	
					detalleimpuestoinvenLocal.setVersionRow(detalleimpuestoinven.getVersionRow());	
					detalleimpuestoinvenLocal.setid_empresa(detalleimpuestoinven.getid_empresa());	
					detalleimpuestoinvenLocal.setid_sucursal(detalleimpuestoinven.getid_sucursal());	
					detalleimpuestoinvenLocal.setid_bodega(detalleimpuestoinven.getid_bodega());	
					detalleimpuestoinvenLocal.setid_producto(detalleimpuestoinven.getid_producto());	
					detalleimpuestoinvenLocal.setid_impuesto_inven(detalleimpuestoinven.getid_impuesto_inven());	
					detalleimpuestoinvenLocal.setporcentaje(detalleimpuestoinven.getporcentaje());	
					detalleimpuestoinvenLocal.setvalor(detalleimpuestoinven.getvalor());	
					detalleimpuestoinvenLocal.setdescripcion(detalleimpuestoinven.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleimpuestoinven.getIsDeleted()) {
				if(!existe) {
					detalleimpuestoinvens.add(detalleimpuestoinven);
				}
			} else {
				if(detalleimpuestoinvenEncontrado!=null && permiteQuitar)  {
					detalleimpuestoinvens.remove(detalleimpuestoinvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleImpuestoInven detalleimpuestoinven,List<DetalleImpuestoInven> detalleimpuestoinvens) throws Exception {
		try	{			
			for(DetalleImpuestoInven detalleimpuestoinvenLocal:detalleimpuestoinvens) {
				if(detalleimpuestoinvenLocal.getId().equals(detalleimpuestoinven.getId())) {
					detalleimpuestoinvenLocal.setIsSelected(detalleimpuestoinven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleImpuestoInven(List<DetalleImpuestoInven> detalleimpuestoinvensAux) throws Exception {
		//this.detalleimpuestoinvensAux=detalleimpuestoinvensAux;
		
		for(DetalleImpuestoInven detalleimpuestoinvenAux:detalleimpuestoinvensAux) {
			if(detalleimpuestoinvenAux.getIsChanged()) {
				detalleimpuestoinvenAux.setIsChanged(false);
			}		
			
			if(detalleimpuestoinvenAux.getIsNew()) {
				detalleimpuestoinvenAux.setIsNew(false);
			}	
			
			if(detalleimpuestoinvenAux.getIsDeleted()) {
				detalleimpuestoinvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleImpuestoInven(DetalleImpuestoInven detalleimpuestoinvenAux) throws Exception {
		//this.detalleimpuestoinvenAux=detalleimpuestoinvenAux;
		
			if(detalleimpuestoinvenAux.getIsChanged()) {
				detalleimpuestoinvenAux.setIsChanged(false);
			}		
			
			if(detalleimpuestoinvenAux.getIsNew()) {
				detalleimpuestoinvenAux.setIsNew(false);
			}	
			
			if(detalleimpuestoinvenAux.getIsDeleted()) {
				detalleimpuestoinvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleImpuestoInven detalleimpuestoinvenAsignar,DetalleImpuestoInven detalleimpuestoinven) throws Exception {
		detalleimpuestoinvenAsignar.setId(detalleimpuestoinven.getId());	
		detalleimpuestoinvenAsignar.setVersionRow(detalleimpuestoinven.getVersionRow());	
		detalleimpuestoinvenAsignar.setid_empresa(detalleimpuestoinven.getid_empresa());
		detalleimpuestoinvenAsignar.setempresa_descripcion(detalleimpuestoinven.getempresa_descripcion());	
		detalleimpuestoinvenAsignar.setid_sucursal(detalleimpuestoinven.getid_sucursal());
		detalleimpuestoinvenAsignar.setsucursal_descripcion(detalleimpuestoinven.getsucursal_descripcion());	
		detalleimpuestoinvenAsignar.setid_bodega(detalleimpuestoinven.getid_bodega());
		detalleimpuestoinvenAsignar.setbodega_descripcion(detalleimpuestoinven.getbodega_descripcion());	
		detalleimpuestoinvenAsignar.setid_producto(detalleimpuestoinven.getid_producto());
		detalleimpuestoinvenAsignar.setproducto_descripcion(detalleimpuestoinven.getproducto_descripcion());	
		detalleimpuestoinvenAsignar.setid_impuesto_inven(detalleimpuestoinven.getid_impuesto_inven());
		detalleimpuestoinvenAsignar.setimpuestoinven_descripcion(detalleimpuestoinven.getimpuestoinven_descripcion());	
		detalleimpuestoinvenAsignar.setporcentaje(detalleimpuestoinven.getporcentaje());	
		detalleimpuestoinvenAsignar.setvalor(detalleimpuestoinven.getvalor());	
		detalleimpuestoinvenAsignar.setdescripcion(detalleimpuestoinven.getdescripcion());	
	}
	
	public static void inicializarDetalleImpuestoInven(DetalleImpuestoInven detalleimpuestoinven) throws Exception {
		try {
				detalleimpuestoinven.setId(0L);	
					
				detalleimpuestoinven.setid_empresa(-1L);	
				detalleimpuestoinven.setid_sucursal(-1L);	
				detalleimpuestoinven.setid_bodega(-1L);	
				detalleimpuestoinven.setid_producto(-1L);	
				detalleimpuestoinven.setid_impuesto_inven(-1L);	
				detalleimpuestoinven.setporcentaje(0.0);	
				detalleimpuestoinven.setvalor(0.0);	
				detalleimpuestoinven.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleImpuestoInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleImpuestoInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleImpuestoInvenConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleImpuestoInvenConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleImpuestoInvenConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleImpuestoInvenConstantesFunciones.LABEL_IDIMPUESTOINVEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleImpuestoInvenConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleImpuestoInvenConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleImpuestoInvenConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleImpuestoInven(String sTipo,Row row,Workbook workbook,DetalleImpuestoInven detalleimpuestoinven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleimpuestoinven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleimpuestoinven.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleimpuestoinven.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleimpuestoinven.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleimpuestoinven.getimpuestoinven_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleimpuestoinven.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleimpuestoinven.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleimpuestoinven.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleImpuestoInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleImpuestoInven() {
		return this.sFinalQueryDetalleImpuestoInven;
	}
	
	public void setsFinalQueryDetalleImpuestoInven(String sFinalQueryDetalleImpuestoInven) {
		this.sFinalQueryDetalleImpuestoInven= sFinalQueryDetalleImpuestoInven;
	}
	
	public Border resaltarSeleccionarDetalleImpuestoInven=null;
	
	public Border setResaltarSeleccionarDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleimpuestoinvenBeanSwingJInternalFrame.jTtoolBarDetalleImpuestoInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleImpuestoInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleImpuestoInven() {
		return this.resaltarSeleccionarDetalleImpuestoInven;
	}
	
	public void setResaltarSeleccionarDetalleImpuestoInven(Border borderResaltarSeleccionarDetalleImpuestoInven) {
		this.resaltarSeleccionarDetalleImpuestoInven= borderResaltarSeleccionarDetalleImpuestoInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleImpuestoInven=null;
	public Boolean mostraridDetalleImpuestoInven=true;
	public Boolean activaridDetalleImpuestoInven=true;

	public Border resaltarid_empresaDetalleImpuestoInven=null;
	public Boolean mostrarid_empresaDetalleImpuestoInven=true;
	public Boolean activarid_empresaDetalleImpuestoInven=true;
	public Boolean cargarid_empresaDetalleImpuestoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleImpuestoInven=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleImpuestoInven=null;
	public Boolean mostrarid_sucursalDetalleImpuestoInven=true;
	public Boolean activarid_sucursalDetalleImpuestoInven=true;
	public Boolean cargarid_sucursalDetalleImpuestoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleImpuestoInven=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetalleImpuestoInven=null;
	public Boolean mostrarid_bodegaDetalleImpuestoInven=true;
	public Boolean activarid_bodegaDetalleImpuestoInven=true;
	public Boolean cargarid_bodegaDetalleImpuestoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetalleImpuestoInven=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleImpuestoInven=null;
	public Boolean mostrarid_productoDetalleImpuestoInven=true;
	public Boolean activarid_productoDetalleImpuestoInven=true;
	public Boolean cargarid_productoDetalleImpuestoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleImpuestoInven=false;//ConEventDepend=true

	public Border resaltarid_impuesto_invenDetalleImpuestoInven=null;
	public Boolean mostrarid_impuesto_invenDetalleImpuestoInven=true;
	public Boolean activarid_impuesto_invenDetalleImpuestoInven=true;
	public Boolean cargarid_impuesto_invenDetalleImpuestoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_impuesto_invenDetalleImpuestoInven=false;//ConEventDepend=true

	public Border resaltarporcentajeDetalleImpuestoInven=null;
	public Boolean mostrarporcentajeDetalleImpuestoInven=true;
	public Boolean activarporcentajeDetalleImpuestoInven=true;

	public Border resaltarvalorDetalleImpuestoInven=null;
	public Boolean mostrarvalorDetalleImpuestoInven=true;
	public Boolean activarvalorDetalleImpuestoInven=true;

	public Border resaltardescripcionDetalleImpuestoInven=null;
	public Boolean mostrardescripcionDetalleImpuestoInven=true;
	public Boolean activardescripcionDetalleImpuestoInven=true;

	
	

	public Border setResaltaridDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleimpuestoinvenBeanSwingJInternalFrame.jTtoolBarDetalleImpuestoInven.setBorder(borderResaltar);
		
		this.resaltaridDetalleImpuestoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleImpuestoInven() {
		return this.resaltaridDetalleImpuestoInven;
	}

	public void setResaltaridDetalleImpuestoInven(Border borderResaltar) {
		this.resaltaridDetalleImpuestoInven= borderResaltar;
	}

	public Boolean getMostraridDetalleImpuestoInven() {
		return this.mostraridDetalleImpuestoInven;
	}

	public void setMostraridDetalleImpuestoInven(Boolean mostraridDetalleImpuestoInven) {
		this.mostraridDetalleImpuestoInven= mostraridDetalleImpuestoInven;
	}

	public Boolean getActivaridDetalleImpuestoInven() {
		return this.activaridDetalleImpuestoInven;
	}

	public void setActivaridDetalleImpuestoInven(Boolean activaridDetalleImpuestoInven) {
		this.activaridDetalleImpuestoInven= activaridDetalleImpuestoInven;
	}

	public Border setResaltarid_empresaDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleimpuestoinvenBeanSwingJInternalFrame.jTtoolBarDetalleImpuestoInven.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleImpuestoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleImpuestoInven() {
		return this.resaltarid_empresaDetalleImpuestoInven;
	}

	public void setResaltarid_empresaDetalleImpuestoInven(Border borderResaltar) {
		this.resaltarid_empresaDetalleImpuestoInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleImpuestoInven() {
		return this.mostrarid_empresaDetalleImpuestoInven;
	}

	public void setMostrarid_empresaDetalleImpuestoInven(Boolean mostrarid_empresaDetalleImpuestoInven) {
		this.mostrarid_empresaDetalleImpuestoInven= mostrarid_empresaDetalleImpuestoInven;
	}

	public Boolean getActivarid_empresaDetalleImpuestoInven() {
		return this.activarid_empresaDetalleImpuestoInven;
	}

	public void setActivarid_empresaDetalleImpuestoInven(Boolean activarid_empresaDetalleImpuestoInven) {
		this.activarid_empresaDetalleImpuestoInven= activarid_empresaDetalleImpuestoInven;
	}

	public Boolean getCargarid_empresaDetalleImpuestoInven() {
		return this.cargarid_empresaDetalleImpuestoInven;
	}

	public void setCargarid_empresaDetalleImpuestoInven(Boolean cargarid_empresaDetalleImpuestoInven) {
		this.cargarid_empresaDetalleImpuestoInven= cargarid_empresaDetalleImpuestoInven;
	}

	public Border setResaltarid_sucursalDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleimpuestoinvenBeanSwingJInternalFrame.jTtoolBarDetalleImpuestoInven.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleImpuestoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleImpuestoInven() {
		return this.resaltarid_sucursalDetalleImpuestoInven;
	}

	public void setResaltarid_sucursalDetalleImpuestoInven(Border borderResaltar) {
		this.resaltarid_sucursalDetalleImpuestoInven= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleImpuestoInven() {
		return this.mostrarid_sucursalDetalleImpuestoInven;
	}

	public void setMostrarid_sucursalDetalleImpuestoInven(Boolean mostrarid_sucursalDetalleImpuestoInven) {
		this.mostrarid_sucursalDetalleImpuestoInven= mostrarid_sucursalDetalleImpuestoInven;
	}

	public Boolean getActivarid_sucursalDetalleImpuestoInven() {
		return this.activarid_sucursalDetalleImpuestoInven;
	}

	public void setActivarid_sucursalDetalleImpuestoInven(Boolean activarid_sucursalDetalleImpuestoInven) {
		this.activarid_sucursalDetalleImpuestoInven= activarid_sucursalDetalleImpuestoInven;
	}

	public Boolean getCargarid_sucursalDetalleImpuestoInven() {
		return this.cargarid_sucursalDetalleImpuestoInven;
	}

	public void setCargarid_sucursalDetalleImpuestoInven(Boolean cargarid_sucursalDetalleImpuestoInven) {
		this.cargarid_sucursalDetalleImpuestoInven= cargarid_sucursalDetalleImpuestoInven;
	}

	public Border setResaltarid_bodegaDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleimpuestoinvenBeanSwingJInternalFrame.jTtoolBarDetalleImpuestoInven.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetalleImpuestoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetalleImpuestoInven() {
		return this.resaltarid_bodegaDetalleImpuestoInven;
	}

	public void setResaltarid_bodegaDetalleImpuestoInven(Border borderResaltar) {
		this.resaltarid_bodegaDetalleImpuestoInven= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetalleImpuestoInven() {
		return this.mostrarid_bodegaDetalleImpuestoInven;
	}

	public void setMostrarid_bodegaDetalleImpuestoInven(Boolean mostrarid_bodegaDetalleImpuestoInven) {
		this.mostrarid_bodegaDetalleImpuestoInven= mostrarid_bodegaDetalleImpuestoInven;
	}

	public Boolean getActivarid_bodegaDetalleImpuestoInven() {
		return this.activarid_bodegaDetalleImpuestoInven;
	}

	public void setActivarid_bodegaDetalleImpuestoInven(Boolean activarid_bodegaDetalleImpuestoInven) {
		this.activarid_bodegaDetalleImpuestoInven= activarid_bodegaDetalleImpuestoInven;
	}

	public Boolean getCargarid_bodegaDetalleImpuestoInven() {
		return this.cargarid_bodegaDetalleImpuestoInven;
	}

	public void setCargarid_bodegaDetalleImpuestoInven(Boolean cargarid_bodegaDetalleImpuestoInven) {
		this.cargarid_bodegaDetalleImpuestoInven= cargarid_bodegaDetalleImpuestoInven;
	}

	public Border setResaltarid_productoDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleimpuestoinvenBeanSwingJInternalFrame.jTtoolBarDetalleImpuestoInven.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleImpuestoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleImpuestoInven() {
		return this.resaltarid_productoDetalleImpuestoInven;
	}

	public void setResaltarid_productoDetalleImpuestoInven(Border borderResaltar) {
		this.resaltarid_productoDetalleImpuestoInven= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleImpuestoInven() {
		return this.mostrarid_productoDetalleImpuestoInven;
	}

	public void setMostrarid_productoDetalleImpuestoInven(Boolean mostrarid_productoDetalleImpuestoInven) {
		this.mostrarid_productoDetalleImpuestoInven= mostrarid_productoDetalleImpuestoInven;
	}

	public Boolean getActivarid_productoDetalleImpuestoInven() {
		return this.activarid_productoDetalleImpuestoInven;
	}

	public void setActivarid_productoDetalleImpuestoInven(Boolean activarid_productoDetalleImpuestoInven) {
		this.activarid_productoDetalleImpuestoInven= activarid_productoDetalleImpuestoInven;
	}

	public Boolean getCargarid_productoDetalleImpuestoInven() {
		return this.cargarid_productoDetalleImpuestoInven;
	}

	public void setCargarid_productoDetalleImpuestoInven(Boolean cargarid_productoDetalleImpuestoInven) {
		this.cargarid_productoDetalleImpuestoInven= cargarid_productoDetalleImpuestoInven;
	}

	public Border setResaltarid_impuesto_invenDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleimpuestoinvenBeanSwingJInternalFrame.jTtoolBarDetalleImpuestoInven.setBorder(borderResaltar);
		
		this.resaltarid_impuesto_invenDetalleImpuestoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_impuesto_invenDetalleImpuestoInven() {
		return this.resaltarid_impuesto_invenDetalleImpuestoInven;
	}

	public void setResaltarid_impuesto_invenDetalleImpuestoInven(Border borderResaltar) {
		this.resaltarid_impuesto_invenDetalleImpuestoInven= borderResaltar;
	}

	public Boolean getMostrarid_impuesto_invenDetalleImpuestoInven() {
		return this.mostrarid_impuesto_invenDetalleImpuestoInven;
	}

	public void setMostrarid_impuesto_invenDetalleImpuestoInven(Boolean mostrarid_impuesto_invenDetalleImpuestoInven) {
		this.mostrarid_impuesto_invenDetalleImpuestoInven= mostrarid_impuesto_invenDetalleImpuestoInven;
	}

	public Boolean getActivarid_impuesto_invenDetalleImpuestoInven() {
		return this.activarid_impuesto_invenDetalleImpuestoInven;
	}

	public void setActivarid_impuesto_invenDetalleImpuestoInven(Boolean activarid_impuesto_invenDetalleImpuestoInven) {
		this.activarid_impuesto_invenDetalleImpuestoInven= activarid_impuesto_invenDetalleImpuestoInven;
	}

	public Boolean getCargarid_impuesto_invenDetalleImpuestoInven() {
		return this.cargarid_impuesto_invenDetalleImpuestoInven;
	}

	public void setCargarid_impuesto_invenDetalleImpuestoInven(Boolean cargarid_impuesto_invenDetalleImpuestoInven) {
		this.cargarid_impuesto_invenDetalleImpuestoInven= cargarid_impuesto_invenDetalleImpuestoInven;
	}

	public Border setResaltarporcentajeDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleimpuestoinvenBeanSwingJInternalFrame.jTtoolBarDetalleImpuestoInven.setBorder(borderResaltar);
		
		this.resaltarporcentajeDetalleImpuestoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeDetalleImpuestoInven() {
		return this.resaltarporcentajeDetalleImpuestoInven;
	}

	public void setResaltarporcentajeDetalleImpuestoInven(Border borderResaltar) {
		this.resaltarporcentajeDetalleImpuestoInven= borderResaltar;
	}

	public Boolean getMostrarporcentajeDetalleImpuestoInven() {
		return this.mostrarporcentajeDetalleImpuestoInven;
	}

	public void setMostrarporcentajeDetalleImpuestoInven(Boolean mostrarporcentajeDetalleImpuestoInven) {
		this.mostrarporcentajeDetalleImpuestoInven= mostrarporcentajeDetalleImpuestoInven;
	}

	public Boolean getActivarporcentajeDetalleImpuestoInven() {
		return this.activarporcentajeDetalleImpuestoInven;
	}

	public void setActivarporcentajeDetalleImpuestoInven(Boolean activarporcentajeDetalleImpuestoInven) {
		this.activarporcentajeDetalleImpuestoInven= activarporcentajeDetalleImpuestoInven;
	}

	public Border setResaltarvalorDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleimpuestoinvenBeanSwingJInternalFrame.jTtoolBarDetalleImpuestoInven.setBorder(borderResaltar);
		
		this.resaltarvalorDetalleImpuestoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorDetalleImpuestoInven() {
		return this.resaltarvalorDetalleImpuestoInven;
	}

	public void setResaltarvalorDetalleImpuestoInven(Border borderResaltar) {
		this.resaltarvalorDetalleImpuestoInven= borderResaltar;
	}

	public Boolean getMostrarvalorDetalleImpuestoInven() {
		return this.mostrarvalorDetalleImpuestoInven;
	}

	public void setMostrarvalorDetalleImpuestoInven(Boolean mostrarvalorDetalleImpuestoInven) {
		this.mostrarvalorDetalleImpuestoInven= mostrarvalorDetalleImpuestoInven;
	}

	public Boolean getActivarvalorDetalleImpuestoInven() {
		return this.activarvalorDetalleImpuestoInven;
	}

	public void setActivarvalorDetalleImpuestoInven(Boolean activarvalorDetalleImpuestoInven) {
		this.activarvalorDetalleImpuestoInven= activarvalorDetalleImpuestoInven;
	}

	public Border setResaltardescripcionDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleimpuestoinvenBeanSwingJInternalFrame.jTtoolBarDetalleImpuestoInven.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleImpuestoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleImpuestoInven() {
		return this.resaltardescripcionDetalleImpuestoInven;
	}

	public void setResaltardescripcionDetalleImpuestoInven(Border borderResaltar) {
		this.resaltardescripcionDetalleImpuestoInven= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleImpuestoInven() {
		return this.mostrardescripcionDetalleImpuestoInven;
	}

	public void setMostrardescripcionDetalleImpuestoInven(Boolean mostrardescripcionDetalleImpuestoInven) {
		this.mostrardescripcionDetalleImpuestoInven= mostrardescripcionDetalleImpuestoInven;
	}

	public Boolean getActivardescripcionDetalleImpuestoInven() {
		return this.activardescripcionDetalleImpuestoInven;
	}

	public void setActivardescripcionDetalleImpuestoInven(Boolean activardescripcionDetalleImpuestoInven) {
		this.activardescripcionDetalleImpuestoInven= activardescripcionDetalleImpuestoInven;
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
		
		
		this.setMostraridDetalleImpuestoInven(esInicial);
		this.setMostrarid_empresaDetalleImpuestoInven(esInicial);
		this.setMostrarid_sucursalDetalleImpuestoInven(esInicial);
		this.setMostrarid_bodegaDetalleImpuestoInven(esInicial);
		this.setMostrarid_productoDetalleImpuestoInven(esInicial);
		this.setMostrarid_impuesto_invenDetalleImpuestoInven(esInicial);
		this.setMostrarporcentajeDetalleImpuestoInven(esInicial);
		this.setMostrarvalorDetalleImpuestoInven(esInicial);
		this.setMostrardescripcionDetalleImpuestoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.ID)) {
				this.setMostraridDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDIMPUESTOINVEN)) {
				this.setMostrarid_impuesto_invenDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.VALOR)) {
				this.setMostrarvalorDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleImpuestoInven(esAsigna);
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
		
		
		this.setActivaridDetalleImpuestoInven(esInicial);
		this.setActivarid_empresaDetalleImpuestoInven(esInicial);
		this.setActivarid_sucursalDetalleImpuestoInven(esInicial);
		this.setActivarid_bodegaDetalleImpuestoInven(esInicial);
		this.setActivarid_productoDetalleImpuestoInven(esInicial);
		this.setActivarid_impuesto_invenDetalleImpuestoInven(esInicial);
		this.setActivarporcentajeDetalleImpuestoInven(esInicial);
		this.setActivarvalorDetalleImpuestoInven(esInicial);
		this.setActivardescripcionDetalleImpuestoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.ID)) {
				this.setActivaridDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDIMPUESTOINVEN)) {
				this.setActivarid_impuesto_invenDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.VALOR)) {
				this.setActivarvalorDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleImpuestoInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleImpuestoInven(esInicial);
		this.setResaltarid_empresaDetalleImpuestoInven(esInicial);
		this.setResaltarid_sucursalDetalleImpuestoInven(esInicial);
		this.setResaltarid_bodegaDetalleImpuestoInven(esInicial);
		this.setResaltarid_productoDetalleImpuestoInven(esInicial);
		this.setResaltarid_impuesto_invenDetalleImpuestoInven(esInicial);
		this.setResaltarporcentajeDetalleImpuestoInven(esInicial);
		this.setResaltarvalorDetalleImpuestoInven(esInicial);
		this.setResaltardescripcionDetalleImpuestoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.ID)) {
				this.setResaltaridDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.IDIMPUESTOINVEN)) {
				this.setResaltarid_impuesto_invenDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.VALOR)) {
				this.setResaltarvalorDetalleImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleImpuestoInvenConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleImpuestoInven(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaDetalleImpuestoInven=true;

	public Boolean getMostrarFK_IdBodegaDetalleImpuestoInven() {
		return this.mostrarFK_IdBodegaDetalleImpuestoInven;
	}

	public void setMostrarFK_IdBodegaDetalleImpuestoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetalleImpuestoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleImpuestoInven=true;

	public Boolean getMostrarFK_IdEmpresaDetalleImpuestoInven() {
		return this.mostrarFK_IdEmpresaDetalleImpuestoInven;
	}

	public void setMostrarFK_IdEmpresaDetalleImpuestoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleImpuestoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdImpuestoInvenDetalleImpuestoInven=true;

	public Boolean getMostrarFK_IdImpuestoInvenDetalleImpuestoInven() {
		return this.mostrarFK_IdImpuestoInvenDetalleImpuestoInven;
	}

	public void setMostrarFK_IdImpuestoInvenDetalleImpuestoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdImpuestoInvenDetalleImpuestoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleImpuestoInven=true;

	public Boolean getMostrarFK_IdProductoDetalleImpuestoInven() {
		return this.mostrarFK_IdProductoDetalleImpuestoInven;
	}

	public void setMostrarFK_IdProductoDetalleImpuestoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleImpuestoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleImpuestoInven=true;

	public Boolean getMostrarFK_IdSucursalDetalleImpuestoInven() {
		return this.mostrarFK_IdSucursalDetalleImpuestoInven;
	}

	public void setMostrarFK_IdSucursalDetalleImpuestoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleImpuestoInven= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaDetalleImpuestoInven=true;

	public Boolean getActivarFK_IdBodegaDetalleImpuestoInven() {
		return this.activarFK_IdBodegaDetalleImpuestoInven;
	}

	public void setActivarFK_IdBodegaDetalleImpuestoInven(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetalleImpuestoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleImpuestoInven=true;

	public Boolean getActivarFK_IdEmpresaDetalleImpuestoInven() {
		return this.activarFK_IdEmpresaDetalleImpuestoInven;
	}

	public void setActivarFK_IdEmpresaDetalleImpuestoInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleImpuestoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdImpuestoInvenDetalleImpuestoInven=true;

	public Boolean getActivarFK_IdImpuestoInvenDetalleImpuestoInven() {
		return this.activarFK_IdImpuestoInvenDetalleImpuestoInven;
	}

	public void setActivarFK_IdImpuestoInvenDetalleImpuestoInven(Boolean habilitarResaltar) {
		this.activarFK_IdImpuestoInvenDetalleImpuestoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleImpuestoInven=true;

	public Boolean getActivarFK_IdProductoDetalleImpuestoInven() {
		return this.activarFK_IdProductoDetalleImpuestoInven;
	}

	public void setActivarFK_IdProductoDetalleImpuestoInven(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleImpuestoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleImpuestoInven=true;

	public Boolean getActivarFK_IdSucursalDetalleImpuestoInven() {
		return this.activarFK_IdSucursalDetalleImpuestoInven;
	}

	public void setActivarFK_IdSucursalDetalleImpuestoInven(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleImpuestoInven= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaDetalleImpuestoInven=null;

	public Border getResaltarFK_IdBodegaDetalleImpuestoInven() {
		return this.resaltarFK_IdBodegaDetalleImpuestoInven;
	}

	public void setResaltarFK_IdBodegaDetalleImpuestoInven(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetalleImpuestoInven= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetalleImpuestoInven= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleImpuestoInven=null;

	public Border getResaltarFK_IdEmpresaDetalleImpuestoInven() {
		return this.resaltarFK_IdEmpresaDetalleImpuestoInven;
	}

	public void setResaltarFK_IdEmpresaDetalleImpuestoInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleImpuestoInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleImpuestoInven= borderResaltar;
	}

	public Border resaltarFK_IdImpuestoInvenDetalleImpuestoInven=null;

	public Border getResaltarFK_IdImpuestoInvenDetalleImpuestoInven() {
		return this.resaltarFK_IdImpuestoInvenDetalleImpuestoInven;
	}

	public void setResaltarFK_IdImpuestoInvenDetalleImpuestoInven(Border borderResaltar) {
		this.resaltarFK_IdImpuestoInvenDetalleImpuestoInven= borderResaltar;
	}

	public void setResaltarFK_IdImpuestoInvenDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdImpuestoInvenDetalleImpuestoInven= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleImpuestoInven=null;

	public Border getResaltarFK_IdProductoDetalleImpuestoInven() {
		return this.resaltarFK_IdProductoDetalleImpuestoInven;
	}

	public void setResaltarFK_IdProductoDetalleImpuestoInven(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleImpuestoInven= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleImpuestoInven= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleImpuestoInven=null;

	public Border getResaltarFK_IdSucursalDetalleImpuestoInven() {
		return this.resaltarFK_IdSucursalDetalleImpuestoInven;
	}

	public void setResaltarFK_IdSucursalDetalleImpuestoInven(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleImpuestoInven= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleImpuestoInvenBeanSwingJInternalFrame detalleimpuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleImpuestoInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}