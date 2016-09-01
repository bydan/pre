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


import com.bydan.erp.inventario.util.RangoUnidadVentaConstantesFunciones;
import com.bydan.erp.inventario.util.RangoUnidadVentaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.RangoUnidadVentaParameterGeneral;

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
final public class RangoUnidadVentaConstantesFunciones extends RangoUnidadVentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RangoUnidadVenta";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RangoUnidadVenta"+RangoUnidadVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RangoUnidadVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RangoUnidadVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RangoUnidadVentaConstantesFunciones.SCHEMA+"_"+RangoUnidadVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RangoUnidadVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RangoUnidadVentaConstantesFunciones.SCHEMA+"_"+RangoUnidadVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RangoUnidadVentaConstantesFunciones.SCHEMA+"_"+RangoUnidadVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RangoUnidadVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RangoUnidadVentaConstantesFunciones.SCHEMA+"_"+RangoUnidadVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RangoUnidadVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RangoUnidadVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RangoUnidadVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RangoUnidadVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RangoUnidadVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RangoUnidadVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RangoUnidadVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RangoUnidadVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RangoUnidadVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RangoUnidadVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Rango Unidad Ventas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Rango Unidad Venta";
	public static final String SCLASSWEBTITULO_LOWER="Rango Unidad Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RangoUnidadVenta";
	public static final String OBJECTNAME="rangounidadventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="rango_unidad_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select rangounidadventa from "+RangoUnidadVentaConstantesFunciones.SPERSISTENCENAME+" rangounidadventa";
	public static String QUERYSELECTNATIVE="select "+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".id,"+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".version_row,"+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".id_empresa,"+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".id_unidad,"+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".rango_inicial,"+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".rango_final from "+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME;//+" as "+RangoUnidadVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RangoUnidadVentaConstantesFuncionesAdditional rangounidadventaConstantesFuncionesAdditional=null;
	
	public RangoUnidadVentaConstantesFuncionesAdditional getRangoUnidadVentaConstantesFuncionesAdditional() {
		return this.rangounidadventaConstantesFuncionesAdditional;
	}
	
	public void setRangoUnidadVentaConstantesFuncionesAdditional(RangoUnidadVentaConstantesFuncionesAdditional rangounidadventaConstantesFuncionesAdditional) {
		try {
			this.rangounidadventaConstantesFuncionesAdditional=rangounidadventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDUNIDAD= "id_unidad";
    public static final String RANGOINICIAL= "rango_inicial";
    public static final String RANGOFINAL= "rango_final";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_RANGOINICIAL= "Rango Inicial";
		public static final String LABEL_RANGOINICIAL_LOWER= "Rango Inicial";
    	public static final String LABEL_RANGOFINAL= "Rango Final";
		public static final String LABEL_RANGOFINAL_LOWER= "Rango Final";
	
		
		
		
		
		
		
	
	public static String getRangoUnidadVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RangoUnidadVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=RangoUnidadVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RangoUnidadVentaConstantesFunciones.IDUNIDAD)) {sLabelColumna=RangoUnidadVentaConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(RangoUnidadVentaConstantesFunciones.RANGOINICIAL)) {sLabelColumna=RangoUnidadVentaConstantesFunciones.LABEL_RANGOINICIAL;}
		if(sNombreColumna.equals(RangoUnidadVentaConstantesFunciones.RANGOFINAL)) {sLabelColumna=RangoUnidadVentaConstantesFunciones.LABEL_RANGOFINAL;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getRangoUnidadVentaDescripcion(RangoUnidadVenta rangounidadventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(rangounidadventa !=null/* && rangounidadventa.getId()!=0*/) {
			if(rangounidadventa.getId()!=null) {
				sDescripcion=rangounidadventa.getId().toString();
			}//rangounidadventarangounidadventa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRangoUnidadVentaDescripcionDetallado(RangoUnidadVenta rangounidadventa) {
		String sDescripcion="";
			
		sDescripcion+=RangoUnidadVentaConstantesFunciones.ID+"=";
		sDescripcion+=rangounidadventa.getId().toString()+",";
		sDescripcion+=RangoUnidadVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=rangounidadventa.getVersionRow().toString()+",";
		sDescripcion+=RangoUnidadVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=rangounidadventa.getid_empresa().toString()+",";
		sDescripcion+=RangoUnidadVentaConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=rangounidadventa.getid_unidad().toString()+",";
		sDescripcion+=RangoUnidadVentaConstantesFunciones.RANGOINICIAL+"=";
		sDescripcion+=rangounidadventa.getrango_inicial().toString()+",";
		sDescripcion+=RangoUnidadVentaConstantesFunciones.RANGOFINAL+"=";
		sDescripcion+=rangounidadventa.getrango_final().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRangoUnidadVentaDescripcion(RangoUnidadVenta rangounidadventa,String sValor) throws Exception {			
		if(rangounidadventa !=null) {
			//rangounidadventarangounidadventa.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unad";
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

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRangoUnidadVenta(RangoUnidadVenta rangounidadventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosRangoUnidadVentas(List<RangoUnidadVenta> rangounidadventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RangoUnidadVenta rangounidadventa: rangounidadventas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRangoUnidadVenta(RangoUnidadVenta rangounidadventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && rangounidadventa.getConCambioAuxiliar()) {
			rangounidadventa.setIsDeleted(rangounidadventa.getIsDeletedAuxiliar());	
			rangounidadventa.setIsNew(rangounidadventa.getIsNewAuxiliar());	
			rangounidadventa.setIsChanged(rangounidadventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			rangounidadventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			rangounidadventa.setIsDeletedAuxiliar(false);	
			rangounidadventa.setIsNewAuxiliar(false);	
			rangounidadventa.setIsChangedAuxiliar(false);
			
			rangounidadventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRangoUnidadVentas(List<RangoUnidadVenta> rangounidadventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RangoUnidadVenta rangounidadventa : rangounidadventas) {
			if(conAsignarBase && rangounidadventa.getConCambioAuxiliar()) {
				rangounidadventa.setIsDeleted(rangounidadventa.getIsDeletedAuxiliar());	
				rangounidadventa.setIsNew(rangounidadventa.getIsNewAuxiliar());	
				rangounidadventa.setIsChanged(rangounidadventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				rangounidadventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				rangounidadventa.setIsDeletedAuxiliar(false);	
				rangounidadventa.setIsNewAuxiliar(false);	
				rangounidadventa.setIsChangedAuxiliar(false);
				
				rangounidadventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRangoUnidadVenta(RangoUnidadVenta rangounidadventa,Boolean conEnteros) throws Exception  {
		rangounidadventa.setrango_inicial(0.0);
		rangounidadventa.setrango_final(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRangoUnidadVentas(List<RangoUnidadVenta> rangounidadventas,Boolean conEnteros) throws Exception  {
		
		for(RangoUnidadVenta rangounidadventa: rangounidadventas) {
			rangounidadventa.setrango_inicial(0.0);
			rangounidadventa.setrango_final(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRangoUnidadVenta(List<RangoUnidadVenta> rangounidadventas,RangoUnidadVenta rangounidadventaAux) throws Exception  {
		RangoUnidadVentaConstantesFunciones.InicializarValoresRangoUnidadVenta(rangounidadventaAux,true);
		
		for(RangoUnidadVenta rangounidadventa: rangounidadventas) {
			if(rangounidadventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			rangounidadventaAux.setrango_inicial(rangounidadventaAux.getrango_inicial()+rangounidadventa.getrango_inicial());			
			rangounidadventaAux.setrango_final(rangounidadventaAux.getrango_final()+rangounidadventa.getrango_final());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRangoUnidadVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RangoUnidadVentaConstantesFunciones.getArrayColumnasGlobalesRangoUnidadVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRangoUnidadVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RangoUnidadVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RangoUnidadVentaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRangoUnidadVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RangoUnidadVenta> rangounidadventas,RangoUnidadVenta rangounidadventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RangoUnidadVenta rangounidadventaAux: rangounidadventas) {
			if(rangounidadventaAux!=null && rangounidadventa!=null) {
				if((rangounidadventaAux.getId()==null && rangounidadventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(rangounidadventaAux.getId()!=null && rangounidadventa.getId()!=null){
					if(rangounidadventaAux.getId().equals(rangounidadventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRangoUnidadVenta(List<RangoUnidadVenta> rangounidadventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double rango_inicialTotal=0.0;
		Double rango_finalTotal=0.0;
	
		for(RangoUnidadVenta rangounidadventa: rangounidadventas) {			
			if(rangounidadventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			rango_inicialTotal+=rangounidadventa.getrango_inicial();
			rango_finalTotal+=rangounidadventa.getrango_final();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RangoUnidadVentaConstantesFunciones.RANGOINICIAL);
		datoGeneral.setsDescripcion(RangoUnidadVentaConstantesFunciones.LABEL_RANGOINICIAL);
		datoGeneral.setdValorDouble(rango_inicialTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RangoUnidadVentaConstantesFunciones.RANGOFINAL);
		datoGeneral.setsDescripcion(RangoUnidadVentaConstantesFunciones.LABEL_RANGOFINAL);
		datoGeneral.setdValorDouble(rango_finalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRangoUnidadVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RangoUnidadVentaConstantesFunciones.LABEL_ID, RangoUnidadVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RangoUnidadVentaConstantesFunciones.LABEL_VERSIONROW, RangoUnidadVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RangoUnidadVentaConstantesFunciones.LABEL_IDEMPRESA, RangoUnidadVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RangoUnidadVentaConstantesFunciones.LABEL_IDUNIDAD, RangoUnidadVentaConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RangoUnidadVentaConstantesFunciones.LABEL_RANGOINICIAL, RangoUnidadVentaConstantesFunciones.RANGOINICIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RangoUnidadVentaConstantesFunciones.LABEL_RANGOFINAL, RangoUnidadVentaConstantesFunciones.RANGOFINAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRangoUnidadVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RangoUnidadVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RangoUnidadVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RangoUnidadVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RangoUnidadVentaConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RangoUnidadVentaConstantesFunciones.RANGOINICIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RangoUnidadVentaConstantesFunciones.RANGOFINAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRangoUnidadVenta() throws Exception  {
		return RangoUnidadVentaConstantesFunciones.getTiposSeleccionarRangoUnidadVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRangoUnidadVenta(Boolean conFk) throws Exception  {
		return RangoUnidadVentaConstantesFunciones.getTiposSeleccionarRangoUnidadVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRangoUnidadVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RangoUnidadVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RangoUnidadVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RangoUnidadVentaConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(RangoUnidadVentaConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RangoUnidadVentaConstantesFunciones.LABEL_RANGOINICIAL);
			reporte.setsDescripcion(RangoUnidadVentaConstantesFunciones.LABEL_RANGOINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RangoUnidadVentaConstantesFunciones.LABEL_RANGOFINAL);
			reporte.setsDescripcion(RangoUnidadVentaConstantesFunciones.LABEL_RANGOFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRangoUnidadVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRangoUnidadVenta(RangoUnidadVenta rangounidadventaAux) throws Exception {
		
			rangounidadventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rangounidadventaAux.getEmpresa()));
			rangounidadventaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(rangounidadventaAux.getUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRangoUnidadVenta(List<RangoUnidadVenta> rangounidadventasTemp) throws Exception {
		for(RangoUnidadVenta rangounidadventaAux:rangounidadventasTemp) {
			
			rangounidadventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rangounidadventaAux.getEmpresa()));
			rangounidadventaAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(rangounidadventaAux.getUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRangoUnidadVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Unidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRangoUnidadVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRangoUnidadVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RangoUnidadVentaConstantesFunciones.getClassesRelationshipsOfRangoUnidadVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRangoUnidadVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Precio.class));
				classes.add(new Classe(ParametroInventarioDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Precio.class)) {
						classes.add(new Classe(Precio.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroInventarioDefecto.class)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRangoUnidadVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RangoUnidadVentaConstantesFunciones.getClassesRelationshipsFromStringsOfRangoUnidadVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRangoUnidadVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Precio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Precio.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Precio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Precio.class)); continue;
					}

					if(ParametroInventarioDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroInventarioDefecto.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(RangoUnidadVenta rangounidadventa,List<RangoUnidadVenta> rangounidadventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RangoUnidadVenta rangounidadventaEncontrado=null;
			
			for(RangoUnidadVenta rangounidadventaLocal:rangounidadventas) {
				if(rangounidadventaLocal.getId().equals(rangounidadventa.getId())) {
					rangounidadventaEncontrado=rangounidadventaLocal;
					
					rangounidadventaLocal.setIsChanged(rangounidadventa.getIsChanged());
					rangounidadventaLocal.setIsNew(rangounidadventa.getIsNew());
					rangounidadventaLocal.setIsDeleted(rangounidadventa.getIsDeleted());
					
					rangounidadventaLocal.setGeneralEntityOriginal(rangounidadventa.getGeneralEntityOriginal());
					
					rangounidadventaLocal.setId(rangounidadventa.getId());	
					rangounidadventaLocal.setVersionRow(rangounidadventa.getVersionRow());	
					rangounidadventaLocal.setid_empresa(rangounidadventa.getid_empresa());	
					rangounidadventaLocal.setid_unidad(rangounidadventa.getid_unidad());	
					rangounidadventaLocal.setrango_inicial(rangounidadventa.getrango_inicial());	
					rangounidadventaLocal.setrango_final(rangounidadventa.getrango_final());	
					
					
					rangounidadventaLocal.setPrecios(rangounidadventa.getPrecios());
					rangounidadventaLocal.setParametroInventarioDefectos(rangounidadventa.getParametroInventarioDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!rangounidadventa.getIsDeleted()) {
				if(!existe) {
					rangounidadventas.add(rangounidadventa);
				}
			} else {
				if(rangounidadventaEncontrado!=null && permiteQuitar)  {
					rangounidadventas.remove(rangounidadventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RangoUnidadVenta rangounidadventa,List<RangoUnidadVenta> rangounidadventas) throws Exception {
		try	{			
			for(RangoUnidadVenta rangounidadventaLocal:rangounidadventas) {
				if(rangounidadventaLocal.getId().equals(rangounidadventa.getId())) {
					rangounidadventaLocal.setIsSelected(rangounidadventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRangoUnidadVenta(List<RangoUnidadVenta> rangounidadventasAux) throws Exception {
		//this.rangounidadventasAux=rangounidadventasAux;
		
		for(RangoUnidadVenta rangounidadventaAux:rangounidadventasAux) {
			if(rangounidadventaAux.getIsChanged()) {
				rangounidadventaAux.setIsChanged(false);
			}		
			
			if(rangounidadventaAux.getIsNew()) {
				rangounidadventaAux.setIsNew(false);
			}	
			
			if(rangounidadventaAux.getIsDeleted()) {
				rangounidadventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRangoUnidadVenta(RangoUnidadVenta rangounidadventaAux) throws Exception {
		//this.rangounidadventaAux=rangounidadventaAux;
		
			if(rangounidadventaAux.getIsChanged()) {
				rangounidadventaAux.setIsChanged(false);
			}		
			
			if(rangounidadventaAux.getIsNew()) {
				rangounidadventaAux.setIsNew(false);
			}	
			
			if(rangounidadventaAux.getIsDeleted()) {
				rangounidadventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RangoUnidadVenta rangounidadventaAsignar,RangoUnidadVenta rangounidadventa) throws Exception {
		rangounidadventaAsignar.setId(rangounidadventa.getId());	
		rangounidadventaAsignar.setVersionRow(rangounidadventa.getVersionRow());	
		rangounidadventaAsignar.setid_empresa(rangounidadventa.getid_empresa());
		rangounidadventaAsignar.setempresa_descripcion(rangounidadventa.getempresa_descripcion());	
		rangounidadventaAsignar.setid_unidad(rangounidadventa.getid_unidad());
		rangounidadventaAsignar.setunidad_descripcion(rangounidadventa.getunidad_descripcion());	
		rangounidadventaAsignar.setrango_inicial(rangounidadventa.getrango_inicial());	
		rangounidadventaAsignar.setrango_final(rangounidadventa.getrango_final());	
	}
	
	public static void inicializarRangoUnidadVenta(RangoUnidadVenta rangounidadventa) throws Exception {
		try {
				rangounidadventa.setId(0L);	
					
				rangounidadventa.setid_empresa(-1L);	
				rangounidadventa.setid_unidad(-1L);	
				rangounidadventa.setrango_inicial(0.0);	
				rangounidadventa.setrango_final(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRangoUnidadVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RangoUnidadVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RangoUnidadVentaConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RangoUnidadVentaConstantesFunciones.LABEL_RANGOINICIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RangoUnidadVentaConstantesFunciones.LABEL_RANGOFINAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRangoUnidadVenta(String sTipo,Row row,Workbook workbook,RangoUnidadVenta rangounidadventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(rangounidadventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rangounidadventa.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rangounidadventa.getrango_inicial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rangounidadventa.getrango_final());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRangoUnidadVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRangoUnidadVenta() {
		return this.sFinalQueryRangoUnidadVenta;
	}
	
	public void setsFinalQueryRangoUnidadVenta(String sFinalQueryRangoUnidadVenta) {
		this.sFinalQueryRangoUnidadVenta= sFinalQueryRangoUnidadVenta;
	}
	
	public Border resaltarSeleccionarRangoUnidadVenta=null;
	
	public Border setResaltarSeleccionarRangoUnidadVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RangoUnidadVentaBeanSwingJInternalFrame rangounidadventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//rangounidadventaBeanSwingJInternalFrame.jTtoolBarRangoUnidadVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRangoUnidadVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRangoUnidadVenta() {
		return this.resaltarSeleccionarRangoUnidadVenta;
	}
	
	public void setResaltarSeleccionarRangoUnidadVenta(Border borderResaltarSeleccionarRangoUnidadVenta) {
		this.resaltarSeleccionarRangoUnidadVenta= borderResaltarSeleccionarRangoUnidadVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRangoUnidadVenta=null;
	public Boolean mostraridRangoUnidadVenta=true;
	public Boolean activaridRangoUnidadVenta=true;

	public Border resaltarid_empresaRangoUnidadVenta=null;
	public Boolean mostrarid_empresaRangoUnidadVenta=true;
	public Boolean activarid_empresaRangoUnidadVenta=true;
	public Boolean cargarid_empresaRangoUnidadVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRangoUnidadVenta=false;//ConEventDepend=true

	public Border resaltarid_unidadRangoUnidadVenta=null;
	public Boolean mostrarid_unidadRangoUnidadVenta=true;
	public Boolean activarid_unidadRangoUnidadVenta=true;
	public Boolean cargarid_unidadRangoUnidadVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadRangoUnidadVenta=false;//ConEventDepend=true

	public Border resaltarrango_inicialRangoUnidadVenta=null;
	public Boolean mostrarrango_inicialRangoUnidadVenta=true;
	public Boolean activarrango_inicialRangoUnidadVenta=true;

	public Border resaltarrango_finalRangoUnidadVenta=null;
	public Boolean mostrarrango_finalRangoUnidadVenta=true;
	public Boolean activarrango_finalRangoUnidadVenta=true;

	
	

	public Border setResaltaridRangoUnidadVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RangoUnidadVentaBeanSwingJInternalFrame rangounidadventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rangounidadventaBeanSwingJInternalFrame.jTtoolBarRangoUnidadVenta.setBorder(borderResaltar);
		
		this.resaltaridRangoUnidadVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRangoUnidadVenta() {
		return this.resaltaridRangoUnidadVenta;
	}

	public void setResaltaridRangoUnidadVenta(Border borderResaltar) {
		this.resaltaridRangoUnidadVenta= borderResaltar;
	}

	public Boolean getMostraridRangoUnidadVenta() {
		return this.mostraridRangoUnidadVenta;
	}

	public void setMostraridRangoUnidadVenta(Boolean mostraridRangoUnidadVenta) {
		this.mostraridRangoUnidadVenta= mostraridRangoUnidadVenta;
	}

	public Boolean getActivaridRangoUnidadVenta() {
		return this.activaridRangoUnidadVenta;
	}

	public void setActivaridRangoUnidadVenta(Boolean activaridRangoUnidadVenta) {
		this.activaridRangoUnidadVenta= activaridRangoUnidadVenta;
	}

	public Border setResaltarid_empresaRangoUnidadVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RangoUnidadVentaBeanSwingJInternalFrame rangounidadventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rangounidadventaBeanSwingJInternalFrame.jTtoolBarRangoUnidadVenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaRangoUnidadVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRangoUnidadVenta() {
		return this.resaltarid_empresaRangoUnidadVenta;
	}

	public void setResaltarid_empresaRangoUnidadVenta(Border borderResaltar) {
		this.resaltarid_empresaRangoUnidadVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaRangoUnidadVenta() {
		return this.mostrarid_empresaRangoUnidadVenta;
	}

	public void setMostrarid_empresaRangoUnidadVenta(Boolean mostrarid_empresaRangoUnidadVenta) {
		this.mostrarid_empresaRangoUnidadVenta= mostrarid_empresaRangoUnidadVenta;
	}

	public Boolean getActivarid_empresaRangoUnidadVenta() {
		return this.activarid_empresaRangoUnidadVenta;
	}

	public void setActivarid_empresaRangoUnidadVenta(Boolean activarid_empresaRangoUnidadVenta) {
		this.activarid_empresaRangoUnidadVenta= activarid_empresaRangoUnidadVenta;
	}

	public Boolean getCargarid_empresaRangoUnidadVenta() {
		return this.cargarid_empresaRangoUnidadVenta;
	}

	public void setCargarid_empresaRangoUnidadVenta(Boolean cargarid_empresaRangoUnidadVenta) {
		this.cargarid_empresaRangoUnidadVenta= cargarid_empresaRangoUnidadVenta;
	}

	public Border setResaltarid_unidadRangoUnidadVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RangoUnidadVentaBeanSwingJInternalFrame rangounidadventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rangounidadventaBeanSwingJInternalFrame.jTtoolBarRangoUnidadVenta.setBorder(borderResaltar);
		
		this.resaltarid_unidadRangoUnidadVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadRangoUnidadVenta() {
		return this.resaltarid_unidadRangoUnidadVenta;
	}

	public void setResaltarid_unidadRangoUnidadVenta(Border borderResaltar) {
		this.resaltarid_unidadRangoUnidadVenta= borderResaltar;
	}

	public Boolean getMostrarid_unidadRangoUnidadVenta() {
		return this.mostrarid_unidadRangoUnidadVenta;
	}

	public void setMostrarid_unidadRangoUnidadVenta(Boolean mostrarid_unidadRangoUnidadVenta) {
		this.mostrarid_unidadRangoUnidadVenta= mostrarid_unidadRangoUnidadVenta;
	}

	public Boolean getActivarid_unidadRangoUnidadVenta() {
		return this.activarid_unidadRangoUnidadVenta;
	}

	public void setActivarid_unidadRangoUnidadVenta(Boolean activarid_unidadRangoUnidadVenta) {
		this.activarid_unidadRangoUnidadVenta= activarid_unidadRangoUnidadVenta;
	}

	public Boolean getCargarid_unidadRangoUnidadVenta() {
		return this.cargarid_unidadRangoUnidadVenta;
	}

	public void setCargarid_unidadRangoUnidadVenta(Boolean cargarid_unidadRangoUnidadVenta) {
		this.cargarid_unidadRangoUnidadVenta= cargarid_unidadRangoUnidadVenta;
	}

	public Border setResaltarrango_inicialRangoUnidadVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RangoUnidadVentaBeanSwingJInternalFrame rangounidadventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rangounidadventaBeanSwingJInternalFrame.jTtoolBarRangoUnidadVenta.setBorder(borderResaltar);
		
		this.resaltarrango_inicialRangoUnidadVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrango_inicialRangoUnidadVenta() {
		return this.resaltarrango_inicialRangoUnidadVenta;
	}

	public void setResaltarrango_inicialRangoUnidadVenta(Border borderResaltar) {
		this.resaltarrango_inicialRangoUnidadVenta= borderResaltar;
	}

	public Boolean getMostrarrango_inicialRangoUnidadVenta() {
		return this.mostrarrango_inicialRangoUnidadVenta;
	}

	public void setMostrarrango_inicialRangoUnidadVenta(Boolean mostrarrango_inicialRangoUnidadVenta) {
		this.mostrarrango_inicialRangoUnidadVenta= mostrarrango_inicialRangoUnidadVenta;
	}

	public Boolean getActivarrango_inicialRangoUnidadVenta() {
		return this.activarrango_inicialRangoUnidadVenta;
	}

	public void setActivarrango_inicialRangoUnidadVenta(Boolean activarrango_inicialRangoUnidadVenta) {
		this.activarrango_inicialRangoUnidadVenta= activarrango_inicialRangoUnidadVenta;
	}

	public Border setResaltarrango_finalRangoUnidadVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RangoUnidadVentaBeanSwingJInternalFrame rangounidadventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rangounidadventaBeanSwingJInternalFrame.jTtoolBarRangoUnidadVenta.setBorder(borderResaltar);
		
		this.resaltarrango_finalRangoUnidadVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrango_finalRangoUnidadVenta() {
		return this.resaltarrango_finalRangoUnidadVenta;
	}

	public void setResaltarrango_finalRangoUnidadVenta(Border borderResaltar) {
		this.resaltarrango_finalRangoUnidadVenta= borderResaltar;
	}

	public Boolean getMostrarrango_finalRangoUnidadVenta() {
		return this.mostrarrango_finalRangoUnidadVenta;
	}

	public void setMostrarrango_finalRangoUnidadVenta(Boolean mostrarrango_finalRangoUnidadVenta) {
		this.mostrarrango_finalRangoUnidadVenta= mostrarrango_finalRangoUnidadVenta;
	}

	public Boolean getActivarrango_finalRangoUnidadVenta() {
		return this.activarrango_finalRangoUnidadVenta;
	}

	public void setActivarrango_finalRangoUnidadVenta(Boolean activarrango_finalRangoUnidadVenta) {
		this.activarrango_finalRangoUnidadVenta= activarrango_finalRangoUnidadVenta;
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
		
		
		this.setMostraridRangoUnidadVenta(esInicial);
		this.setMostrarid_empresaRangoUnidadVenta(esInicial);
		this.setMostrarid_unidadRangoUnidadVenta(esInicial);
		this.setMostrarrango_inicialRangoUnidadVenta(esInicial);
		this.setMostrarrango_finalRangoUnidadVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.ID)) {
				this.setMostraridRangoUnidadVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRangoUnidadVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadRangoUnidadVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.RANGOINICIAL)) {
				this.setMostrarrango_inicialRangoUnidadVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.RANGOFINAL)) {
				this.setMostrarrango_finalRangoUnidadVenta(esAsigna);
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
		
		
		this.setActivaridRangoUnidadVenta(esInicial);
		this.setActivarid_empresaRangoUnidadVenta(esInicial);
		this.setActivarid_unidadRangoUnidadVenta(esInicial);
		this.setActivarrango_inicialRangoUnidadVenta(esInicial);
		this.setActivarrango_finalRangoUnidadVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.ID)) {
				this.setActivaridRangoUnidadVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRangoUnidadVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadRangoUnidadVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.RANGOINICIAL)) {
				this.setActivarrango_inicialRangoUnidadVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.RANGOFINAL)) {
				this.setActivarrango_finalRangoUnidadVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RangoUnidadVentaBeanSwingJInternalFrame rangounidadventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRangoUnidadVenta(esInicial);
		this.setResaltarid_empresaRangoUnidadVenta(esInicial);
		this.setResaltarid_unidadRangoUnidadVenta(esInicial);
		this.setResaltarrango_inicialRangoUnidadVenta(esInicial);
		this.setResaltarrango_finalRangoUnidadVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.ID)) {
				this.setResaltaridRangoUnidadVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRangoUnidadVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadRangoUnidadVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.RANGOINICIAL)) {
				this.setResaltarrango_inicialRangoUnidadVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(RangoUnidadVentaConstantesFunciones.RANGOFINAL)) {
				this.setResaltarrango_finalRangoUnidadVenta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPrecioRangoUnidadVenta=null;

	public Border getResaltarPrecioRangoUnidadVenta() {
		return this.resaltarPrecioRangoUnidadVenta;
	}

	public void setResaltarPrecioRangoUnidadVenta(Border borderResaltarPrecio) {
		if(borderResaltarPrecio!=null) {
			this.resaltarPrecioRangoUnidadVenta= borderResaltarPrecio;
		}
	}

	public Border setResaltarPrecioRangoUnidadVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RangoUnidadVentaBeanSwingJInternalFrame rangounidadventaBeanSwingJInternalFrame*/) {
		Border borderResaltarPrecio=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rangounidadventaBeanSwingJInternalFrame.jTtoolBarRangoUnidadVenta.setBorder(borderResaltarPrecio);
			
		this.resaltarPrecioRangoUnidadVenta= borderResaltarPrecio;

		 return borderResaltarPrecio;
	}



	public Boolean mostrarPrecioRangoUnidadVenta=true;

	public Boolean getMostrarPrecioRangoUnidadVenta() {
		return this.mostrarPrecioRangoUnidadVenta;
	}

	public void setMostrarPrecioRangoUnidadVenta(Boolean visibilidadResaltarPrecio) {
		this.mostrarPrecioRangoUnidadVenta= visibilidadResaltarPrecio;
	}



	public Boolean activarPrecioRangoUnidadVenta=true;

	public Boolean gethabilitarResaltarPrecioRangoUnidadVenta() {
		return this.activarPrecioRangoUnidadVenta;
	}

	public void setActivarPrecioRangoUnidadVenta(Boolean habilitarResaltarPrecio) {
		this.activarPrecioRangoUnidadVenta= habilitarResaltarPrecio;
	}


	public Border resaltarParametroInventarioDefectoRangoUnidadVenta=null;

	public Border getResaltarParametroInventarioDefectoRangoUnidadVenta() {
		return this.resaltarParametroInventarioDefectoRangoUnidadVenta;
	}

	public void setResaltarParametroInventarioDefectoRangoUnidadVenta(Border borderResaltarParametroInventarioDefecto) {
		if(borderResaltarParametroInventarioDefecto!=null) {
			this.resaltarParametroInventarioDefectoRangoUnidadVenta= borderResaltarParametroInventarioDefecto;
		}
	}

	public Border setResaltarParametroInventarioDefectoRangoUnidadVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RangoUnidadVentaBeanSwingJInternalFrame rangounidadventaBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroInventarioDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//rangounidadventaBeanSwingJInternalFrame.jTtoolBarRangoUnidadVenta.setBorder(borderResaltarParametroInventarioDefecto);
			
		this.resaltarParametroInventarioDefectoRangoUnidadVenta= borderResaltarParametroInventarioDefecto;

		 return borderResaltarParametroInventarioDefecto;
	}



	public Boolean mostrarParametroInventarioDefectoRangoUnidadVenta=true;

	public Boolean getMostrarParametroInventarioDefectoRangoUnidadVenta() {
		return this.mostrarParametroInventarioDefectoRangoUnidadVenta;
	}

	public void setMostrarParametroInventarioDefectoRangoUnidadVenta(Boolean visibilidadResaltarParametroInventarioDefecto) {
		this.mostrarParametroInventarioDefectoRangoUnidadVenta= visibilidadResaltarParametroInventarioDefecto;
	}



	public Boolean activarParametroInventarioDefectoRangoUnidadVenta=true;

	public Boolean gethabilitarResaltarParametroInventarioDefectoRangoUnidadVenta() {
		return this.activarParametroInventarioDefectoRangoUnidadVenta;
	}

	public void setActivarParametroInventarioDefectoRangoUnidadVenta(Boolean habilitarResaltarParametroInventarioDefecto) {
		this.activarParametroInventarioDefectoRangoUnidadVenta= habilitarResaltarParametroInventarioDefecto;
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

		this.setMostrarPrecioRangoUnidadVenta(esInicial);
		this.setMostrarParametroInventarioDefectoRangoUnidadVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Precio.class)) {
				this.setMostrarPrecioRangoUnidadVenta(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setMostrarParametroInventarioDefectoRangoUnidadVenta(esAsigna);
				continue;
			}
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

		this.setActivarPrecioRangoUnidadVenta(esInicial);
		this.setActivarParametroInventarioDefectoRangoUnidadVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Precio.class)) {
				this.setActivarPrecioRangoUnidadVenta(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setActivarParametroInventarioDefectoRangoUnidadVenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RangoUnidadVentaBeanSwingJInternalFrame rangounidadventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPrecioRangoUnidadVenta(esInicial);
		this.setResaltarParametroInventarioDefectoRangoUnidadVenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Precio.class)) {
				this.setResaltarPrecioRangoUnidadVenta(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroInventarioDefecto.class)) {
				this.setResaltarParametroInventarioDefectoRangoUnidadVenta(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaRangoUnidadVenta=true;

	public Boolean getMostrarFK_IdEmpresaRangoUnidadVenta() {
		return this.mostrarFK_IdEmpresaRangoUnidadVenta;
	}

	public void setMostrarFK_IdEmpresaRangoUnidadVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRangoUnidadVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadRangoUnidadVenta=true;

	public Boolean getMostrarFK_IdUnidadRangoUnidadVenta() {
		return this.mostrarFK_IdUnidadRangoUnidadVenta;
	}

	public void setMostrarFK_IdUnidadRangoUnidadVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadRangoUnidadVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaRangoUnidadVenta=true;

	public Boolean getActivarFK_IdEmpresaRangoUnidadVenta() {
		return this.activarFK_IdEmpresaRangoUnidadVenta;
	}

	public void setActivarFK_IdEmpresaRangoUnidadVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRangoUnidadVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadRangoUnidadVenta=true;

	public Boolean getActivarFK_IdUnidadRangoUnidadVenta() {
		return this.activarFK_IdUnidadRangoUnidadVenta;
	}

	public void setActivarFK_IdUnidadRangoUnidadVenta(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadRangoUnidadVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaRangoUnidadVenta=null;

	public Border getResaltarFK_IdEmpresaRangoUnidadVenta() {
		return this.resaltarFK_IdEmpresaRangoUnidadVenta;
	}

	public void setResaltarFK_IdEmpresaRangoUnidadVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRangoUnidadVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRangoUnidadVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RangoUnidadVentaBeanSwingJInternalFrame rangounidadventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRangoUnidadVenta= borderResaltar;
	}

	public Border resaltarFK_IdUnidadRangoUnidadVenta=null;

	public Border getResaltarFK_IdUnidadRangoUnidadVenta() {
		return this.resaltarFK_IdUnidadRangoUnidadVenta;
	}

	public void setResaltarFK_IdUnidadRangoUnidadVenta(Border borderResaltar) {
		this.resaltarFK_IdUnidadRangoUnidadVenta= borderResaltar;
	}

	public void setResaltarFK_IdUnidadRangoUnidadVenta(ParametroGeneralUsuario parametroGeneralUsuario/*RangoUnidadVentaBeanSwingJInternalFrame rangounidadventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadRangoUnidadVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}