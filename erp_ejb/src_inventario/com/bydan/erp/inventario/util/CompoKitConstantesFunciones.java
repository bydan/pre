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


import com.bydan.erp.inventario.util.CompoKitConstantesFunciones;
import com.bydan.erp.inventario.util.CompoKitParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CompoKitParameterGeneral;

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
final public class CompoKitConstantesFunciones extends CompoKitConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CompoKit";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CompoKit"+CompoKitConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CompoKitHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CompoKitHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CompoKitConstantesFunciones.SCHEMA+"_"+CompoKitConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CompoKitHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CompoKitConstantesFunciones.SCHEMA+"_"+CompoKitConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CompoKitConstantesFunciones.SCHEMA+"_"+CompoKitConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CompoKitHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CompoKitConstantesFunciones.SCHEMA+"_"+CompoKitConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CompoKitConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CompoKitHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CompoKitConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CompoKitConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CompoKitHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CompoKitConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CompoKitConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CompoKitConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CompoKitConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CompoKitConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Compo Kites";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Compo Kit";
	public static final String SCLASSWEBTITULO_LOWER="Compo Kit";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CompoKit";
	public static final String OBJECTNAME="compokit";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="compo_kit";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select compokit from "+CompoKitConstantesFunciones.SPERSISTENCENAME+" compokit";
	public static String QUERYSELECTNATIVE="select "+CompoKitConstantesFunciones.SCHEMA+"."+CompoKitConstantesFunciones.TABLENAME+".id,"+CompoKitConstantesFunciones.SCHEMA+"."+CompoKitConstantesFunciones.TABLENAME+".version_row,"+CompoKitConstantesFunciones.SCHEMA+"."+CompoKitConstantesFunciones.TABLENAME+".id_empresa,"+CompoKitConstantesFunciones.SCHEMA+"."+CompoKitConstantesFunciones.TABLENAME+".id_sucursal,"+CompoKitConstantesFunciones.SCHEMA+"."+CompoKitConstantesFunciones.TABLENAME+".id_bodega,"+CompoKitConstantesFunciones.SCHEMA+"."+CompoKitConstantesFunciones.TABLENAME+".id_producto,"+CompoKitConstantesFunciones.SCHEMA+"."+CompoKitConstantesFunciones.TABLENAME+".id_kit,"+CompoKitConstantesFunciones.SCHEMA+"."+CompoKitConstantesFunciones.TABLENAME+".id_unidad,"+CompoKitConstantesFunciones.SCHEMA+"."+CompoKitConstantesFunciones.TABLENAME+".cantidad,"+CompoKitConstantesFunciones.SCHEMA+"."+CompoKitConstantesFunciones.TABLENAME+".valor_ingreso,"+CompoKitConstantesFunciones.SCHEMA+"."+CompoKitConstantesFunciones.TABLENAME+".descripcion from "+CompoKitConstantesFunciones.SCHEMA+"."+CompoKitConstantesFunciones.TABLENAME;//+" as "+CompoKitConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CompoKitConstantesFuncionesAdditional compokitConstantesFuncionesAdditional=null;
	
	public CompoKitConstantesFuncionesAdditional getCompoKitConstantesFuncionesAdditional() {
		return this.compokitConstantesFuncionesAdditional;
	}
	
	public void setCompoKitConstantesFuncionesAdditional(CompoKitConstantesFuncionesAdditional compokitConstantesFuncionesAdditional) {
		try {
			this.compokitConstantesFuncionesAdditional=compokitConstantesFuncionesAdditional;
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
    public static final String IDKIT= "id_kit";
    public static final String IDUNIDAD= "id_unidad";
    public static final String CANTIDAD= "cantidad";
    public static final String VALORINGRESO= "valor_ingreso";
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
    	public static final String LABEL_IDKIT= "Kit";
		public static final String LABEL_IDKIT_LOWER= "Kit";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_VALORINGRESO= "Valor Ingreso";
		public static final String LABEL_VALORINGRESO_LOWER= "Valor Ingreso";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCompoKitLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CompoKitConstantesFunciones.IDEMPRESA)) {sLabelColumna=CompoKitConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CompoKitConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CompoKitConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CompoKitConstantesFunciones.IDBODEGA)) {sLabelColumna=CompoKitConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(CompoKitConstantesFunciones.IDPRODUCTO)) {sLabelColumna=CompoKitConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(CompoKitConstantesFunciones.IDKIT)) {sLabelColumna=CompoKitConstantesFunciones.LABEL_IDKIT;}
		if(sNombreColumna.equals(CompoKitConstantesFunciones.IDUNIDAD)) {sLabelColumna=CompoKitConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(CompoKitConstantesFunciones.CANTIDAD)) {sLabelColumna=CompoKitConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(CompoKitConstantesFunciones.VALORINGRESO)) {sLabelColumna=CompoKitConstantesFunciones.LABEL_VALORINGRESO;}
		if(sNombreColumna.equals(CompoKitConstantesFunciones.DESCRIPCION)) {sLabelColumna=CompoKitConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCompoKitDescripcion(CompoKit compokit) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(compokit !=null/* && compokit.getId()!=0*/) {
			if(compokit.getId()!=null) {
				sDescripcion=compokit.getId().toString();
			}//compokitcompokit.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCompoKitDescripcionDetallado(CompoKit compokit) {
		String sDescripcion="";
			
		sDescripcion+=CompoKitConstantesFunciones.ID+"=";
		sDescripcion+=compokit.getId().toString()+",";
		sDescripcion+=CompoKitConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=compokit.getVersionRow().toString()+",";
		sDescripcion+=CompoKitConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=compokit.getid_empresa().toString()+",";
		sDescripcion+=CompoKitConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=compokit.getid_sucursal().toString()+",";
		sDescripcion+=CompoKitConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=compokit.getid_bodega().toString()+",";
		sDescripcion+=CompoKitConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=compokit.getid_producto().toString()+",";
		sDescripcion+=CompoKitConstantesFunciones.IDKIT+"=";
		sDescripcion+=compokit.getid_kit().toString()+",";
		sDescripcion+=CompoKitConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=compokit.getid_unidad().toString()+",";
		sDescripcion+=CompoKitConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=compokit.getcantidad().toString()+",";
		sDescripcion+=CompoKitConstantesFunciones.VALORINGRESO+"=";
		sDescripcion+=compokit.getvalor_ingreso().toString()+",";
		sDescripcion+=CompoKitConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=compokit.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setCompoKitDescripcion(CompoKit compokit,String sValor) throws Exception {			
		if(compokit !=null) {
			//compokitcompokit.getId().toString();
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

	public static String getKitDescripcion(Kit kit) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(kit!=null/*&&kit.getId()>0*/) {
			sDescripcion=KitConstantesFunciones.getKitDescripcion(kit);
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
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdKit")) {
			sNombreIndice="Tipo=  Por Kit";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unad";
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

	public static String getDetalleIndiceFK_IdKit(Long id_kit) {
		String sDetalleIndice=" Parametros->";
		if(id_kit!=null) {sDetalleIndice+=" Codigo Unico De Kit="+id_kit.toString();} 

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

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCompoKit(CompoKit compokit,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		compokit.setdescripcion(compokit.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCompoKits(List<CompoKit> compokits,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CompoKit compokit: compokits) {
			compokit.setdescripcion(compokit.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCompoKit(CompoKit compokit,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && compokit.getConCambioAuxiliar()) {
			compokit.setIsDeleted(compokit.getIsDeletedAuxiliar());	
			compokit.setIsNew(compokit.getIsNewAuxiliar());	
			compokit.setIsChanged(compokit.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			compokit.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			compokit.setIsDeletedAuxiliar(false);	
			compokit.setIsNewAuxiliar(false);	
			compokit.setIsChangedAuxiliar(false);
			
			compokit.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCompoKits(List<CompoKit> compokits,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CompoKit compokit : compokits) {
			if(conAsignarBase && compokit.getConCambioAuxiliar()) {
				compokit.setIsDeleted(compokit.getIsDeletedAuxiliar());	
				compokit.setIsNew(compokit.getIsNewAuxiliar());	
				compokit.setIsChanged(compokit.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				compokit.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				compokit.setIsDeletedAuxiliar(false);	
				compokit.setIsNewAuxiliar(false);	
				compokit.setIsChangedAuxiliar(false);
				
				compokit.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCompoKit(CompoKit compokit,Boolean conEnteros) throws Exception  {
		compokit.setvalor_ingreso(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			compokit.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresCompoKits(List<CompoKit> compokits,Boolean conEnteros) throws Exception  {
		
		for(CompoKit compokit: compokits) {
			compokit.setvalor_ingreso(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				compokit.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCompoKit(List<CompoKit> compokits,CompoKit compokitAux) throws Exception  {
		CompoKitConstantesFunciones.InicializarValoresCompoKit(compokitAux,true);
		
		for(CompoKit compokit: compokits) {
			if(compokit.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			compokitAux.setcantidad(compokitAux.getcantidad()+compokit.getcantidad());			
			compokitAux.setvalor_ingreso(compokitAux.getvalor_ingreso()+compokit.getvalor_ingreso());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCompoKit(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CompoKitConstantesFunciones.getArrayColumnasGlobalesCompoKit(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCompoKit(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CompoKitConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CompoKitConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CompoKitConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CompoKitConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCompoKit(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CompoKit> compokits,CompoKit compokit,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CompoKit compokitAux: compokits) {
			if(compokitAux!=null && compokit!=null) {
				if((compokitAux.getId()==null && compokit.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(compokitAux.getId()!=null && compokit.getId()!=null){
					if(compokitAux.getId().equals(compokit.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCompoKit(List<CompoKit> compokits) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_ingresoTotal=0.0;
	
		for(CompoKit compokit: compokits) {			
			if(compokit.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_ingresoTotal+=compokit.getvalor_ingreso();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CompoKitConstantesFunciones.VALORINGRESO);
		datoGeneral.setsDescripcion(CompoKitConstantesFunciones.LABEL_VALORINGRESO);
		datoGeneral.setdValorDouble(valor_ingresoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCompoKit() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CompoKitConstantesFunciones.LABEL_ID, CompoKitConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompoKitConstantesFunciones.LABEL_VERSIONROW, CompoKitConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompoKitConstantesFunciones.LABEL_IDEMPRESA, CompoKitConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompoKitConstantesFunciones.LABEL_IDSUCURSAL, CompoKitConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompoKitConstantesFunciones.LABEL_IDBODEGA, CompoKitConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompoKitConstantesFunciones.LABEL_IDPRODUCTO, CompoKitConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompoKitConstantesFunciones.LABEL_IDKIT, CompoKitConstantesFunciones.IDKIT,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompoKitConstantesFunciones.LABEL_IDUNIDAD, CompoKitConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompoKitConstantesFunciones.LABEL_CANTIDAD, CompoKitConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompoKitConstantesFunciones.LABEL_VALORINGRESO, CompoKitConstantesFunciones.VALORINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CompoKitConstantesFunciones.LABEL_DESCRIPCION, CompoKitConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCompoKit() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CompoKitConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompoKitConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompoKitConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompoKitConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompoKitConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompoKitConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompoKitConstantesFunciones.IDKIT;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompoKitConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompoKitConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompoKitConstantesFunciones.VALORINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CompoKitConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCompoKit() throws Exception  {
		return CompoKitConstantesFunciones.getTiposSeleccionarCompoKit(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCompoKit(Boolean conFk) throws Exception  {
		return CompoKitConstantesFunciones.getTiposSeleccionarCompoKit(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCompoKit(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompoKitConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CompoKitConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompoKitConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CompoKitConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompoKitConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(CompoKitConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompoKitConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(CompoKitConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompoKitConstantesFunciones.LABEL_IDKIT);
			reporte.setsDescripcion(CompoKitConstantesFunciones.LABEL_IDKIT);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CompoKitConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(CompoKitConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompoKitConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(CompoKitConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompoKitConstantesFunciones.LABEL_VALORINGRESO);
			reporte.setsDescripcion(CompoKitConstantesFunciones.LABEL_VALORINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CompoKitConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CompoKitConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCompoKit(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCompoKit(CompoKit compokitAux) throws Exception {
		
			compokitAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(compokitAux.getEmpresa()));
			compokitAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(compokitAux.getSucursal()));
			compokitAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(compokitAux.getBodega()));
			compokitAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(compokitAux.getProducto()));
			compokitAux.setkit_descripcion(KitConstantesFunciones.getKitDescripcion(compokitAux.getKit()));
			compokitAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(compokitAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCompoKit(List<CompoKit> compokitsTemp) throws Exception {
		for(CompoKit compokitAux:compokitsTemp) {
			
			compokitAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(compokitAux.getEmpresa()));
			compokitAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(compokitAux.getSucursal()));
			compokitAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(compokitAux.getBodega()));
			compokitAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(compokitAux.getProducto()));
			compokitAux.setkit_descripcion(KitConstantesFunciones.getKitDescripcion(compokitAux.getKit()));
			compokitAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(compokitAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCompoKit(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Kit.class));
				classes.add(new Classe(Unidad.class));
				
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
					if(clas.clas.equals(Kit.class)) {
						classes.add(new Classe(Kit.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCompoKit(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Kit.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Kit.class)); continue;
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

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Kit.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Kit.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCompoKit(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CompoKitConstantesFunciones.getClassesRelationshipsOfCompoKit(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCompoKit(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCompoKit(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CompoKitConstantesFunciones.getClassesRelationshipsFromStringsOfCompoKit(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCompoKit(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CompoKit compokit,List<CompoKit> compokits,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CompoKit compokitEncontrado=null;
			
			for(CompoKit compokitLocal:compokits) {
				if(compokitLocal.getId().equals(compokit.getId())) {
					compokitEncontrado=compokitLocal;
					
					compokitLocal.setIsChanged(compokit.getIsChanged());
					compokitLocal.setIsNew(compokit.getIsNew());
					compokitLocal.setIsDeleted(compokit.getIsDeleted());
					
					compokitLocal.setGeneralEntityOriginal(compokit.getGeneralEntityOriginal());
					
					compokitLocal.setId(compokit.getId());	
					compokitLocal.setVersionRow(compokit.getVersionRow());	
					compokitLocal.setid_empresa(compokit.getid_empresa());	
					compokitLocal.setid_sucursal(compokit.getid_sucursal());	
					compokitLocal.setid_bodega(compokit.getid_bodega());	
					compokitLocal.setid_producto(compokit.getid_producto());	
					compokitLocal.setid_kit(compokit.getid_kit());	
					compokitLocal.setid_unidad(compokit.getid_unidad());	
					compokitLocal.setcantidad(compokit.getcantidad());	
					compokitLocal.setvalor_ingreso(compokit.getvalor_ingreso());	
					compokitLocal.setdescripcion(compokit.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!compokit.getIsDeleted()) {
				if(!existe) {
					compokits.add(compokit);
				}
			} else {
				if(compokitEncontrado!=null && permiteQuitar)  {
					compokits.remove(compokitEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CompoKit compokit,List<CompoKit> compokits) throws Exception {
		try	{			
			for(CompoKit compokitLocal:compokits) {
				if(compokitLocal.getId().equals(compokit.getId())) {
					compokitLocal.setIsSelected(compokit.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCompoKit(List<CompoKit> compokitsAux) throws Exception {
		//this.compokitsAux=compokitsAux;
		
		for(CompoKit compokitAux:compokitsAux) {
			if(compokitAux.getIsChanged()) {
				compokitAux.setIsChanged(false);
			}		
			
			if(compokitAux.getIsNew()) {
				compokitAux.setIsNew(false);
			}	
			
			if(compokitAux.getIsDeleted()) {
				compokitAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCompoKit(CompoKit compokitAux) throws Exception {
		//this.compokitAux=compokitAux;
		
			if(compokitAux.getIsChanged()) {
				compokitAux.setIsChanged(false);
			}		
			
			if(compokitAux.getIsNew()) {
				compokitAux.setIsNew(false);
			}	
			
			if(compokitAux.getIsDeleted()) {
				compokitAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CompoKit compokitAsignar,CompoKit compokit) throws Exception {
		compokitAsignar.setId(compokit.getId());	
		compokitAsignar.setVersionRow(compokit.getVersionRow());	
		compokitAsignar.setid_empresa(compokit.getid_empresa());
		compokitAsignar.setempresa_descripcion(compokit.getempresa_descripcion());	
		compokitAsignar.setid_sucursal(compokit.getid_sucursal());
		compokitAsignar.setsucursal_descripcion(compokit.getsucursal_descripcion());	
		compokitAsignar.setid_bodega(compokit.getid_bodega());
		compokitAsignar.setbodega_descripcion(compokit.getbodega_descripcion());	
		compokitAsignar.setid_producto(compokit.getid_producto());
		compokitAsignar.setproducto_descripcion(compokit.getproducto_descripcion());	
		compokitAsignar.setid_kit(compokit.getid_kit());
		compokitAsignar.setkit_descripcion(compokit.getkit_descripcion());	
		compokitAsignar.setid_unidad(compokit.getid_unidad());
		compokitAsignar.setunidad_descripcion(compokit.getunidad_descripcion());	
		compokitAsignar.setcantidad(compokit.getcantidad());	
		compokitAsignar.setvalor_ingreso(compokit.getvalor_ingreso());	
		compokitAsignar.setdescripcion(compokit.getdescripcion());	
	}
	
	public static void inicializarCompoKit(CompoKit compokit) throws Exception {
		try {
				compokit.setId(0L);	
					
				compokit.setid_empresa(-1L);	
				compokit.setid_sucursal(-1L);	
				compokit.setid_bodega(-1L);	
				compokit.setid_producto(-1L);	
				compokit.setid_kit(-1L);	
				compokit.setid_unidad(-1L);	
				compokit.setcantidad(0);	
				compokit.setvalor_ingreso(0.0);	
				compokit.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCompoKit(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CompoKitConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompoKitConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompoKitConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompoKitConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompoKitConstantesFunciones.LABEL_IDKIT);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompoKitConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompoKitConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompoKitConstantesFunciones.LABEL_VALORINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CompoKitConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCompoKit(String sTipo,Row row,Workbook workbook,CompoKit compokit,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(compokit.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compokit.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compokit.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compokit.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compokit.getkit_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compokit.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compokit.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compokit.getvalor_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(compokit.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCompoKit=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCompoKit() {
		return this.sFinalQueryCompoKit;
	}
	
	public void setsFinalQueryCompoKit(String sFinalQueryCompoKit) {
		this.sFinalQueryCompoKit= sFinalQueryCompoKit;
	}
	
	public Border resaltarSeleccionarCompoKit=null;
	
	public Border setResaltarSeleccionarCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//compokitBeanSwingJInternalFrame.jTtoolBarCompoKit.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCompoKit= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCompoKit() {
		return this.resaltarSeleccionarCompoKit;
	}
	
	public void setResaltarSeleccionarCompoKit(Border borderResaltarSeleccionarCompoKit) {
		this.resaltarSeleccionarCompoKit= borderResaltarSeleccionarCompoKit;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCompoKit=null;
	public Boolean mostraridCompoKit=true;
	public Boolean activaridCompoKit=true;

	public Border resaltarid_empresaCompoKit=null;
	public Boolean mostrarid_empresaCompoKit=true;
	public Boolean activarid_empresaCompoKit=true;
	public Boolean cargarid_empresaCompoKit=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCompoKit=false;//ConEventDepend=true

	public Border resaltarid_sucursalCompoKit=null;
	public Boolean mostrarid_sucursalCompoKit=true;
	public Boolean activarid_sucursalCompoKit=true;
	public Boolean cargarid_sucursalCompoKit=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCompoKit=false;//ConEventDepend=true

	public Border resaltarid_bodegaCompoKit=null;
	public Boolean mostrarid_bodegaCompoKit=true;
	public Boolean activarid_bodegaCompoKit=true;
	public Boolean cargarid_bodegaCompoKit=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaCompoKit=false;//ConEventDepend=true

	public Border resaltarid_productoCompoKit=null;
	public Boolean mostrarid_productoCompoKit=true;
	public Boolean activarid_productoCompoKit=true;
	public Boolean cargarid_productoCompoKit=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoCompoKit=true;//ConEventDepend=true

	public Border resaltarid_kitCompoKit=null;
	public Boolean mostrarid_kitCompoKit=true;
	public Boolean activarid_kitCompoKit=true;
	public Boolean cargarid_kitCompoKit=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_kitCompoKit=false;//ConEventDepend=true

	public Border resaltarid_unidadCompoKit=null;
	public Boolean mostrarid_unidadCompoKit=true;
	public Boolean activarid_unidadCompoKit=true;
	public Boolean cargarid_unidadCompoKit=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadCompoKit=true;//ConEventDepend=true

	public Border resaltarcantidadCompoKit=null;
	public Boolean mostrarcantidadCompoKit=true;
	public Boolean activarcantidadCompoKit=true;

	public Border resaltarvalor_ingresoCompoKit=null;
	public Boolean mostrarvalor_ingresoCompoKit=true;
	public Boolean activarvalor_ingresoCompoKit=true;

	public Border resaltardescripcionCompoKit=null;
	public Boolean mostrardescripcionCompoKit=true;
	public Boolean activardescripcionCompoKit=true;

	
	

	public Border setResaltaridCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compokitBeanSwingJInternalFrame.jTtoolBarCompoKit.setBorder(borderResaltar);
		
		this.resaltaridCompoKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCompoKit() {
		return this.resaltaridCompoKit;
	}

	public void setResaltaridCompoKit(Border borderResaltar) {
		this.resaltaridCompoKit= borderResaltar;
	}

	public Boolean getMostraridCompoKit() {
		return this.mostraridCompoKit;
	}

	public void setMostraridCompoKit(Boolean mostraridCompoKit) {
		this.mostraridCompoKit= mostraridCompoKit;
	}

	public Boolean getActivaridCompoKit() {
		return this.activaridCompoKit;
	}

	public void setActivaridCompoKit(Boolean activaridCompoKit) {
		this.activaridCompoKit= activaridCompoKit;
	}

	public Border setResaltarid_empresaCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compokitBeanSwingJInternalFrame.jTtoolBarCompoKit.setBorder(borderResaltar);
		
		this.resaltarid_empresaCompoKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCompoKit() {
		return this.resaltarid_empresaCompoKit;
	}

	public void setResaltarid_empresaCompoKit(Border borderResaltar) {
		this.resaltarid_empresaCompoKit= borderResaltar;
	}

	public Boolean getMostrarid_empresaCompoKit() {
		return this.mostrarid_empresaCompoKit;
	}

	public void setMostrarid_empresaCompoKit(Boolean mostrarid_empresaCompoKit) {
		this.mostrarid_empresaCompoKit= mostrarid_empresaCompoKit;
	}

	public Boolean getActivarid_empresaCompoKit() {
		return this.activarid_empresaCompoKit;
	}

	public void setActivarid_empresaCompoKit(Boolean activarid_empresaCompoKit) {
		this.activarid_empresaCompoKit= activarid_empresaCompoKit;
	}

	public Boolean getCargarid_empresaCompoKit() {
		return this.cargarid_empresaCompoKit;
	}

	public void setCargarid_empresaCompoKit(Boolean cargarid_empresaCompoKit) {
		this.cargarid_empresaCompoKit= cargarid_empresaCompoKit;
	}

	public Border setResaltarid_sucursalCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compokitBeanSwingJInternalFrame.jTtoolBarCompoKit.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCompoKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCompoKit() {
		return this.resaltarid_sucursalCompoKit;
	}

	public void setResaltarid_sucursalCompoKit(Border borderResaltar) {
		this.resaltarid_sucursalCompoKit= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCompoKit() {
		return this.mostrarid_sucursalCompoKit;
	}

	public void setMostrarid_sucursalCompoKit(Boolean mostrarid_sucursalCompoKit) {
		this.mostrarid_sucursalCompoKit= mostrarid_sucursalCompoKit;
	}

	public Boolean getActivarid_sucursalCompoKit() {
		return this.activarid_sucursalCompoKit;
	}

	public void setActivarid_sucursalCompoKit(Boolean activarid_sucursalCompoKit) {
		this.activarid_sucursalCompoKit= activarid_sucursalCompoKit;
	}

	public Boolean getCargarid_sucursalCompoKit() {
		return this.cargarid_sucursalCompoKit;
	}

	public void setCargarid_sucursalCompoKit(Boolean cargarid_sucursalCompoKit) {
		this.cargarid_sucursalCompoKit= cargarid_sucursalCompoKit;
	}

	public Border setResaltarid_bodegaCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compokitBeanSwingJInternalFrame.jTtoolBarCompoKit.setBorder(borderResaltar);
		
		this.resaltarid_bodegaCompoKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaCompoKit() {
		return this.resaltarid_bodegaCompoKit;
	}

	public void setResaltarid_bodegaCompoKit(Border borderResaltar) {
		this.resaltarid_bodegaCompoKit= borderResaltar;
	}

	public Boolean getMostrarid_bodegaCompoKit() {
		return this.mostrarid_bodegaCompoKit;
	}

	public void setMostrarid_bodegaCompoKit(Boolean mostrarid_bodegaCompoKit) {
		this.mostrarid_bodegaCompoKit= mostrarid_bodegaCompoKit;
	}

	public Boolean getActivarid_bodegaCompoKit() {
		return this.activarid_bodegaCompoKit;
	}

	public void setActivarid_bodegaCompoKit(Boolean activarid_bodegaCompoKit) {
		this.activarid_bodegaCompoKit= activarid_bodegaCompoKit;
	}

	public Boolean getCargarid_bodegaCompoKit() {
		return this.cargarid_bodegaCompoKit;
	}

	public void setCargarid_bodegaCompoKit(Boolean cargarid_bodegaCompoKit) {
		this.cargarid_bodegaCompoKit= cargarid_bodegaCompoKit;
	}

	public Border setResaltarid_productoCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compokitBeanSwingJInternalFrame.jTtoolBarCompoKit.setBorder(borderResaltar);
		
		this.resaltarid_productoCompoKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoCompoKit() {
		return this.resaltarid_productoCompoKit;
	}

	public void setResaltarid_productoCompoKit(Border borderResaltar) {
		this.resaltarid_productoCompoKit= borderResaltar;
	}

	public Boolean getMostrarid_productoCompoKit() {
		return this.mostrarid_productoCompoKit;
	}

	public void setMostrarid_productoCompoKit(Boolean mostrarid_productoCompoKit) {
		this.mostrarid_productoCompoKit= mostrarid_productoCompoKit;
	}

	public Boolean getActivarid_productoCompoKit() {
		return this.activarid_productoCompoKit;
	}

	public void setActivarid_productoCompoKit(Boolean activarid_productoCompoKit) {
		this.activarid_productoCompoKit= activarid_productoCompoKit;
	}

	public Boolean getCargarid_productoCompoKit() {
		return this.cargarid_productoCompoKit;
	}

	public void setCargarid_productoCompoKit(Boolean cargarid_productoCompoKit) {
		this.cargarid_productoCompoKit= cargarid_productoCompoKit;
	}

	public Border setResaltarid_kitCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compokitBeanSwingJInternalFrame.jTtoolBarCompoKit.setBorder(borderResaltar);
		
		this.resaltarid_kitCompoKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_kitCompoKit() {
		return this.resaltarid_kitCompoKit;
	}

	public void setResaltarid_kitCompoKit(Border borderResaltar) {
		this.resaltarid_kitCompoKit= borderResaltar;
	}

	public Boolean getMostrarid_kitCompoKit() {
		return this.mostrarid_kitCompoKit;
	}

	public void setMostrarid_kitCompoKit(Boolean mostrarid_kitCompoKit) {
		this.mostrarid_kitCompoKit= mostrarid_kitCompoKit;
	}

	public Boolean getActivarid_kitCompoKit() {
		return this.activarid_kitCompoKit;
	}

	public void setActivarid_kitCompoKit(Boolean activarid_kitCompoKit) {
		this.activarid_kitCompoKit= activarid_kitCompoKit;
	}

	public Boolean getCargarid_kitCompoKit() {
		return this.cargarid_kitCompoKit;
	}

	public void setCargarid_kitCompoKit(Boolean cargarid_kitCompoKit) {
		this.cargarid_kitCompoKit= cargarid_kitCompoKit;
	}

	public Border setResaltarid_unidadCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compokitBeanSwingJInternalFrame.jTtoolBarCompoKit.setBorder(borderResaltar);
		
		this.resaltarid_unidadCompoKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadCompoKit() {
		return this.resaltarid_unidadCompoKit;
	}

	public void setResaltarid_unidadCompoKit(Border borderResaltar) {
		this.resaltarid_unidadCompoKit= borderResaltar;
	}

	public Boolean getMostrarid_unidadCompoKit() {
		return this.mostrarid_unidadCompoKit;
	}

	public void setMostrarid_unidadCompoKit(Boolean mostrarid_unidadCompoKit) {
		this.mostrarid_unidadCompoKit= mostrarid_unidadCompoKit;
	}

	public Boolean getActivarid_unidadCompoKit() {
		return this.activarid_unidadCompoKit;
	}

	public void setActivarid_unidadCompoKit(Boolean activarid_unidadCompoKit) {
		this.activarid_unidadCompoKit= activarid_unidadCompoKit;
	}

	public Boolean getCargarid_unidadCompoKit() {
		return this.cargarid_unidadCompoKit;
	}

	public void setCargarid_unidadCompoKit(Boolean cargarid_unidadCompoKit) {
		this.cargarid_unidadCompoKit= cargarid_unidadCompoKit;
	}

	public Border setResaltarcantidadCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compokitBeanSwingJInternalFrame.jTtoolBarCompoKit.setBorder(borderResaltar);
		
		this.resaltarcantidadCompoKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadCompoKit() {
		return this.resaltarcantidadCompoKit;
	}

	public void setResaltarcantidadCompoKit(Border borderResaltar) {
		this.resaltarcantidadCompoKit= borderResaltar;
	}

	public Boolean getMostrarcantidadCompoKit() {
		return this.mostrarcantidadCompoKit;
	}

	public void setMostrarcantidadCompoKit(Boolean mostrarcantidadCompoKit) {
		this.mostrarcantidadCompoKit= mostrarcantidadCompoKit;
	}

	public Boolean getActivarcantidadCompoKit() {
		return this.activarcantidadCompoKit;
	}

	public void setActivarcantidadCompoKit(Boolean activarcantidadCompoKit) {
		this.activarcantidadCompoKit= activarcantidadCompoKit;
	}

	public Border setResaltarvalor_ingresoCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compokitBeanSwingJInternalFrame.jTtoolBarCompoKit.setBorder(borderResaltar);
		
		this.resaltarvalor_ingresoCompoKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_ingresoCompoKit() {
		return this.resaltarvalor_ingresoCompoKit;
	}

	public void setResaltarvalor_ingresoCompoKit(Border borderResaltar) {
		this.resaltarvalor_ingresoCompoKit= borderResaltar;
	}

	public Boolean getMostrarvalor_ingresoCompoKit() {
		return this.mostrarvalor_ingresoCompoKit;
	}

	public void setMostrarvalor_ingresoCompoKit(Boolean mostrarvalor_ingresoCompoKit) {
		this.mostrarvalor_ingresoCompoKit= mostrarvalor_ingresoCompoKit;
	}

	public Boolean getActivarvalor_ingresoCompoKit() {
		return this.activarvalor_ingresoCompoKit;
	}

	public void setActivarvalor_ingresoCompoKit(Boolean activarvalor_ingresoCompoKit) {
		this.activarvalor_ingresoCompoKit= activarvalor_ingresoCompoKit;
	}

	public Border setResaltardescripcionCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//compokitBeanSwingJInternalFrame.jTtoolBarCompoKit.setBorder(borderResaltar);
		
		this.resaltardescripcionCompoKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCompoKit() {
		return this.resaltardescripcionCompoKit;
	}

	public void setResaltardescripcionCompoKit(Border borderResaltar) {
		this.resaltardescripcionCompoKit= borderResaltar;
	}

	public Boolean getMostrardescripcionCompoKit() {
		return this.mostrardescripcionCompoKit;
	}

	public void setMostrardescripcionCompoKit(Boolean mostrardescripcionCompoKit) {
		this.mostrardescripcionCompoKit= mostrardescripcionCompoKit;
	}

	public Boolean getActivardescripcionCompoKit() {
		return this.activardescripcionCompoKit;
	}

	public void setActivardescripcionCompoKit(Boolean activardescripcionCompoKit) {
		this.activardescripcionCompoKit= activardescripcionCompoKit;
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
		
		
		this.setMostraridCompoKit(esInicial);
		this.setMostrarid_empresaCompoKit(esInicial);
		this.setMostrarid_sucursalCompoKit(esInicial);
		this.setMostrarid_bodegaCompoKit(esInicial);
		this.setMostrarid_productoCompoKit(esInicial);
		this.setMostrarid_kitCompoKit(esInicial);
		this.setMostrarid_unidadCompoKit(esInicial);
		this.setMostrarcantidadCompoKit(esInicial);
		this.setMostrarvalor_ingresoCompoKit(esInicial);
		this.setMostrardescripcionCompoKit(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CompoKitConstantesFunciones.ID)) {
				this.setMostraridCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDKIT)) {
				this.setMostrarid_kitCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.VALORINGRESO)) {
				this.setMostrarvalor_ingresoCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCompoKit(esAsigna);
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
		
		
		this.setActivaridCompoKit(esInicial);
		this.setActivarid_empresaCompoKit(esInicial);
		this.setActivarid_sucursalCompoKit(esInicial);
		this.setActivarid_bodegaCompoKit(esInicial);
		this.setActivarid_productoCompoKit(esInicial);
		this.setActivarid_kitCompoKit(esInicial);
		this.setActivarid_unidadCompoKit(esInicial);
		this.setActivarcantidadCompoKit(esInicial);
		this.setActivarvalor_ingresoCompoKit(esInicial);
		this.setActivardescripcionCompoKit(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CompoKitConstantesFunciones.ID)) {
				this.setActivaridCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDKIT)) {
				this.setActivarid_kitCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.VALORINGRESO)) {
				this.setActivarvalor_ingresoCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCompoKit(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCompoKit(esInicial);
		this.setResaltarid_empresaCompoKit(esInicial);
		this.setResaltarid_sucursalCompoKit(esInicial);
		this.setResaltarid_bodegaCompoKit(esInicial);
		this.setResaltarid_productoCompoKit(esInicial);
		this.setResaltarid_kitCompoKit(esInicial);
		this.setResaltarid_unidadCompoKit(esInicial);
		this.setResaltarcantidadCompoKit(esInicial);
		this.setResaltarvalor_ingresoCompoKit(esInicial);
		this.setResaltardescripcionCompoKit(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CompoKitConstantesFunciones.ID)) {
				this.setResaltaridCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDKIT)) {
				this.setResaltarid_kitCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.VALORINGRESO)) {
				this.setResaltarvalor_ingresoCompoKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(CompoKitConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCompoKit(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaCompoKit=true;

	public Boolean getMostrarFK_IdBodegaCompoKit() {
		return this.mostrarFK_IdBodegaCompoKit;
	}

	public void setMostrarFK_IdBodegaCompoKit(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaCompoKit= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCompoKit=true;

	public Boolean getMostrarFK_IdEmpresaCompoKit() {
		return this.mostrarFK_IdEmpresaCompoKit;
	}

	public void setMostrarFK_IdEmpresaCompoKit(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCompoKit= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdKitCompoKit=true;

	public Boolean getMostrarFK_IdKitCompoKit() {
		return this.mostrarFK_IdKitCompoKit;
	}

	public void setMostrarFK_IdKitCompoKit(Boolean visibilidadResaltar) {
		this.mostrarFK_IdKitCompoKit= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoCompoKit=true;

	public Boolean getMostrarFK_IdProductoCompoKit() {
		return this.mostrarFK_IdProductoCompoKit;
	}

	public void setMostrarFK_IdProductoCompoKit(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoCompoKit= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCompoKit=true;

	public Boolean getMostrarFK_IdSucursalCompoKit() {
		return this.mostrarFK_IdSucursalCompoKit;
	}

	public void setMostrarFK_IdSucursalCompoKit(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCompoKit= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadCompoKit=true;

	public Boolean getMostrarFK_IdUnidadCompoKit() {
		return this.mostrarFK_IdUnidadCompoKit;
	}

	public void setMostrarFK_IdUnidadCompoKit(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadCompoKit= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaCompoKit=true;

	public Boolean getActivarFK_IdBodegaCompoKit() {
		return this.activarFK_IdBodegaCompoKit;
	}

	public void setActivarFK_IdBodegaCompoKit(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaCompoKit= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCompoKit=true;

	public Boolean getActivarFK_IdEmpresaCompoKit() {
		return this.activarFK_IdEmpresaCompoKit;
	}

	public void setActivarFK_IdEmpresaCompoKit(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCompoKit= habilitarResaltar;
	}

	public Boolean activarFK_IdKitCompoKit=true;

	public Boolean getActivarFK_IdKitCompoKit() {
		return this.activarFK_IdKitCompoKit;
	}

	public void setActivarFK_IdKitCompoKit(Boolean habilitarResaltar) {
		this.activarFK_IdKitCompoKit= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoCompoKit=true;

	public Boolean getActivarFK_IdProductoCompoKit() {
		return this.activarFK_IdProductoCompoKit;
	}

	public void setActivarFK_IdProductoCompoKit(Boolean habilitarResaltar) {
		this.activarFK_IdProductoCompoKit= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCompoKit=true;

	public Boolean getActivarFK_IdSucursalCompoKit() {
		return this.activarFK_IdSucursalCompoKit;
	}

	public void setActivarFK_IdSucursalCompoKit(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCompoKit= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadCompoKit=true;

	public Boolean getActivarFK_IdUnidadCompoKit() {
		return this.activarFK_IdUnidadCompoKit;
	}

	public void setActivarFK_IdUnidadCompoKit(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadCompoKit= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaCompoKit=null;

	public Border getResaltarFK_IdBodegaCompoKit() {
		return this.resaltarFK_IdBodegaCompoKit;
	}

	public void setResaltarFK_IdBodegaCompoKit(Border borderResaltar) {
		this.resaltarFK_IdBodegaCompoKit= borderResaltar;
	}

	public void setResaltarFK_IdBodegaCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaCompoKit= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCompoKit=null;

	public Border getResaltarFK_IdEmpresaCompoKit() {
		return this.resaltarFK_IdEmpresaCompoKit;
	}

	public void setResaltarFK_IdEmpresaCompoKit(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCompoKit= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCompoKit= borderResaltar;
	}

	public Border resaltarFK_IdKitCompoKit=null;

	public Border getResaltarFK_IdKitCompoKit() {
		return this.resaltarFK_IdKitCompoKit;
	}

	public void setResaltarFK_IdKitCompoKit(Border borderResaltar) {
		this.resaltarFK_IdKitCompoKit= borderResaltar;
	}

	public void setResaltarFK_IdKitCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdKitCompoKit= borderResaltar;
	}

	public Border resaltarFK_IdProductoCompoKit=null;

	public Border getResaltarFK_IdProductoCompoKit() {
		return this.resaltarFK_IdProductoCompoKit;
	}

	public void setResaltarFK_IdProductoCompoKit(Border borderResaltar) {
		this.resaltarFK_IdProductoCompoKit= borderResaltar;
	}

	public void setResaltarFK_IdProductoCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoCompoKit= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCompoKit=null;

	public Border getResaltarFK_IdSucursalCompoKit() {
		return this.resaltarFK_IdSucursalCompoKit;
	}

	public void setResaltarFK_IdSucursalCompoKit(Border borderResaltar) {
		this.resaltarFK_IdSucursalCompoKit= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCompoKit= borderResaltar;
	}

	public Border resaltarFK_IdUnidadCompoKit=null;

	public Border getResaltarFK_IdUnidadCompoKit() {
		return this.resaltarFK_IdUnidadCompoKit;
	}

	public void setResaltarFK_IdUnidadCompoKit(Border borderResaltar) {
		this.resaltarFK_IdUnidadCompoKit= borderResaltar;
	}

	public void setResaltarFK_IdUnidadCompoKit(ParametroGeneralUsuario parametroGeneralUsuario/*CompoKitBeanSwingJInternalFrame compokitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadCompoKit= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}