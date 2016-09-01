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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.AreaConstantesFunciones;
import com.bydan.erp.contabilidad.util.AreaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.AreaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AreaConstantesFunciones extends AreaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Area";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Area"+AreaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AreaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AreaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AreaConstantesFunciones.SCHEMA+"_"+AreaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AreaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AreaConstantesFunciones.SCHEMA+"_"+AreaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AreaConstantesFunciones.SCHEMA+"_"+AreaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AreaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AreaConstantesFunciones.SCHEMA+"_"+AreaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AreaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AreaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AreaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AreaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AreaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AreaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AreaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AreaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AreaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AreaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Areas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Area";
	public static final String SCLASSWEBTITULO_LOWER="Area";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Area";
	public static final String OBJECTNAME="area";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="area";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select area from "+AreaConstantesFunciones.SPERSISTENCENAME+" area";
	public static String QUERYSELECTNATIVE="select "+AreaConstantesFunciones.SCHEMA+"."+AreaConstantesFunciones.TABLENAME+".id,"+AreaConstantesFunciones.SCHEMA+"."+AreaConstantesFunciones.TABLENAME+".version_row,"+AreaConstantesFunciones.SCHEMA+"."+AreaConstantesFunciones.TABLENAME+".id_empresa,"+AreaConstantesFunciones.SCHEMA+"."+AreaConstantesFunciones.TABLENAME+".id_empleado,"+AreaConstantesFunciones.SCHEMA+"."+AreaConstantesFunciones.TABLENAME+".id_empleado_sustituto,"+AreaConstantesFunciones.SCHEMA+"."+AreaConstantesFunciones.TABLENAME+".codigo,"+AreaConstantesFunciones.SCHEMA+"."+AreaConstantesFunciones.TABLENAME+".nombre,"+AreaConstantesFunciones.SCHEMA+"."+AreaConstantesFunciones.TABLENAME+".secuencial_pedido,"+AreaConstantesFunciones.SCHEMA+"."+AreaConstantesFunciones.TABLENAME+".secuencial_cotizacion from "+AreaConstantesFunciones.SCHEMA+"."+AreaConstantesFunciones.TABLENAME;//+" as "+AreaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AreaConstantesFuncionesAdditional areaConstantesFuncionesAdditional=null;
	
	public AreaConstantesFuncionesAdditional getAreaConstantesFuncionesAdditional() {
		return this.areaConstantesFuncionesAdditional;
	}
	
	public void setAreaConstantesFuncionesAdditional(AreaConstantesFuncionesAdditional areaConstantesFuncionesAdditional) {
		try {
			this.areaConstantesFuncionesAdditional=areaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDEMPLEADOSUSTITUTO= "id_empleado_sustituto";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String SECUENCIALPEDIDO= "secuencial_pedido";
    public static final String SECUENCIALCOTIZACION= "secuencial_cotizacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDEMPLEADOSUSTITUTO= "Empleado Sustituto";
		public static final String LABEL_IDEMPLEADOSUSTITUTO_LOWER= "Empleado Sustituto";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SECUENCIALPEDIDO= "Secuencial Pedido";
		public static final String LABEL_SECUENCIALPEDIDO_LOWER= "Secuencial Pedido";
    	public static final String LABEL_SECUENCIALCOTIZACION= "Secuencial Cotizacion";
		public static final String LABEL_SECUENCIALCOTIZACION_LOWER= "Secuencial Cotizacion";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL_PEDIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL_PEDIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL_COTIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL_COTIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getAreaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AreaConstantesFunciones.IDEMPRESA)) {sLabelColumna=AreaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AreaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=AreaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(AreaConstantesFunciones.IDEMPLEADOSUSTITUTO)) {sLabelColumna=AreaConstantesFunciones.LABEL_IDEMPLEADOSUSTITUTO;}
		if(sNombreColumna.equals(AreaConstantesFunciones.CODIGO)) {sLabelColumna=AreaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(AreaConstantesFunciones.NOMBRE)) {sLabelColumna=AreaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(AreaConstantesFunciones.SECUENCIALPEDIDO)) {sLabelColumna=AreaConstantesFunciones.LABEL_SECUENCIALPEDIDO;}
		if(sNombreColumna.equals(AreaConstantesFunciones.SECUENCIALCOTIZACION)) {sLabelColumna=AreaConstantesFunciones.LABEL_SECUENCIALCOTIZACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getAreaDescripcion(Area area) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(area !=null/* && area.getId()!=0*/) {
			sDescripcion=area.getcodigo();//areaarea.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAreaDescripcionDetallado(Area area) {
		String sDescripcion="";
			
		sDescripcion+=AreaConstantesFunciones.ID+"=";
		sDescripcion+=area.getId().toString()+",";
		sDescripcion+=AreaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=area.getVersionRow().toString()+",";
		sDescripcion+=AreaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=area.getid_empresa().toString()+",";
		sDescripcion+=AreaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=area.getid_empleado().toString()+",";
		sDescripcion+=AreaConstantesFunciones.IDEMPLEADOSUSTITUTO+"=";
		sDescripcion+=area.getid_empleado_sustituto().toString()+",";
		sDescripcion+=AreaConstantesFunciones.CODIGO+"=";
		sDescripcion+=area.getcodigo()+",";
		sDescripcion+=AreaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=area.getnombre()+",";
		sDescripcion+=AreaConstantesFunciones.SECUENCIALPEDIDO+"=";
		sDescripcion+=area.getsecuencial_pedido()+",";
		sDescripcion+=AreaConstantesFunciones.SECUENCIALCOTIZACION+"=";
		sDescripcion+=area.getsecuencial_cotizacion()+",";
			
		return sDescripcion;
	}
	
	public static void setAreaDescripcion(Area area,String sValor) throws Exception {			
		if(area !=null) {
			area.setcodigo(sValor);;//areaarea.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getEmpleadoSustitutoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpleadoSustituto")) {
			sNombreIndice="Tipo=  Por Empleado Sustituto";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleadoSustituto(Long id_empleado_sustituto) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado_sustituto!=null) {sDetalleIndice+=" Codigo Unico De Empleado Sustituto="+id_empleado_sustituto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosArea(Area area,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		area.setcodigo(area.getcodigo().trim());
		area.setnombre(area.getnombre().trim());
		area.setsecuencial_pedido(area.getsecuencial_pedido().trim());
		area.setsecuencial_cotizacion(area.getsecuencial_cotizacion().trim());
	}
	
	public static void quitarEspaciosAreas(List<Area> areas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Area area: areas) {
			area.setcodigo(area.getcodigo().trim());
			area.setnombre(area.getnombre().trim());
			area.setsecuencial_pedido(area.getsecuencial_pedido().trim());
			area.setsecuencial_cotizacion(area.getsecuencial_cotizacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresArea(Area area,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && area.getConCambioAuxiliar()) {
			area.setIsDeleted(area.getIsDeletedAuxiliar());	
			area.setIsNew(area.getIsNewAuxiliar());	
			area.setIsChanged(area.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			area.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			area.setIsDeletedAuxiliar(false);	
			area.setIsNewAuxiliar(false);	
			area.setIsChangedAuxiliar(false);
			
			area.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAreas(List<Area> areas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Area area : areas) {
			if(conAsignarBase && area.getConCambioAuxiliar()) {
				area.setIsDeleted(area.getIsDeletedAuxiliar());	
				area.setIsNew(area.getIsNewAuxiliar());	
				area.setIsChanged(area.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				area.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				area.setIsDeletedAuxiliar(false);	
				area.setIsNewAuxiliar(false);	
				area.setIsChangedAuxiliar(false);
				
				area.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresArea(Area area,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAreas(List<Area> areas,Boolean conEnteros) throws Exception  {
		
		for(Area area: areas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaArea(List<Area> areas,Area areaAux) throws Exception  {
		AreaConstantesFunciones.InicializarValoresArea(areaAux,true);
		
		for(Area area: areas) {
			if(area.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesArea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AreaConstantesFunciones.getArrayColumnasGlobalesArea(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesArea(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AreaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AreaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoArea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Area> areas,Area area,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Area areaAux: areas) {
			if(areaAux!=null && area!=null) {
				if((areaAux.getId()==null && area.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(areaAux.getId()!=null && area.getId()!=null){
					if(areaAux.getId().equals(area.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaArea(List<Area> areas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Area area: areas) {			
			if(area.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaArea() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AreaConstantesFunciones.LABEL_ID, AreaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaConstantesFunciones.LABEL_VERSIONROW, AreaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaConstantesFunciones.LABEL_IDEMPRESA, AreaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaConstantesFunciones.LABEL_IDEMPLEADO, AreaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaConstantesFunciones.LABEL_IDEMPLEADOSUSTITUTO, AreaConstantesFunciones.IDEMPLEADOSUSTITUTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaConstantesFunciones.LABEL_CODIGO, AreaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaConstantesFunciones.LABEL_NOMBRE, AreaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaConstantesFunciones.LABEL_SECUENCIALPEDIDO, AreaConstantesFunciones.SECUENCIALPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AreaConstantesFunciones.LABEL_SECUENCIALCOTIZACION, AreaConstantesFunciones.SECUENCIALCOTIZACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasArea() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AreaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaConstantesFunciones.IDEMPLEADOSUSTITUTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaConstantesFunciones.SECUENCIALPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AreaConstantesFunciones.SECUENCIALCOTIZACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarArea() throws Exception  {
		return AreaConstantesFunciones.getTiposSeleccionarArea(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarArea(Boolean conFk) throws Exception  {
		return AreaConstantesFunciones.getTiposSeleccionarArea(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarArea(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AreaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AreaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AreaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(AreaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AreaConstantesFunciones.LABEL_IDEMPLEADOSUSTITUTO);
			reporte.setsDescripcion(AreaConstantesFunciones.LABEL_IDEMPLEADOSUSTITUTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AreaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(AreaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AreaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(AreaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AreaConstantesFunciones.LABEL_SECUENCIALPEDIDO);
			reporte.setsDescripcion(AreaConstantesFunciones.LABEL_SECUENCIALPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AreaConstantesFunciones.LABEL_SECUENCIALCOTIZACION);
			reporte.setsDescripcion(AreaConstantesFunciones.LABEL_SECUENCIALCOTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesArea(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesArea(Area areaAux) throws Exception {
		
			areaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(areaAux.getEmpresa()));
			areaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(areaAux.getEmpleado()));
			areaAux.setempleadosustituto_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(areaAux.getEmpleadoSustituto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesArea(List<Area> areasTemp) throws Exception {
		for(Area areaAux:areasTemp) {
			
			areaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(areaAux.getEmpresa()));
			areaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(areaAux.getEmpleado()));
			areaAux.setempleadosustituto_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(areaAux.getEmpleadoSustituto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfArea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfArea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfArea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AreaConstantesFunciones.getClassesRelationshipsOfArea(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfArea(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfArea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AreaConstantesFunciones.getClassesRelationshipsFromStringsOfArea(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfArea(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Area area,List<Area> areas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Area areaEncontrado=null;
			
			for(Area areaLocal:areas) {
				if(areaLocal.getId().equals(area.getId())) {
					areaEncontrado=areaLocal;
					
					areaLocal.setIsChanged(area.getIsChanged());
					areaLocal.setIsNew(area.getIsNew());
					areaLocal.setIsDeleted(area.getIsDeleted());
					
					areaLocal.setGeneralEntityOriginal(area.getGeneralEntityOriginal());
					
					areaLocal.setId(area.getId());	
					areaLocal.setVersionRow(area.getVersionRow());	
					areaLocal.setid_empresa(area.getid_empresa());	
					areaLocal.setid_empleado(area.getid_empleado());	
					areaLocal.setid_empleado_sustituto(area.getid_empleado_sustituto());	
					areaLocal.setcodigo(area.getcodigo());	
					areaLocal.setnombre(area.getnombre());	
					areaLocal.setsecuencial_pedido(area.getsecuencial_pedido());	
					areaLocal.setsecuencial_cotizacion(area.getsecuencial_cotizacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!area.getIsDeleted()) {
				if(!existe) {
					areas.add(area);
				}
			} else {
				if(areaEncontrado!=null && permiteQuitar)  {
					areas.remove(areaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Area area,List<Area> areas) throws Exception {
		try	{			
			for(Area areaLocal:areas) {
				if(areaLocal.getId().equals(area.getId())) {
					areaLocal.setIsSelected(area.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesArea(List<Area> areasAux) throws Exception {
		//this.areasAux=areasAux;
		
		for(Area areaAux:areasAux) {
			if(areaAux.getIsChanged()) {
				areaAux.setIsChanged(false);
			}		
			
			if(areaAux.getIsNew()) {
				areaAux.setIsNew(false);
			}	
			
			if(areaAux.getIsDeleted()) {
				areaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesArea(Area areaAux) throws Exception {
		//this.areaAux=areaAux;
		
			if(areaAux.getIsChanged()) {
				areaAux.setIsChanged(false);
			}		
			
			if(areaAux.getIsNew()) {
				areaAux.setIsNew(false);
			}	
			
			if(areaAux.getIsDeleted()) {
				areaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Area areaAsignar,Area area) throws Exception {
		areaAsignar.setId(area.getId());	
		areaAsignar.setVersionRow(area.getVersionRow());	
		areaAsignar.setid_empresa(area.getid_empresa());
		areaAsignar.setempresa_descripcion(area.getempresa_descripcion());	
		areaAsignar.setid_empleado(area.getid_empleado());
		areaAsignar.setempleado_descripcion(area.getempleado_descripcion());	
		areaAsignar.setid_empleado_sustituto(area.getid_empleado_sustituto());
		areaAsignar.setempleadosustituto_descripcion(area.getempleadosustituto_descripcion());	
		areaAsignar.setcodigo(area.getcodigo());	
		areaAsignar.setnombre(area.getnombre());	
		areaAsignar.setsecuencial_pedido(area.getsecuencial_pedido());	
		areaAsignar.setsecuencial_cotizacion(area.getsecuencial_cotizacion());	
	}
	
	public static void inicializarArea(Area area) throws Exception {
		try {
				area.setId(0L);	
					
				area.setid_empresa(-1L);	
				area.setid_empleado(-1L);	
				area.setid_empleado_sustituto(-1L);	
				area.setcodigo("");	
				area.setnombre("");	
				area.setsecuencial_pedido("");	
				area.setsecuencial_cotizacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderArea(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AreaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AreaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AreaConstantesFunciones.LABEL_IDEMPLEADOSUSTITUTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AreaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AreaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AreaConstantesFunciones.LABEL_SECUENCIALPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AreaConstantesFunciones.LABEL_SECUENCIALCOTIZACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataArea(String sTipo,Row row,Workbook workbook,Area area,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(area.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(area.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(area.getempleadosustituto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(area.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(area.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(area.getsecuencial_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(area.getsecuencial_cotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryArea=Constantes.SFINALQUERY;
	
	public String getsFinalQueryArea() {
		return this.sFinalQueryArea;
	}
	
	public void setsFinalQueryArea(String sFinalQueryArea) {
		this.sFinalQueryArea= sFinalQueryArea;
	}
	
	public Border resaltarSeleccionarArea=null;
	
	public Border setResaltarSeleccionarArea(ParametroGeneralUsuario parametroGeneralUsuario/*AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//areaBeanSwingJInternalFrame.jTtoolBarArea.setBorder(borderResaltar);
		
		this.resaltarSeleccionarArea= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarArea() {
		return this.resaltarSeleccionarArea;
	}
	
	public void setResaltarSeleccionarArea(Border borderResaltarSeleccionarArea) {
		this.resaltarSeleccionarArea= borderResaltarSeleccionarArea;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridArea=null;
	public Boolean mostraridArea=true;
	public Boolean activaridArea=true;

	public Border resaltarid_empresaArea=null;
	public Boolean mostrarid_empresaArea=true;
	public Boolean activarid_empresaArea=true;
	public Boolean cargarid_empresaArea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaArea=false;//ConEventDepend=true

	public Border resaltarid_empleadoArea=null;
	public Boolean mostrarid_empleadoArea=true;
	public Boolean activarid_empleadoArea=true;
	public Boolean cargarid_empleadoArea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoArea=false;//ConEventDepend=true

	public Border resaltarid_empleado_sustitutoArea=null;
	public Boolean mostrarid_empleado_sustitutoArea=true;
	public Boolean activarid_empleado_sustitutoArea=true;
	public Boolean cargarid_empleado_sustitutoArea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_sustitutoArea=false;//ConEventDepend=true

	public Border resaltarcodigoArea=null;
	public Boolean mostrarcodigoArea=true;
	public Boolean activarcodigoArea=true;

	public Border resaltarnombreArea=null;
	public Boolean mostrarnombreArea=true;
	public Boolean activarnombreArea=true;

	public Border resaltarsecuencial_pedidoArea=null;
	public Boolean mostrarsecuencial_pedidoArea=true;
	public Boolean activarsecuencial_pedidoArea=true;

	public Border resaltarsecuencial_cotizacionArea=null;
	public Boolean mostrarsecuencial_cotizacionArea=true;
	public Boolean activarsecuencial_cotizacionArea=true;

	
	

	public Border setResaltaridArea(ParametroGeneralUsuario parametroGeneralUsuario/*AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areaBeanSwingJInternalFrame.jTtoolBarArea.setBorder(borderResaltar);
		
		this.resaltaridArea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridArea() {
		return this.resaltaridArea;
	}

	public void setResaltaridArea(Border borderResaltar) {
		this.resaltaridArea= borderResaltar;
	}

	public Boolean getMostraridArea() {
		return this.mostraridArea;
	}

	public void setMostraridArea(Boolean mostraridArea) {
		this.mostraridArea= mostraridArea;
	}

	public Boolean getActivaridArea() {
		return this.activaridArea;
	}

	public void setActivaridArea(Boolean activaridArea) {
		this.activaridArea= activaridArea;
	}

	public Border setResaltarid_empresaArea(ParametroGeneralUsuario parametroGeneralUsuario/*AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areaBeanSwingJInternalFrame.jTtoolBarArea.setBorder(borderResaltar);
		
		this.resaltarid_empresaArea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaArea() {
		return this.resaltarid_empresaArea;
	}

	public void setResaltarid_empresaArea(Border borderResaltar) {
		this.resaltarid_empresaArea= borderResaltar;
	}

	public Boolean getMostrarid_empresaArea() {
		return this.mostrarid_empresaArea;
	}

	public void setMostrarid_empresaArea(Boolean mostrarid_empresaArea) {
		this.mostrarid_empresaArea= mostrarid_empresaArea;
	}

	public Boolean getActivarid_empresaArea() {
		return this.activarid_empresaArea;
	}

	public void setActivarid_empresaArea(Boolean activarid_empresaArea) {
		this.activarid_empresaArea= activarid_empresaArea;
	}

	public Boolean getCargarid_empresaArea() {
		return this.cargarid_empresaArea;
	}

	public void setCargarid_empresaArea(Boolean cargarid_empresaArea) {
		this.cargarid_empresaArea= cargarid_empresaArea;
	}

	public Border setResaltarid_empleadoArea(ParametroGeneralUsuario parametroGeneralUsuario/*AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areaBeanSwingJInternalFrame.jTtoolBarArea.setBorder(borderResaltar);
		
		this.resaltarid_empleadoArea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoArea() {
		return this.resaltarid_empleadoArea;
	}

	public void setResaltarid_empleadoArea(Border borderResaltar) {
		this.resaltarid_empleadoArea= borderResaltar;
	}

	public Boolean getMostrarid_empleadoArea() {
		return this.mostrarid_empleadoArea;
	}

	public void setMostrarid_empleadoArea(Boolean mostrarid_empleadoArea) {
		this.mostrarid_empleadoArea= mostrarid_empleadoArea;
	}

	public Boolean getActivarid_empleadoArea() {
		return this.activarid_empleadoArea;
	}

	public void setActivarid_empleadoArea(Boolean activarid_empleadoArea) {
		this.activarid_empleadoArea= activarid_empleadoArea;
	}

	public Boolean getCargarid_empleadoArea() {
		return this.cargarid_empleadoArea;
	}

	public void setCargarid_empleadoArea(Boolean cargarid_empleadoArea) {
		this.cargarid_empleadoArea= cargarid_empleadoArea;
	}

	public Border setResaltarid_empleado_sustitutoArea(ParametroGeneralUsuario parametroGeneralUsuario/*AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areaBeanSwingJInternalFrame.jTtoolBarArea.setBorder(borderResaltar);
		
		this.resaltarid_empleado_sustitutoArea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_sustitutoArea() {
		return this.resaltarid_empleado_sustitutoArea;
	}

	public void setResaltarid_empleado_sustitutoArea(Border borderResaltar) {
		this.resaltarid_empleado_sustitutoArea= borderResaltar;
	}

	public Boolean getMostrarid_empleado_sustitutoArea() {
		return this.mostrarid_empleado_sustitutoArea;
	}

	public void setMostrarid_empleado_sustitutoArea(Boolean mostrarid_empleado_sustitutoArea) {
		this.mostrarid_empleado_sustitutoArea= mostrarid_empleado_sustitutoArea;
	}

	public Boolean getActivarid_empleado_sustitutoArea() {
		return this.activarid_empleado_sustitutoArea;
	}

	public void setActivarid_empleado_sustitutoArea(Boolean activarid_empleado_sustitutoArea) {
		this.activarid_empleado_sustitutoArea= activarid_empleado_sustitutoArea;
	}

	public Boolean getCargarid_empleado_sustitutoArea() {
		return this.cargarid_empleado_sustitutoArea;
	}

	public void setCargarid_empleado_sustitutoArea(Boolean cargarid_empleado_sustitutoArea) {
		this.cargarid_empleado_sustitutoArea= cargarid_empleado_sustitutoArea;
	}

	public Border setResaltarcodigoArea(ParametroGeneralUsuario parametroGeneralUsuario/*AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areaBeanSwingJInternalFrame.jTtoolBarArea.setBorder(borderResaltar);
		
		this.resaltarcodigoArea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoArea() {
		return this.resaltarcodigoArea;
	}

	public void setResaltarcodigoArea(Border borderResaltar) {
		this.resaltarcodigoArea= borderResaltar;
	}

	public Boolean getMostrarcodigoArea() {
		return this.mostrarcodigoArea;
	}

	public void setMostrarcodigoArea(Boolean mostrarcodigoArea) {
		this.mostrarcodigoArea= mostrarcodigoArea;
	}

	public Boolean getActivarcodigoArea() {
		return this.activarcodigoArea;
	}

	public void setActivarcodigoArea(Boolean activarcodigoArea) {
		this.activarcodigoArea= activarcodigoArea;
	}

	public Border setResaltarnombreArea(ParametroGeneralUsuario parametroGeneralUsuario/*AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areaBeanSwingJInternalFrame.jTtoolBarArea.setBorder(borderResaltar);
		
		this.resaltarnombreArea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreArea() {
		return this.resaltarnombreArea;
	}

	public void setResaltarnombreArea(Border borderResaltar) {
		this.resaltarnombreArea= borderResaltar;
	}

	public Boolean getMostrarnombreArea() {
		return this.mostrarnombreArea;
	}

	public void setMostrarnombreArea(Boolean mostrarnombreArea) {
		this.mostrarnombreArea= mostrarnombreArea;
	}

	public Boolean getActivarnombreArea() {
		return this.activarnombreArea;
	}

	public void setActivarnombreArea(Boolean activarnombreArea) {
		this.activarnombreArea= activarnombreArea;
	}

	public Border setResaltarsecuencial_pedidoArea(ParametroGeneralUsuario parametroGeneralUsuario/*AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areaBeanSwingJInternalFrame.jTtoolBarArea.setBorder(borderResaltar);
		
		this.resaltarsecuencial_pedidoArea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_pedidoArea() {
		return this.resaltarsecuencial_pedidoArea;
	}

	public void setResaltarsecuencial_pedidoArea(Border borderResaltar) {
		this.resaltarsecuencial_pedidoArea= borderResaltar;
	}

	public Boolean getMostrarsecuencial_pedidoArea() {
		return this.mostrarsecuencial_pedidoArea;
	}

	public void setMostrarsecuencial_pedidoArea(Boolean mostrarsecuencial_pedidoArea) {
		this.mostrarsecuencial_pedidoArea= mostrarsecuencial_pedidoArea;
	}

	public Boolean getActivarsecuencial_pedidoArea() {
		return this.activarsecuencial_pedidoArea;
	}

	public void setActivarsecuencial_pedidoArea(Boolean activarsecuencial_pedidoArea) {
		this.activarsecuencial_pedidoArea= activarsecuencial_pedidoArea;
	}

	public Border setResaltarsecuencial_cotizacionArea(ParametroGeneralUsuario parametroGeneralUsuario/*AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//areaBeanSwingJInternalFrame.jTtoolBarArea.setBorder(borderResaltar);
		
		this.resaltarsecuencial_cotizacionArea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencial_cotizacionArea() {
		return this.resaltarsecuencial_cotizacionArea;
	}

	public void setResaltarsecuencial_cotizacionArea(Border borderResaltar) {
		this.resaltarsecuencial_cotizacionArea= borderResaltar;
	}

	public Boolean getMostrarsecuencial_cotizacionArea() {
		return this.mostrarsecuencial_cotizacionArea;
	}

	public void setMostrarsecuencial_cotizacionArea(Boolean mostrarsecuencial_cotizacionArea) {
		this.mostrarsecuencial_cotizacionArea= mostrarsecuencial_cotizacionArea;
	}

	public Boolean getActivarsecuencial_cotizacionArea() {
		return this.activarsecuencial_cotizacionArea;
	}

	public void setActivarsecuencial_cotizacionArea(Boolean activarsecuencial_cotizacionArea) {
		this.activarsecuencial_cotizacionArea= activarsecuencial_cotizacionArea;
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
		
		
		this.setMostraridArea(esInicial);
		this.setMostrarid_empresaArea(esInicial);
		this.setMostrarid_empleadoArea(esInicial);
		this.setMostrarid_empleado_sustitutoArea(esInicial);
		this.setMostrarcodigoArea(esInicial);
		this.setMostrarnombreArea(esInicial);
		this.setMostrarsecuencial_pedidoArea(esInicial);
		this.setMostrarsecuencial_cotizacionArea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AreaConstantesFunciones.ID)) {
				this.setMostraridArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.IDEMPLEADOSUSTITUTO)) {
				this.setMostrarid_empleado_sustitutoArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.SECUENCIALPEDIDO)) {
				this.setMostrarsecuencial_pedidoArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.SECUENCIALCOTIZACION)) {
				this.setMostrarsecuencial_cotizacionArea(esAsigna);
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
		
		
		this.setActivaridArea(esInicial);
		this.setActivarid_empresaArea(esInicial);
		this.setActivarid_empleadoArea(esInicial);
		this.setActivarid_empleado_sustitutoArea(esInicial);
		this.setActivarcodigoArea(esInicial);
		this.setActivarnombreArea(esInicial);
		this.setActivarsecuencial_pedidoArea(esInicial);
		this.setActivarsecuencial_cotizacionArea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AreaConstantesFunciones.ID)) {
				this.setActivaridArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.IDEMPLEADOSUSTITUTO)) {
				this.setActivarid_empleado_sustitutoArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.SECUENCIALPEDIDO)) {
				this.setActivarsecuencial_pedidoArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.SECUENCIALCOTIZACION)) {
				this.setActivarsecuencial_cotizacionArea(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridArea(esInicial);
		this.setResaltarid_empresaArea(esInicial);
		this.setResaltarid_empleadoArea(esInicial);
		this.setResaltarid_empleado_sustitutoArea(esInicial);
		this.setResaltarcodigoArea(esInicial);
		this.setResaltarnombreArea(esInicial);
		this.setResaltarsecuencial_pedidoArea(esInicial);
		this.setResaltarsecuencial_cotizacionArea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AreaConstantesFunciones.ID)) {
				this.setResaltaridArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.IDEMPLEADOSUSTITUTO)) {
				this.setResaltarid_empleado_sustitutoArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.SECUENCIALPEDIDO)) {
				this.setResaltarsecuencial_pedidoArea(esAsigna);
				continue;
			}

			if(campo.clase.equals(AreaConstantesFunciones.SECUENCIALCOTIZACION)) {
				this.setResaltarsecuencial_cotizacionArea(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoArea=true;

	public Boolean getMostrarFK_IdEmpleadoArea() {
		return this.mostrarFK_IdEmpleadoArea;
	}

	public void setMostrarFK_IdEmpleadoArea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoArea= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoSustitutoArea=true;

	public Boolean getMostrarFK_IdEmpleadoSustitutoArea() {
		return this.mostrarFK_IdEmpleadoSustitutoArea;
	}

	public void setMostrarFK_IdEmpleadoSustitutoArea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoSustitutoArea= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaArea=true;

	public Boolean getMostrarFK_IdEmpresaArea() {
		return this.mostrarFK_IdEmpresaArea;
	}

	public void setMostrarFK_IdEmpresaArea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaArea= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoArea=true;

	public Boolean getActivarFK_IdEmpleadoArea() {
		return this.activarFK_IdEmpleadoArea;
	}

	public void setActivarFK_IdEmpleadoArea(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoArea= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoSustitutoArea=true;

	public Boolean getActivarFK_IdEmpleadoSustitutoArea() {
		return this.activarFK_IdEmpleadoSustitutoArea;
	}

	public void setActivarFK_IdEmpleadoSustitutoArea(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoSustitutoArea= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaArea=true;

	public Boolean getActivarFK_IdEmpresaArea() {
		return this.activarFK_IdEmpresaArea;
	}

	public void setActivarFK_IdEmpresaArea(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaArea= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoArea=null;

	public Border getResaltarFK_IdEmpleadoArea() {
		return this.resaltarFK_IdEmpleadoArea;
	}

	public void setResaltarFK_IdEmpleadoArea(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoArea= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoArea(ParametroGeneralUsuario parametroGeneralUsuario/*AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoArea= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoSustitutoArea=null;

	public Border getResaltarFK_IdEmpleadoSustitutoArea() {
		return this.resaltarFK_IdEmpleadoSustitutoArea;
	}

	public void setResaltarFK_IdEmpleadoSustitutoArea(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoSustitutoArea= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoSustitutoArea(ParametroGeneralUsuario parametroGeneralUsuario/*AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoSustitutoArea= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaArea=null;

	public Border getResaltarFK_IdEmpresaArea() {
		return this.resaltarFK_IdEmpresaArea;
	}

	public void setResaltarFK_IdEmpresaArea(Border borderResaltar) {
		this.resaltarFK_IdEmpresaArea= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaArea(ParametroGeneralUsuario parametroGeneralUsuario/*AreaBeanSwingJInternalFrame areaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaArea= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}