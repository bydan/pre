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


import com.bydan.erp.facturacion.util.ParametroFacturacionDefectoConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroFacturacionDefectoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroFacturacionDefectoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroFacturacionDefectoConstantesFunciones extends ParametroFacturacionDefectoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroFacturacionDefecto";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroFacturacionDefecto"+ParametroFacturacionDefectoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroFacturacionDefectoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroFacturacionDefectoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"_"+ParametroFacturacionDefectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFacturacionDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"_"+ParametroFacturacionDefectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"_"+ParametroFacturacionDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFacturacionDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"_"+ParametroFacturacionDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFacturacionDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFacturacionDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFacturacionDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFacturacionDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFacturacionDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFacturacionDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroFacturacionDefectoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroFacturacionDefectoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroFacturacionDefectoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroFacturacionDefectoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Facturacion Defectos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Facturacion Defecto";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Facturacion Defecto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroFacturacionDefecto";
	public static final String OBJECTNAME="parametrofacturaciondefecto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="parametro_facturacion_defecto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrofacturaciondefecto from "+ParametroFacturacionDefectoConstantesFunciones.SPERSISTENCENAME+" parametrofacturaciondefecto";
	public static String QUERYSELECTNATIVE="select "+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+".id,"+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+".version_row,"+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+".id_tipo_via_transporte from "+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroFacturacionDefectoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroFacturacionDefectoConstantesFuncionesAdditional parametrofacturaciondefectoConstantesFuncionesAdditional=null;
	
	public ParametroFacturacionDefectoConstantesFuncionesAdditional getParametroFacturacionDefectoConstantesFuncionesAdditional() {
		return this.parametrofacturaciondefectoConstantesFuncionesAdditional;
	}
	
	public void setParametroFacturacionDefectoConstantesFuncionesAdditional(ParametroFacturacionDefectoConstantesFuncionesAdditional parametrofacturaciondefectoConstantesFuncionesAdditional) {
		try {
			this.parametrofacturaciondefectoConstantesFuncionesAdditional=parametrofacturaciondefectoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTIPOVIATRANSPORTE= "id_tipo_via_transporte";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTIPOVIATRANSPORTE= "T. Via Transporte";
		public static final String LABEL_IDTIPOVIATRANSPORTE_LOWER= "Tipo Via Transporte";
	
		
		
		
		
		
	
	public static String getParametroFacturacionDefectoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroFacturacionDefectoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroFacturacionDefectoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroFacturacionDefectoConstantesFunciones.IDTIPOVIATRANSPORTE)) {sLabelColumna=ParametroFacturacionDefectoConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getParametroFacturacionDefectoDescripcion(ParametroFacturacionDefecto parametrofacturaciondefecto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrofacturaciondefecto !=null/* && parametrofacturaciondefecto.getId()!=0*/) {
			if(parametrofacturaciondefecto.getId()!=null) {
				sDescripcion=parametrofacturaciondefecto.getId().toString();
			}//parametrofacturaciondefectoparametrofacturaciondefecto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroFacturacionDefectoDescripcionDetallado(ParametroFacturacionDefecto parametrofacturaciondefecto) {
		String sDescripcion="";
			
		sDescripcion+=ParametroFacturacionDefectoConstantesFunciones.ID+"=";
		sDescripcion+=parametrofacturaciondefecto.getId().toString()+",";
		sDescripcion+=ParametroFacturacionDefectoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrofacturaciondefecto.getVersionRow().toString()+",";
		sDescripcion+=ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrofacturaciondefecto.getid_empresa().toString()+",";
		sDescripcion+=ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametrofacturaciondefecto.getid_sucursal().toString()+",";
		sDescripcion+=ParametroFacturacionDefectoConstantesFunciones.IDTIPOVIATRANSPORTE+"=";
		sDescripcion+=parametrofacturaciondefecto.getid_tipo_via_transporte().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroFacturacionDefectoDescripcion(ParametroFacturacionDefecto parametrofacturaciondefecto,String sValor) throws Exception {			
		if(parametrofacturaciondefecto !=null) {
			//parametrofacturaciondefectoparametrofacturaciondefecto.getId().toString();
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

	public static String getTipoViaTransporteDescripcion(TipoViaTransporte tipoviatransporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoviatransporte!=null/*&&tipoviatransporte.getId()>0*/) {
			sDescripcion=TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(tipoviatransporte);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoViaTransporte")) {
			sNombreIndice="Tipo=  Por T. Via Transporte";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoViaTransporte(Long id_tipo_via_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_via_transporte!=null) {sDetalleIndice+=" Codigo Unico De T. Via Transporte="+id_tipo_via_transporte.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroFacturacionDefecto(ParametroFacturacionDefecto parametrofacturaciondefecto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroFacturacionDefectos(List<ParametroFacturacionDefecto> parametrofacturaciondefectos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroFacturacionDefecto parametrofacturaciondefecto: parametrofacturaciondefectos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFacturacionDefecto(ParametroFacturacionDefecto parametrofacturaciondefecto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrofacturaciondefecto.getConCambioAuxiliar()) {
			parametrofacturaciondefecto.setIsDeleted(parametrofacturaciondefecto.getIsDeletedAuxiliar());	
			parametrofacturaciondefecto.setIsNew(parametrofacturaciondefecto.getIsNewAuxiliar());	
			parametrofacturaciondefecto.setIsChanged(parametrofacturaciondefecto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrofacturaciondefecto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrofacturaciondefecto.setIsDeletedAuxiliar(false);	
			parametrofacturaciondefecto.setIsNewAuxiliar(false);	
			parametrofacturaciondefecto.setIsChangedAuxiliar(false);
			
			parametrofacturaciondefecto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFacturacionDefectos(List<ParametroFacturacionDefecto> parametrofacturaciondefectos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroFacturacionDefecto parametrofacturaciondefecto : parametrofacturaciondefectos) {
			if(conAsignarBase && parametrofacturaciondefecto.getConCambioAuxiliar()) {
				parametrofacturaciondefecto.setIsDeleted(parametrofacturaciondefecto.getIsDeletedAuxiliar());	
				parametrofacturaciondefecto.setIsNew(parametrofacturaciondefecto.getIsNewAuxiliar());	
				parametrofacturaciondefecto.setIsChanged(parametrofacturaciondefecto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrofacturaciondefecto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrofacturaciondefecto.setIsDeletedAuxiliar(false);	
				parametrofacturaciondefecto.setIsNewAuxiliar(false);	
				parametrofacturaciondefecto.setIsChangedAuxiliar(false);
				
				parametrofacturaciondefecto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroFacturacionDefecto(ParametroFacturacionDefecto parametrofacturaciondefecto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroFacturacionDefectos(List<ParametroFacturacionDefecto> parametrofacturaciondefectos,Boolean conEnteros) throws Exception  {
		
		for(ParametroFacturacionDefecto parametrofacturaciondefecto: parametrofacturaciondefectos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroFacturacionDefecto(List<ParametroFacturacionDefecto> parametrofacturaciondefectos,ParametroFacturacionDefecto parametrofacturaciondefectoAux) throws Exception  {
		ParametroFacturacionDefectoConstantesFunciones.InicializarValoresParametroFacturacionDefecto(parametrofacturaciondefectoAux,true);
		
		for(ParametroFacturacionDefecto parametrofacturaciondefecto: parametrofacturaciondefectos) {
			if(parametrofacturaciondefecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFacturacionDefecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroFacturacionDefectoConstantesFunciones.getArrayColumnasGlobalesParametroFacturacionDefecto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFacturacionDefecto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroFacturacionDefecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroFacturacionDefecto> parametrofacturaciondefectos,ParametroFacturacionDefecto parametrofacturaciondefecto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroFacturacionDefecto parametrofacturaciondefectoAux: parametrofacturaciondefectos) {
			if(parametrofacturaciondefectoAux!=null && parametrofacturaciondefecto!=null) {
				if((parametrofacturaciondefectoAux.getId()==null && parametrofacturaciondefecto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrofacturaciondefectoAux.getId()!=null && parametrofacturaciondefecto.getId()!=null){
					if(parametrofacturaciondefectoAux.getId().equals(parametrofacturaciondefecto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroFacturacionDefecto(List<ParametroFacturacionDefecto> parametrofacturaciondefectos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroFacturacionDefecto parametrofacturaciondefecto: parametrofacturaciondefectos) {			
			if(parametrofacturaciondefecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroFacturacionDefecto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroFacturacionDefectoConstantesFunciones.LABEL_ID, ParametroFacturacionDefectoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFacturacionDefectoConstantesFunciones.LABEL_VERSIONROW, ParametroFacturacionDefectoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFacturacionDefectoConstantesFunciones.LABEL_IDEMPRESA, ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFacturacionDefectoConstantesFunciones.LABEL_IDSUCURSAL, ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFacturacionDefectoConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE, ParametroFacturacionDefectoConstantesFunciones.IDTIPOVIATRANSPORTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroFacturacionDefecto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroFacturacionDefectoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFacturacionDefectoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFacturacionDefectoConstantesFunciones.IDTIPOVIATRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFacturacionDefecto() throws Exception  {
		return ParametroFacturacionDefectoConstantesFunciones.getTiposSeleccionarParametroFacturacionDefecto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFacturacionDefecto(Boolean conFk) throws Exception  {
		return ParametroFacturacionDefectoConstantesFunciones.getTiposSeleccionarParametroFacturacionDefecto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFacturacionDefecto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFacturacionDefectoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroFacturacionDefectoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFacturacionDefectoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroFacturacionDefectoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFacturacionDefectoConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
			reporte.setsDescripcion(ParametroFacturacionDefectoConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroFacturacionDefecto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFacturacionDefecto(ParametroFacturacionDefecto parametrofacturaciondefectoAux) throws Exception {
		
			parametrofacturaciondefectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofacturaciondefectoAux.getEmpresa()));
			parametrofacturaciondefectoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofacturaciondefectoAux.getSucursal()));
			parametrofacturaciondefectoAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(parametrofacturaciondefectoAux.getTipoViaTransporte()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFacturacionDefecto(List<ParametroFacturacionDefecto> parametrofacturaciondefectosTemp) throws Exception {
		for(ParametroFacturacionDefecto parametrofacturaciondefectoAux:parametrofacturaciondefectosTemp) {
			
			parametrofacturaciondefectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofacturaciondefectoAux.getEmpresa()));
			parametrofacturaciondefectoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofacturaciondefectoAux.getSucursal()));
			parametrofacturaciondefectoAux.settipoviatransporte_descripcion(TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(parametrofacturaciondefectoAux.getTipoViaTransporte()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFacturacionDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoViaTransporte.class));
				
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
					if(clas.clas.equals(TipoViaTransporte.class)) {
						classes.add(new Classe(TipoViaTransporte.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroFacturacionDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
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

					if(TipoViaTransporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoViaTransporte.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFacturacionDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFacturacionDefectoConstantesFunciones.getClassesRelationshipsOfParametroFacturacionDefecto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFacturacionDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFacturacionDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFacturacionDefectoConstantesFunciones.getClassesRelationshipsFromStringsOfParametroFacturacionDefecto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFacturacionDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroFacturacionDefecto parametrofacturaciondefecto,List<ParametroFacturacionDefecto> parametrofacturaciondefectos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroFacturacionDefecto parametrofacturaciondefectoEncontrado=null;
			
			for(ParametroFacturacionDefecto parametrofacturaciondefectoLocal:parametrofacturaciondefectos) {
				if(parametrofacturaciondefectoLocal.getId().equals(parametrofacturaciondefecto.getId())) {
					parametrofacturaciondefectoEncontrado=parametrofacturaciondefectoLocal;
					
					parametrofacturaciondefectoLocal.setIsChanged(parametrofacturaciondefecto.getIsChanged());
					parametrofacturaciondefectoLocal.setIsNew(parametrofacturaciondefecto.getIsNew());
					parametrofacturaciondefectoLocal.setIsDeleted(parametrofacturaciondefecto.getIsDeleted());
					
					parametrofacturaciondefectoLocal.setGeneralEntityOriginal(parametrofacturaciondefecto.getGeneralEntityOriginal());
					
					parametrofacturaciondefectoLocal.setId(parametrofacturaciondefecto.getId());	
					parametrofacturaciondefectoLocal.setVersionRow(parametrofacturaciondefecto.getVersionRow());	
					parametrofacturaciondefectoLocal.setid_empresa(parametrofacturaciondefecto.getid_empresa());	
					parametrofacturaciondefectoLocal.setid_sucursal(parametrofacturaciondefecto.getid_sucursal());	
					parametrofacturaciondefectoLocal.setid_tipo_via_transporte(parametrofacturaciondefecto.getid_tipo_via_transporte());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrofacturaciondefecto.getIsDeleted()) {
				if(!existe) {
					parametrofacturaciondefectos.add(parametrofacturaciondefecto);
				}
			} else {
				if(parametrofacturaciondefectoEncontrado!=null && permiteQuitar)  {
					parametrofacturaciondefectos.remove(parametrofacturaciondefectoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroFacturacionDefecto parametrofacturaciondefecto,List<ParametroFacturacionDefecto> parametrofacturaciondefectos) throws Exception {
		try	{			
			for(ParametroFacturacionDefecto parametrofacturaciondefectoLocal:parametrofacturaciondefectos) {
				if(parametrofacturaciondefectoLocal.getId().equals(parametrofacturaciondefecto.getId())) {
					parametrofacturaciondefectoLocal.setIsSelected(parametrofacturaciondefecto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroFacturacionDefecto(List<ParametroFacturacionDefecto> parametrofacturaciondefectosAux) throws Exception {
		//this.parametrofacturaciondefectosAux=parametrofacturaciondefectosAux;
		
		for(ParametroFacturacionDefecto parametrofacturaciondefectoAux:parametrofacturaciondefectosAux) {
			if(parametrofacturaciondefectoAux.getIsChanged()) {
				parametrofacturaciondefectoAux.setIsChanged(false);
			}		
			
			if(parametrofacturaciondefectoAux.getIsNew()) {
				parametrofacturaciondefectoAux.setIsNew(false);
			}	
			
			if(parametrofacturaciondefectoAux.getIsDeleted()) {
				parametrofacturaciondefectoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroFacturacionDefecto(ParametroFacturacionDefecto parametrofacturaciondefectoAux) throws Exception {
		//this.parametrofacturaciondefectoAux=parametrofacturaciondefectoAux;
		
			if(parametrofacturaciondefectoAux.getIsChanged()) {
				parametrofacturaciondefectoAux.setIsChanged(false);
			}		
			
			if(parametrofacturaciondefectoAux.getIsNew()) {
				parametrofacturaciondefectoAux.setIsNew(false);
			}	
			
			if(parametrofacturaciondefectoAux.getIsDeleted()) {
				parametrofacturaciondefectoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroFacturacionDefecto parametrofacturaciondefectoAsignar,ParametroFacturacionDefecto parametrofacturaciondefecto) throws Exception {
		parametrofacturaciondefectoAsignar.setId(parametrofacturaciondefecto.getId());	
		parametrofacturaciondefectoAsignar.setVersionRow(parametrofacturaciondefecto.getVersionRow());	
		parametrofacturaciondefectoAsignar.setid_empresa(parametrofacturaciondefecto.getid_empresa());
		parametrofacturaciondefectoAsignar.setempresa_descripcion(parametrofacturaciondefecto.getempresa_descripcion());	
		parametrofacturaciondefectoAsignar.setid_sucursal(parametrofacturaciondefecto.getid_sucursal());
		parametrofacturaciondefectoAsignar.setsucursal_descripcion(parametrofacturaciondefecto.getsucursal_descripcion());	
		parametrofacturaciondefectoAsignar.setid_tipo_via_transporte(parametrofacturaciondefecto.getid_tipo_via_transporte());
		parametrofacturaciondefectoAsignar.settipoviatransporte_descripcion(parametrofacturaciondefecto.gettipoviatransporte_descripcion());	
	}
	
	public static void inicializarParametroFacturacionDefecto(ParametroFacturacionDefecto parametrofacturaciondefecto) throws Exception {
		try {
				parametrofacturaciondefecto.setId(0L);	
					
				parametrofacturaciondefecto.setid_empresa(-1L);	
				parametrofacturaciondefecto.setid_sucursal(-1L);	
				parametrofacturaciondefecto.setid_tipo_via_transporte(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroFacturacionDefecto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFacturacionDefectoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFacturacionDefectoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFacturacionDefectoConstantesFunciones.LABEL_IDTIPOVIATRANSPORTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroFacturacionDefecto(String sTipo,Row row,Workbook workbook,ParametroFacturacionDefecto parametrofacturaciondefecto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofacturaciondefecto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofacturaciondefecto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofacturaciondefecto.gettipoviatransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroFacturacionDefecto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroFacturacionDefecto() {
		return this.sFinalQueryParametroFacturacionDefecto;
	}
	
	public void setsFinalQueryParametroFacturacionDefecto(String sFinalQueryParametroFacturacionDefecto) {
		this.sFinalQueryParametroFacturacionDefecto= sFinalQueryParametroFacturacionDefecto;
	}
	
	public Border resaltarSeleccionarParametroFacturacionDefecto=null;
	
	public Border setResaltarSeleccionarParametroFacturacionDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFacturacionDefectoBeanSwingJInternalFrame parametrofacturaciondefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrofacturaciondefectoBeanSwingJInternalFrame.jTtoolBarParametroFacturacionDefecto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroFacturacionDefecto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroFacturacionDefecto() {
		return this.resaltarSeleccionarParametroFacturacionDefecto;
	}
	
	public void setResaltarSeleccionarParametroFacturacionDefecto(Border borderResaltarSeleccionarParametroFacturacionDefecto) {
		this.resaltarSeleccionarParametroFacturacionDefecto= borderResaltarSeleccionarParametroFacturacionDefecto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroFacturacionDefecto=null;
	public Boolean mostraridParametroFacturacionDefecto=true;
	public Boolean activaridParametroFacturacionDefecto=true;

	public Border resaltarid_empresaParametroFacturacionDefecto=null;
	public Boolean mostrarid_empresaParametroFacturacionDefecto=true;
	public Boolean activarid_empresaParametroFacturacionDefecto=true;
	public Boolean cargarid_empresaParametroFacturacionDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroFacturacionDefecto=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroFacturacionDefecto=null;
	public Boolean mostrarid_sucursalParametroFacturacionDefecto=true;
	public Boolean activarid_sucursalParametroFacturacionDefecto=true;
	public Boolean cargarid_sucursalParametroFacturacionDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroFacturacionDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_via_transporteParametroFacturacionDefecto=null;
	public Boolean mostrarid_tipo_via_transporteParametroFacturacionDefecto=true;
	public Boolean activarid_tipo_via_transporteParametroFacturacionDefecto=true;
	public Boolean cargarid_tipo_via_transporteParametroFacturacionDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_via_transporteParametroFacturacionDefecto=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroFacturacionDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFacturacionDefectoBeanSwingJInternalFrame parametrofacturaciondefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofacturaciondefectoBeanSwingJInternalFrame.jTtoolBarParametroFacturacionDefecto.setBorder(borderResaltar);
		
		this.resaltaridParametroFacturacionDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroFacturacionDefecto() {
		return this.resaltaridParametroFacturacionDefecto;
	}

	public void setResaltaridParametroFacturacionDefecto(Border borderResaltar) {
		this.resaltaridParametroFacturacionDefecto= borderResaltar;
	}

	public Boolean getMostraridParametroFacturacionDefecto() {
		return this.mostraridParametroFacturacionDefecto;
	}

	public void setMostraridParametroFacturacionDefecto(Boolean mostraridParametroFacturacionDefecto) {
		this.mostraridParametroFacturacionDefecto= mostraridParametroFacturacionDefecto;
	}

	public Boolean getActivaridParametroFacturacionDefecto() {
		return this.activaridParametroFacturacionDefecto;
	}

	public void setActivaridParametroFacturacionDefecto(Boolean activaridParametroFacturacionDefecto) {
		this.activaridParametroFacturacionDefecto= activaridParametroFacturacionDefecto;
	}

	public Border setResaltarid_empresaParametroFacturacionDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFacturacionDefectoBeanSwingJInternalFrame parametrofacturaciondefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofacturaciondefectoBeanSwingJInternalFrame.jTtoolBarParametroFacturacionDefecto.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroFacturacionDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroFacturacionDefecto() {
		return this.resaltarid_empresaParametroFacturacionDefecto;
	}

	public void setResaltarid_empresaParametroFacturacionDefecto(Border borderResaltar) {
		this.resaltarid_empresaParametroFacturacionDefecto= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroFacturacionDefecto() {
		return this.mostrarid_empresaParametroFacturacionDefecto;
	}

	public void setMostrarid_empresaParametroFacturacionDefecto(Boolean mostrarid_empresaParametroFacturacionDefecto) {
		this.mostrarid_empresaParametroFacturacionDefecto= mostrarid_empresaParametroFacturacionDefecto;
	}

	public Boolean getActivarid_empresaParametroFacturacionDefecto() {
		return this.activarid_empresaParametroFacturacionDefecto;
	}

	public void setActivarid_empresaParametroFacturacionDefecto(Boolean activarid_empresaParametroFacturacionDefecto) {
		this.activarid_empresaParametroFacturacionDefecto= activarid_empresaParametroFacturacionDefecto;
	}

	public Boolean getCargarid_empresaParametroFacturacionDefecto() {
		return this.cargarid_empresaParametroFacturacionDefecto;
	}

	public void setCargarid_empresaParametroFacturacionDefecto(Boolean cargarid_empresaParametroFacturacionDefecto) {
		this.cargarid_empresaParametroFacturacionDefecto= cargarid_empresaParametroFacturacionDefecto;
	}

	public Border setResaltarid_sucursalParametroFacturacionDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFacturacionDefectoBeanSwingJInternalFrame parametrofacturaciondefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofacturaciondefectoBeanSwingJInternalFrame.jTtoolBarParametroFacturacionDefecto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroFacturacionDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroFacturacionDefecto() {
		return this.resaltarid_sucursalParametroFacturacionDefecto;
	}

	public void setResaltarid_sucursalParametroFacturacionDefecto(Border borderResaltar) {
		this.resaltarid_sucursalParametroFacturacionDefecto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroFacturacionDefecto() {
		return this.mostrarid_sucursalParametroFacturacionDefecto;
	}

	public void setMostrarid_sucursalParametroFacturacionDefecto(Boolean mostrarid_sucursalParametroFacturacionDefecto) {
		this.mostrarid_sucursalParametroFacturacionDefecto= mostrarid_sucursalParametroFacturacionDefecto;
	}

	public Boolean getActivarid_sucursalParametroFacturacionDefecto() {
		return this.activarid_sucursalParametroFacturacionDefecto;
	}

	public void setActivarid_sucursalParametroFacturacionDefecto(Boolean activarid_sucursalParametroFacturacionDefecto) {
		this.activarid_sucursalParametroFacturacionDefecto= activarid_sucursalParametroFacturacionDefecto;
	}

	public Boolean getCargarid_sucursalParametroFacturacionDefecto() {
		return this.cargarid_sucursalParametroFacturacionDefecto;
	}

	public void setCargarid_sucursalParametroFacturacionDefecto(Boolean cargarid_sucursalParametroFacturacionDefecto) {
		this.cargarid_sucursalParametroFacturacionDefecto= cargarid_sucursalParametroFacturacionDefecto;
	}

	public Border setResaltarid_tipo_via_transporteParametroFacturacionDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFacturacionDefectoBeanSwingJInternalFrame parametrofacturaciondefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofacturaciondefectoBeanSwingJInternalFrame.jTtoolBarParametroFacturacionDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_via_transporteParametroFacturacionDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_via_transporteParametroFacturacionDefecto() {
		return this.resaltarid_tipo_via_transporteParametroFacturacionDefecto;
	}

	public void setResaltarid_tipo_via_transporteParametroFacturacionDefecto(Border borderResaltar) {
		this.resaltarid_tipo_via_transporteParametroFacturacionDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_via_transporteParametroFacturacionDefecto() {
		return this.mostrarid_tipo_via_transporteParametroFacturacionDefecto;
	}

	public void setMostrarid_tipo_via_transporteParametroFacturacionDefecto(Boolean mostrarid_tipo_via_transporteParametroFacturacionDefecto) {
		this.mostrarid_tipo_via_transporteParametroFacturacionDefecto= mostrarid_tipo_via_transporteParametroFacturacionDefecto;
	}

	public Boolean getActivarid_tipo_via_transporteParametroFacturacionDefecto() {
		return this.activarid_tipo_via_transporteParametroFacturacionDefecto;
	}

	public void setActivarid_tipo_via_transporteParametroFacturacionDefecto(Boolean activarid_tipo_via_transporteParametroFacturacionDefecto) {
		this.activarid_tipo_via_transporteParametroFacturacionDefecto= activarid_tipo_via_transporteParametroFacturacionDefecto;
	}

	public Boolean getCargarid_tipo_via_transporteParametroFacturacionDefecto() {
		return this.cargarid_tipo_via_transporteParametroFacturacionDefecto;
	}

	public void setCargarid_tipo_via_transporteParametroFacturacionDefecto(Boolean cargarid_tipo_via_transporteParametroFacturacionDefecto) {
		this.cargarid_tipo_via_transporteParametroFacturacionDefecto= cargarid_tipo_via_transporteParametroFacturacionDefecto;
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
		
		
		this.setMostraridParametroFacturacionDefecto(esInicial);
		this.setMostrarid_empresaParametroFacturacionDefecto(esInicial);
		this.setMostrarid_sucursalParametroFacturacionDefecto(esInicial);
		this.setMostrarid_tipo_via_transporteParametroFacturacionDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFacturacionDefectoConstantesFunciones.ID)) {
				this.setMostraridParametroFacturacionDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroFacturacionDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroFacturacionDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFacturacionDefectoConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setMostrarid_tipo_via_transporteParametroFacturacionDefecto(esAsigna);
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
		
		
		this.setActivaridParametroFacturacionDefecto(esInicial);
		this.setActivarid_empresaParametroFacturacionDefecto(esInicial);
		this.setActivarid_sucursalParametroFacturacionDefecto(esInicial);
		this.setActivarid_tipo_via_transporteParametroFacturacionDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFacturacionDefectoConstantesFunciones.ID)) {
				this.setActivaridParametroFacturacionDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroFacturacionDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroFacturacionDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFacturacionDefectoConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setActivarid_tipo_via_transporteParametroFacturacionDefecto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFacturacionDefectoBeanSwingJInternalFrame parametrofacturaciondefectoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroFacturacionDefecto(esInicial);
		this.setResaltarid_empresaParametroFacturacionDefecto(esInicial);
		this.setResaltarid_sucursalParametroFacturacionDefecto(esInicial);
		this.setResaltarid_tipo_via_transporteParametroFacturacionDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFacturacionDefectoConstantesFunciones.ID)) {
				this.setResaltaridParametroFacturacionDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroFacturacionDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroFacturacionDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFacturacionDefectoConstantesFunciones.IDTIPOVIATRANSPORTE)) {
				this.setResaltarid_tipo_via_transporteParametroFacturacionDefecto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFacturacionDefectoBeanSwingJInternalFrame parametrofacturaciondefectoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaParametroFacturacionDefecto=true;

	public Boolean getMostrarFK_IdEmpresaParametroFacturacionDefecto() {
		return this.mostrarFK_IdEmpresaParametroFacturacionDefecto;
	}

	public void setMostrarFK_IdEmpresaParametroFacturacionDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroFacturacionDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroFacturacionDefecto=true;

	public Boolean getMostrarFK_IdSucursalParametroFacturacionDefecto() {
		return this.mostrarFK_IdSucursalParametroFacturacionDefecto;
	}

	public void setMostrarFK_IdSucursalParametroFacturacionDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroFacturacionDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoViaTransporteParametroFacturacionDefecto=true;

	public Boolean getMostrarFK_IdTipoViaTransporteParametroFacturacionDefecto() {
		return this.mostrarFK_IdTipoViaTransporteParametroFacturacionDefecto;
	}

	public void setMostrarFK_IdTipoViaTransporteParametroFacturacionDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoViaTransporteParametroFacturacionDefecto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaParametroFacturacionDefecto=true;

	public Boolean getActivarFK_IdEmpresaParametroFacturacionDefecto() {
		return this.activarFK_IdEmpresaParametroFacturacionDefecto;
	}

	public void setActivarFK_IdEmpresaParametroFacturacionDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroFacturacionDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroFacturacionDefecto=true;

	public Boolean getActivarFK_IdSucursalParametroFacturacionDefecto() {
		return this.activarFK_IdSucursalParametroFacturacionDefecto;
	}

	public void setActivarFK_IdSucursalParametroFacturacionDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroFacturacionDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoViaTransporteParametroFacturacionDefecto=true;

	public Boolean getActivarFK_IdTipoViaTransporteParametroFacturacionDefecto() {
		return this.activarFK_IdTipoViaTransporteParametroFacturacionDefecto;
	}

	public void setActivarFK_IdTipoViaTransporteParametroFacturacionDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoViaTransporteParametroFacturacionDefecto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaParametroFacturacionDefecto=null;

	public Border getResaltarFK_IdEmpresaParametroFacturacionDefecto() {
		return this.resaltarFK_IdEmpresaParametroFacturacionDefecto;
	}

	public void setResaltarFK_IdEmpresaParametroFacturacionDefecto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroFacturacionDefecto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroFacturacionDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFacturacionDefectoBeanSwingJInternalFrame parametrofacturaciondefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroFacturacionDefecto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroFacturacionDefecto=null;

	public Border getResaltarFK_IdSucursalParametroFacturacionDefecto() {
		return this.resaltarFK_IdSucursalParametroFacturacionDefecto;
	}

	public void setResaltarFK_IdSucursalParametroFacturacionDefecto(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroFacturacionDefecto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroFacturacionDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFacturacionDefectoBeanSwingJInternalFrame parametrofacturaciondefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroFacturacionDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoViaTransporteParametroFacturacionDefecto=null;

	public Border getResaltarFK_IdTipoViaTransporteParametroFacturacionDefecto() {
		return this.resaltarFK_IdTipoViaTransporteParametroFacturacionDefecto;
	}

	public void setResaltarFK_IdTipoViaTransporteParametroFacturacionDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoViaTransporteParametroFacturacionDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoViaTransporteParametroFacturacionDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFacturacionDefectoBeanSwingJInternalFrame parametrofacturaciondefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoViaTransporteParametroFacturacionDefecto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}