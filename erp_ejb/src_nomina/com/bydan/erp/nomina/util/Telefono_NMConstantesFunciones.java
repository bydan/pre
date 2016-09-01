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


import com.bydan.erp.nomina.util.Telefono_NMConstantesFunciones;
import com.bydan.erp.nomina.util.Telefono_NMParameterReturnGeneral;
//import com.bydan.erp.nomina.util.Telefono_NMParameterGeneral;

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
final public class Telefono_NMConstantesFunciones extends Telefono_NMConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Telefono_NM";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Telefono_NM"+Telefono_NMConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="Telefono_NMHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="Telefono_NMHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=Telefono_NMConstantesFunciones.SCHEMA+"_"+Telefono_NMConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/Telefono_NMHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=Telefono_NMConstantesFunciones.SCHEMA+"_"+Telefono_NMConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=Telefono_NMConstantesFunciones.SCHEMA+"_"+Telefono_NMConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/Telefono_NMHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=Telefono_NMConstantesFunciones.SCHEMA+"_"+Telefono_NMConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+Telefono_NMConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/Telefono_NMHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+Telefono_NMConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+Telefono_NMConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/Telefono_NMHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+Telefono_NMConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=Telefono_NMConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+Telefono_NMConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=Telefono_NMConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+Telefono_NMConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Telefono_ N Mes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Telefono_ N M";
	public static final String SCLASSWEBTITULO_LOWER="Telefono_ N M";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Telefono_NM";
	public static final String OBJECTNAME="telefono_nm";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="telefono__n_m";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select telefono_nm from "+Telefono_NMConstantesFunciones.SPERSISTENCENAME+" telefono_nm";
	public static String QUERYSELECTNATIVE="select "+Telefono_NMConstantesFunciones.SCHEMA+"."+Telefono_NMConstantesFunciones.TABLENAME+".id,"+Telefono_NMConstantesFunciones.SCHEMA+"."+Telefono_NMConstantesFunciones.TABLENAME+".version_row,"+Telefono_NMConstantesFunciones.SCHEMA+"."+Telefono_NMConstantesFunciones.TABLENAME+".id_empresa,"+Telefono_NMConstantesFunciones.SCHEMA+"."+Telefono_NMConstantesFunciones.TABLENAME+".id_empleado,"+Telefono_NMConstantesFunciones.SCHEMA+"."+Telefono_NMConstantesFunciones.TABLENAME+".telefono from "+Telefono_NMConstantesFunciones.SCHEMA+"."+Telefono_NMConstantesFunciones.TABLENAME;//+" as "+Telefono_NMConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected Telefono_NMConstantesFuncionesAdditional telefono_nmConstantesFuncionesAdditional=null;
	
	public Telefono_NMConstantesFuncionesAdditional getTelefono_NMConstantesFuncionesAdditional() {
		return this.telefono_nmConstantesFuncionesAdditional;
	}
	
	public void setTelefono_NMConstantesFuncionesAdditional(Telefono_NMConstantesFuncionesAdditional telefono_nmConstantesFuncionesAdditional) {
		try {
			this.telefono_nmConstantesFuncionesAdditional=telefono_nmConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String TELEFONO= "telefono";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
	
		
		
		
		
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	
	public static String getTelefono_NMLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(Telefono_NMConstantesFunciones.IDEMPRESA)) {sLabelColumna=Telefono_NMConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(Telefono_NMConstantesFunciones.IDEMPLEADO)) {sLabelColumna=Telefono_NMConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(Telefono_NMConstantesFunciones.TELEFONO)) {sLabelColumna=Telefono_NMConstantesFunciones.LABEL_TELEFONO;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTelefono_NMDescripcion(Telefono_NM telefono_nm) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(telefono_nm !=null/* && telefono_nm.getId()!=0*/) {
			sDescripcion=telefono_nm.gettelefono();//telefono_nmtelefono_nm.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTelefono_NMDescripcionDetallado(Telefono_NM telefono_nm) {
		String sDescripcion="";
			
		sDescripcion+=Telefono_NMConstantesFunciones.ID+"=";
		sDescripcion+=telefono_nm.getId().toString()+",";
		sDescripcion+=Telefono_NMConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=telefono_nm.getVersionRow().toString()+",";
		sDescripcion+=Telefono_NMConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=telefono_nm.getid_empresa().toString()+",";
		sDescripcion+=Telefono_NMConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=telefono_nm.getid_empleado().toString()+",";
		sDescripcion+=Telefono_NMConstantesFunciones.TELEFONO+"=";
		sDescripcion+=telefono_nm.gettelefono()+",";
			
		return sDescripcion;
	}
	
	public static void setTelefono_NMDescripcion(Telefono_NM telefono_nm,String sValor) throws Exception {			
		if(telefono_nm !=null) {
			telefono_nm.settelefono(sValor);//telefono_nmtelefono_nm.getId().toString();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTelefono_NM(Telefono_NM telefono_nm,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		telefono_nm.settelefono(telefono_nm.gettelefono().trim());
	}
	
	public static void quitarEspaciosTelefono_NMs(List<Telefono_NM> telefono_nms,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Telefono_NM telefono_nm: telefono_nms) {
			telefono_nm.settelefono(telefono_nm.gettelefono().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTelefono_NM(Telefono_NM telefono_nm,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && telefono_nm.getConCambioAuxiliar()) {
			telefono_nm.setIsDeleted(telefono_nm.getIsDeletedAuxiliar());	
			telefono_nm.setIsNew(telefono_nm.getIsNewAuxiliar());	
			telefono_nm.setIsChanged(telefono_nm.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			telefono_nm.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			telefono_nm.setIsDeletedAuxiliar(false);	
			telefono_nm.setIsNewAuxiliar(false);	
			telefono_nm.setIsChangedAuxiliar(false);
			
			telefono_nm.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTelefono_NMs(List<Telefono_NM> telefono_nms,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Telefono_NM telefono_nm : telefono_nms) {
			if(conAsignarBase && telefono_nm.getConCambioAuxiliar()) {
				telefono_nm.setIsDeleted(telefono_nm.getIsDeletedAuxiliar());	
				telefono_nm.setIsNew(telefono_nm.getIsNewAuxiliar());	
				telefono_nm.setIsChanged(telefono_nm.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				telefono_nm.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				telefono_nm.setIsDeletedAuxiliar(false);	
				telefono_nm.setIsNewAuxiliar(false);	
				telefono_nm.setIsChangedAuxiliar(false);
				
				telefono_nm.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTelefono_NM(Telefono_NM telefono_nm,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTelefono_NMs(List<Telefono_NM> telefono_nms,Boolean conEnteros) throws Exception  {
		
		for(Telefono_NM telefono_nm: telefono_nms) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTelefono_NM(List<Telefono_NM> telefono_nms,Telefono_NM telefono_nmAux) throws Exception  {
		Telefono_NMConstantesFunciones.InicializarValoresTelefono_NM(telefono_nmAux,true);
		
		for(Telefono_NM telefono_nm: telefono_nms) {
			if(telefono_nm.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTelefono_NM(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=Telefono_NMConstantesFunciones.getArrayColumnasGlobalesTelefono_NM(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTelefono_NM(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(Telefono_NMConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(Telefono_NMConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTelefono_NM(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Telefono_NM> telefono_nms,Telefono_NM telefono_nm,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Telefono_NM telefono_nmAux: telefono_nms) {
			if(telefono_nmAux!=null && telefono_nm!=null) {
				if((telefono_nmAux.getId()==null && telefono_nm.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(telefono_nmAux.getId()!=null && telefono_nm.getId()!=null){
					if(telefono_nmAux.getId().equals(telefono_nm.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTelefono_NM(List<Telefono_NM> telefono_nms) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Telefono_NM telefono_nm: telefono_nms) {			
			if(telefono_nm.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTelefono_NM() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,Telefono_NMConstantesFunciones.LABEL_ID, Telefono_NMConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,Telefono_NMConstantesFunciones.LABEL_VERSIONROW, Telefono_NMConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,Telefono_NMConstantesFunciones.LABEL_IDEMPRESA, Telefono_NMConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,Telefono_NMConstantesFunciones.LABEL_IDEMPLEADO, Telefono_NMConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,Telefono_NMConstantesFunciones.LABEL_TELEFONO, Telefono_NMConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTelefono_NM() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=Telefono_NMConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=Telefono_NMConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=Telefono_NMConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=Telefono_NMConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=Telefono_NMConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTelefono_NM() throws Exception  {
		return Telefono_NMConstantesFunciones.getTiposSeleccionarTelefono_NM(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTelefono_NM(Boolean conFk) throws Exception  {
		return Telefono_NMConstantesFunciones.getTiposSeleccionarTelefono_NM(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTelefono_NM(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(Telefono_NMConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(Telefono_NMConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(Telefono_NMConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(Telefono_NMConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(Telefono_NMConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(Telefono_NMConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTelefono_NM(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTelefono_NM(Telefono_NM telefono_nmAux) throws Exception {
		
			telefono_nmAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(telefono_nmAux.getEmpresa()));
			telefono_nmAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(telefono_nmAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTelefono_NM(List<Telefono_NM> telefono_nmsTemp) throws Exception {
		for(Telefono_NM telefono_nmAux:telefono_nmsTemp) {
			
			telefono_nmAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(telefono_nmAux.getEmpresa()));
			telefono_nmAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(telefono_nmAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTelefono_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTelefono_NM(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTelefono_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return Telefono_NMConstantesFunciones.getClassesRelationshipsOfTelefono_NM(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTelefono_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTelefono_NM(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return Telefono_NMConstantesFunciones.getClassesRelationshipsFromStringsOfTelefono_NM(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTelefono_NM(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Telefono_NM telefono_nm,List<Telefono_NM> telefono_nms,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Telefono_NM telefono_nmEncontrado=null;
			
			for(Telefono_NM telefono_nmLocal:telefono_nms) {
				if(telefono_nmLocal.getId().equals(telefono_nm.getId())) {
					telefono_nmEncontrado=telefono_nmLocal;
					
					telefono_nmLocal.setIsChanged(telefono_nm.getIsChanged());
					telefono_nmLocal.setIsNew(telefono_nm.getIsNew());
					telefono_nmLocal.setIsDeleted(telefono_nm.getIsDeleted());
					
					telefono_nmLocal.setGeneralEntityOriginal(telefono_nm.getGeneralEntityOriginal());
					
					telefono_nmLocal.setId(telefono_nm.getId());	
					telefono_nmLocal.setVersionRow(telefono_nm.getVersionRow());	
					telefono_nmLocal.setid_empresa(telefono_nm.getid_empresa());	
					telefono_nmLocal.setid_empleado(telefono_nm.getid_empleado());	
					telefono_nmLocal.settelefono(telefono_nm.gettelefono());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!telefono_nm.getIsDeleted()) {
				if(!existe) {
					telefono_nms.add(telefono_nm);
				}
			} else {
				if(telefono_nmEncontrado!=null && permiteQuitar)  {
					telefono_nms.remove(telefono_nmEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Telefono_NM telefono_nm,List<Telefono_NM> telefono_nms) throws Exception {
		try	{			
			for(Telefono_NM telefono_nmLocal:telefono_nms) {
				if(telefono_nmLocal.getId().equals(telefono_nm.getId())) {
					telefono_nmLocal.setIsSelected(telefono_nm.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTelefono_NM(List<Telefono_NM> telefono_nmsAux) throws Exception {
		//this.telefono_nmsAux=telefono_nmsAux;
		
		for(Telefono_NM telefono_nmAux:telefono_nmsAux) {
			if(telefono_nmAux.getIsChanged()) {
				telefono_nmAux.setIsChanged(false);
			}		
			
			if(telefono_nmAux.getIsNew()) {
				telefono_nmAux.setIsNew(false);
			}	
			
			if(telefono_nmAux.getIsDeleted()) {
				telefono_nmAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTelefono_NM(Telefono_NM telefono_nmAux) throws Exception {
		//this.telefono_nmAux=telefono_nmAux;
		
			if(telefono_nmAux.getIsChanged()) {
				telefono_nmAux.setIsChanged(false);
			}		
			
			if(telefono_nmAux.getIsNew()) {
				telefono_nmAux.setIsNew(false);
			}	
			
			if(telefono_nmAux.getIsDeleted()) {
				telefono_nmAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Telefono_NM telefono_nmAsignar,Telefono_NM telefono_nm) throws Exception {
		telefono_nmAsignar.setId(telefono_nm.getId());	
		telefono_nmAsignar.setVersionRow(telefono_nm.getVersionRow());	
		telefono_nmAsignar.setid_empresa(telefono_nm.getid_empresa());
		telefono_nmAsignar.setempresa_descripcion(telefono_nm.getempresa_descripcion());	
		telefono_nmAsignar.setid_empleado(telefono_nm.getid_empleado());
		telefono_nmAsignar.setempleado_descripcion(telefono_nm.getempleado_descripcion());	
		telefono_nmAsignar.settelefono(telefono_nm.gettelefono());	
	}
	
	public static void inicializarTelefono_NM(Telefono_NM telefono_nm) throws Exception {
		try {
				telefono_nm.setId(0L);	
					
				telefono_nm.setid_empresa(-1L);	
				telefono_nm.setid_empleado(-1L);	
				telefono_nm.settelefono("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTelefono_NM(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(Telefono_NMConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(Telefono_NMConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(Telefono_NMConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTelefono_NM(String sTipo,Row row,Workbook workbook,Telefono_NM telefono_nm,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(telefono_nm.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(telefono_nm.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(telefono_nm.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTelefono_NM=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTelefono_NM() {
		return this.sFinalQueryTelefono_NM;
	}
	
	public void setsFinalQueryTelefono_NM(String sFinalQueryTelefono_NM) {
		this.sFinalQueryTelefono_NM= sFinalQueryTelefono_NM;
	}
	
	public Border resaltarSeleccionarTelefono_NM=null;
	
	public Border setResaltarSeleccionarTelefono_NM(ParametroGeneralUsuario parametroGeneralUsuario/*Telefono_NMBeanSwingJInternalFrame telefono_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//telefono_nmBeanSwingJInternalFrame.jTtoolBarTelefono_NM.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTelefono_NM= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTelefono_NM() {
		return this.resaltarSeleccionarTelefono_NM;
	}
	
	public void setResaltarSeleccionarTelefono_NM(Border borderResaltarSeleccionarTelefono_NM) {
		this.resaltarSeleccionarTelefono_NM= borderResaltarSeleccionarTelefono_NM;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTelefono_NM=null;
	public Boolean mostraridTelefono_NM=true;
	public Boolean activaridTelefono_NM=true;

	public Border resaltarid_empresaTelefono_NM=null;
	public Boolean mostrarid_empresaTelefono_NM=true;
	public Boolean activarid_empresaTelefono_NM=true;
	public Boolean cargarid_empresaTelefono_NM=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTelefono_NM=false;//ConEventDepend=true

	public Border resaltarid_empleadoTelefono_NM=null;
	public Boolean mostrarid_empleadoTelefono_NM=true;
	public Boolean activarid_empleadoTelefono_NM=true;
	public Boolean cargarid_empleadoTelefono_NM=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoTelefono_NM=false;//ConEventDepend=true

	public Border resaltartelefonoTelefono_NM=null;
	public Boolean mostrartelefonoTelefono_NM=true;
	public Boolean activartelefonoTelefono_NM=true;

	
	

	public Border setResaltaridTelefono_NM(ParametroGeneralUsuario parametroGeneralUsuario/*Telefono_NMBeanSwingJInternalFrame telefono_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefono_nmBeanSwingJInternalFrame.jTtoolBarTelefono_NM.setBorder(borderResaltar);
		
		this.resaltaridTelefono_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTelefono_NM() {
		return this.resaltaridTelefono_NM;
	}

	public void setResaltaridTelefono_NM(Border borderResaltar) {
		this.resaltaridTelefono_NM= borderResaltar;
	}

	public Boolean getMostraridTelefono_NM() {
		return this.mostraridTelefono_NM;
	}

	public void setMostraridTelefono_NM(Boolean mostraridTelefono_NM) {
		this.mostraridTelefono_NM= mostraridTelefono_NM;
	}

	public Boolean getActivaridTelefono_NM() {
		return this.activaridTelefono_NM;
	}

	public void setActivaridTelefono_NM(Boolean activaridTelefono_NM) {
		this.activaridTelefono_NM= activaridTelefono_NM;
	}

	public Border setResaltarid_empresaTelefono_NM(ParametroGeneralUsuario parametroGeneralUsuario/*Telefono_NMBeanSwingJInternalFrame telefono_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefono_nmBeanSwingJInternalFrame.jTtoolBarTelefono_NM.setBorder(borderResaltar);
		
		this.resaltarid_empresaTelefono_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTelefono_NM() {
		return this.resaltarid_empresaTelefono_NM;
	}

	public void setResaltarid_empresaTelefono_NM(Border borderResaltar) {
		this.resaltarid_empresaTelefono_NM= borderResaltar;
	}

	public Boolean getMostrarid_empresaTelefono_NM() {
		return this.mostrarid_empresaTelefono_NM;
	}

	public void setMostrarid_empresaTelefono_NM(Boolean mostrarid_empresaTelefono_NM) {
		this.mostrarid_empresaTelefono_NM= mostrarid_empresaTelefono_NM;
	}

	public Boolean getActivarid_empresaTelefono_NM() {
		return this.activarid_empresaTelefono_NM;
	}

	public void setActivarid_empresaTelefono_NM(Boolean activarid_empresaTelefono_NM) {
		this.activarid_empresaTelefono_NM= activarid_empresaTelefono_NM;
	}

	public Boolean getCargarid_empresaTelefono_NM() {
		return this.cargarid_empresaTelefono_NM;
	}

	public void setCargarid_empresaTelefono_NM(Boolean cargarid_empresaTelefono_NM) {
		this.cargarid_empresaTelefono_NM= cargarid_empresaTelefono_NM;
	}

	public Border setResaltarid_empleadoTelefono_NM(ParametroGeneralUsuario parametroGeneralUsuario/*Telefono_NMBeanSwingJInternalFrame telefono_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefono_nmBeanSwingJInternalFrame.jTtoolBarTelefono_NM.setBorder(borderResaltar);
		
		this.resaltarid_empleadoTelefono_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoTelefono_NM() {
		return this.resaltarid_empleadoTelefono_NM;
	}

	public void setResaltarid_empleadoTelefono_NM(Border borderResaltar) {
		this.resaltarid_empleadoTelefono_NM= borderResaltar;
	}

	public Boolean getMostrarid_empleadoTelefono_NM() {
		return this.mostrarid_empleadoTelefono_NM;
	}

	public void setMostrarid_empleadoTelefono_NM(Boolean mostrarid_empleadoTelefono_NM) {
		this.mostrarid_empleadoTelefono_NM= mostrarid_empleadoTelefono_NM;
	}

	public Boolean getActivarid_empleadoTelefono_NM() {
		return this.activarid_empleadoTelefono_NM;
	}

	public void setActivarid_empleadoTelefono_NM(Boolean activarid_empleadoTelefono_NM) {
		this.activarid_empleadoTelefono_NM= activarid_empleadoTelefono_NM;
	}

	public Boolean getCargarid_empleadoTelefono_NM() {
		return this.cargarid_empleadoTelefono_NM;
	}

	public void setCargarid_empleadoTelefono_NM(Boolean cargarid_empleadoTelefono_NM) {
		this.cargarid_empleadoTelefono_NM= cargarid_empleadoTelefono_NM;
	}

	public Border setResaltartelefonoTelefono_NM(ParametroGeneralUsuario parametroGeneralUsuario/*Telefono_NMBeanSwingJInternalFrame telefono_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//telefono_nmBeanSwingJInternalFrame.jTtoolBarTelefono_NM.setBorder(borderResaltar);
		
		this.resaltartelefonoTelefono_NM= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoTelefono_NM() {
		return this.resaltartelefonoTelefono_NM;
	}

	public void setResaltartelefonoTelefono_NM(Border borderResaltar) {
		this.resaltartelefonoTelefono_NM= borderResaltar;
	}

	public Boolean getMostrartelefonoTelefono_NM() {
		return this.mostrartelefonoTelefono_NM;
	}

	public void setMostrartelefonoTelefono_NM(Boolean mostrartelefonoTelefono_NM) {
		this.mostrartelefonoTelefono_NM= mostrartelefonoTelefono_NM;
	}

	public Boolean getActivartelefonoTelefono_NM() {
		return this.activartelefonoTelefono_NM;
	}

	public void setActivartelefonoTelefono_NM(Boolean activartelefonoTelefono_NM) {
		this.activartelefonoTelefono_NM= activartelefonoTelefono_NM;
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
		
		
		this.setMostraridTelefono_NM(esInicial);
		this.setMostrarid_empresaTelefono_NM(esInicial);
		this.setMostrarid_empleadoTelefono_NM(esInicial);
		this.setMostrartelefonoTelefono_NM(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(Telefono_NMConstantesFunciones.ID)) {
				this.setMostraridTelefono_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(Telefono_NMConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTelefono_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(Telefono_NMConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoTelefono_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(Telefono_NMConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoTelefono_NM(esAsigna);
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
		
		
		this.setActivaridTelefono_NM(esInicial);
		this.setActivarid_empresaTelefono_NM(esInicial);
		this.setActivarid_empleadoTelefono_NM(esInicial);
		this.setActivartelefonoTelefono_NM(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(Telefono_NMConstantesFunciones.ID)) {
				this.setActivaridTelefono_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(Telefono_NMConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTelefono_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(Telefono_NMConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoTelefono_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(Telefono_NMConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoTelefono_NM(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,Telefono_NMBeanSwingJInternalFrame telefono_nmBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTelefono_NM(esInicial);
		this.setResaltarid_empresaTelefono_NM(esInicial);
		this.setResaltarid_empleadoTelefono_NM(esInicial);
		this.setResaltartelefonoTelefono_NM(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(Telefono_NMConstantesFunciones.ID)) {
				this.setResaltaridTelefono_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(Telefono_NMConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTelefono_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(Telefono_NMConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoTelefono_NM(esAsigna);
				continue;
			}

			if(campo.clase.equals(Telefono_NMConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoTelefono_NM(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,Telefono_NMBeanSwingJInternalFrame telefono_nmBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoTelefono_NM=true;

	public Boolean getMostrarFK_IdEmpleadoTelefono_NM() {
		return this.mostrarFK_IdEmpleadoTelefono_NM;
	}

	public void setMostrarFK_IdEmpleadoTelefono_NM(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoTelefono_NM= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTelefono_NM=true;

	public Boolean getMostrarFK_IdEmpresaTelefono_NM() {
		return this.mostrarFK_IdEmpresaTelefono_NM;
	}

	public void setMostrarFK_IdEmpresaTelefono_NM(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTelefono_NM= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoTelefono_NM=true;

	public Boolean getActivarFK_IdEmpleadoTelefono_NM() {
		return this.activarFK_IdEmpleadoTelefono_NM;
	}

	public void setActivarFK_IdEmpleadoTelefono_NM(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoTelefono_NM= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTelefono_NM=true;

	public Boolean getActivarFK_IdEmpresaTelefono_NM() {
		return this.activarFK_IdEmpresaTelefono_NM;
	}

	public void setActivarFK_IdEmpresaTelefono_NM(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTelefono_NM= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoTelefono_NM=null;

	public Border getResaltarFK_IdEmpleadoTelefono_NM() {
		return this.resaltarFK_IdEmpleadoTelefono_NM;
	}

	public void setResaltarFK_IdEmpleadoTelefono_NM(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoTelefono_NM= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoTelefono_NM(ParametroGeneralUsuario parametroGeneralUsuario/*Telefono_NMBeanSwingJInternalFrame telefono_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoTelefono_NM= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTelefono_NM=null;

	public Border getResaltarFK_IdEmpresaTelefono_NM() {
		return this.resaltarFK_IdEmpresaTelefono_NM;
	}

	public void setResaltarFK_IdEmpresaTelefono_NM(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTelefono_NM= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTelefono_NM(ParametroGeneralUsuario parametroGeneralUsuario/*Telefono_NMBeanSwingJInternalFrame telefono_nmBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTelefono_NM= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}