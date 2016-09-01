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


import com.bydan.erp.facturacion.util.CentroCostoGrupoProductoConstantesFunciones;
import com.bydan.erp.facturacion.util.CentroCostoGrupoProductoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.CentroCostoGrupoProductoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CentroCostoGrupoProductoConstantesFunciones extends CentroCostoGrupoProductoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CentroCostoGrupoProducto";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CentroCostoGrupoProducto"+CentroCostoGrupoProductoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CentroCostoGrupoProductoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CentroCostoGrupoProductoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"_"+CentroCostoGrupoProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CentroCostoGrupoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"_"+CentroCostoGrupoProductoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"_"+CentroCostoGrupoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CentroCostoGrupoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"_"+CentroCostoGrupoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoGrupoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CentroCostoGrupoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoGrupoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoGrupoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CentroCostoGrupoProductoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CentroCostoGrupoProductoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CentroCostoGrupoProductoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CentroCostoGrupoProductoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CentroCostoGrupoProductoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CentroCostoGrupoProductoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Centro Costo Grupo Productos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Centro Costo Grupo Producto";
	public static final String SCLASSWEBTITULO_LOWER="Centro Costo Grupo Producto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CentroCostoGrupoProducto";
	public static final String OBJECTNAME="centrocostogrupoproducto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="centro_costo_grupo_producto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select centrocostogrupoproducto from "+CentroCostoGrupoProductoConstantesFunciones.SPERSISTENCENAME+" centrocostogrupoproducto";
	public static String QUERYSELECTNATIVE="select "+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".version_row,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id_empresa,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id_sucursal,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id_centro_costo,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id_linea,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".id_linea_grupo,"+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME+".descripcion from "+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+"."+CentroCostoGrupoProductoConstantesFunciones.TABLENAME;//+" as "+CentroCostoGrupoProductoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CentroCostoGrupoProductoConstantesFuncionesAdditional centrocostogrupoproductoConstantesFuncionesAdditional=null;
	
	public CentroCostoGrupoProductoConstantesFuncionesAdditional getCentroCostoGrupoProductoConstantesFuncionesAdditional() {
		return this.centrocostogrupoproductoConstantesFuncionesAdditional;
	}
	
	public void setCentroCostoGrupoProductoConstantesFuncionesAdditional(CentroCostoGrupoProductoConstantesFuncionesAdditional centrocostogrupoproductoConstantesFuncionesAdditional) {
		try {
			this.centrocostogrupoproductoConstantesFuncionesAdditional=centrocostogrupoproductoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
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
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCentroCostoGrupoProductoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CentroCostoGrupoProductoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CentroCostoGrupoProductoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=CentroCostoGrupoProductoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(CentroCostoGrupoProductoConstantesFunciones.IDLINEA)) {sLabelColumna=CentroCostoGrupoProductoConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(CentroCostoGrupoProductoConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=CentroCostoGrupoProductoConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(CentroCostoGrupoProductoConstantesFunciones.DESCRIPCION)) {sLabelColumna=CentroCostoGrupoProductoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getCentroCostoGrupoProductoDescripcion(CentroCostoGrupoProducto centrocostogrupoproducto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(centrocostogrupoproducto !=null/* && centrocostogrupoproducto.getId()!=0*/) {
			if(centrocostogrupoproducto.getId()!=null) {
				sDescripcion=centrocostogrupoproducto.getId().toString();
			}//centrocostogrupoproductocentrocostogrupoproducto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCentroCostoGrupoProductoDescripcionDetallado(CentroCostoGrupoProducto centrocostogrupoproducto) {
		String sDescripcion="";
			
		sDescripcion+=CentroCostoGrupoProductoConstantesFunciones.ID+"=";
		sDescripcion+=centrocostogrupoproducto.getId().toString()+",";
		sDescripcion+=CentroCostoGrupoProductoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=centrocostogrupoproducto.getVersionRow().toString()+",";
		sDescripcion+=CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=centrocostogrupoproducto.getid_empresa().toString()+",";
		sDescripcion+=CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=centrocostogrupoproducto.getid_sucursal().toString()+",";
		sDescripcion+=CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=centrocostogrupoproducto.getid_centro_costo().toString()+",";
		sDescripcion+=CentroCostoGrupoProductoConstantesFunciones.IDLINEA+"=";
		sDescripcion+=centrocostogrupoproducto.getid_linea().toString()+",";
		sDescripcion+=CentroCostoGrupoProductoConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=centrocostogrupoproducto.getid_linea_grupo().toString()+",";
		sDescripcion+=CentroCostoGrupoProductoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=centrocostogrupoproducto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setCentroCostoGrupoProductoDescripcion(CentroCostoGrupoProducto centrocostogrupoproducto,String sValor) throws Exception {			
		if(centrocostogrupoproducto !=null) {
			//centrocostogrupoproductocentrocostogrupoproducto.getId().toString();
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

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdCentroCostoPorIdLinea")) {
			sNombreIndice="Tipo=  Por Centro Costo Por Linea";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorIdCentroCostoPorIdLinea(Long id_centro_costo,Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCentroCostoGrupoProducto(CentroCostoGrupoProducto centrocostogrupoproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		centrocostogrupoproducto.setdescripcion(centrocostogrupoproducto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCentroCostoGrupoProductos(List<CentroCostoGrupoProducto> centrocostogrupoproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CentroCostoGrupoProducto centrocostogrupoproducto: centrocostogrupoproductos) {
			centrocostogrupoproducto.setdescripcion(centrocostogrupoproducto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCentroCostoGrupoProducto(CentroCostoGrupoProducto centrocostogrupoproducto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && centrocostogrupoproducto.getConCambioAuxiliar()) {
			centrocostogrupoproducto.setIsDeleted(centrocostogrupoproducto.getIsDeletedAuxiliar());	
			centrocostogrupoproducto.setIsNew(centrocostogrupoproducto.getIsNewAuxiliar());	
			centrocostogrupoproducto.setIsChanged(centrocostogrupoproducto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			centrocostogrupoproducto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			centrocostogrupoproducto.setIsDeletedAuxiliar(false);	
			centrocostogrupoproducto.setIsNewAuxiliar(false);	
			centrocostogrupoproducto.setIsChangedAuxiliar(false);
			
			centrocostogrupoproducto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCentroCostoGrupoProductos(List<CentroCostoGrupoProducto> centrocostogrupoproductos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CentroCostoGrupoProducto centrocostogrupoproducto : centrocostogrupoproductos) {
			if(conAsignarBase && centrocostogrupoproducto.getConCambioAuxiliar()) {
				centrocostogrupoproducto.setIsDeleted(centrocostogrupoproducto.getIsDeletedAuxiliar());	
				centrocostogrupoproducto.setIsNew(centrocostogrupoproducto.getIsNewAuxiliar());	
				centrocostogrupoproducto.setIsChanged(centrocostogrupoproducto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				centrocostogrupoproducto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				centrocostogrupoproducto.setIsDeletedAuxiliar(false);	
				centrocostogrupoproducto.setIsNewAuxiliar(false);	
				centrocostogrupoproducto.setIsChangedAuxiliar(false);
				
				centrocostogrupoproducto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCentroCostoGrupoProducto(CentroCostoGrupoProducto centrocostogrupoproducto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCentroCostoGrupoProductos(List<CentroCostoGrupoProducto> centrocostogrupoproductos,Boolean conEnteros) throws Exception  {
		
		for(CentroCostoGrupoProducto centrocostogrupoproducto: centrocostogrupoproductos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCentroCostoGrupoProducto(List<CentroCostoGrupoProducto> centrocostogrupoproductos,CentroCostoGrupoProducto centrocostogrupoproductoAux) throws Exception  {
		CentroCostoGrupoProductoConstantesFunciones.InicializarValoresCentroCostoGrupoProducto(centrocostogrupoproductoAux,true);
		
		for(CentroCostoGrupoProducto centrocostogrupoproducto: centrocostogrupoproductos) {
			if(centrocostogrupoproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCentroCostoGrupoProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CentroCostoGrupoProductoConstantesFunciones.getArrayColumnasGlobalesCentroCostoGrupoProducto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCentroCostoGrupoProducto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCentroCostoGrupoProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CentroCostoGrupoProducto> centrocostogrupoproductos,CentroCostoGrupoProducto centrocostogrupoproducto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CentroCostoGrupoProducto centrocostogrupoproductoAux: centrocostogrupoproductos) {
			if(centrocostogrupoproductoAux!=null && centrocostogrupoproducto!=null) {
				if((centrocostogrupoproductoAux.getId()==null && centrocostogrupoproducto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(centrocostogrupoproductoAux.getId()!=null && centrocostogrupoproducto.getId()!=null){
					if(centrocostogrupoproductoAux.getId().equals(centrocostogrupoproducto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCentroCostoGrupoProducto(List<CentroCostoGrupoProducto> centrocostogrupoproductos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CentroCostoGrupoProducto centrocostogrupoproducto: centrocostogrupoproductos) {			
			if(centrocostogrupoproducto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCentroCostoGrupoProducto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CentroCostoGrupoProductoConstantesFunciones.LABEL_ID, CentroCostoGrupoProductoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoGrupoProductoConstantesFunciones.LABEL_VERSIONROW, CentroCostoGrupoProductoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoGrupoProductoConstantesFunciones.LABEL_IDEMPRESA, CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoGrupoProductoConstantesFunciones.LABEL_IDSUCURSAL, CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoGrupoProductoConstantesFunciones.LABEL_IDCENTROCOSTO, CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoGrupoProductoConstantesFunciones.LABEL_IDLINEA, CentroCostoGrupoProductoConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoGrupoProductoConstantesFunciones.LABEL_IDLINEAGRUPO, CentroCostoGrupoProductoConstantesFunciones.IDLINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CentroCostoGrupoProductoConstantesFunciones.LABEL_DESCRIPCION, CentroCostoGrupoProductoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCentroCostoGrupoProducto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CentroCostoGrupoProductoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoGrupoProductoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoGrupoProductoConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoGrupoProductoConstantesFunciones.IDLINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CentroCostoGrupoProductoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroCostoGrupoProducto() throws Exception  {
		return CentroCostoGrupoProductoConstantesFunciones.getTiposSeleccionarCentroCostoGrupoProducto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroCostoGrupoProducto(Boolean conFk) throws Exception  {
		return CentroCostoGrupoProductoConstantesFunciones.getTiposSeleccionarCentroCostoGrupoProducto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCentroCostoGrupoProducto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CentroCostoGrupoProductoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(CentroCostoGrupoProductoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCentroCostoGrupoProducto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(CentroCostoGrupoProducto centrocostogrupoproductoAux) throws Exception {
		
			centrocostogrupoproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(centrocostogrupoproductoAux.getEmpresa()));
			centrocostogrupoproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(centrocostogrupoproductoAux.getSucursal()));
			centrocostogrupoproductoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocostogrupoproductoAux.getCentroCosto()));
			centrocostogrupoproductoAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(centrocostogrupoproductoAux.getLinea()));
			centrocostogrupoproductoAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(centrocostogrupoproductoAux.getLineaGrupo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCentroCostoGrupoProducto(List<CentroCostoGrupoProducto> centrocostogrupoproductosTemp) throws Exception {
		for(CentroCostoGrupoProducto centrocostogrupoproductoAux:centrocostogrupoproductosTemp) {
			
			centrocostogrupoproductoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(centrocostogrupoproductoAux.getEmpresa()));
			centrocostogrupoproductoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(centrocostogrupoproductoAux.getSucursal()));
			centrocostogrupoproductoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocostogrupoproductoAux.getCentroCosto()));
			centrocostogrupoproductoAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(centrocostogrupoproductoAux.getLinea()));
			centrocostogrupoproductoAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(centrocostogrupoproductoAux.getLineaGrupo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCentroCostoGrupoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
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
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCentroCostoGrupoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroCostoGrupoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CentroCostoGrupoProductoConstantesFunciones.getClassesRelationshipsOfCentroCostoGrupoProducto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCentroCostoGrupoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCentroCostoGrupoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CentroCostoGrupoProductoConstantesFunciones.getClassesRelationshipsFromStringsOfCentroCostoGrupoProducto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCentroCostoGrupoProducto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CentroCostoGrupoProducto centrocostogrupoproducto,List<CentroCostoGrupoProducto> centrocostogrupoproductos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CentroCostoGrupoProducto centrocostogrupoproductoEncontrado=null;
			
			for(CentroCostoGrupoProducto centrocostogrupoproductoLocal:centrocostogrupoproductos) {
				if(centrocostogrupoproductoLocal.getId().equals(centrocostogrupoproducto.getId())) {
					centrocostogrupoproductoEncontrado=centrocostogrupoproductoLocal;
					
					centrocostogrupoproductoLocal.setIsChanged(centrocostogrupoproducto.getIsChanged());
					centrocostogrupoproductoLocal.setIsNew(centrocostogrupoproducto.getIsNew());
					centrocostogrupoproductoLocal.setIsDeleted(centrocostogrupoproducto.getIsDeleted());
					
					centrocostogrupoproductoLocal.setGeneralEntityOriginal(centrocostogrupoproducto.getGeneralEntityOriginal());
					
					centrocostogrupoproductoLocal.setId(centrocostogrupoproducto.getId());	
					centrocostogrupoproductoLocal.setVersionRow(centrocostogrupoproducto.getVersionRow());	
					centrocostogrupoproductoLocal.setid_empresa(centrocostogrupoproducto.getid_empresa());	
					centrocostogrupoproductoLocal.setid_sucursal(centrocostogrupoproducto.getid_sucursal());	
					centrocostogrupoproductoLocal.setid_centro_costo(centrocostogrupoproducto.getid_centro_costo());	
					centrocostogrupoproductoLocal.setid_linea(centrocostogrupoproducto.getid_linea());	
					centrocostogrupoproductoLocal.setid_linea_grupo(centrocostogrupoproducto.getid_linea_grupo());	
					centrocostogrupoproductoLocal.setdescripcion(centrocostogrupoproducto.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!centrocostogrupoproducto.getIsDeleted()) {
				if(!existe) {
					centrocostogrupoproductos.add(centrocostogrupoproducto);
				}
			} else {
				if(centrocostogrupoproductoEncontrado!=null && permiteQuitar)  {
					centrocostogrupoproductos.remove(centrocostogrupoproductoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CentroCostoGrupoProducto centrocostogrupoproducto,List<CentroCostoGrupoProducto> centrocostogrupoproductos) throws Exception {
		try	{			
			for(CentroCostoGrupoProducto centrocostogrupoproductoLocal:centrocostogrupoproductos) {
				if(centrocostogrupoproductoLocal.getId().equals(centrocostogrupoproducto.getId())) {
					centrocostogrupoproductoLocal.setIsSelected(centrocostogrupoproducto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCentroCostoGrupoProducto(List<CentroCostoGrupoProducto> centrocostogrupoproductosAux) throws Exception {
		//this.centrocostogrupoproductosAux=centrocostogrupoproductosAux;
		
		for(CentroCostoGrupoProducto centrocostogrupoproductoAux:centrocostogrupoproductosAux) {
			if(centrocostogrupoproductoAux.getIsChanged()) {
				centrocostogrupoproductoAux.setIsChanged(false);
			}		
			
			if(centrocostogrupoproductoAux.getIsNew()) {
				centrocostogrupoproductoAux.setIsNew(false);
			}	
			
			if(centrocostogrupoproductoAux.getIsDeleted()) {
				centrocostogrupoproductoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCentroCostoGrupoProducto(CentroCostoGrupoProducto centrocostogrupoproductoAux) throws Exception {
		//this.centrocostogrupoproductoAux=centrocostogrupoproductoAux;
		
			if(centrocostogrupoproductoAux.getIsChanged()) {
				centrocostogrupoproductoAux.setIsChanged(false);
			}		
			
			if(centrocostogrupoproductoAux.getIsNew()) {
				centrocostogrupoproductoAux.setIsNew(false);
			}	
			
			if(centrocostogrupoproductoAux.getIsDeleted()) {
				centrocostogrupoproductoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CentroCostoGrupoProducto centrocostogrupoproductoAsignar,CentroCostoGrupoProducto centrocostogrupoproducto) throws Exception {
		centrocostogrupoproductoAsignar.setId(centrocostogrupoproducto.getId());	
		centrocostogrupoproductoAsignar.setVersionRow(centrocostogrupoproducto.getVersionRow());	
		centrocostogrupoproductoAsignar.setid_empresa(centrocostogrupoproducto.getid_empresa());
		centrocostogrupoproductoAsignar.setempresa_descripcion(centrocostogrupoproducto.getempresa_descripcion());	
		centrocostogrupoproductoAsignar.setid_sucursal(centrocostogrupoproducto.getid_sucursal());
		centrocostogrupoproductoAsignar.setsucursal_descripcion(centrocostogrupoproducto.getsucursal_descripcion());	
		centrocostogrupoproductoAsignar.setid_centro_costo(centrocostogrupoproducto.getid_centro_costo());
		centrocostogrupoproductoAsignar.setcentrocosto_descripcion(centrocostogrupoproducto.getcentrocosto_descripcion());	
		centrocostogrupoproductoAsignar.setid_linea(centrocostogrupoproducto.getid_linea());
		centrocostogrupoproductoAsignar.setlinea_descripcion(centrocostogrupoproducto.getlinea_descripcion());	
		centrocostogrupoproductoAsignar.setid_linea_grupo(centrocostogrupoproducto.getid_linea_grupo());
		centrocostogrupoproductoAsignar.setlineagrupo_descripcion(centrocostogrupoproducto.getlineagrupo_descripcion());	
		centrocostogrupoproductoAsignar.setdescripcion(centrocostogrupoproducto.getdescripcion());	
	}
	
	public static void inicializarCentroCostoGrupoProducto(CentroCostoGrupoProducto centrocostogrupoproducto) throws Exception {
		try {
				centrocostogrupoproducto.setId(0L);	
					
				centrocostogrupoproducto.setid_empresa(-1L);	
				centrocostogrupoproducto.setid_sucursal(-1L);	
				centrocostogrupoproducto.setid_centro_costo(null);	
				centrocostogrupoproducto.setid_linea(-1L);	
				centrocostogrupoproducto.setid_linea_grupo(-1L);	
				centrocostogrupoproducto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCentroCostoGrupoProducto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoGrupoProductoConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CentroCostoGrupoProductoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCentroCostoGrupoProducto(String sTipo,Row row,Workbook workbook,CentroCostoGrupoProducto centrocostogrupoproducto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostogrupoproducto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostogrupoproducto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostogrupoproducto.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostogrupoproducto.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostogrupoproducto.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(centrocostogrupoproducto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCentroCostoGrupoProducto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCentroCostoGrupoProducto() {
		return this.sFinalQueryCentroCostoGrupoProducto;
	}
	
	public void setsFinalQueryCentroCostoGrupoProducto(String sFinalQueryCentroCostoGrupoProducto) {
		this.sFinalQueryCentroCostoGrupoProducto= sFinalQueryCentroCostoGrupoProducto;
	}
	
	public Border resaltarSeleccionarCentroCostoGrupoProducto=null;
	
	public Border setResaltarSeleccionarCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//centrocostogrupoproductoBeanSwingJInternalFrame.jTtoolBarCentroCostoGrupoProducto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCentroCostoGrupoProducto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCentroCostoGrupoProducto() {
		return this.resaltarSeleccionarCentroCostoGrupoProducto;
	}
	
	public void setResaltarSeleccionarCentroCostoGrupoProducto(Border borderResaltarSeleccionarCentroCostoGrupoProducto) {
		this.resaltarSeleccionarCentroCostoGrupoProducto= borderResaltarSeleccionarCentroCostoGrupoProducto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCentroCostoGrupoProducto=null;
	public Boolean mostraridCentroCostoGrupoProducto=true;
	public Boolean activaridCentroCostoGrupoProducto=true;

	public Border resaltarid_empresaCentroCostoGrupoProducto=null;
	public Boolean mostrarid_empresaCentroCostoGrupoProducto=true;
	public Boolean activarid_empresaCentroCostoGrupoProducto=true;
	public Boolean cargarid_empresaCentroCostoGrupoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCentroCostoGrupoProducto=false;//ConEventDepend=true

	public Border resaltarid_sucursalCentroCostoGrupoProducto=null;
	public Boolean mostrarid_sucursalCentroCostoGrupoProducto=true;
	public Boolean activarid_sucursalCentroCostoGrupoProducto=true;
	public Boolean cargarid_sucursalCentroCostoGrupoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCentroCostoGrupoProducto=false;//ConEventDepend=true

	public Border resaltarid_centro_costoCentroCostoGrupoProducto=null;
	public Boolean mostrarid_centro_costoCentroCostoGrupoProducto=true;
	public Boolean activarid_centro_costoCentroCostoGrupoProducto=true;
	public Boolean cargarid_centro_costoCentroCostoGrupoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoCentroCostoGrupoProducto=false;//ConEventDepend=true

	public Border resaltarid_lineaCentroCostoGrupoProducto=null;
	public Boolean mostrarid_lineaCentroCostoGrupoProducto=true;
	public Boolean activarid_lineaCentroCostoGrupoProducto=true;
	public Boolean cargarid_lineaCentroCostoGrupoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaCentroCostoGrupoProducto=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoCentroCostoGrupoProducto=null;
	public Boolean mostrarid_linea_grupoCentroCostoGrupoProducto=true;
	public Boolean activarid_linea_grupoCentroCostoGrupoProducto=true;
	public Boolean cargarid_linea_grupoCentroCostoGrupoProducto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoCentroCostoGrupoProducto=false;//ConEventDepend=true

	public Border resaltardescripcionCentroCostoGrupoProducto=null;
	public Boolean mostrardescripcionCentroCostoGrupoProducto=true;
	public Boolean activardescripcionCentroCostoGrupoProducto=true;

	
	

	public Border setResaltaridCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostogrupoproductoBeanSwingJInternalFrame.jTtoolBarCentroCostoGrupoProducto.setBorder(borderResaltar);
		
		this.resaltaridCentroCostoGrupoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCentroCostoGrupoProducto() {
		return this.resaltaridCentroCostoGrupoProducto;
	}

	public void setResaltaridCentroCostoGrupoProducto(Border borderResaltar) {
		this.resaltaridCentroCostoGrupoProducto= borderResaltar;
	}

	public Boolean getMostraridCentroCostoGrupoProducto() {
		return this.mostraridCentroCostoGrupoProducto;
	}

	public void setMostraridCentroCostoGrupoProducto(Boolean mostraridCentroCostoGrupoProducto) {
		this.mostraridCentroCostoGrupoProducto= mostraridCentroCostoGrupoProducto;
	}

	public Boolean getActivaridCentroCostoGrupoProducto() {
		return this.activaridCentroCostoGrupoProducto;
	}

	public void setActivaridCentroCostoGrupoProducto(Boolean activaridCentroCostoGrupoProducto) {
		this.activaridCentroCostoGrupoProducto= activaridCentroCostoGrupoProducto;
	}

	public Border setResaltarid_empresaCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostogrupoproductoBeanSwingJInternalFrame.jTtoolBarCentroCostoGrupoProducto.setBorder(borderResaltar);
		
		this.resaltarid_empresaCentroCostoGrupoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCentroCostoGrupoProducto() {
		return this.resaltarid_empresaCentroCostoGrupoProducto;
	}

	public void setResaltarid_empresaCentroCostoGrupoProducto(Border borderResaltar) {
		this.resaltarid_empresaCentroCostoGrupoProducto= borderResaltar;
	}

	public Boolean getMostrarid_empresaCentroCostoGrupoProducto() {
		return this.mostrarid_empresaCentroCostoGrupoProducto;
	}

	public void setMostrarid_empresaCentroCostoGrupoProducto(Boolean mostrarid_empresaCentroCostoGrupoProducto) {
		this.mostrarid_empresaCentroCostoGrupoProducto= mostrarid_empresaCentroCostoGrupoProducto;
	}

	public Boolean getActivarid_empresaCentroCostoGrupoProducto() {
		return this.activarid_empresaCentroCostoGrupoProducto;
	}

	public void setActivarid_empresaCentroCostoGrupoProducto(Boolean activarid_empresaCentroCostoGrupoProducto) {
		this.activarid_empresaCentroCostoGrupoProducto= activarid_empresaCentroCostoGrupoProducto;
	}

	public Boolean getCargarid_empresaCentroCostoGrupoProducto() {
		return this.cargarid_empresaCentroCostoGrupoProducto;
	}

	public void setCargarid_empresaCentroCostoGrupoProducto(Boolean cargarid_empresaCentroCostoGrupoProducto) {
		this.cargarid_empresaCentroCostoGrupoProducto= cargarid_empresaCentroCostoGrupoProducto;
	}

	public Border setResaltarid_sucursalCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostogrupoproductoBeanSwingJInternalFrame.jTtoolBarCentroCostoGrupoProducto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCentroCostoGrupoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCentroCostoGrupoProducto() {
		return this.resaltarid_sucursalCentroCostoGrupoProducto;
	}

	public void setResaltarid_sucursalCentroCostoGrupoProducto(Border borderResaltar) {
		this.resaltarid_sucursalCentroCostoGrupoProducto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCentroCostoGrupoProducto() {
		return this.mostrarid_sucursalCentroCostoGrupoProducto;
	}

	public void setMostrarid_sucursalCentroCostoGrupoProducto(Boolean mostrarid_sucursalCentroCostoGrupoProducto) {
		this.mostrarid_sucursalCentroCostoGrupoProducto= mostrarid_sucursalCentroCostoGrupoProducto;
	}

	public Boolean getActivarid_sucursalCentroCostoGrupoProducto() {
		return this.activarid_sucursalCentroCostoGrupoProducto;
	}

	public void setActivarid_sucursalCentroCostoGrupoProducto(Boolean activarid_sucursalCentroCostoGrupoProducto) {
		this.activarid_sucursalCentroCostoGrupoProducto= activarid_sucursalCentroCostoGrupoProducto;
	}

	public Boolean getCargarid_sucursalCentroCostoGrupoProducto() {
		return this.cargarid_sucursalCentroCostoGrupoProducto;
	}

	public void setCargarid_sucursalCentroCostoGrupoProducto(Boolean cargarid_sucursalCentroCostoGrupoProducto) {
		this.cargarid_sucursalCentroCostoGrupoProducto= cargarid_sucursalCentroCostoGrupoProducto;
	}

	public Border setResaltarid_centro_costoCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostogrupoproductoBeanSwingJInternalFrame.jTtoolBarCentroCostoGrupoProducto.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoCentroCostoGrupoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoCentroCostoGrupoProducto() {
		return this.resaltarid_centro_costoCentroCostoGrupoProducto;
	}

	public void setResaltarid_centro_costoCentroCostoGrupoProducto(Border borderResaltar) {
		this.resaltarid_centro_costoCentroCostoGrupoProducto= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoCentroCostoGrupoProducto() {
		return this.mostrarid_centro_costoCentroCostoGrupoProducto;
	}

	public void setMostrarid_centro_costoCentroCostoGrupoProducto(Boolean mostrarid_centro_costoCentroCostoGrupoProducto) {
		this.mostrarid_centro_costoCentroCostoGrupoProducto= mostrarid_centro_costoCentroCostoGrupoProducto;
	}

	public Boolean getActivarid_centro_costoCentroCostoGrupoProducto() {
		return this.activarid_centro_costoCentroCostoGrupoProducto;
	}

	public void setActivarid_centro_costoCentroCostoGrupoProducto(Boolean activarid_centro_costoCentroCostoGrupoProducto) {
		this.activarid_centro_costoCentroCostoGrupoProducto= activarid_centro_costoCentroCostoGrupoProducto;
	}

	public Boolean getCargarid_centro_costoCentroCostoGrupoProducto() {
		return this.cargarid_centro_costoCentroCostoGrupoProducto;
	}

	public void setCargarid_centro_costoCentroCostoGrupoProducto(Boolean cargarid_centro_costoCentroCostoGrupoProducto) {
		this.cargarid_centro_costoCentroCostoGrupoProducto= cargarid_centro_costoCentroCostoGrupoProducto;
	}

	public Border setResaltarid_lineaCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostogrupoproductoBeanSwingJInternalFrame.jTtoolBarCentroCostoGrupoProducto.setBorder(borderResaltar);
		
		this.resaltarid_lineaCentroCostoGrupoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaCentroCostoGrupoProducto() {
		return this.resaltarid_lineaCentroCostoGrupoProducto;
	}

	public void setResaltarid_lineaCentroCostoGrupoProducto(Border borderResaltar) {
		this.resaltarid_lineaCentroCostoGrupoProducto= borderResaltar;
	}

	public Boolean getMostrarid_lineaCentroCostoGrupoProducto() {
		return this.mostrarid_lineaCentroCostoGrupoProducto;
	}

	public void setMostrarid_lineaCentroCostoGrupoProducto(Boolean mostrarid_lineaCentroCostoGrupoProducto) {
		this.mostrarid_lineaCentroCostoGrupoProducto= mostrarid_lineaCentroCostoGrupoProducto;
	}

	public Boolean getActivarid_lineaCentroCostoGrupoProducto() {
		return this.activarid_lineaCentroCostoGrupoProducto;
	}

	public void setActivarid_lineaCentroCostoGrupoProducto(Boolean activarid_lineaCentroCostoGrupoProducto) {
		this.activarid_lineaCentroCostoGrupoProducto= activarid_lineaCentroCostoGrupoProducto;
	}

	public Boolean getCargarid_lineaCentroCostoGrupoProducto() {
		return this.cargarid_lineaCentroCostoGrupoProducto;
	}

	public void setCargarid_lineaCentroCostoGrupoProducto(Boolean cargarid_lineaCentroCostoGrupoProducto) {
		this.cargarid_lineaCentroCostoGrupoProducto= cargarid_lineaCentroCostoGrupoProducto;
	}

	public Border setResaltarid_linea_grupoCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostogrupoproductoBeanSwingJInternalFrame.jTtoolBarCentroCostoGrupoProducto.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoCentroCostoGrupoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoCentroCostoGrupoProducto() {
		return this.resaltarid_linea_grupoCentroCostoGrupoProducto;
	}

	public void setResaltarid_linea_grupoCentroCostoGrupoProducto(Border borderResaltar) {
		this.resaltarid_linea_grupoCentroCostoGrupoProducto= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoCentroCostoGrupoProducto() {
		return this.mostrarid_linea_grupoCentroCostoGrupoProducto;
	}

	public void setMostrarid_linea_grupoCentroCostoGrupoProducto(Boolean mostrarid_linea_grupoCentroCostoGrupoProducto) {
		this.mostrarid_linea_grupoCentroCostoGrupoProducto= mostrarid_linea_grupoCentroCostoGrupoProducto;
	}

	public Boolean getActivarid_linea_grupoCentroCostoGrupoProducto() {
		return this.activarid_linea_grupoCentroCostoGrupoProducto;
	}

	public void setActivarid_linea_grupoCentroCostoGrupoProducto(Boolean activarid_linea_grupoCentroCostoGrupoProducto) {
		this.activarid_linea_grupoCentroCostoGrupoProducto= activarid_linea_grupoCentroCostoGrupoProducto;
	}

	public Boolean getCargarid_linea_grupoCentroCostoGrupoProducto() {
		return this.cargarid_linea_grupoCentroCostoGrupoProducto;
	}

	public void setCargarid_linea_grupoCentroCostoGrupoProducto(Boolean cargarid_linea_grupoCentroCostoGrupoProducto) {
		this.cargarid_linea_grupoCentroCostoGrupoProducto= cargarid_linea_grupoCentroCostoGrupoProducto;
	}

	public Border setResaltardescripcionCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//centrocostogrupoproductoBeanSwingJInternalFrame.jTtoolBarCentroCostoGrupoProducto.setBorder(borderResaltar);
		
		this.resaltardescripcionCentroCostoGrupoProducto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionCentroCostoGrupoProducto() {
		return this.resaltardescripcionCentroCostoGrupoProducto;
	}

	public void setResaltardescripcionCentroCostoGrupoProducto(Border borderResaltar) {
		this.resaltardescripcionCentroCostoGrupoProducto= borderResaltar;
	}

	public Boolean getMostrardescripcionCentroCostoGrupoProducto() {
		return this.mostrardescripcionCentroCostoGrupoProducto;
	}

	public void setMostrardescripcionCentroCostoGrupoProducto(Boolean mostrardescripcionCentroCostoGrupoProducto) {
		this.mostrardescripcionCentroCostoGrupoProducto= mostrardescripcionCentroCostoGrupoProducto;
	}

	public Boolean getActivardescripcionCentroCostoGrupoProducto() {
		return this.activardescripcionCentroCostoGrupoProducto;
	}

	public void setActivardescripcionCentroCostoGrupoProducto(Boolean activardescripcionCentroCostoGrupoProducto) {
		this.activardescripcionCentroCostoGrupoProducto= activardescripcionCentroCostoGrupoProducto;
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
		
		
		this.setMostraridCentroCostoGrupoProducto(esInicial);
		this.setMostrarid_empresaCentroCostoGrupoProducto(esInicial);
		this.setMostrarid_sucursalCentroCostoGrupoProducto(esInicial);
		this.setMostrarid_centro_costoCentroCostoGrupoProducto(esInicial);
		this.setMostrarid_lineaCentroCostoGrupoProducto(esInicial);
		this.setMostrarid_linea_grupoCentroCostoGrupoProducto(esInicial);
		this.setMostrardescripcionCentroCostoGrupoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.ID)) {
				this.setMostraridCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionCentroCostoGrupoProducto(esAsigna);
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
		
		
		this.setActivaridCentroCostoGrupoProducto(esInicial);
		this.setActivarid_empresaCentroCostoGrupoProducto(esInicial);
		this.setActivarid_sucursalCentroCostoGrupoProducto(esInicial);
		this.setActivarid_centro_costoCentroCostoGrupoProducto(esInicial);
		this.setActivarid_lineaCentroCostoGrupoProducto(esInicial);
		this.setActivarid_linea_grupoCentroCostoGrupoProducto(esInicial);
		this.setActivardescripcionCentroCostoGrupoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.ID)) {
				this.setActivaridCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionCentroCostoGrupoProducto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCentroCostoGrupoProducto(esInicial);
		this.setResaltarid_empresaCentroCostoGrupoProducto(esInicial);
		this.setResaltarid_sucursalCentroCostoGrupoProducto(esInicial);
		this.setResaltarid_centro_costoCentroCostoGrupoProducto(esInicial);
		this.setResaltarid_lineaCentroCostoGrupoProducto(esInicial);
		this.setResaltarid_linea_grupoCentroCostoGrupoProducto(esInicial);
		this.setResaltardescripcionCentroCostoGrupoProducto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.ID)) {
				this.setResaltaridCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoCentroCostoGrupoProducto(esAsigna);
				continue;
			}

			if(campo.clase.equals(CentroCostoGrupoProductoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionCentroCostoGrupoProducto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto=true;

	public Boolean getMostrarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto() {
		return this.mostrarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto;
	}

	public void setMostrarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoCentroCostoGrupoProducto=true;

	public Boolean getMostrarFK_IdCentroCostoCentroCostoGrupoProducto() {
		return this.mostrarFK_IdCentroCostoCentroCostoGrupoProducto;
	}

	public void setMostrarFK_IdCentroCostoCentroCostoGrupoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoCentroCostoGrupoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCentroCostoGrupoProducto=true;

	public Boolean getMostrarFK_IdEmpresaCentroCostoGrupoProducto() {
		return this.mostrarFK_IdEmpresaCentroCostoGrupoProducto;
	}

	public void setMostrarFK_IdEmpresaCentroCostoGrupoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCentroCostoGrupoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaCentroCostoGrupoProducto=true;

	public Boolean getMostrarFK_IdLineaCentroCostoGrupoProducto() {
		return this.mostrarFK_IdLineaCentroCostoGrupoProducto;
	}

	public void setMostrarFK_IdLineaCentroCostoGrupoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaCentroCostoGrupoProducto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCentroCostoGrupoProducto=true;

	public Boolean getMostrarFK_IdSucursalCentroCostoGrupoProducto() {
		return this.mostrarFK_IdSucursalCentroCostoGrupoProducto;
	}

	public void setMostrarFK_IdSucursalCentroCostoGrupoProducto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCentroCostoGrupoProducto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto=true;

	public Boolean getActivarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto() {
		return this.activarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto;
	}

	public void setActivarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoCentroCostoGrupoProducto=true;

	public Boolean getActivarFK_IdCentroCostoCentroCostoGrupoProducto() {
		return this.activarFK_IdCentroCostoCentroCostoGrupoProducto;
	}

	public void setActivarFK_IdCentroCostoCentroCostoGrupoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoCentroCostoGrupoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCentroCostoGrupoProducto=true;

	public Boolean getActivarFK_IdEmpresaCentroCostoGrupoProducto() {
		return this.activarFK_IdEmpresaCentroCostoGrupoProducto;
	}

	public void setActivarFK_IdEmpresaCentroCostoGrupoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCentroCostoGrupoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaCentroCostoGrupoProducto=true;

	public Boolean getActivarFK_IdLineaCentroCostoGrupoProducto() {
		return this.activarFK_IdLineaCentroCostoGrupoProducto;
	}

	public void setActivarFK_IdLineaCentroCostoGrupoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdLineaCentroCostoGrupoProducto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCentroCostoGrupoProducto=true;

	public Boolean getActivarFK_IdSucursalCentroCostoGrupoProducto() {
		return this.activarFK_IdSucursalCentroCostoGrupoProducto;
	}

	public void setActivarFK_IdSucursalCentroCostoGrupoProducto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCentroCostoGrupoProducto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto=null;

	public Border getResaltarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto() {
		return this.resaltarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto;
	}

	public void setResaltarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto(Border borderResaltar) {
		this.resaltarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto= borderResaltar;
	}

	public void setResaltarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdCentroCostoPorIdLineaCentroCostoGrupoProducto= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoCentroCostoGrupoProducto=null;

	public Border getResaltarFK_IdCentroCostoCentroCostoGrupoProducto() {
		return this.resaltarFK_IdCentroCostoCentroCostoGrupoProducto;
	}

	public void setResaltarFK_IdCentroCostoCentroCostoGrupoProducto(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoCentroCostoGrupoProducto= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoCentroCostoGrupoProducto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCentroCostoGrupoProducto=null;

	public Border getResaltarFK_IdEmpresaCentroCostoGrupoProducto() {
		return this.resaltarFK_IdEmpresaCentroCostoGrupoProducto;
	}

	public void setResaltarFK_IdEmpresaCentroCostoGrupoProducto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCentroCostoGrupoProducto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCentroCostoGrupoProducto= borderResaltar;
	}

	public Border resaltarFK_IdLineaCentroCostoGrupoProducto=null;

	public Border getResaltarFK_IdLineaCentroCostoGrupoProducto() {
		return this.resaltarFK_IdLineaCentroCostoGrupoProducto;
	}

	public void setResaltarFK_IdLineaCentroCostoGrupoProducto(Border borderResaltar) {
		this.resaltarFK_IdLineaCentroCostoGrupoProducto= borderResaltar;
	}

	public void setResaltarFK_IdLineaCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaCentroCostoGrupoProducto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCentroCostoGrupoProducto=null;

	public Border getResaltarFK_IdSucursalCentroCostoGrupoProducto() {
		return this.resaltarFK_IdSucursalCentroCostoGrupoProducto;
	}

	public void setResaltarFK_IdSucursalCentroCostoGrupoProducto(Border borderResaltar) {
		this.resaltarFK_IdSucursalCentroCostoGrupoProducto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCentroCostoGrupoProducto(ParametroGeneralUsuario parametroGeneralUsuario/*CentroCostoGrupoProductoBeanSwingJInternalFrame centrocostogrupoproductoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCentroCostoGrupoProducto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}