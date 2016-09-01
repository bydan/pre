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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.VisaConstantesFunciones;
import com.bydan.erp.nomina.util.VisaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.VisaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VisaConstantesFunciones extends VisaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Visa";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Visa"+VisaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VisaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VisaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VisaConstantesFunciones.SCHEMA+"_"+VisaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VisaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VisaConstantesFunciones.SCHEMA+"_"+VisaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VisaConstantesFunciones.SCHEMA+"_"+VisaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VisaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VisaConstantesFunciones.SCHEMA+"_"+VisaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VisaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VisaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VisaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VisaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VisaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VisaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VisaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VisaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VisaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VisaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Visas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Visa";
	public static final String SCLASSWEBTITULO_LOWER="Visa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Visa";
	public static final String OBJECTNAME="visa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="visa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select visa from "+VisaConstantesFunciones.SPERSISTENCENAME+" visa";
	public static String QUERYSELECTNATIVE="select "+VisaConstantesFunciones.SCHEMA+"."+VisaConstantesFunciones.TABLENAME+".id,"+VisaConstantesFunciones.SCHEMA+"."+VisaConstantesFunciones.TABLENAME+".version_row,"+VisaConstantesFunciones.SCHEMA+"."+VisaConstantesFunciones.TABLENAME+".id_empresa,"+VisaConstantesFunciones.SCHEMA+"."+VisaConstantesFunciones.TABLENAME+".id_pais,"+VisaConstantesFunciones.SCHEMA+"."+VisaConstantesFunciones.TABLENAME+".id_empleado,"+VisaConstantesFunciones.SCHEMA+"."+VisaConstantesFunciones.TABLENAME+".descripcion from "+VisaConstantesFunciones.SCHEMA+"."+VisaConstantesFunciones.TABLENAME;//+" as "+VisaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected VisaConstantesFuncionesAdditional visaConstantesFuncionesAdditional=null;
	
	public VisaConstantesFuncionesAdditional getVisaConstantesFuncionesAdditional() {
		return this.visaConstantesFuncionesAdditional;
	}
	
	public void setVisaConstantesFuncionesAdditional(VisaConstantesFuncionesAdditional visaConstantesFuncionesAdditional) {
		try {
			this.visaConstantesFuncionesAdditional=visaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDPAIS= "id_pais";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getVisaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VisaConstantesFunciones.IDEMPRESA)) {sLabelColumna=VisaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VisaConstantesFunciones.IDPAIS)) {sLabelColumna=VisaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(VisaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=VisaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(VisaConstantesFunciones.DESCRIPCION)) {sLabelColumna=VisaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getVisaDescripcion(Visa visa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(visa !=null/* && visa.getId()!=0*/) {
			if(visa.getId()!=null) {
				sDescripcion=visa.getId().toString();
			}//visavisa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVisaDescripcionDetallado(Visa visa) {
		String sDescripcion="";
			
		sDescripcion+=VisaConstantesFunciones.ID+"=";
		sDescripcion+=visa.getId().toString()+",";
		sDescripcion+=VisaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=visa.getVersionRow().toString()+",";
		sDescripcion+=VisaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=visa.getid_empresa().toString()+",";
		sDescripcion+=VisaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=visa.getid_pais().toString()+",";
		sDescripcion+=VisaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=visa.getid_empleado().toString()+",";
		sDescripcion+=VisaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=visa.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setVisaDescripcion(Visa visa,String sValor) throws Exception {			
		if(visa !=null) {
			//visavisa.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVisa(Visa visa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		visa.setdescripcion(visa.getdescripcion().trim());
	}
	
	public static void quitarEspaciosVisas(List<Visa> visas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Visa visa: visas) {
			visa.setdescripcion(visa.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVisa(Visa visa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && visa.getConCambioAuxiliar()) {
			visa.setIsDeleted(visa.getIsDeletedAuxiliar());	
			visa.setIsNew(visa.getIsNewAuxiliar());	
			visa.setIsChanged(visa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			visa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			visa.setIsDeletedAuxiliar(false);	
			visa.setIsNewAuxiliar(false);	
			visa.setIsChangedAuxiliar(false);
			
			visa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVisas(List<Visa> visas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Visa visa : visas) {
			if(conAsignarBase && visa.getConCambioAuxiliar()) {
				visa.setIsDeleted(visa.getIsDeletedAuxiliar());	
				visa.setIsNew(visa.getIsNewAuxiliar());	
				visa.setIsChanged(visa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				visa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				visa.setIsDeletedAuxiliar(false);	
				visa.setIsNewAuxiliar(false);	
				visa.setIsChangedAuxiliar(false);
				
				visa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVisa(Visa visa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVisas(List<Visa> visas,Boolean conEnteros) throws Exception  {
		
		for(Visa visa: visas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVisa(List<Visa> visas,Visa visaAux) throws Exception  {
		VisaConstantesFunciones.InicializarValoresVisa(visaAux,true);
		
		for(Visa visa: visas) {
			if(visa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVisa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VisaConstantesFunciones.getArrayColumnasGlobalesVisa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVisa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VisaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VisaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVisa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Visa> visas,Visa visa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Visa visaAux: visas) {
			if(visaAux!=null && visa!=null) {
				if((visaAux.getId()==null && visa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(visaAux.getId()!=null && visa.getId()!=null){
					if(visaAux.getId().equals(visa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVisa(List<Visa> visas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Visa visa: visas) {			
			if(visa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVisa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VisaConstantesFunciones.LABEL_ID, VisaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisaConstantesFunciones.LABEL_VERSIONROW, VisaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisaConstantesFunciones.LABEL_IDEMPRESA, VisaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisaConstantesFunciones.LABEL_IDPAIS, VisaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisaConstantesFunciones.LABEL_IDEMPLEADO, VisaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisaConstantesFunciones.LABEL_DESCRIPCION, VisaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVisa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VisaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVisa() throws Exception  {
		return VisaConstantesFunciones.getTiposSeleccionarVisa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVisa(Boolean conFk) throws Exception  {
		return VisaConstantesFunciones.getTiposSeleccionarVisa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVisa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VisaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VisaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VisaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(VisaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VisaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(VisaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VisaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(VisaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVisa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVisa(Visa visaAux) throws Exception {
		
			visaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(visaAux.getEmpresa()));
			visaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(visaAux.getPais()));
			visaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(visaAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVisa(List<Visa> visasTemp) throws Exception {
		for(Visa visaAux:visasTemp) {
			
			visaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(visaAux.getEmpresa()));
			visaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(visaAux.getPais()));
			visaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(visaAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVisa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVisa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVisa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VisaConstantesFunciones.getClassesRelationshipsOfVisa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVisa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVisa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VisaConstantesFunciones.getClassesRelationshipsFromStringsOfVisa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVisa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Visa visa,List<Visa> visas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Visa visaEncontrado=null;
			
			for(Visa visaLocal:visas) {
				if(visaLocal.getId().equals(visa.getId())) {
					visaEncontrado=visaLocal;
					
					visaLocal.setIsChanged(visa.getIsChanged());
					visaLocal.setIsNew(visa.getIsNew());
					visaLocal.setIsDeleted(visa.getIsDeleted());
					
					visaLocal.setGeneralEntityOriginal(visa.getGeneralEntityOriginal());
					
					visaLocal.setId(visa.getId());	
					visaLocal.setVersionRow(visa.getVersionRow());	
					visaLocal.setid_empresa(visa.getid_empresa());	
					visaLocal.setid_pais(visa.getid_pais());	
					visaLocal.setid_empleado(visa.getid_empleado());	
					visaLocal.setdescripcion(visa.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!visa.getIsDeleted()) {
				if(!existe) {
					visas.add(visa);
				}
			} else {
				if(visaEncontrado!=null && permiteQuitar)  {
					visas.remove(visaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Visa visa,List<Visa> visas) throws Exception {
		try	{			
			for(Visa visaLocal:visas) {
				if(visaLocal.getId().equals(visa.getId())) {
					visaLocal.setIsSelected(visa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVisa(List<Visa> visasAux) throws Exception {
		//this.visasAux=visasAux;
		
		for(Visa visaAux:visasAux) {
			if(visaAux.getIsChanged()) {
				visaAux.setIsChanged(false);
			}		
			
			if(visaAux.getIsNew()) {
				visaAux.setIsNew(false);
			}	
			
			if(visaAux.getIsDeleted()) {
				visaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVisa(Visa visaAux) throws Exception {
		//this.visaAux=visaAux;
		
			if(visaAux.getIsChanged()) {
				visaAux.setIsChanged(false);
			}		
			
			if(visaAux.getIsNew()) {
				visaAux.setIsNew(false);
			}	
			
			if(visaAux.getIsDeleted()) {
				visaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Visa visaAsignar,Visa visa) throws Exception {
		visaAsignar.setId(visa.getId());	
		visaAsignar.setVersionRow(visa.getVersionRow());	
		visaAsignar.setid_empresa(visa.getid_empresa());
		visaAsignar.setempresa_descripcion(visa.getempresa_descripcion());	
		visaAsignar.setid_pais(visa.getid_pais());
		visaAsignar.setpais_descripcion(visa.getpais_descripcion());	
		visaAsignar.setid_empleado(visa.getid_empleado());
		visaAsignar.setempleado_descripcion(visa.getempleado_descripcion());	
		visaAsignar.setdescripcion(visa.getdescripcion());	
	}
	
	public static void inicializarVisa(Visa visa) throws Exception {
		try {
				visa.setId(0L);	
					
				visa.setid_empresa(-1L);	
				visa.setid_pais(-1L);	
				visa.setid_empleado(-1L);	
				visa.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVisa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VisaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVisa(String sTipo,Row row,Workbook workbook,Visa visa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(visa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(visa.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(visa.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(visa.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVisa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryVisa() {
		return this.sFinalQueryVisa;
	}
	
	public void setsFinalQueryVisa(String sFinalQueryVisa) {
		this.sFinalQueryVisa= sFinalQueryVisa;
	}
	
	public Border resaltarSeleccionarVisa=null;
	
	public Border setResaltarSeleccionarVisa(ParametroGeneralUsuario parametroGeneralUsuario/*VisaBeanSwingJInternalFrame visaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//visaBeanSwingJInternalFrame.jTtoolBarVisa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVisa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVisa() {
		return this.resaltarSeleccionarVisa;
	}
	
	public void setResaltarSeleccionarVisa(Border borderResaltarSeleccionarVisa) {
		this.resaltarSeleccionarVisa= borderResaltarSeleccionarVisa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVisa=null;
	public Boolean mostraridVisa=true;
	public Boolean activaridVisa=true;

	public Border resaltarid_empresaVisa=null;
	public Boolean mostrarid_empresaVisa=true;
	public Boolean activarid_empresaVisa=true;
	public Boolean cargarid_empresaVisa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVisa=false;//ConEventDepend=true

	public Border resaltarid_paisVisa=null;
	public Boolean mostrarid_paisVisa=true;
	public Boolean activarid_paisVisa=true;
	public Boolean cargarid_paisVisa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisVisa=false;//ConEventDepend=true

	public Border resaltarid_empleadoVisa=null;
	public Boolean mostrarid_empleadoVisa=true;
	public Boolean activarid_empleadoVisa=true;
	public Boolean cargarid_empleadoVisa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoVisa=false;//ConEventDepend=true

	public Border resaltardescripcionVisa=null;
	public Boolean mostrardescripcionVisa=true;
	public Boolean activardescripcionVisa=true;

	
	

	public Border setResaltaridVisa(ParametroGeneralUsuario parametroGeneralUsuario/*VisaBeanSwingJInternalFrame visaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visaBeanSwingJInternalFrame.jTtoolBarVisa.setBorder(borderResaltar);
		
		this.resaltaridVisa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVisa() {
		return this.resaltaridVisa;
	}

	public void setResaltaridVisa(Border borderResaltar) {
		this.resaltaridVisa= borderResaltar;
	}

	public Boolean getMostraridVisa() {
		return this.mostraridVisa;
	}

	public void setMostraridVisa(Boolean mostraridVisa) {
		this.mostraridVisa= mostraridVisa;
	}

	public Boolean getActivaridVisa() {
		return this.activaridVisa;
	}

	public void setActivaridVisa(Boolean activaridVisa) {
		this.activaridVisa= activaridVisa;
	}

	public Border setResaltarid_empresaVisa(ParametroGeneralUsuario parametroGeneralUsuario/*VisaBeanSwingJInternalFrame visaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visaBeanSwingJInternalFrame.jTtoolBarVisa.setBorder(borderResaltar);
		
		this.resaltarid_empresaVisa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVisa() {
		return this.resaltarid_empresaVisa;
	}

	public void setResaltarid_empresaVisa(Border borderResaltar) {
		this.resaltarid_empresaVisa= borderResaltar;
	}

	public Boolean getMostrarid_empresaVisa() {
		return this.mostrarid_empresaVisa;
	}

	public void setMostrarid_empresaVisa(Boolean mostrarid_empresaVisa) {
		this.mostrarid_empresaVisa= mostrarid_empresaVisa;
	}

	public Boolean getActivarid_empresaVisa() {
		return this.activarid_empresaVisa;
	}

	public void setActivarid_empresaVisa(Boolean activarid_empresaVisa) {
		this.activarid_empresaVisa= activarid_empresaVisa;
	}

	public Boolean getCargarid_empresaVisa() {
		return this.cargarid_empresaVisa;
	}

	public void setCargarid_empresaVisa(Boolean cargarid_empresaVisa) {
		this.cargarid_empresaVisa= cargarid_empresaVisa;
	}

	public Border setResaltarid_paisVisa(ParametroGeneralUsuario parametroGeneralUsuario/*VisaBeanSwingJInternalFrame visaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visaBeanSwingJInternalFrame.jTtoolBarVisa.setBorder(borderResaltar);
		
		this.resaltarid_paisVisa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisVisa() {
		return this.resaltarid_paisVisa;
	}

	public void setResaltarid_paisVisa(Border borderResaltar) {
		this.resaltarid_paisVisa= borderResaltar;
	}

	public Boolean getMostrarid_paisVisa() {
		return this.mostrarid_paisVisa;
	}

	public void setMostrarid_paisVisa(Boolean mostrarid_paisVisa) {
		this.mostrarid_paisVisa= mostrarid_paisVisa;
	}

	public Boolean getActivarid_paisVisa() {
		return this.activarid_paisVisa;
	}

	public void setActivarid_paisVisa(Boolean activarid_paisVisa) {
		this.activarid_paisVisa= activarid_paisVisa;
	}

	public Boolean getCargarid_paisVisa() {
		return this.cargarid_paisVisa;
	}

	public void setCargarid_paisVisa(Boolean cargarid_paisVisa) {
		this.cargarid_paisVisa= cargarid_paisVisa;
	}

	public Border setResaltarid_empleadoVisa(ParametroGeneralUsuario parametroGeneralUsuario/*VisaBeanSwingJInternalFrame visaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visaBeanSwingJInternalFrame.jTtoolBarVisa.setBorder(borderResaltar);
		
		this.resaltarid_empleadoVisa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoVisa() {
		return this.resaltarid_empleadoVisa;
	}

	public void setResaltarid_empleadoVisa(Border borderResaltar) {
		this.resaltarid_empleadoVisa= borderResaltar;
	}

	public Boolean getMostrarid_empleadoVisa() {
		return this.mostrarid_empleadoVisa;
	}

	public void setMostrarid_empleadoVisa(Boolean mostrarid_empleadoVisa) {
		this.mostrarid_empleadoVisa= mostrarid_empleadoVisa;
	}

	public Boolean getActivarid_empleadoVisa() {
		return this.activarid_empleadoVisa;
	}

	public void setActivarid_empleadoVisa(Boolean activarid_empleadoVisa) {
		this.activarid_empleadoVisa= activarid_empleadoVisa;
	}

	public Boolean getCargarid_empleadoVisa() {
		return this.cargarid_empleadoVisa;
	}

	public void setCargarid_empleadoVisa(Boolean cargarid_empleadoVisa) {
		this.cargarid_empleadoVisa= cargarid_empleadoVisa;
	}

	public Border setResaltardescripcionVisa(ParametroGeneralUsuario parametroGeneralUsuario/*VisaBeanSwingJInternalFrame visaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visaBeanSwingJInternalFrame.jTtoolBarVisa.setBorder(borderResaltar);
		
		this.resaltardescripcionVisa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionVisa() {
		return this.resaltardescripcionVisa;
	}

	public void setResaltardescripcionVisa(Border borderResaltar) {
		this.resaltardescripcionVisa= borderResaltar;
	}

	public Boolean getMostrardescripcionVisa() {
		return this.mostrardescripcionVisa;
	}

	public void setMostrardescripcionVisa(Boolean mostrardescripcionVisa) {
		this.mostrardescripcionVisa= mostrardescripcionVisa;
	}

	public Boolean getActivardescripcionVisa() {
		return this.activardescripcionVisa;
	}

	public void setActivardescripcionVisa(Boolean activardescripcionVisa) {
		this.activardescripcionVisa= activardescripcionVisa;
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
		
		
		this.setMostraridVisa(esInicial);
		this.setMostrarid_empresaVisa(esInicial);
		this.setMostrarid_paisVisa(esInicial);
		this.setMostrarid_empleadoVisa(esInicial);
		this.setMostrardescripcionVisa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VisaConstantesFunciones.ID)) {
				this.setMostraridVisa(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVisa(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisVisa(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoVisa(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionVisa(esAsigna);
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
		
		
		this.setActivaridVisa(esInicial);
		this.setActivarid_empresaVisa(esInicial);
		this.setActivarid_paisVisa(esInicial);
		this.setActivarid_empleadoVisa(esInicial);
		this.setActivardescripcionVisa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VisaConstantesFunciones.ID)) {
				this.setActivaridVisa(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVisa(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisVisa(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoVisa(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionVisa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VisaBeanSwingJInternalFrame visaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVisa(esInicial);
		this.setResaltarid_empresaVisa(esInicial);
		this.setResaltarid_paisVisa(esInicial);
		this.setResaltarid_empleadoVisa(esInicial);
		this.setResaltardescripcionVisa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VisaConstantesFunciones.ID)) {
				this.setResaltaridVisa(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVisa(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisVisa(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoVisa(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionVisa(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VisaBeanSwingJInternalFrame visaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoVisa=true;

	public Boolean getMostrarFK_IdEmpleadoVisa() {
		return this.mostrarFK_IdEmpleadoVisa;
	}

	public void setMostrarFK_IdEmpleadoVisa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoVisa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaVisa=true;

	public Boolean getMostrarFK_IdEmpresaVisa() {
		return this.mostrarFK_IdEmpresaVisa;
	}

	public void setMostrarFK_IdEmpresaVisa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaVisa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisVisa=true;

	public Boolean getMostrarFK_IdPaisVisa() {
		return this.mostrarFK_IdPaisVisa;
	}

	public void setMostrarFK_IdPaisVisa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisVisa= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoVisa=true;

	public Boolean getActivarFK_IdEmpleadoVisa() {
		return this.activarFK_IdEmpleadoVisa;
	}

	public void setActivarFK_IdEmpleadoVisa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoVisa= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaVisa=true;

	public Boolean getActivarFK_IdEmpresaVisa() {
		return this.activarFK_IdEmpresaVisa;
	}

	public void setActivarFK_IdEmpresaVisa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaVisa= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisVisa=true;

	public Boolean getActivarFK_IdPaisVisa() {
		return this.activarFK_IdPaisVisa;
	}

	public void setActivarFK_IdPaisVisa(Boolean habilitarResaltar) {
		this.activarFK_IdPaisVisa= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoVisa=null;

	public Border getResaltarFK_IdEmpleadoVisa() {
		return this.resaltarFK_IdEmpleadoVisa;
	}

	public void setResaltarFK_IdEmpleadoVisa(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoVisa= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoVisa(ParametroGeneralUsuario parametroGeneralUsuario/*VisaBeanSwingJInternalFrame visaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoVisa= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaVisa=null;

	public Border getResaltarFK_IdEmpresaVisa() {
		return this.resaltarFK_IdEmpresaVisa;
	}

	public void setResaltarFK_IdEmpresaVisa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaVisa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaVisa(ParametroGeneralUsuario parametroGeneralUsuario/*VisaBeanSwingJInternalFrame visaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaVisa= borderResaltar;
	}

	public Border resaltarFK_IdPaisVisa=null;

	public Border getResaltarFK_IdPaisVisa() {
		return this.resaltarFK_IdPaisVisa;
	}

	public void setResaltarFK_IdPaisVisa(Border borderResaltar) {
		this.resaltarFK_IdPaisVisa= borderResaltar;
	}

	public void setResaltarFK_IdPaisVisa(ParametroGeneralUsuario parametroGeneralUsuario/*VisaBeanSwingJInternalFrame visaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisVisa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}