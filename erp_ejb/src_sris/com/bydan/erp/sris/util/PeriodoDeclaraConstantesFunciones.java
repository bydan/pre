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
package com.bydan.erp.sris.util;

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


import com.bydan.erp.sris.util.PeriodoDeclaraConstantesFunciones;
import com.bydan.erp.sris.util.PeriodoDeclaraParameterReturnGeneral;
//import com.bydan.erp.sris.util.PeriodoDeclaraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PeriodoDeclaraConstantesFunciones extends PeriodoDeclaraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PeriodoDeclara";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PeriodoDeclara"+PeriodoDeclaraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PeriodoDeclaraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PeriodoDeclaraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PeriodoDeclaraConstantesFunciones.SCHEMA+"_"+PeriodoDeclaraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PeriodoDeclaraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PeriodoDeclaraConstantesFunciones.SCHEMA+"_"+PeriodoDeclaraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PeriodoDeclaraConstantesFunciones.SCHEMA+"_"+PeriodoDeclaraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PeriodoDeclaraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PeriodoDeclaraConstantesFunciones.SCHEMA+"_"+PeriodoDeclaraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoDeclaraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PeriodoDeclaraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoDeclaraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoDeclaraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PeriodoDeclaraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PeriodoDeclaraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PeriodoDeclaraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PeriodoDeclaraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PeriodoDeclaraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PeriodoDeclaraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Periodo Declaras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Periodo Declara";
	public static final String SCLASSWEBTITULO_LOWER="Periodo Declara";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PeriodoDeclara";
	public static final String OBJECTNAME="periododeclara";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="periodo_declara";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select periododeclara from "+PeriodoDeclaraConstantesFunciones.SPERSISTENCENAME+" periododeclara";
	public static String QUERYSELECTNATIVE="select "+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".id,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".version_row,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".codigo,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".id_anio,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".id_mes,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".fecha,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".esta_activo from "+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME;//+" as "+PeriodoDeclaraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PeriodoDeclaraConstantesFuncionesAdditional periododeclaraConstantesFuncionesAdditional=null;
	
	public PeriodoDeclaraConstantesFuncionesAdditional getPeriodoDeclaraConstantesFuncionesAdditional() {
		return this.periododeclaraConstantesFuncionesAdditional;
	}
	
	public void setPeriodoDeclaraConstantesFuncionesAdditional(PeriodoDeclaraConstantesFuncionesAdditional periododeclaraConstantesFuncionesAdditional) {
		try {
			this.periododeclaraConstantesFuncionesAdditional=periododeclaraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String FECHA= "fecha";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getPeriodoDeclaraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PeriodoDeclaraConstantesFunciones.CODIGO)) {sLabelColumna=PeriodoDeclaraConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PeriodoDeclaraConstantesFunciones.IDANIO)) {sLabelColumna=PeriodoDeclaraConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(PeriodoDeclaraConstantesFunciones.IDMES)) {sLabelColumna=PeriodoDeclaraConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(PeriodoDeclaraConstantesFunciones.FECHA)) {sLabelColumna=PeriodoDeclaraConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PeriodoDeclaraConstantesFunciones.ESTAACTIVO)) {sLabelColumna=PeriodoDeclaraConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(PeriodoDeclara periododeclara) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!periododeclara.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(PeriodoDeclara periododeclara) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(periododeclara.getId(),periododeclara.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getPeriodoDeclaraDescripcion(PeriodoDeclara periododeclara) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(periododeclara !=null/* && periododeclara.getId()!=0*/) {
			sDescripcion=periododeclara.getcodigo()+"-"+periododeclara.getid_anio().toString()+"-"+periododeclara.getid_mes().toString();//periododeclaraperiododeclara.getcodigo().trim()+"-"+periododeclara.getid_anio().toString().trim()+"-"+periododeclara.getid_mes().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPeriodoDeclaraDescripcionDetallado(PeriodoDeclara periododeclara) {
		String sDescripcion="";
			
		sDescripcion+=PeriodoDeclaraConstantesFunciones.ID+"=";
		sDescripcion+=periododeclara.getId().toString()+",";
		sDescripcion+=PeriodoDeclaraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=periododeclara.getVersionRow().toString()+",";
		sDescripcion+=PeriodoDeclaraConstantesFunciones.CODIGO+"=";
		sDescripcion+=periododeclara.getcodigo()+",";
		sDescripcion+=PeriodoDeclaraConstantesFunciones.IDANIO+"=";
		sDescripcion+=periododeclara.getid_anio().toString()+",";
		sDescripcion+=PeriodoDeclaraConstantesFunciones.IDMES+"=";
		sDescripcion+=periododeclara.getid_mes().toString()+",";
		sDescripcion+=PeriodoDeclaraConstantesFunciones.FECHA+"=";
		sDescripcion+=periododeclara.getfecha().toString()+",";
		sDescripcion+=PeriodoDeclaraConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=periododeclara.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPeriodoDeclaraDescripcion(PeriodoDeclara periododeclara,String sValor) throws Exception {			
		if(periododeclara !=null) {
			periododeclara.setcodigo(sValor);

;//periododeclaraperiododeclara.getcodigo().trim()+"-"+periododeclara.getid_anio().toString().trim()+"-"+periododeclara.getid_mes().toString().trim();
		}		
	}
	
		

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPeriodoDeclara(PeriodoDeclara periododeclara,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		periododeclara.setcodigo(periododeclara.getcodigo().trim());
	}
	
	public static void quitarEspaciosPeriodoDeclaras(List<PeriodoDeclara> periododeclaras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PeriodoDeclara periododeclara: periododeclaras) {
			periododeclara.setcodigo(periododeclara.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPeriodoDeclara(PeriodoDeclara periododeclara,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && periododeclara.getConCambioAuxiliar()) {
			periododeclara.setIsDeleted(periododeclara.getIsDeletedAuxiliar());	
			periododeclara.setIsNew(periododeclara.getIsNewAuxiliar());	
			periododeclara.setIsChanged(periododeclara.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			periododeclara.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			periododeclara.setIsDeletedAuxiliar(false);	
			periododeclara.setIsNewAuxiliar(false);	
			periododeclara.setIsChangedAuxiliar(false);
			
			periododeclara.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPeriodoDeclaras(List<PeriodoDeclara> periododeclaras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PeriodoDeclara periododeclara : periododeclaras) {
			if(conAsignarBase && periododeclara.getConCambioAuxiliar()) {
				periododeclara.setIsDeleted(periododeclara.getIsDeletedAuxiliar());	
				periododeclara.setIsNew(periododeclara.getIsNewAuxiliar());	
				periododeclara.setIsChanged(periododeclara.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				periododeclara.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				periododeclara.setIsDeletedAuxiliar(false);	
				periododeclara.setIsNewAuxiliar(false);	
				periododeclara.setIsChangedAuxiliar(false);
				
				periododeclara.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPeriodoDeclara(PeriodoDeclara periododeclara,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPeriodoDeclaras(List<PeriodoDeclara> periododeclaras,Boolean conEnteros) throws Exception  {
		
		for(PeriodoDeclara periododeclara: periododeclaras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPeriodoDeclara(List<PeriodoDeclara> periododeclaras,PeriodoDeclara periododeclaraAux) throws Exception  {
		PeriodoDeclaraConstantesFunciones.InicializarValoresPeriodoDeclara(periododeclaraAux,true);
		
		for(PeriodoDeclara periododeclara: periododeclaras) {
			if(periododeclara.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPeriodoDeclara(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PeriodoDeclaraConstantesFunciones.getArrayColumnasGlobalesPeriodoDeclara(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPeriodoDeclara(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPeriodoDeclara(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PeriodoDeclara> periododeclaras,PeriodoDeclara periododeclara,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PeriodoDeclara periododeclaraAux: periododeclaras) {
			if(periododeclaraAux!=null && periododeclara!=null) {
				if((periododeclaraAux.getId()==null && periododeclara.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(periododeclaraAux.getId()!=null && periododeclara.getId()!=null){
					if(periododeclaraAux.getId().equals(periododeclara.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPeriodoDeclara(List<PeriodoDeclara> periododeclaras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PeriodoDeclara periododeclara: periododeclaras) {			
			if(periododeclara.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPeriodoDeclara() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PeriodoDeclaraConstantesFunciones.LABEL_ID, PeriodoDeclaraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoDeclaraConstantesFunciones.LABEL_VERSIONROW, PeriodoDeclaraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoDeclaraConstantesFunciones.LABEL_CODIGO, PeriodoDeclaraConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoDeclaraConstantesFunciones.LABEL_IDANIO, PeriodoDeclaraConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoDeclaraConstantesFunciones.LABEL_IDMES, PeriodoDeclaraConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoDeclaraConstantesFunciones.LABEL_FECHA, PeriodoDeclaraConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PeriodoDeclaraConstantesFunciones.LABEL_ESTAACTIVO, PeriodoDeclaraConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPeriodoDeclara() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PeriodoDeclaraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoDeclaraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoDeclaraConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoDeclaraConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoDeclaraConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoDeclaraConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PeriodoDeclaraConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPeriodoDeclara() throws Exception  {
		return PeriodoDeclaraConstantesFunciones.getTiposSeleccionarPeriodoDeclara(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPeriodoDeclara(Boolean conFk) throws Exception  {
		return PeriodoDeclaraConstantesFunciones.getTiposSeleccionarPeriodoDeclara(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPeriodoDeclara(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoDeclaraConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PeriodoDeclaraConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoDeclaraConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(PeriodoDeclaraConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoDeclaraConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(PeriodoDeclaraConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoDeclaraConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PeriodoDeclaraConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PeriodoDeclaraConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(PeriodoDeclaraConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPeriodoDeclara(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPeriodoDeclara(PeriodoDeclara periododeclaraAux) throws Exception {
		
			periododeclaraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(periododeclaraAux.getAnio()));
			periododeclaraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(periododeclaraAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPeriodoDeclara(List<PeriodoDeclara> periododeclarasTemp) throws Exception {
		for(PeriodoDeclara periododeclaraAux:periododeclarasTemp) {
			
			periododeclaraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(periododeclaraAux.getAnio()));
			periododeclaraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(periododeclaraAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPeriodoDeclara(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPeriodoDeclara(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPeriodoDeclara(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PeriodoDeclaraConstantesFunciones.getClassesRelationshipsOfPeriodoDeclara(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPeriodoDeclara(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TransaccionLocal.class));
				classes.add(new Classe(RetencionVenta.class));
				classes.add(new Classe(FacturaDiario.class));
				classes.add(new Classe(DocumentoAnulado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TransaccionLocal.class)) {
						classes.add(new Classe(TransaccionLocal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RetencionVenta.class)) {
						classes.add(new Classe(RetencionVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaDiario.class)) {
						classes.add(new Classe(FacturaDiario.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DocumentoAnulado.class)) {
						classes.add(new Classe(DocumentoAnulado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPeriodoDeclara(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PeriodoDeclaraConstantesFunciones.getClassesRelationshipsFromStringsOfPeriodoDeclara(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPeriodoDeclara(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}

					if(RetencionVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RetencionVenta.class)); continue;
					}

					if(FacturaDiario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaDiario.class)); continue;
					}

					if(DocumentoAnulado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DocumentoAnulado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}

					if(RetencionVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RetencionVenta.class)); continue;
					}

					if(FacturaDiario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaDiario.class)); continue;
					}

					if(DocumentoAnulado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DocumentoAnulado.class)); continue;
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
	public static void actualizarLista(PeriodoDeclara periododeclara,List<PeriodoDeclara> periododeclaras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PeriodoDeclara periododeclaraEncontrado=null;
			
			for(PeriodoDeclara periododeclaraLocal:periododeclaras) {
				if(periododeclaraLocal.getId().equals(periododeclara.getId())) {
					periododeclaraEncontrado=periododeclaraLocal;
					
					periododeclaraLocal.setIsChanged(periododeclara.getIsChanged());
					periododeclaraLocal.setIsNew(periododeclara.getIsNew());
					periododeclaraLocal.setIsDeleted(periododeclara.getIsDeleted());
					
					periododeclaraLocal.setGeneralEntityOriginal(periododeclara.getGeneralEntityOriginal());
					
					periododeclaraLocal.setId(periododeclara.getId());	
					periododeclaraLocal.setVersionRow(periododeclara.getVersionRow());	
					periododeclaraLocal.setcodigo(periododeclara.getcodigo());	
					periododeclaraLocal.setid_anio(periododeclara.getid_anio());	
					periododeclaraLocal.setid_mes(periododeclara.getid_mes());	
					periododeclaraLocal.setfecha(periododeclara.getfecha());	
					periododeclaraLocal.setesta_activo(periododeclara.getesta_activo());	
					
					
					periododeclaraLocal.setTransaccionLocals(periododeclara.getTransaccionLocals());
					periododeclaraLocal.setRetencionVentas(periododeclara.getRetencionVentas());
					periododeclaraLocal.setFacturaDiarios(periododeclara.getFacturaDiarios());
					periododeclaraLocal.setDocumentoAnulados(periododeclara.getDocumentoAnulados());
					
					existe=true;
					break;
				}
			}
			
			if(!periododeclara.getIsDeleted()) {
				if(!existe) {
					periododeclaras.add(periododeclara);
				}
			} else {
				if(periododeclaraEncontrado!=null && permiteQuitar)  {
					periododeclaras.remove(periododeclaraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PeriodoDeclara periododeclara,List<PeriodoDeclara> periododeclaras) throws Exception {
		try	{			
			for(PeriodoDeclara periododeclaraLocal:periododeclaras) {
				if(periododeclaraLocal.getId().equals(periododeclara.getId())) {
					periododeclaraLocal.setIsSelected(periododeclara.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPeriodoDeclara(List<PeriodoDeclara> periododeclarasAux) throws Exception {
		//this.periododeclarasAux=periododeclarasAux;
		
		for(PeriodoDeclara periododeclaraAux:periododeclarasAux) {
			if(periododeclaraAux.getIsChanged()) {
				periododeclaraAux.setIsChanged(false);
			}		
			
			if(periododeclaraAux.getIsNew()) {
				periododeclaraAux.setIsNew(false);
			}	
			
			if(periododeclaraAux.getIsDeleted()) {
				periododeclaraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPeriodoDeclara(PeriodoDeclara periododeclaraAux) throws Exception {
		//this.periododeclaraAux=periododeclaraAux;
		
			if(periododeclaraAux.getIsChanged()) {
				periododeclaraAux.setIsChanged(false);
			}		
			
			if(periododeclaraAux.getIsNew()) {
				periododeclaraAux.setIsNew(false);
			}	
			
			if(periododeclaraAux.getIsDeleted()) {
				periododeclaraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PeriodoDeclara periododeclaraAsignar,PeriodoDeclara periododeclara) throws Exception {
		periododeclaraAsignar.setId(periododeclara.getId());	
		periododeclaraAsignar.setVersionRow(periododeclara.getVersionRow());	
		periododeclaraAsignar.setcodigo(periododeclara.getcodigo());	
		periododeclaraAsignar.setid_anio(periododeclara.getid_anio());
		periododeclaraAsignar.setanio_descripcion(periododeclara.getanio_descripcion());	
		periododeclaraAsignar.setid_mes(periododeclara.getid_mes());
		periododeclaraAsignar.setmes_descripcion(periododeclara.getmes_descripcion());	
		periododeclaraAsignar.setfecha(periododeclara.getfecha());	
		periododeclaraAsignar.setesta_activo(periododeclara.getesta_activo());	
	}
	
	public static void inicializarPeriodoDeclara(PeriodoDeclara periododeclara) throws Exception {
		try {
				periododeclara.setId(0L);	
					
				periododeclara.setcodigo("");	
				periododeclara.setid_anio(-1L);	
				periododeclara.setid_mes(-1L);	
				periododeclara.setfecha(new Date());	
				periododeclara.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPeriodoDeclara(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoDeclaraConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoDeclaraConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoDeclaraConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoDeclaraConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PeriodoDeclaraConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPeriodoDeclara(String sTipo,Row row,Workbook workbook,PeriodoDeclara periododeclara,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(periododeclara.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periododeclara.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periododeclara.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(periododeclara.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(periododeclara.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPeriodoDeclara=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPeriodoDeclara() {
		return this.sFinalQueryPeriodoDeclara;
	}
	
	public void setsFinalQueryPeriodoDeclara(String sFinalQueryPeriodoDeclara) {
		this.sFinalQueryPeriodoDeclara= sFinalQueryPeriodoDeclara;
	}
	
	public Border resaltarSeleccionarPeriodoDeclara=null;
	
	public Border setResaltarSeleccionarPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//periododeclaraBeanSwingJInternalFrame.jTtoolBarPeriodoDeclara.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPeriodoDeclara= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPeriodoDeclara() {
		return this.resaltarSeleccionarPeriodoDeclara;
	}
	
	public void setResaltarSeleccionarPeriodoDeclara(Border borderResaltarSeleccionarPeriodoDeclara) {
		this.resaltarSeleccionarPeriodoDeclara= borderResaltarSeleccionarPeriodoDeclara;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPeriodoDeclara=null;
	public Boolean mostraridPeriodoDeclara=true;
	public Boolean activaridPeriodoDeclara=true;

	public Border resaltarcodigoPeriodoDeclara=null;
	public Boolean mostrarcodigoPeriodoDeclara=true;
	public Boolean activarcodigoPeriodoDeclara=true;

	public Border resaltarid_anioPeriodoDeclara=null;
	public Boolean mostrarid_anioPeriodoDeclara=true;
	public Boolean activarid_anioPeriodoDeclara=true;
	public Boolean cargarid_anioPeriodoDeclara=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioPeriodoDeclara=false;//ConEventDepend=true

	public Border resaltarid_mesPeriodoDeclara=null;
	public Boolean mostrarid_mesPeriodoDeclara=true;
	public Boolean activarid_mesPeriodoDeclara=true;
	public Boolean cargarid_mesPeriodoDeclara=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesPeriodoDeclara=false;//ConEventDepend=true

	public Border resaltarfechaPeriodoDeclara=null;
	public Boolean mostrarfechaPeriodoDeclara=true;
	public Boolean activarfechaPeriodoDeclara=true;

	public Border resaltaresta_activoPeriodoDeclara=null;
	public Boolean mostraresta_activoPeriodoDeclara=true;
	public Boolean activaresta_activoPeriodoDeclara=true;

	
	

	public Border setResaltaridPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periododeclaraBeanSwingJInternalFrame.jTtoolBarPeriodoDeclara.setBorder(borderResaltar);
		
		this.resaltaridPeriodoDeclara= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPeriodoDeclara() {
		return this.resaltaridPeriodoDeclara;
	}

	public void setResaltaridPeriodoDeclara(Border borderResaltar) {
		this.resaltaridPeriodoDeclara= borderResaltar;
	}

	public Boolean getMostraridPeriodoDeclara() {
		return this.mostraridPeriodoDeclara;
	}

	public void setMostraridPeriodoDeclara(Boolean mostraridPeriodoDeclara) {
		this.mostraridPeriodoDeclara= mostraridPeriodoDeclara;
	}

	public Boolean getActivaridPeriodoDeclara() {
		return this.activaridPeriodoDeclara;
	}

	public void setActivaridPeriodoDeclara(Boolean activaridPeriodoDeclara) {
		this.activaridPeriodoDeclara= activaridPeriodoDeclara;
	}

	public Border setResaltarcodigoPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periododeclaraBeanSwingJInternalFrame.jTtoolBarPeriodoDeclara.setBorder(borderResaltar);
		
		this.resaltarcodigoPeriodoDeclara= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPeriodoDeclara() {
		return this.resaltarcodigoPeriodoDeclara;
	}

	public void setResaltarcodigoPeriodoDeclara(Border borderResaltar) {
		this.resaltarcodigoPeriodoDeclara= borderResaltar;
	}

	public Boolean getMostrarcodigoPeriodoDeclara() {
		return this.mostrarcodigoPeriodoDeclara;
	}

	public void setMostrarcodigoPeriodoDeclara(Boolean mostrarcodigoPeriodoDeclara) {
		this.mostrarcodigoPeriodoDeclara= mostrarcodigoPeriodoDeclara;
	}

	public Boolean getActivarcodigoPeriodoDeclara() {
		return this.activarcodigoPeriodoDeclara;
	}

	public void setActivarcodigoPeriodoDeclara(Boolean activarcodigoPeriodoDeclara) {
		this.activarcodigoPeriodoDeclara= activarcodigoPeriodoDeclara;
	}

	public Border setResaltarid_anioPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periododeclaraBeanSwingJInternalFrame.jTtoolBarPeriodoDeclara.setBorder(borderResaltar);
		
		this.resaltarid_anioPeriodoDeclara= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioPeriodoDeclara() {
		return this.resaltarid_anioPeriodoDeclara;
	}

	public void setResaltarid_anioPeriodoDeclara(Border borderResaltar) {
		this.resaltarid_anioPeriodoDeclara= borderResaltar;
	}

	public Boolean getMostrarid_anioPeriodoDeclara() {
		return this.mostrarid_anioPeriodoDeclara;
	}

	public void setMostrarid_anioPeriodoDeclara(Boolean mostrarid_anioPeriodoDeclara) {
		this.mostrarid_anioPeriodoDeclara= mostrarid_anioPeriodoDeclara;
	}

	public Boolean getActivarid_anioPeriodoDeclara() {
		return this.activarid_anioPeriodoDeclara;
	}

	public void setActivarid_anioPeriodoDeclara(Boolean activarid_anioPeriodoDeclara) {
		this.activarid_anioPeriodoDeclara= activarid_anioPeriodoDeclara;
	}

	public Boolean getCargarid_anioPeriodoDeclara() {
		return this.cargarid_anioPeriodoDeclara;
	}

	public void setCargarid_anioPeriodoDeclara(Boolean cargarid_anioPeriodoDeclara) {
		this.cargarid_anioPeriodoDeclara= cargarid_anioPeriodoDeclara;
	}

	public Border setResaltarid_mesPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periododeclaraBeanSwingJInternalFrame.jTtoolBarPeriodoDeclara.setBorder(borderResaltar);
		
		this.resaltarid_mesPeriodoDeclara= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesPeriodoDeclara() {
		return this.resaltarid_mesPeriodoDeclara;
	}

	public void setResaltarid_mesPeriodoDeclara(Border borderResaltar) {
		this.resaltarid_mesPeriodoDeclara= borderResaltar;
	}

	public Boolean getMostrarid_mesPeriodoDeclara() {
		return this.mostrarid_mesPeriodoDeclara;
	}

	public void setMostrarid_mesPeriodoDeclara(Boolean mostrarid_mesPeriodoDeclara) {
		this.mostrarid_mesPeriodoDeclara= mostrarid_mesPeriodoDeclara;
	}

	public Boolean getActivarid_mesPeriodoDeclara() {
		return this.activarid_mesPeriodoDeclara;
	}

	public void setActivarid_mesPeriodoDeclara(Boolean activarid_mesPeriodoDeclara) {
		this.activarid_mesPeriodoDeclara= activarid_mesPeriodoDeclara;
	}

	public Boolean getCargarid_mesPeriodoDeclara() {
		return this.cargarid_mesPeriodoDeclara;
	}

	public void setCargarid_mesPeriodoDeclara(Boolean cargarid_mesPeriodoDeclara) {
		this.cargarid_mesPeriodoDeclara= cargarid_mesPeriodoDeclara;
	}

	public Border setResaltarfechaPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periododeclaraBeanSwingJInternalFrame.jTtoolBarPeriodoDeclara.setBorder(borderResaltar);
		
		this.resaltarfechaPeriodoDeclara= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPeriodoDeclara() {
		return this.resaltarfechaPeriodoDeclara;
	}

	public void setResaltarfechaPeriodoDeclara(Border borderResaltar) {
		this.resaltarfechaPeriodoDeclara= borderResaltar;
	}

	public Boolean getMostrarfechaPeriodoDeclara() {
		return this.mostrarfechaPeriodoDeclara;
	}

	public void setMostrarfechaPeriodoDeclara(Boolean mostrarfechaPeriodoDeclara) {
		this.mostrarfechaPeriodoDeclara= mostrarfechaPeriodoDeclara;
	}

	public Boolean getActivarfechaPeriodoDeclara() {
		return this.activarfechaPeriodoDeclara;
	}

	public void setActivarfechaPeriodoDeclara(Boolean activarfechaPeriodoDeclara) {
		this.activarfechaPeriodoDeclara= activarfechaPeriodoDeclara;
	}

	public Border setResaltaresta_activoPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//periododeclaraBeanSwingJInternalFrame.jTtoolBarPeriodoDeclara.setBorder(borderResaltar);
		
		this.resaltaresta_activoPeriodoDeclara= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoPeriodoDeclara() {
		return this.resaltaresta_activoPeriodoDeclara;
	}

	public void setResaltaresta_activoPeriodoDeclara(Border borderResaltar) {
		this.resaltaresta_activoPeriodoDeclara= borderResaltar;
	}

	public Boolean getMostraresta_activoPeriodoDeclara() {
		return this.mostraresta_activoPeriodoDeclara;
	}

	public void setMostraresta_activoPeriodoDeclara(Boolean mostraresta_activoPeriodoDeclara) {
		this.mostraresta_activoPeriodoDeclara= mostraresta_activoPeriodoDeclara;
	}

	public Boolean getActivaresta_activoPeriodoDeclara() {
		return this.activaresta_activoPeriodoDeclara;
	}

	public void setActivaresta_activoPeriodoDeclara(Boolean activaresta_activoPeriodoDeclara) {
		this.activaresta_activoPeriodoDeclara= activaresta_activoPeriodoDeclara;
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
		
		
		this.setMostraridPeriodoDeclara(esInicial);
		this.setMostrarcodigoPeriodoDeclara(esInicial);
		this.setMostrarid_anioPeriodoDeclara(esInicial);
		this.setMostrarid_mesPeriodoDeclara(esInicial);
		this.setMostrarfechaPeriodoDeclara(esInicial);
		this.setMostraresta_activoPeriodoDeclara(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.ID)) {
				this.setMostraridPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.IDMES)) {
				this.setMostrarid_mesPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.FECHA)) {
				this.setMostrarfechaPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoPeriodoDeclara(esAsigna);
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
		
		
		this.setActivaridPeriodoDeclara(esInicial);
		this.setActivarcodigoPeriodoDeclara(esInicial);
		this.setActivarid_anioPeriodoDeclara(esInicial);
		this.setActivarid_mesPeriodoDeclara(esInicial);
		this.setActivarfechaPeriodoDeclara(esInicial);
		this.setActivaresta_activoPeriodoDeclara(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.ID)) {
				this.setActivaridPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.IDANIO)) {
				this.setActivarid_anioPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.IDMES)) {
				this.setActivarid_mesPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.FECHA)) {
				this.setActivarfechaPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoPeriodoDeclara(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPeriodoDeclara(esInicial);
		this.setResaltarcodigoPeriodoDeclara(esInicial);
		this.setResaltarid_anioPeriodoDeclara(esInicial);
		this.setResaltarid_mesPeriodoDeclara(esInicial);
		this.setResaltarfechaPeriodoDeclara(esInicial);
		this.setResaltaresta_activoPeriodoDeclara(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.ID)) {
				this.setResaltaridPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.IDMES)) {
				this.setResaltarid_mesPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.FECHA)) {
				this.setResaltarfechaPeriodoDeclara(esAsigna);
				continue;
			}

			if(campo.clase.equals(PeriodoDeclaraConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoPeriodoDeclara(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTransaccionLocalPeriodoDeclara=null;

	public Border getResaltarTransaccionLocalPeriodoDeclara() {
		return this.resaltarTransaccionLocalPeriodoDeclara;
	}

	public void setResaltarTransaccionLocalPeriodoDeclara(Border borderResaltarTransaccionLocal) {
		if(borderResaltarTransaccionLocal!=null) {
			this.resaltarTransaccionLocalPeriodoDeclara= borderResaltarTransaccionLocal;
		}
	}

	public Border setResaltarTransaccionLocalPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltarTransaccionLocal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//periododeclaraBeanSwingJInternalFrame.jTtoolBarPeriodoDeclara.setBorder(borderResaltarTransaccionLocal);
			
		this.resaltarTransaccionLocalPeriodoDeclara= borderResaltarTransaccionLocal;

		 return borderResaltarTransaccionLocal;
	}



	public Boolean mostrarTransaccionLocalPeriodoDeclara=true;

	public Boolean getMostrarTransaccionLocalPeriodoDeclara() {
		return this.mostrarTransaccionLocalPeriodoDeclara;
	}

	public void setMostrarTransaccionLocalPeriodoDeclara(Boolean visibilidadResaltarTransaccionLocal) {
		this.mostrarTransaccionLocalPeriodoDeclara= visibilidadResaltarTransaccionLocal;
	}



	public Boolean activarTransaccionLocalPeriodoDeclara=true;

	public Boolean gethabilitarResaltarTransaccionLocalPeriodoDeclara() {
		return this.activarTransaccionLocalPeriodoDeclara;
	}

	public void setActivarTransaccionLocalPeriodoDeclara(Boolean habilitarResaltarTransaccionLocal) {
		this.activarTransaccionLocalPeriodoDeclara= habilitarResaltarTransaccionLocal;
	}


	public Border resaltarRetencionVentaPeriodoDeclara=null;

	public Border getResaltarRetencionVentaPeriodoDeclara() {
		return this.resaltarRetencionVentaPeriodoDeclara;
	}

	public void setResaltarRetencionVentaPeriodoDeclara(Border borderResaltarRetencionVenta) {
		if(borderResaltarRetencionVenta!=null) {
			this.resaltarRetencionVentaPeriodoDeclara= borderResaltarRetencionVenta;
		}
	}

	public Border setResaltarRetencionVentaPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltarRetencionVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//periododeclaraBeanSwingJInternalFrame.jTtoolBarPeriodoDeclara.setBorder(borderResaltarRetencionVenta);
			
		this.resaltarRetencionVentaPeriodoDeclara= borderResaltarRetencionVenta;

		 return borderResaltarRetencionVenta;
	}



	public Boolean mostrarRetencionVentaPeriodoDeclara=true;

	public Boolean getMostrarRetencionVentaPeriodoDeclara() {
		return this.mostrarRetencionVentaPeriodoDeclara;
	}

	public void setMostrarRetencionVentaPeriodoDeclara(Boolean visibilidadResaltarRetencionVenta) {
		this.mostrarRetencionVentaPeriodoDeclara= visibilidadResaltarRetencionVenta;
	}



	public Boolean activarRetencionVentaPeriodoDeclara=true;

	public Boolean gethabilitarResaltarRetencionVentaPeriodoDeclara() {
		return this.activarRetencionVentaPeriodoDeclara;
	}

	public void setActivarRetencionVentaPeriodoDeclara(Boolean habilitarResaltarRetencionVenta) {
		this.activarRetencionVentaPeriodoDeclara= habilitarResaltarRetencionVenta;
	}


	public Border resaltarFacturaDiarioPeriodoDeclara=null;

	public Border getResaltarFacturaDiarioPeriodoDeclara() {
		return this.resaltarFacturaDiarioPeriodoDeclara;
	}

	public void setResaltarFacturaDiarioPeriodoDeclara(Border borderResaltarFacturaDiario) {
		if(borderResaltarFacturaDiario!=null) {
			this.resaltarFacturaDiarioPeriodoDeclara= borderResaltarFacturaDiario;
		}
	}

	public Border setResaltarFacturaDiarioPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltarFacturaDiario=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//periododeclaraBeanSwingJInternalFrame.jTtoolBarPeriodoDeclara.setBorder(borderResaltarFacturaDiario);
			
		this.resaltarFacturaDiarioPeriodoDeclara= borderResaltarFacturaDiario;

		 return borderResaltarFacturaDiario;
	}



	public Boolean mostrarFacturaDiarioPeriodoDeclara=true;

	public Boolean getMostrarFacturaDiarioPeriodoDeclara() {
		return this.mostrarFacturaDiarioPeriodoDeclara;
	}

	public void setMostrarFacturaDiarioPeriodoDeclara(Boolean visibilidadResaltarFacturaDiario) {
		this.mostrarFacturaDiarioPeriodoDeclara= visibilidadResaltarFacturaDiario;
	}



	public Boolean activarFacturaDiarioPeriodoDeclara=true;

	public Boolean gethabilitarResaltarFacturaDiarioPeriodoDeclara() {
		return this.activarFacturaDiarioPeriodoDeclara;
	}

	public void setActivarFacturaDiarioPeriodoDeclara(Boolean habilitarResaltarFacturaDiario) {
		this.activarFacturaDiarioPeriodoDeclara= habilitarResaltarFacturaDiario;
	}


	public Border resaltarDocumentoAnuladoPeriodoDeclara=null;

	public Border getResaltarDocumentoAnuladoPeriodoDeclara() {
		return this.resaltarDocumentoAnuladoPeriodoDeclara;
	}

	public void setResaltarDocumentoAnuladoPeriodoDeclara(Border borderResaltarDocumentoAnulado) {
		if(borderResaltarDocumentoAnulado!=null) {
			this.resaltarDocumentoAnuladoPeriodoDeclara= borderResaltarDocumentoAnulado;
		}
	}

	public Border setResaltarDocumentoAnuladoPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltarDocumentoAnulado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//periododeclaraBeanSwingJInternalFrame.jTtoolBarPeriodoDeclara.setBorder(borderResaltarDocumentoAnulado);
			
		this.resaltarDocumentoAnuladoPeriodoDeclara= borderResaltarDocumentoAnulado;

		 return borderResaltarDocumentoAnulado;
	}



	public Boolean mostrarDocumentoAnuladoPeriodoDeclara=true;

	public Boolean getMostrarDocumentoAnuladoPeriodoDeclara() {
		return this.mostrarDocumentoAnuladoPeriodoDeclara;
	}

	public void setMostrarDocumentoAnuladoPeriodoDeclara(Boolean visibilidadResaltarDocumentoAnulado) {
		this.mostrarDocumentoAnuladoPeriodoDeclara= visibilidadResaltarDocumentoAnulado;
	}



	public Boolean activarDocumentoAnuladoPeriodoDeclara=true;

	public Boolean gethabilitarResaltarDocumentoAnuladoPeriodoDeclara() {
		return this.activarDocumentoAnuladoPeriodoDeclara;
	}

	public void setActivarDocumentoAnuladoPeriodoDeclara(Boolean habilitarResaltarDocumentoAnulado) {
		this.activarDocumentoAnuladoPeriodoDeclara= habilitarResaltarDocumentoAnulado;
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

		this.setMostrarTransaccionLocalPeriodoDeclara(esInicial);
		this.setMostrarRetencionVentaPeriodoDeclara(esInicial);
		this.setMostrarFacturaDiarioPeriodoDeclara(esInicial);
		this.setMostrarDocumentoAnuladoPeriodoDeclara(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setMostrarTransaccionLocalPeriodoDeclara(esAsigna);
				continue;
			}

			if(clase.clas.equals(RetencionVenta.class)) {
				this.setMostrarRetencionVentaPeriodoDeclara(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaDiario.class)) {
				this.setMostrarFacturaDiarioPeriodoDeclara(esAsigna);
				continue;
			}

			if(clase.clas.equals(DocumentoAnulado.class)) {
				this.setMostrarDocumentoAnuladoPeriodoDeclara(esAsigna);
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

		this.setActivarTransaccionLocalPeriodoDeclara(esInicial);
		this.setActivarRetencionVentaPeriodoDeclara(esInicial);
		this.setActivarFacturaDiarioPeriodoDeclara(esInicial);
		this.setActivarDocumentoAnuladoPeriodoDeclara(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setActivarTransaccionLocalPeriodoDeclara(esAsigna);
				continue;
			}

			if(clase.clas.equals(RetencionVenta.class)) {
				this.setActivarRetencionVentaPeriodoDeclara(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaDiario.class)) {
				this.setActivarFacturaDiarioPeriodoDeclara(esAsigna);
				continue;
			}

			if(clase.clas.equals(DocumentoAnulado.class)) {
				this.setActivarDocumentoAnuladoPeriodoDeclara(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTransaccionLocalPeriodoDeclara(esInicial);
		this.setResaltarRetencionVentaPeriodoDeclara(esInicial);
		this.setResaltarFacturaDiarioPeriodoDeclara(esInicial);
		this.setResaltarDocumentoAnuladoPeriodoDeclara(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setResaltarTransaccionLocalPeriodoDeclara(esAsigna);
				continue;
			}

			if(clase.clas.equals(RetencionVenta.class)) {
				this.setResaltarRetencionVentaPeriodoDeclara(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaDiario.class)) {
				this.setResaltarFacturaDiarioPeriodoDeclara(esAsigna);
				continue;
			}

			if(clase.clas.equals(DocumentoAnulado.class)) {
				this.setResaltarDocumentoAnuladoPeriodoDeclara(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAnioPeriodoDeclara=true;

	public Boolean getMostrarFK_IdAnioPeriodoDeclara() {
		return this.mostrarFK_IdAnioPeriodoDeclara;
	}

	public void setMostrarFK_IdAnioPeriodoDeclara(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioPeriodoDeclara= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesPeriodoDeclara=true;

	public Boolean getMostrarFK_IdMesPeriodoDeclara() {
		return this.mostrarFK_IdMesPeriodoDeclara;
	}

	public void setMostrarFK_IdMesPeriodoDeclara(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesPeriodoDeclara= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioPeriodoDeclara=true;

	public Boolean getActivarFK_IdAnioPeriodoDeclara() {
		return this.activarFK_IdAnioPeriodoDeclara;
	}

	public void setActivarFK_IdAnioPeriodoDeclara(Boolean habilitarResaltar) {
		this.activarFK_IdAnioPeriodoDeclara= habilitarResaltar;
	}

	public Boolean activarFK_IdMesPeriodoDeclara=true;

	public Boolean getActivarFK_IdMesPeriodoDeclara() {
		return this.activarFK_IdMesPeriodoDeclara;
	}

	public void setActivarFK_IdMesPeriodoDeclara(Boolean habilitarResaltar) {
		this.activarFK_IdMesPeriodoDeclara= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioPeriodoDeclara=null;

	public Border getResaltarFK_IdAnioPeriodoDeclara() {
		return this.resaltarFK_IdAnioPeriodoDeclara;
	}

	public void setResaltarFK_IdAnioPeriodoDeclara(Border borderResaltar) {
		this.resaltarFK_IdAnioPeriodoDeclara= borderResaltar;
	}

	public void setResaltarFK_IdAnioPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioPeriodoDeclara= borderResaltar;
	}

	public Border resaltarFK_IdMesPeriodoDeclara=null;

	public Border getResaltarFK_IdMesPeriodoDeclara() {
		return this.resaltarFK_IdMesPeriodoDeclara;
	}

	public void setResaltarFK_IdMesPeriodoDeclara(Border borderResaltar) {
		this.resaltarFK_IdMesPeriodoDeclara= borderResaltar;
	}

	public void setResaltarFK_IdMesPeriodoDeclara(ParametroGeneralUsuario parametroGeneralUsuario/*PeriodoDeclaraBeanSwingJInternalFrame periododeclaraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesPeriodoDeclara= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}